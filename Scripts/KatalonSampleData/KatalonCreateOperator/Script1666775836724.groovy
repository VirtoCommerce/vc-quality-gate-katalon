import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonSlurper
import internal.GlobalVariable

WebUI.comment('TEST CASE: create katalon tests operator')


'AUTHORIZR AS ENVIRONMENT ADMIN'
authorize = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePlatform/Authorization/AuthBackToken'),
	null)
println GlobalVariable.token


'CREATE KATALON USER'
userCreate = WS.sendRequestAndVerify(findTestObject('Object Repository/API/katalonDataCreation/UserCreateKatalon', [
	('email') : GlobalVariable.katalonEmail,
	('userName') : GlobalVariable.katalonUserName,
	('userType') : 'Customer'//hardcoded as user can not be manually created with any other userType
	]))
WS.verifyElementPropertyValue(userCreate, 'succeeded', true)


WS.sendRequestAndVerify(findTestObject('Object Repository/API/katalonDataCreation/indexKatalon'))

WebUI.comment('Waiting for drop index 20 sec')

WS.delay(20)


'SEARCH FOR THE CREATED USER'
userSearch = WS.sendRequestAndVerify(findTestObject('Object Repository/API/katalonDataCreation/UserSearchKatalon', [
	('searchPhrase') : GlobalVariable.katalonUserName,
	]))
WS.verifyElementPropertyValue(userSearch, 'users[0].userName', GlobalVariable.katalonUserName)
WS.verifyElementPropertyValue(userSearch, 'users[0].emailConfirmed', 'true', FailureHandling.STOP_ON_FAILURE)


'GET CREATED USER ID'
GlobalVariable.userId = WS.getElementPropertyValue(userSearch, 'users[0].id')
//GlobalVariable.katalonUserId = GlobalVariable.userId  
WebUI.comment('USER ID is: ' + GlobalVariable.userId)



WebUI.comment('TEST CASE: update created user')

'GET CREATED USER DATA TO UPDATE USER'
userGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/katalonDataCreation/UserGetUserByIdKatalon', [
	('userId') : GlobalVariable.userId
	]))
userGetBody = userGet.getResponseBodyContent()
println userGetBody
userBodyParsed = new JsonSlurper().parseText(userGetBody)
userBodyParsed.userType = 'SiteAdministrator'
userBodyParsed.isAdministrator = true
userBodyJson = new groovy.json.JsonBuilder(userBodyParsed).toString()
println userBodyJson


'SEND REQUEST TO UPDATE THE CREATED USER (update is required to make a user lockble (workflow peculiarity))'
RequestObject userBodyObject = findTestObject('Object Repository/API/katalonDataCreation/UserUpdateKatalon')
userBodyObject.setBodyContent(new HttpTextBodyContent(userBodyJson))
userUpdate = WS.sendRequestAndVerify(userBodyObject)
WS.verifyElementPropertyValue(userUpdate, 'succeeded', true)


'ADD APIKEY TO KATALON USER'
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/ApiKeySet', [
	('userName') : GlobalVariable.katalonUserName,
	('api_key') : GlobalVariable.api_key,
	('userId') : GlobalVariable.userId,
	('apiKeyStatus') : GlobalVariable.apiKeyStatus
	]))

responseApiKey = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/ApiKeyGet', [
	('userId') : GlobalVariable.userId
	]))
WS.verifyElementPropertyValue(responseApiKey, '[0].apiKey', GlobalVariable.api_key)
GlobalVariable.apiKeyId = (WS.getElementPropertyValue(responseApiKey, '[0].id'))
WebUI.comment('API KEY ID : ' + GlobalVariable.apiKeyId)


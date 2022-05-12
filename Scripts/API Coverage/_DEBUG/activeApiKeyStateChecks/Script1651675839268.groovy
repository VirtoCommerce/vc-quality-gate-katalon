import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonOutput
import com.kms.katalon.core.testobject.ResponseObject


//'PRECONDITION (not related)'
//'First create a user'
//userCreate = WS.callTestCase(findTestCase('Test Cases/API Coverage/Platform/UserCreate'),
//	null)
//'Get the created user by name id'
//getUserId = WS.callTestCase(findTestCase('Test Cases/API Coverage/Platform/UserSearchSetUserID'), 
//	null)
//'Authorize and get the auth token'
//auth = WS.callTestCase(findTestCase('Test Cases/API Coverage/Platform/AuthBackToken'),
//	null)
//'**********'
//
//
//
//WebUI.comment('TEST CASE: apikey check')
//
//
//'SET API KEY FOR THE THE USER THAT IS NOT ADMIN AND CHECK ITS RESPONSE WHILE ITS ON/OFF AND THE USER IS LOCKED'
//apiKeyIsActive = [true, false]
//
//
//'******'
//'SET APIKEY FOR THE CREATED USER'
//GlobalVariable.apiKeyStatus = apiKeyIsActive[0]
//GlobalVariable.userApiKey = UUID.randomUUID()
//WS.callTestCase(findTestCase('API Coverage/Platform/apiKeyStatusCheck/apiKeyUserSet'),
//	null)
//println GlobalVariable.apiKeyId
//println GlobalVariable.userId
//println GlobalVariable.userApiKey
//'****'
//
////'GET & UPDATE THE CREATED USER TO ADD USERTYPE (to make possible to get the proper response)'
////userUpdate = WS.callTestCase(findTestCase('null'), 
////	null)
//
//'*******'
//'GET USER DATA'
//userGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserGetUserById', [
//	('userId') : GlobalVariable.userId
//	]))
//userGetBody = userGet.getResponseBodyContent()
//println userGetBody
//userBodyParsed = new JsonSlurper().parseText(userGetBody)
//userBodyParsed.userType = 'Manager' 
////userBodyParsed.concurrencyStamp = UUID.randomUUID()
//userBodyJson = new groovy.json.JsonBuilder(userBodyParsed).toString()
//println userBodyJson
//
//'SEND REQUEST TO UPDATE THE CREATED USER (LOCK FUNCTION WONT RESPONSE OTHERWISE)'
//RequestObject userBodyObject = findTestObject('Object Repository/API/backWebServices/_DEBUG/UserUpdateNoRoles')
//userBodyObject.setBodyContent(new HttpTextBodyContent(userBodyJson))
//userBodyUpdate = WS.sendRequestAndVerify(userBodyObject)
//'*********'








//'IS ACTIVE = TRUE CHECK'
//'**********'
//'SEND REQUEST TO LOCK THE USER'
//userLock = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/userLock', [
//	('userId') : GlobalVariable.userId
//	]))
//
//
//'VERIFY THE LOCK STATE HAS BEEN SET AS EXPECTED'
//lockStateGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/userLockStateGet',[
//	('userId') : GlobalVariable.userId
//	]))
//WS.verifyElementPropertyValue(lockStateGet,'locked', true)
//
//
//'CHECK LOCKED STATE RESPONSE'
//lockedStateResponseCheck = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Platform/apiKeyResponseCheck',[
//	('apiKey') : GlobalVariable.userApiKey
//	]))
//WS.verifyResponseStatusCode(lockedStateResponseCheck, 401)
//
//
//'SEND REQUEST TO UNLOCK THE CREATED USER'
//userUnlock = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/userUnlock', [
//	('userId') : GlobalVariable.userId
//	]))  
//
//
//'VERIFY THE LOCK STATE HAS BEEN SET AS EXPECTED'
//lockStateGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/userLockStateGet',[
//	('userId') : GlobalVariable.userId
//	]))
//WS.verifyElementPropertyValue(lockStateGet,'locked', false)
//
//
//lockedStateResponseCheck = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Platform/apiKeyResponseCheck',[
//	('apiKey') : GlobalVariable.userApiKey
//	]))
//WS.verifyResponseStatusCode(lockedStateResponseCheck, 200)

'*******'









//'IS ACTIVE = FALSE CHECK'
//
//'UPDATE THE API KEY FOR THE CREATED USER (ISACTIVE = false)'
//GlobalVariable.apiKeyStatus = apiKeyIsActive[1]
////GlobalVariable.userApiKey = UUID.randomUUID()
//WS.callTestCase(findTestCase('API Coverage/Platform/apiKeyStatusCheck/apiKeyUserSet'),
//	null)
//println GlobalVariable.apiKeyId
//println GlobalVariable.userId
//println GlobalVariable.userApiKey
//
//
//'SEND REQUEST TO LOCK THE USER'
//userLock = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/userLock', [
//	('userId') : GlobalVariable.userId
//	]))
//
//
//'VERIFY THE LOCK STATE HAS BEEN SET AS EXPECTED'
//lockStateGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/userLockStateGet',[
//	('userId') : GlobalVariable.userId
//	]))
//WS.verifyElementPropertyValue(lockStateGet,'locked', true)
//
//
//'CHECK LOCKED STATE RESPONSE'
//lockedStateResponseCheck = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Platform/apiKeyResponseCheck',[
//	('apiKey') : GlobalVariable.userApiKey
//	]))
//WS.verifyResponseStatusCode(lockedStateResponseCheck, 401)
//
//
//'SEND REQUEST TO UNLOCK THE CREATED USER'
//userUnlock = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/userUnlock', [
//	('userId') : GlobalVariable.userId
//	]))
//
//
//'VERIFY THE LOCK STATE HAS BEEN SET AS EXPECTED'
//lockStateGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/userLockStateGet',[
//	('userId') : GlobalVariable.userId
//	]))
//WS.verifyElementPropertyValue(lockStateGet,'locked', false)
//
//
//lockedStateResponseCheck = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Platform/apiKeyResponseCheck',[
//	('apiKey') : GlobalVariable.userApiKey
//	]))
//WS.verifyResponseStatusCode(lockedStateResponseCheck, 401)













'SEND REQUEST TO DELETE THE CREATED USER'
userDelete = WS.callTestCase(findTestCase('Test Cases/API Coverage/Platform/UserDelete'),
	null)


'VERIFY THE RESPONSE CHECK RETURN THE EXPECTED RESULT'
lockedStateResponseCheck = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Platform/apiKeyResponseCheck',[
	('apiKey') : GlobalVariable.userApiKey
	]))
WS.verifyResponseStatusCode(lockedStateResponseCheck, 401)




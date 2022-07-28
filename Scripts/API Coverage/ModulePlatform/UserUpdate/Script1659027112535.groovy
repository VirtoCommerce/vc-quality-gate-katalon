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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil


import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonOutput
import com.kms.katalon.core.testobject.ResponseObject


WebUI.comment('TEST CASE: update created user')

'GET CREATED USER DATA TO UPDATE USER'
userGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserGetUserById', [
	('userId') : GlobalVariable.userId
	]))
userGetBody = userGet.getResponseBodyContent()
println userGetBody
userBodyParsed = new JsonSlurper().parseText(userGetBody)
userBodyParsed.userType = GlobalVariable.userType
userBodyParsed.isAdministrator = GlobalVariable.isAdministratorStatus
userBodyJson = new groovy.json.JsonBuilder(userBodyParsed).toString()
println userBodyJson


'SEND REQUEST TO UPDATE THE CREATED USER (update is required to make a user lockble (workflow peculiarity))'
RequestObject userBodyObject = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Platform/UserUpdate')
userBodyObject.setBodyContent(new HttpTextBodyContent(userBodyJson))
userUpdate = WS.sendRequestAndVerify(userBodyObject)
WS.verifyElementPropertyValue(userUpdate, 'succeeded', true)
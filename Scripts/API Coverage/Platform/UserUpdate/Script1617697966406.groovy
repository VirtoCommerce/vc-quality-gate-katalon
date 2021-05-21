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

WebUI.comment('TEST CASE: Update userName/email/userType')

//set new userName in global variables
GlobalVariable.userName = GlobalVariable.userName + "Updated"
GlobalVariable.email = GlobalVariable.email + "Updated"

WebUI.comment("USER ID IS : " + GlobalVariable.userId)

response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserUpdate', [
	('userName') : GlobalVariable.userName,
	('userEmail') : GlobalVariable.email,
	('userId') : GlobalVariable.userId,
	('userType') : 'Manager',
	('emailConfirmed')	: 'true'
	]))
WS.verifyElementPropertyValue(response, 'succeeded', true)
WS.verifyElementPropertyValue(response, 'errors', '[]')


// Verify that updates appllies
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserSearch', [
	('searchPhrase') : GlobalVariable.userName
	]))
WS.verifyElementPropertyValue(response, 'users[0].userName', GlobalVariable.userName)
WS.verifyElementPropertyValue(response, 'users[0].email', GlobalVariable.email)
WS.verifyElementPropertyValue(response, 'users[0].id', GlobalVariable.userId)
WS.verifyElementPropertyValue(response, 'users[0].userType', 'Manager')
WS.verifyElementPropertyValue(response, 'users[0].emailConfirmed', 'true')


//set user back to initial state
//response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserUpdate', [
//	('userName') : GlobalVariable.userName,
//	('userEmail') : GlobalVariable.email,
//	('userId') : GlobalVariable.userId,	
//	('userType') : "Customer"
//	('emailConfirmed')	: "true"
//	]))
//WS.verifyElementPropertyValue(response, 'succeeded', true)
//WS.verifyElementPropertyValue(response, 'errors', '[]')

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

WebUI.comment('TEST CASE: Update user by account type')

response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserUpdate',
	[('userName')  : GlobalVariable.userName,
	 ('userEmail') : GlobalVariable.email,
	 ('userID') : GlobalVariable.userID,
	 ('userType') : "Customer",
	 ('emailConfirmed')	: "false"	
	]))
WS.verifyElementPropertyValue(response, 'succeeded', true)
WS.verifyElementPropertyValue(response, 'errors', '[]')

//verify that updates applly
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserSearch',
	[ ('userName') : GlobalVariable.userName
		]))
WS.verifyElementPropertyValue(response, 'users[0].userName', GlobalVariable.userName)
WS.verifyElementPropertyValue(response, 'users[0].email', GlobalVariable.email)
WS.verifyElementPropertyValue(response, 'users[0].id', GlobalVariable.userID)
WS.verifyElementPropertyValue(response, 'users[0].userType', "Customer")

//set login back to initial state
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserUpdate',
	[('userName')  : GlobalVariable.userName,
	 ('userEmail') : GlobalVariable.email,
	 ('userID') : GlobalVariable.userID,
	 ('userType') : "Manager",
	 ('emailConfirmed')	: "false"
	]))
WS.verifyElementPropertyValue(response, 'succeeded', true)
WS.verifyElementPropertyValue(response, 'errors', '[]')

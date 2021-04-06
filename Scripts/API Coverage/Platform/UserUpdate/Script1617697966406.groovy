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

WebUI.comment('TEST CASE: Update username for user')


response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserUpdate',
	[('userName')  : GlobalVariable.userName + "UPD",
	 ('userEmail') : GlobalVariable.email + "UPD",
	 ('userID') : GlobalVariable.userID,
	 ('userType') : "Customer",
	 ('emailConfirmed')	: "false"
	]))
WS.verifyElementPropertyValue(response, 'succeeded', true)
WS.verifyElementPropertyValue(response, 'errors', '[]')

//verify that updates appllies
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserSearch',
	[ ('userName') : "QweUserUPD"
		]))
WS.verifyElementPropertyValue(response, 'users[0].userName', GlobalVariable.userName + "UPD")
WS.verifyElementPropertyValue(response, 'users[0].email', GlobalVariable.email + "UPD")
WS.verifyElementPropertyValue(response, 'users[0].id', GlobalVariable.userID)
WS.verifyElementPropertyValue(response, 'users[0].userType', "Customer")
WS.verifyElementPropertyValue(response, 'users[0].emailConfirmed', "false")

//set user back to initial state
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserUpdate',
	[('userName')  :GlobalVariable.userName,
	 ('userEmail') : GlobalVariable.email,
	 ('userID') : GlobalVariable.userID,
	 ('userType') : "Manager",
	 ('emailConfirmed')	: "true"
	]))
WS.verifyElementPropertyValue(response, 'succeeded', true)
WS.verifyElementPropertyValue(response, 'errors', '[]')


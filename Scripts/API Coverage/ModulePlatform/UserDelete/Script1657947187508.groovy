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

WebUI.comment('TEST CASE: Delete user')

response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserDelete', [
	('userName') : GlobalVariable.userName]
))
WS.verifyElementPropertyValue(response, 'succeeded', true)


// Verify that user is deleted
GlobalVariable.token = '' //recent changes made it sensitive to token value need to clear it
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserSearch', [
	('userName') : GlobalVariable.userName
	]))
WS.verifyElementPropertyValue(response, 'totalCount', 0)
WS.verifyElementPropertyValue(response, 'results', '[]')

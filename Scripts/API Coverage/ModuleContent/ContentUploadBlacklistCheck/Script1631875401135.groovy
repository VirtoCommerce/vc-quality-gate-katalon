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

import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonOutput
import com.kms.katalon.core.util.KeywordUtil

WebUI.comment('TEST CASE: Content. Check errors during to uploading a new file')

//UPDATE THE BLACKLIST CONFIGURATION
WS.callTestCase(findTestCase('Test Cases/API Coverage/Platform/SettingsUpdateBlacklist'), null,
FailureHandling.STOP_ON_FAILURE)


//SET THE FILE NAME AND THE ERROR MESSAGE
fileName = 'forbidden.exe'
errorMessage = 'This extension is not allowed. Please contact administrator.'


//CREATE A MAP OF ENDPOINTS TO CHECK AND SEND EACH VALUE TO THE ENDPOINT
HashMap<String, String> contentTypes = GlobalVariable.contentTypesMap
for (String contentType : contentTypes.keySet()) {
	upload = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentFileNew', [
		('contentType') : contentType,
		('storeId') : GlobalVariable.storeId,
		('folderName') : GlobalVariable.folderName,
		('fileName') : fileName
		]))//;FailureHandling.OPTIONAL
	WS.verifyResponseStatusCode(upload, 405)
	WS.containsString(upload, errorMessage, false)
	}

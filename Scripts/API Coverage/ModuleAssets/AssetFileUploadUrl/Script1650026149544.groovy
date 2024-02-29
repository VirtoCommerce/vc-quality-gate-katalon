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


WebUI.comment('TEST CASE: Assets. Upload ZIP file by URL')


//UPDATE THE BLACKLIST CONFIGURATION TO CHECK IF THE FORBIDDEN EXTENSION FILE CANT BE UPLOADED
WS.callTestCase(findTestCase('API Coverage/ModulePlatform/SettingsUpdateBlacklist'), null,
FailureHandling.STOP_ON_FAILURE)


//UPLOAD A FILE WITH THE FORBIDDEN EXTENSION
errorMessage = 'This extension is not allowed. Please contact administrator.'
forbiddenFileUrl = 'https://raw.githubusercontent.com/VirtoCommerce/vc-quality-gate-katalon/testfile/test.sitemap'
uploadForbiddenFileUrl = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Assets/AssetFileUpload', [
	('folderUrl') : GlobalVariable.folderUrl,
	('url') : forbiddenFileUrl
	]))
WS.verifyResponseStatusCode(uploadForbiddenFileUrl, 405)
WS.containsString(uploadForbiddenFileUrl, errorMessage, false)


//UPLOAD AN ARCHIVE WITH THE CORRECT EXTENSION
correctFileUrl = 'https://github.com/VirtoCommerce/vc-module-cart/releases/download/3.15.0/VirtoCommerce.Cart_3.15.0.zip'
uploadFileUrl = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Assets/AssetFileUpload', [
	('folderUrl') : GlobalVariable.folderUrl,
	('url') : correctFileUrl
	]))
//get file url
GlobalVariable.uploadFileUrl = WS.getElementPropertyValue(uploadFileUrl, '[0].url')

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

//UPDATE THE BLACKLIST CONFIGURATION
WS.callTestCase(findTestCase('Test Cases/API Coverage/Platform/SettingsUpdateBlacklist'), null, 
FailureHandling.STOP_ON_FAILURE)


//SET THE FILE NAME AND THE ERROR MESSAGE
fileName = 'forbidden.exe'
errorMessage = 'This extension is not allowed. Please contact administrator.'


//THIS PART NEEDS TO BE LOOPED
//UPLOAD PART
//UPLOAD A FILE WITH THE FORBIDDEN EXTENSION TO BLOGS
GlobalVariable.contentType = "blogs"
uploadToBlogs = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentFileNew', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('folderName') : GlobalVariable.folderName,
	('fileName') : fileName
	]))//;FailureHandling.OPTIONAL
WS.verifyResponseStatusCode(uploadToBlogs, 500)
WS.containsString(uploadToBlogs, errorMessage, false)


//UPLOAD A FILE WITH THE FORBIDDEN EXTENSION TO PAGES
GlobalVariable.contentType = "pages"
uploadToPages = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentFileNew', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('fileName') : fileName,
	('folderName') : GlobalVariable.folderName
	]))
WS.verifyResponseStatusCode(uploadToPages, 500)
WS.containsString(uploadToPages, errorMessage, false)


//UPLOAD A FILE WITH THE FORBIDDEN EXTENSION TO THEMES
GlobalVariable.contentType = "themes"
uploadToThemes = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentFileNew', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('fileName') : fileName,
	('folderName') : GlobalVariable.folderName
	]))
WS.verifyResponseStatusCode(uploadToThemes, 500)
WS.containsString(uploadToPages, errorMessage, false)

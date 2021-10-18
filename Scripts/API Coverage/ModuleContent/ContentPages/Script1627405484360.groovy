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

WebUI.comment('TEST CASE: Pages. Upload file from local')

GlobalVariable.contentType = "pages"


//UPDATE THE BLACKLIST CONFIGURATION
WS.callTestCase(findTestCase('Test Cases/API Coverage/Platform/SettingsUpdateBlacklist'), null,
FailureHandling.STOP_ON_FAILURE)


//Get store stats to get initial state. Set PAGE count to compare with final result
stats = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentStatsStoreGet', [
	('storeId') : GlobalVariable.storeId
	]))
count = WS.getElementPropertyValue(stats, 'pagesCount')


//Create a folder
folderCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentFolderCreate', [
	('contentType') : GlobalVariable.contentType ,
	('storeId') : GlobalVariable.storeId,
	('folderName') : GlobalVariable.folderName
	]))
	

//Check if the created folder exists (search for the name)
request = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentSearch', [
	('contentType') : GlobalVariable.contentType ,
	('storeId') : GlobalVariable.storeId,
	('keyword') : GlobalVariable.folderName
	]))
WS.verifyElementPropertyValue(request,'[0].name',GlobalVariable.folderName)


//Upload file to the created folder
fileName = 'qwepage.en-US.md'
uploadFileUrlLocal = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentFileNew', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('fileName') : fileName,
	('folderName') : GlobalVariable.folderName
	]))


//Verify that the file was successfully uploaded and exists
verification = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentGet', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('relativeUrl') : '/' + GlobalVariable.folderName + '/' + fileName
	]))


//Get the file data to set variables for the ContentMove request
fileData = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentSearch', [
	('contentType') : GlobalVariable.contentType ,
	('storeId') : GlobalVariable.storeId,
	('keyword') : fileName
	]))
WS.verifyElementPropertyValue(fileData, '[0].name', fileName)


//Set variables for the ContentMove request
newFileName = 'renamed' + fileName
forbiddenFileName = fileName.replaceAll('.md', '.exe')
oldUrl = WS.getElementPropertyValue(fileData, '[0].url')
forbiddenUrl = oldUrl.replaceAll(fileName, forbiddenFileName)
newUrl = oldUrl.replaceAll(fileName, newFileName)


//Send ContentMove request to rename the page with the FORBIDDEN EXTENSION file
errorMessage = 'This extension is not allowed. Please contact administrator.'
forbiddenRename = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentMove', [
	('contentType') : GlobalVariable.contentType ,
	('storeId') : GlobalVariable.storeId,
	('oldUrl') : oldUrl,
	('newUrl') : forbiddenUrl
	]))
WS.verifyResponseStatusCode(forbiddenRename, 500)
WS.containsString(forbiddenRename, errorMessage, false)


//Send ContentMove request to rename the file
rename = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentMove', [
	('contentType') : GlobalVariable.contentType ,
	('storeId') : GlobalVariable.storeId,
	('oldUrl') : oldUrl,
	('newUrl') : newUrl
	]))


//Verify if the file is accessible via search
search = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentSearch', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('keyword') : newFileName
	]))
WS.verifyElementPropertyValue(search, '[0].name', newFileName)


//Delete the created file
deleteFile = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentDelete', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('folderName') : '/' + GlobalVariable.folderName + '/' + newFileName
	]))


//Check if the created file has been deleted (search for the name)
fileDeleted = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentSearch', [
	('contentType') : GlobalVariable.contentType ,
	('storeId') : GlobalVariable.storeId,
	('keyword') : newFileName
	]))
WS.verifyElementPropertyValue(fileDeleted, '[0]', null)


//Delete the created folder
deleteFolder = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentDelete', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('folderName') : GlobalVariable.folderName
	]))


//Get store stats to verify pages count has been changed
stats = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentStatsStoreGet', [
	('storeId') : GlobalVariable.storeId
	]))
WS.verifyElementPropertyValue(stats, 'pagesCount', count)

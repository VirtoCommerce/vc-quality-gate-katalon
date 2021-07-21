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

WebUI.comment('TEST CASE: Theme. Upload file from local')

GlobalVariable.contentType = "themes"

//Get store stats to get initial state. Set THEME count to compare with final result
stats = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentStatsStoreGet', [
	('storeId') : GlobalVariable.storeId
	]))
count = WS.getElementPropertyValue(stats, 'themesCount')


//Upload .zip file to the platform to unpack it in the further steps
archiveName = 'theme_test_x.zip'
uploadFileUrlLocal = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentFileNew', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('fileName') : archiveName
	]))


//Verify the file has been uploaded
searchFile = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentSearch', [
	('contentType') : GlobalVariable.contentType ,
	('storeId') : GlobalVariable.storeId,
	('keyword') : archiveName
	]))
WS.verifyElementPropertyValue(searchFile, '[0].name', archiveName)


//Get uploaded archive path if file uploaded correctly
archivePath = WS.getElementPropertyValue(uploadFileUrlLocal, '[0].url')
println archivePath

//Unpack the archive to its current location directory
folderName = archiveName.substring(0, archiveName.lastIndexOf("."))
unpackArchive = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentUnpack', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('folderUrl') : folderName,
	('archivePath') : archivePath
	]))


//Verify that the archive was successfully unpacked and unpacked file exists
fileName = 'theme_test.html' //static file name in prepared ZIP file in TestFiles folder
unpackedHtmlFile = WS.sendRequestAndVerify(findTestObject('API/backWebservices/VirtoCommerce.Content/ContentGet', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('relativeUrl') : '/' + folderName + '/' + fileName
	]))


//Delete the created folder
deleteFolder = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentDelete', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('folderName') : folderName
	]))


//Get store stats to verify the added theme folder was deleted
stats = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentStatsStoreGet', [
	('storeId') : GlobalVariable.storeId
	]))
WS.verifyElementPropertyValue(stats, 'themesCount', count)

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

//Upload .zip file to the platform to unpack it in the further steps
uploadFileUrlLocal = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentFileNew', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('fileName') : 'theme_test_x.zip'
	]))

//Verify the file has been uploaded
searchFile = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentSearch', [
	('contentType') : GlobalVariable.contentType ,
	('storeId') : GlobalVariable.storeId,
	('keyword') : 'theme_test_x.zip'
	]))
WS.verifyElementPropertyValue(searchFile,'[0].name','theme_test_x.zip')

//Get uploaded archive path 
archivePath = WS.getElementPropertyValue(uploadFileUrlLocal, '[0].url')

//Unpack the archive to its current location directory
unpackArchive = WS.sendRequestAndVerify(findTestObject('API/backWebServices/virtoCommerce.Content/ContentUnpack', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('folderUrl') : 'theme_test_x',
	('archivePath') : archivePath
	]))

//Verify that the archive was successfully unpacked and unpacked file exists
unpackedHtmlFile = WS.sendRequestAndVerify(findTestObject('API/backWebservices/virtoCommerce.Content/ContentGet', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('relativeUrl') : '/theme_test_x/theme_test.html'
	]))


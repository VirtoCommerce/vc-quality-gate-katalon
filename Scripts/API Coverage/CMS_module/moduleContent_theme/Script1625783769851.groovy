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

WebUI.comment('TEST CASE: Theme. Create/delete theme folder')

GlobalVariable.contentType = "themes"

//Create a folder 
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentFolderCreate', [
	('contentType') : GlobalVariable.contentType ,
	('storeId') : GlobalVariable.storeId,
	('folderName') : GlobalVariable.folderName
	]))
	

//Check if the created folder exists (compare the actual name to a GlobalVariable)
request = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentSearch', [
	('contentType') : GlobalVariable.contentType ,
	('storeId') : GlobalVariable.storeId
	]))

//Verify folder has the expected name now
verification = WS.verifyElementPropertyValue(request, '[1].name', GlobalVariable.folderName)
//WS.delay(10)

//Get store stats to verify themes count has been changed
stats = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentStatsStoreGet', [
	('storeId') : GlobalVariable.storeId
	]))

//Verify themes cound has been changed accordingly to the request send
statsVerification =	WS.verifyElementPropertyValue(stats, 'themesCount', 2)

//Delete the created folder
deleteFolder = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentDelete', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('folderName') : GlobalVariable.folderName 
	]))
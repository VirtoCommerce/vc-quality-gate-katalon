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
import groovy.json.JsonSlurper

WebUI.comment('TEST CASE: Theme. Create + Rename + Delete a theme')

GlobalVariable.contentType = "themes"

//Get store stats to get initial state. Set THEME count to compare with final result
stats = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentStatsStoreGet', [
	('storeId') : GlobalVariable.storeId
	]))
count = WS.getElementPropertyValue(stats, 'themesCount')


//First create a theme folder
createFolder = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentFolderCreate', [
	('contentType') : GlobalVariable.contentType ,
	('storeId') : GlobalVariable.storeId,
	('folderName') : GlobalVariable.folderName
	]))


//Get the folder Url and parentUrl to set variables for the ContentMove request
folderData = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentSearch', [
	('contentType') : GlobalVariable.contentType ,
	('storeId') : GlobalVariable.storeId,
	('keyword') : GlobalVariable.folderName
	]))
WS.verifyElementPropertyValue(folderData,'[0].name',GlobalVariable.folderName)


//Set variables for the ContentMove request
newFolderName = GlobalVariable.folderName + 'Renamed'
oldUrl = WS.getElementPropertyValue(folderData, '[0].url')
newUrl = WS.getElementPropertyValue(folderData, '[0].parentUrl') + newFolderName


//Send ContentMove request to rename the folder
rename = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentMove', [
	('contentType') : GlobalVariable.contentType ,
	('storeId') : GlobalVariable.storeId,
	('oldUrl') : oldUrl,
	('newUrl') : newUrl
	]))


//Verify the folder name has been changed (search for new name)
renamedFolder = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentSearch', [
	('contentType') : GlobalVariable.contentType ,
	('storeId') : GlobalVariable.storeId,
	('keyword') : newFolderName
	]))
WS.verifyElementPropertyValue(renamedFolder,'[0].name', newFolderName)


//Delete the created folder
deleteFolder = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentDelete', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('folderName') : newFolderName
	]))


//Get store stats to verify the added theme folder was deleted and verify that Theme count in initial state
stats = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentStatsStoreGet', [
	('storeId') : GlobalVariable.storeId
	]))
WS.verifyElementPropertyValue(stats, 'themesCount', count)

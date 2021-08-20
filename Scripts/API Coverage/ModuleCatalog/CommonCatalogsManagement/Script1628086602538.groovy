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

WebUI.comment('TEST CASE: Common Catalogs management - add, update, delete')

catalogName = 'AutoTestCatalog'

// Create new catalog
catalogCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsCreate', [
	('name') : catalogName
	]))
WS.verifyElementPropertyValue(catalogCreate, 'name', catalogName)


//Verify that catalog was added 
catalogSearch = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsSearch', [
	('keyword') : catalogName
	]))
WS.verifyElementPropertyValue(catalogSearch, 'results[0].name', catalogName)
WS.verifyElementPropertyValue(catalogSearch, 'totalCount', 1)


//save catalog ID to use in Update and Delete cases
catalogId = WS.getElementPropertyValue(catalogSearch, 'results[0].id')
WebUI.comment(catalogId)
catalogName = (catalogName + 'UPD')


//Update catalog
catalogUpdate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsUpdate', [
	('name') : catalogName, 
	('id') : catalogId
	]))


//Verify that catalog was upadted
catalogSearch2 = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsSearch', [
	('keyword') : catalogName
	]))
WS.verifyElementPropertyValue(catalogSearch2, 'results[0].name', catalogName)
WS.verifyElementPropertyValue(catalogSearch2, 'results[0].id', catalogId)
WS.verifyElementPropertyValue(catalogSearch2, 'totalCount', 1)


// Delete catalog
catalogDelete = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsDeleteById', [
	('id') : catalogId
	]))


//Verify that catalog was deleted
catalogSearch3 = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsSearch', [('keyword') : catalogName]))
WS.verifyElementPropertyValue(catalogSearch3, 'totalCount', 0)

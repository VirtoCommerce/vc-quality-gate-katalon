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

// CREATE NEW CATALOG
catalogCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsCreate', [
	('name') : catalogName
	]))
WS.verifyElementPropertyValue(catalogCreate, 'name', catalogName)


//VERIFY THAT CATALOG WAS ADDED 
searchCreated = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsSearch', [
	('keyword') : catalogName
	]))
WS.verifyElementPropertyValue(searchCreated, 'results[0].name', catalogName)
WS.verifyElementPropertyValue(searchCreated, 'totalCount', 1)


//GET THE CATALOG ID TO USE IN UPDATE AND DELETE CASES
catalogId = WS.getElementPropertyValue(searchCreated, 'results[0].id')
WebUI.comment(catalogId)
newCatalogName = (catalogName + 'UPD')


//UPDATE THE CATALOG
catalogUpdate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsUpdate', [
	('name') : newCatalogName, 
	('id') : catalogId
	]))


//VERIFY THE CATALOG WAS UPDATED
searchUpdated = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsSearch', [
	('keyword') : newCatalogName
	]))
WS.verifyElementPropertyValue(searchUpdated, 'results[0].name', newCatalogName)
WS.verifyElementPropertyValue(searchUpdated, 'results[0].id', catalogId)
WS.verifyElementPropertyValue(searchUpdated, 'totalCount', 1)


//DELETE THE CATALOG
catalogDelete = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsDeleteById', [
	('id') : catalogId
	]))


//VERIFY THE CATALOG WAS DELETED
searchDeleted = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsSearch', [
	('keyword') : catalogName
	]))
WS.verifyElementPropertyValue(searchDeleted, 'totalCount', 0)

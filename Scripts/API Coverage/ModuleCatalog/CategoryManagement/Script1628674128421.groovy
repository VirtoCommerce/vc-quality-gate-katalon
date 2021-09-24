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

WebUI.comment('TEST CASE: categories management - add, update, delete')

categoryName = 'QWECategory'

// Get code for new category
categoryGetNew = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CategoriesGetNewTemplate', [
	('catalogId') : GlobalVariable.catalogId
	]))
WS.verifyElementPropertyValue(categoryGetNew, 'seoObjectType', 'Category')


//save category code for creation
categoryCode = WS.getElementPropertyValue(categoryGetNew, 'code')


// Create new category
categoryCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CategoriesCreate', [
	('catalogId') : GlobalVariable.catalogId,
	('code') : categoryCode,
	('name') : categoryName
	]))
WS.verifyElementPropertyValue(categoryCreate, 'catalogId', GlobalVariable.catalogId)
WS.verifyElementPropertyValue(categoryCreate, 'name', categoryName)
WS.verifyElementPropertyValue(categoryCreate, 'code', categoryCode)


//save category ID for upadting and deleting
categoryId = WS.getElementPropertyValue(categoryCreate, 'id')
WebUI.comment(categoryId)


//Verify that category was added 
categoryGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CategoriesGetById', [
	('id') : categoryId
	]))
WS.verifyElementPropertyValue(categoryGet, 'catalogId', GlobalVariable.catalogId)
WS.verifyElementPropertyValue(categoryGet, 'name', categoryName)
WS.verifyElementPropertyValue(categoryGet, 'code', categoryCode)


//Update category
categoryName = (categoryName + 'UPD')
WebUI.comment(categoryName)
categoryUpdate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CategoriesUpdate', [
	('catalogId') : GlobalVariable.catalogId,
	('code') : categoryCode,
	('name') : categoryName,
	('categoryId') : categoryId
	]))


//Verify that category was upadted
categoryGet2 = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CategoriesGetById', [
	('id') : categoryId
	]))
WS.verifyElementPropertyValue(categoryGet2, 'catalogId', GlobalVariable.catalogId)
WS.verifyElementPropertyValue(categoryGet2, 'name', categoryName)
WS.verifyElementPropertyValue(categoryGet2, 'code', categoryCode)


// Delete category
categoryDelete = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ListentriesDelete', [
	('objectIds') : categoryId
	]))


//Verify that catalog was deleted
categorySearch = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ListentriesSearch', [
	('catalogId') : GlobalVariable.catalogId,
	('keyword') : categoryName
	]))
WS.verifyElementPropertyValue(categorySearch, 'totalCount', 0)

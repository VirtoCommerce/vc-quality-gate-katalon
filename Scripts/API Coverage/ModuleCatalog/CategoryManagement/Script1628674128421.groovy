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

categoryName = 'QWECategory'

// Get code for new category
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CategoriesGetNewTemplate', 
        [('catalogId') : GlobalVariables.catalogId]))

WS.verifyElementPropertyValue(response, 'seoObjectType', 'Category')

//save category code for creation
categoryCode = WS.getElementPropertyValue(response, 'code')

// Create new category
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CategoriesCreate', [('catalogId') : GlobalVariables.catalogId
            , ('code') : categoryCode, ('name') : categoryName]))

WS.verifyElementPropertyValue(response, 'catalogId', GlobalVariables.catalogId)

WS.verifyElementPropertyValue(response, 'name', categoryName)

WS.verifyElementPropertyValue(response, 'code', categoryCode)

//save category ID for upadting and deleting
categoryId = WS.getElementPropertyValue(response, 'id')
WebUI.comment(categoryId)

//Verify that category was added 
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CategoriesGetById', [('id') : categoryId]))

WS.verifyElementPropertyValue(response, 'catalogId', GlobalVariables.catalogId)

WS.verifyElementPropertyValue(response, 'name', categoryName)

WS.verifyElementPropertyValue(response, 'code', categoryCode)

//Update category
categoryName = (categoryName + 'UPD')

WebUI.comment(categoryName)

response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsUpdate', [('name') : catalogName
            , ('id') : catalogId]))

//Verify that catalog was upadted
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsSearch', [('keyword') : catalogName]))

WS.verifyElementPropertyValue(response, 'results[0].name', catalogName)

WS.verifyElementPropertyValue(response, 'results[0].id', catalogId)

WS.verifyElementPropertyValue(response, 'totalCount', 1)

// Delete catalog
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsDeleteById', [('id') : catalogId]))

//Verify that catalog was deleted
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsSearch', [('keyword') : catalogName]))

WS.verifyElementPropertyValue(response, 'totalCount', 0)


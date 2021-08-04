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

propertyType = 'VirtoCommerce.StoreModule.Core.Model.Store'

propertyName = 'Qwe Property Store'

// Create new catalog
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsCreate'))

WS.verifyElementPropertyValue(response, 'objectType', propertyType)

WS.verifyElementPropertyValue(response, 'name', propertyName)

//Verify that catalog was added 
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsSearch'))

WS.verifyElementPropertyValue(response, 'results[0].name', propertyName)

WS.verifyElementPropertyValue(response, 'results[0].objectType', propertyType)

WS.verifyElementPropertyValue(response, 'totalCount', 1)

//save property ID to use in Update and Delete cases
propertyId = WS.getElementPropertyValue(response, 'results[0].id')

//Update catalog
propertyName = (propertyName + 'Updated')

description = 'Qwe Description Updated'

response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsUpdate'))

//Verify that catalog was upadted
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsSearch'))

WS.verifyElementPropertyValue(response, 'results[0].description', description)

WS.verifyElementPropertyValue(response, 'results[0].objectType', propertyType)

WS.verifyElementPropertyValue(response, 'results[0].name', propertyName)

WS.verifyElementPropertyValue(response, 'totalCount', 1)

// Delete catalog
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsDeleteById', [('id') : '']))

//Verify that catalog was deleted
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsSearch'))

WS.verifyElementPropertyValue(response, 'totalCount', 0)


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

WebUI.comment('TEST CASE: Products management - add, update, delete')

productName = 'QweProduct'

// Create new catalog
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductCreate', [('name') : productName]))

WS.verifyElementPropertyValue(response, 'name', 'QweProduct')

//Verify that catalog was added 
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetByIdAndGroup'))

WS.verifyElementPropertyValue(response, 'results[0].name', productName)

WS.verifyElementPropertyValue(response, 'totalCount', 1)

//save catalog ID to use in Update and Delete cases
catalogId = WS.getElementPropertyValue(response, 'results[0].id')

WebUI.comment(catalogId)

catalogName = (productName + 'UPD')

WebUI.comment(catalogName)

//Update catalog
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsUpdate'))

//Verify that catalog was upadted
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetByIdAndGroup'))

WS.verifyElementPropertyValue(response, 'results[0].name', productName)

WS.verifyElementPropertyValue(response, 'results[0].id', catalogId)

WS.verifyElementPropertyValue(response, 'totalCount', 1)

// Delete catalog
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ListentriesDelete'))

//Verify that catalog was deleted
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsSearch', [('keyword') : productName]))

WS.verifyElementPropertyValue(response, 'totalCount', 0)


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

WebUI.comment('TEST CASE: Products management - cut/paste, dimensions')
productName = 'QweDrinkProductCutPaste'

// Create new product
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductCreateUpdate', [('name') : productName]))
WS.verifyElementPropertyValue(response, 'name', productName)

//save catalog ID to use in Update and Delete cases
productId = WS.getElementPropertyValue(response, 'id')
WebUI.comment(productId)

//save categoryName
categoryName = WS.getElementPropertyValue(response, 'path')
WebUI.comment(categoryName)

//Verify that product was added 
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetByIdAndGroup', [
            ('id') : productId]))
WS.verifyElementPropertyValue(response, '[0].name', productName)

//Save catalog name
catalogName = WS.getElementPropertyValue(response, '[0].outlines[0].items[0].name')
WebUI.comment(catalogName)

//Move product to root catalog
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ListentriesMove', 
	[('name') : productName, 
	('code') : GlobalVariable.sku, 
	('catalogId') : GlobalVariable.catalogId, 
	('categoryIdFrom') : GlobalVariable.categoryId, 
	('productId') : productId, 
	('catalogName') : catalogName, 
	('categoryNameFrom') : categoryName
	]))

//Verify that product was moved to root catalog 
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetByIdAndGroup', [
            ('id') : productId]))
WS.verifyElementPropertyValue(response, '[0].path', null)

// update dimensions for product
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductCreateUpdate', 
	[('name') : productName, 
	 ('weightUnit') : 'pound', 
	 ('weight') : 200, 
	 ('height') : 200, 
	 ('width') : 200, 
	 ('length') : 200
	]))

//Verify that product was upadted
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetByIdAndGroup', [
            ('id') : productId]))
WS.verifyElementPropertyValue(response, '[0].weightUnit', 'pound')
WS.verifyElementPropertyValue(response, '[0].weight', 200.00)
WS.verifyElementPropertyValue(response, '[0].height', 200.00)
WS.verifyElementPropertyValue(response, '[0].width', 200.00)
WS.verifyElementPropertyValue(response, '[0].length', 200.00)
WS.verifyElementPropertyValue(response, '[0].name', productName)


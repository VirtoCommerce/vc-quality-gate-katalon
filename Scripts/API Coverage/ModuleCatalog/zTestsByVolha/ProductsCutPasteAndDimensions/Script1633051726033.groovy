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


'CREATE NEW PRODUCT'
createProduct = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductUpdate', [
	('name') : productName
	]))
WS.verifyElementPropertyValue(createProduct, 'name', productName)


'SAVE CATALOG ID TO USE IN UPDATE AND DELETE CASES'
productId = WS.getElementPropertyValue(createProduct, 'id')
WebUI.comment(productId)


'SAVE CATEGORY NAME'
categoryName = WS.getElementPropertyValue(createProduct, 'path')
WebUI.comment(categoryName)


'VERIFY THAT PRODUCT WAS ADDED' 
verifyCreated = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetByIdAndGroup', [
	('id') : productId
	]))
WS.verifyElementPropertyValue(verifyCreated, '[0].name', productName)


'SAVE CATALOG NAME'
catalogName = WS.getElementPropertyValue(verifyCreated, '[0].outlines[0].items[0].name')
WebUI.comment(catalogName)


'MOVE PRODUCT TO ROOT CATALOG'
move = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ListentriesMove', [
	('name') : productName, 
	('code') : GlobalVariable.sku, 
	('catalogId') : GlobalVariable.catalogId, 
	('categoryIdFrom') : GlobalVariable.categoryId, 
	('productId') : productId, 
	('catalogName') : catalogName, 
	('categoryNameFrom') : categoryName
	]))


'VERIFY THE PRODUCT WAS MOVED TO CATALOG' 
verifyMove = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetByIdAndGroup', [
	('id') : productId
	]))
WS.verifyElementPropertyValue(verifyMove, '[0].path', null)


'UPDATE DIMENSIONS FOR PRODUCT'
dimensionsUpdate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductUpdate', [
	('name') : productName, 
	('weightUnit') : 'pound', 
	('weight') : 200, 	
	('height') : 200, 
	('width') : 200, 
	('length') : 200
	]))


'VERIFY THE PRODUCT WAS UPDATED'
verifyDimensions = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetByIdAndGroup', [
	('id') : productId
	]))
WS.verifyElementPropertyValue(verifyDimensions, '[0].weightUnit', 'pound')
WS.verifyElementPropertyValue(verifyDimensions, '[0].weight', 200.00)
WS.verifyElementPropertyValue(verifyDimensions, '[0].height', 200.00)
WS.verifyElementPropertyValue(verifyDimensions, '[0].width', 200.00)
WS.verifyElementPropertyValue(verifyDimensions, '[0].length', 200.00)
WS.verifyElementPropertyValue(verifyDimensions, '[0].name', productName)


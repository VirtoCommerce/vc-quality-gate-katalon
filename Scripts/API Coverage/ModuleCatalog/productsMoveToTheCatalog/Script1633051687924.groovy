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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil


WebUI.comment('TEST CASE: Products management - Cut/Paste/Add dimensions')

'MOVE PRODUCT TO ROOT CATALOG'
move = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ListentriesMove', [
	('name') : GlobalVariable.productName,
	('code') : GlobalVariable.sku,
	('catalogId') : GlobalVariable.catalogId,
	('categoryIdFrom') : GlobalVariable.categoryId,
	('productId') : GlobalVariable.productId,
	('catalogName') : GlobalVariable.catalogName,
	('categoryNameFrom') : GlobalVariable.categoryName
	]))


'VERIFY PRODUCT WAS MOVED TO THE ROOT CATALOG'
verifyMoved = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetByIdAndGroup', [
	('id') : GlobalVariable.productId
	]))
WS.verifyElementPropertyValue(verifyMoved, '[0].path', null)

//'GET MOVED PRODUCT DATA'
//GlobalVariable.productName = WS.getElementPropertyValue(verifyMoved, 'name')
//GlobalVariable.sku = WS.getElementPropertyValue(verifyMoved, 'sku')
//GlobalVariable.catalogId = WS.getElementPropertyValue(verifyMoved, 'catalogId')
//GlobalVariable.categoryId = WS.getElementPropertyValue(verifyMoved, 'categoryId')
//
//
//println GlobalVariable.productName
//println GlobalVariable.sku
//println GlobalVariable.catalogId
//println GlobalVariable.categoryId



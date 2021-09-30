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
productName = 'QweDrink'


// CREATE A NEW PRODUCT
createProduct = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductCreateUpdate', [
	('name') : productName
	]))
WS.verifyElementPropertyValue(createProduct, 'name', productName)


//GET CATALOG ID TO USE IN UPDATE AND DELETE CASES
productId = WS.getElementPropertyValue(createProduct, 'id')
//WebUI.comment(productId)


//VERIFY THE PRODUCT WAS ADDDED 
verifyCreated = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetByIdAndGroup', [
	('id') : productId
	]))
WS.verifyElementPropertyValue(verifyCreated, '[0].name', productName)


//CREATE THE UPDATED NAME
newProductName = (productName + 'UPD')
//WebUI.comment(newProductName)


//UPDATE THE PRODUCT
updateProduct = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductCreateUpdate', [
	('name') : newProductName
	]))


//VERIFY THE PRODUCT WAS UPDATED
verifyUpdated = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetByIdAndGroup', [
	('id') : productId
	]))
WS.verifyElementPropertyValue(verifyUpdated, '[0].name', newProductName)


//DELETE PRODUCT
deleteProduct = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ListentriesDelete', [
	('objectIds') : productId
	]))


//VERIFY THE PRODUCT WAS DELETED
verifyDeleted = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ListentriesSearch', [
	('keyword') : productName
	]))
WS.verifyElementPropertyValue(verifyDeleted, 'totalCount', 0) 


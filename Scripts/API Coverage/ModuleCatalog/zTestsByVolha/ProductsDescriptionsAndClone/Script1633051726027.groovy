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
productName = 'QweDrinkProduct'


//CREATE A NEW PRODUCT
createProduct = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductUpdate', [
	('name') : productName
	]))
WS.verifyElementPropertyValue(createProduct, 'name', productName)


//SAVE CATALOG ID TO USE IN UPDATE AND DELETE CASES
productId = WS.getElementPropertyValue(createProduct, 'id')
//WebUI.comment(productId)


//VERIFY THAT THE PRODUCT WAS ADDED 
verifyCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetByIdAndGroup', [
	('id') : productId
	]))
WS.verifyElementPropertyValue(verifyCreate, '[0].name', productName)


//CREATE THE UPDATED NAME
content = 'Updated quick description'
WebUI.comment(content)


//UPDATE THE PRODUCT
updateProduct = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductUpdate', [
	('name') : productName,
	('content') : content
	]))


//VERIFY THAT THE PRODUCT WAS UPDATED
verifyUpdated = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetByIdAndGroup', [
	('id') : productId
	]))
WS.verifyElementPropertyValue(verifyUpdated, '[0].reviews[0].content', content)


//CLONE PRODUCT
generateClone = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetCloneByProductId', [
	('productId') : productId
	]))


//VERIFY THE PRODUCT CLONE IS RETURNED
WS.verifyElementPropertyValue(generateClone, 'reviews[0].content', content)
WS.verifyElementPropertyValue(generateClone, 'name', productName)


//SAVE BODY OF CLONE
clonnedProductBody = generateClone.getResponseBodyContent()


//CREATE CLONE PRODUCT
createClone = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductCreateUpdateWithBody', [
	('body') : clonnedProductBody
	]))


//SAVE CATALOG ID TO USE IN UPDATE AND DELETE CASES
productId = WS.getElementPropertyValue(createClone, 'id')
WebUI.comment(productId)


//VERIFY THAT PRODUCT WAS UPADTED
verifyClone = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetByIdAndGroup', [
	('id') : productId
	]))
WS.verifyElementPropertyValue(verifyClone, '[0].reviews[0].content', content)

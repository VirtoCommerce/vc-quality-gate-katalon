import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.comment('TEST CASE: create sample data catalog')

'CREATE KATALON CONTACT'
katalonContactCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Contacts/ContactsCreate',[
	('fullName') : GlobalVariable.katalonContactName,
	('firstName') : GlobalVariable.katalonContactName,
	('lastName') : GlobalVariable.katalonContactName
	]))


'CREATE KATALON SAMPLE DATA CATALOG'
GlobalVariable.catalogName = 'katalonCatalog'
catalogCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsCreate', [
	('name') : GlobalVariable.catalogName
	]))
WS.verifyElementPropertyValue(catalogCreate, 'name', GlobalVariable.catalogName)


'GET CATALOG ID'
GlobalVariable.catalogId = WS.getElementPropertyValue(catalogCreate, 'id')
WebUI.comment(GlobalVariable.catalogId)


WebUI.comment('TEST CASE: categories management - create a new category')


'CREATE KATALON CATEGORY'
GlobalVariable.categoryName = 'katalonCategory'
categoryCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CategoriesCreate', [
	('catalogId') : GlobalVariable.catalogId,
	('code') : GlobalVariable.categoryCode,
	('name') : GlobalVariable.categoryName
	]))
WS.verifyElementPropertyValue(categoryCreate, 'catalogId', GlobalVariable.catalogId)
WS.verifyElementPropertyValue(categoryCreate, 'name', GlobalVariable.categoryName)
WS.verifyElementPropertyValue(categoryCreate, 'code', GlobalVariable.categoryCode)
//return categoryCreate


'EXTRACT CATEGORY ID'
GlobalVariable.categoryId = WS.getElementPropertyValue(categoryCreate, 'id')
WebUI.comment(GlobalVariable.categoryId)


'CREATE KATALON PRICELIST AND EXTRACT ITS ID TO GLOBAL VARIABLE'
GlobalVariable.pricelistName = 'katalonPriceList'
pricelistCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Pricing/PricelistCreate', [
	('name') : GlobalVariable.pricelistName
	]))
GlobalVariable.pricelistId = WS.getElementPropertyValue(pricelistCreate, 'id')
WebUI.comment('CREATED PRICELIST ID IS: ' + GlobalVariable.pricelistId)


'VERIFY THE PRICELIST HAS BEEN CREATED'
verifyCreated = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistGet'),
	null)
//WS.verifyElementPropertyValue(verifyCreated, 'totalCount', '1')
WS.verifyElementPropertyValue(verifyCreated, 'results[0].name', GlobalVariable.pricelistName)


WebUI.comment('TEST CASE: CREATE AN ASSIGNMENT FOR THE PRICELIST')


'CREATE AN ASSIGNMENT FOR THE PRICELIST'
assignmentName = 'katalonAssignment'
createAssignment = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Pricing/PricelistCreateAssignment',[
	('catalogId') : GlobalVariable.catalogId,
	('pricelistId') : GlobalVariable.pricelistId,
	('name') : assignmentName
	]))


'VERIFY THE ASSIGNMENT HAS BEEN CREATED'
verifyAssignment = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistAssignmentsSearch'),
	null
	)
//WS.verifyElementPropertyValue(verifyAssignment,'totalCount', '1')
WS.verifyElementPropertyValue(verifyAssignment,'results[0].catalogId', GlobalVariable.catalogId)
WS.verifyElementPropertyValue(verifyAssignment,'results[0].pricelistId', GlobalVariable.pricelistId)
WS.verifyElementPropertyValue(verifyAssignment,'results[0].name', assignmentName)


'EXTRACT THE CREATED ASSIGNMENT ID'
GlobalVariable.assignmentId = WS.getElementPropertyValue(verifyAssignment,'results[0].id')
WebUI.comment('ASSIGNMENT ID IS: ' + GlobalVariable.assignmentId)


WebUI.comment('TEST CASE: Create store')

GlobalVariable.storeId = 'katalonStore'
GlobalVariable.storeName = 'katalonStore'
//Create a store
createStore = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Store/StoreCreate',[
	('storeId') : GlobalVariable.storeId,
	('name') : GlobalVariable.storeName,
	('catalogId') : GlobalVariable.catalogId,
	('defaultLanguage') : GlobalVariable.languageCode,
	('defaultCurrency') : GlobalVariable.currencyCode,
	('storeState') : 'Open'
	]))


WebUI.comment('TEST CASE: Products management - add product')

'CREATE A NEW PRODUCT'
GlobalVariable.productName = 'katalonProduct'
GlobalVariable.sku = 'KAT'
createUpdateProduct = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductCreate',
	[
	('name') : GlobalVariable.productName,
	('code') : GlobalVariable.sku,
	('catalogId') : GlobalVariable.catalogId,
	('categoryId') : GlobalVariable.categoryId,
	('content') : GlobalVariable.content,
	('weightUnit') : GlobalVariable.weightUnit,
	('weight') : GlobalVariable.weight,
	('height') : GlobalVariable.height,
	('width') : GlobalVariable.width,
	('length') : GlobalVariable.length
	]))
WS.verifyElementPropertyValue(createUpdateProduct, 'name', GlobalVariable.productName)


'SAVE PRODUCT ID TO USE IN UPDATE AND DELETE CASES'
GlobalVariable.productId = WS.getElementPropertyValue(createUpdateProduct, 'id')
WebUI.comment(GlobalVariable.productId)


'ADD PRODUCT TO A PRICELIST'
listPrice = '222'
salePrice = '111'
addProductToPricelist = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Pricing/PricelistAddPrices',[
	('pricelistId') : GlobalVariable.pricelistId,
	('productId') : GlobalVariable.productId,
	('listPrice') : listPrice,
	('salePrice') : salePrice
	]))


'VERIFY THE PRODUCT & THE PRICE ARE ADDED'
verifyPrice = WS.callTestCase(findTestCase('API Coverage/ModulePricing/priceSearchGet'),
	null
	)
//WS.verifyElementPropertyValue(verifyPrice,'totalCount','1')
WS.containsString(verifyPrice, GlobalVariable.pricelistId, false)
WS.containsString(verifyPrice,GlobalVariable.productId, false)
WS.containsString(verifyPrice, listPrice + '.0000', false)
WS.containsString(verifyPrice, salePrice + '.0000', false)


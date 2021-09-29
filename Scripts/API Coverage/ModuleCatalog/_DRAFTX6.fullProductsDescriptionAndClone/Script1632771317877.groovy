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


WebUI.comment('TEST CASE: Products management - Create, add descriptions and clone')


'CREATE A NEW PRODUCT'
GlobalVariable.productName = 'QweDrinkProduct'
createProduct = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/_DRAFT1.productCreateUpdate'),null,
FailureHandling.STOP_ON_FAILURE)


'VERIFY THE PRODUCT WAS ADDDED'
getProductById = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/_DRAFT2.ProductsGetById'),null,
FailureHandling.STOP_ON_FAILURE)


'UPDATE PRODUCT'
GlobalVariable.productName = (GlobalVariable.productName +'UPD')
GlobalVariable.content = (GlobalVariable.content + 'UPD')
updateProduct = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/_DRAFT1.productCreateUpdate'),null,
FailureHandling.STOP_ON_FAILURE)


'VERIFY THE ITEM WAS UPDATED'
getProductById = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/_DRAFT2.ProductsGetById'),null,
FailureHandling.STOP_ON_FAILURE)


'CLONE PRODUCT'
clonedProductBody = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/_DRAFTX7.productsGetCloneBody'),null,
FailureHandling.STOP_ON_FAILURE)
println GlobalVariable.clonedProductBody


'CREATE CLONE PRODUCT'
createClone = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/_DRAFTX8.productCreateUpdateWithBody'),null,
FailureHandling.STOP_ON_FAILURE)


'VERIFY THAT PRODUCT WAS UPDATED'
verifyClone = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetByIdAndGroup', [
	('id') : GlobalVariable.productId
	]))
WS.verifyElementPropertyValue(verifyClone, '[0].reviews[0].content', GlobalVariable.content)


'DELETE PRODUCT'
deleteProduct = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/_DRAFT3.ProductsDelete'),null,
FailureHandling.STOP_ON_FAILURE)

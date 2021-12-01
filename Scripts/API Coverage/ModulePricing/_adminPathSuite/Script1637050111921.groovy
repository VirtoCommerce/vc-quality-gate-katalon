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


'Create & verify pricelist'
createPricelist = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/pricelistCreate'),
	null)
	
	
 'Update & verify pricelist'
updatePricelist = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/pricelistUpdate'),
	null)
	

'For the pricelist create an assignment'
createAssignment = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistAssignmentCreate'),
	null)


'Create several products and add to the pricelist and delete'
createAddProducts = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/pricesAddDeleteBulk'),
	null)


'Create  product'
productCreate = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/productCreate'),
	null)
	

'Add product to the pricelist and verify'
addProduct = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistProductsAdd'),
	null)

	
'Check the pricelist widget data'
getWidget = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/pricesWidgetGet'),
	null)	
	
	
'Update price of the created product'
updatePrice = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/priceUpdate'),
	null)


 'Edit the created assignment'
editAssignment = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistAssignmentEdit'),
	null)


'Add one more price to the product'
addMultiplePrices = WS.callTestCase(findTestCase('API Coverage/ModulePricing/priceAddToTheProduct'), 
	null)


'Delete the prices from the pricelist'
deletePrice = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricesDeleteByProductId'),
	null)	
	
	
'Delete the created pricelist assignment'
deleteAssignment = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/pricelistAssignmentDelete'),
	null)
	

'Delete the created pricelist and verify'
deletePricelist = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistDelete'),
	null)
	

'Delete the created product'
deleteProduct = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/productsDelete'),
	null)


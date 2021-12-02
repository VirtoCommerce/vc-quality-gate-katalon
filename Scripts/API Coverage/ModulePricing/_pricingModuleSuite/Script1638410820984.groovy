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



'PART1 / ADMIN PATH'
	
'+Create & verify pricelist'
createPricelist = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/pricelistCreate'),
	null)
	
	
 '+Update & verify pricelist'
updatePricelist = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/pricelistUpdate'),
	null)
	

'+For the pricelist create an assignment'
createAssignment = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistAssignmentCreate'),
	null)


'+Create several products and add to the pricelist and delete'
createAddProducts = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricesAddDeleteBulk'),
	null)


'+Create  product'
productCreate = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/productCreate'),
	null)
	

'+Add product to the pricelist and verify'
addProduct = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistProductsAdd'),
	null)

	
'+Check the pricelist widget data'
getWidget = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/pricesWidgetGet'),
	null)	
	
	
'+Update price of the created product'
updatePrice = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/priceUpdate'),
	null)


 '+Edit the created assignment'
editAssignment = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistAssignmentEdit'),
	null)


'+Add one more price to the product'
addMultiplePrices = WS.callTestCase(findTestCase('API Coverage/ModulePricing/priceAddToTheProduct'), 
	null)


'+Delete prices from the pricelist'
deletePrice = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricesDeleteByProductId'),
	null)	
	
	
'+Delete the created pricelist assignment'
deleteAssignment = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/pricelistAssignmentDelete'),
	null)
	

'Delete the created pricelist and verify'
deletePricelist = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistDelete'),
	null)
	

'+Delete the created product'
deleteProduct = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/productsDelete'),
	null)


'PART 2 / TEST CASES BEYOND ADMIN PATH (module coverage)'


	//This step is duplicated adminPath suite
'+Create & verify pricelist'
createPricelist = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/pricelistCreate'),
	null)

	
	//This step is duplicated adminPath suite
'+Create a product'
productCreate = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/productCreate'),
	null)
	
	
	//This step is duplicated adminPath suite
'+Add product and price to the pricelist and verify'
addProduct = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistProductsAdd'),
	null)
			
/*
to remove
'Search for the product prices'
pricesSearch = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/priceSearchPost'),
		null)
*/


'+Get all pricelists for the product'
pricelistsGetAll = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/pricelistsGetAll'),
	null)
		
			
'+PricelistSearch'
pricelistSearch = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/pricelistAssignmentsSearch'),
	null)

			
'+Get new assignment'
assignmentGetNew = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/pricelistAssignmentGetNew'),
		null)
		
		
		//This step is duplicated adminPath suite
'+For the pricelist create an assignment'
createAssignment = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistAssignmentCreate'),
		null)

			
'+Get pricelist assignment'
getAssignment = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/pricelistAssignmentsGet'),
		null)

		
'+Price delete by priceId'
pricedeleteById = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/priceDeleteByPriceId'),
		null)

						
'+Pricelist assignments delete via filter and verify'
pricelistDeleteViaFilter = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/pricelistAssignmentsDeleteFiltered'),
	null)
	
	
	//This step is duplicated adminPath suite
'Delete the created product'
deleteProduct = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/productsDelete'),
		null)
		
		
		//This step is duplicated adminPath suite
'Delete the created pricelist and verify'
deletePricelist = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistDelete'),
		null)


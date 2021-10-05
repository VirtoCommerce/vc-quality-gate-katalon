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
	
	
'CATALOG FULL SUIT'
GlobalVariable.keyword = GlobalVariable.productName

'PRODUCT PART'
	


'RUN CREATE PRODUCTS BLOCK'
productCreate = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/zFullTests/fullProduct'),
	null,
	FailureHandling.STOP_ON_FAILURE)
	
	
'RUN PRODUCTS DESCRIPTION AND CLONE'
productDescriptionAndClone = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/zFullTests/fullProductsDescriptionAndClone'),
	null,
	FailureHandling.STOP_ON_FAILURE)
	
	
'RUN PRODUCT CUT AND PASTE AND DIMENSIONS'
productCutPasteDimensions = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/zFullTests/fullProductCutPasteAndDimensions'),
	null,
	FailureHandling.STOP_ON_FAILURE)
	
	
'RUN FULL PRODUCT IMAGE'
productImage = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/zFullTests/fullProductImage'),
	null,
	FailureHandling.STOP_ON_FAILURE)
	


'CATEGORY/CATALOG MANAGEMENT PART'
//RUN CATEGORY AFTER CATALOG


'RUN CATEGORY MANAGEMENT'
categoryManagement = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/zFullTests/fullCategoryManagement'),
	null,
	FailureHandling.STOP_ON_FAILURE)


'RUN CATALOG MANAGEMENT'
catalogManagement = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/zFullTests/fullCatalogManagement'),
	null,
	FailureHandling.STOP_ON_FAILURE)


	
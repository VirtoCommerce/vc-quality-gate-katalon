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

WebUI.comment('TEST CASE: ADD PRODUCT WITH PRICE TO THE CREATED PRICELIST')


//GlobalVariable.pricelistId = 'cf085a1b-261f-4bda-87c3-0187e4e69694'
//GlobalVariable.productId = '2926eb38-9ccb-4e9a-aaa1-765f7515920f'
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


'EXTRACT CREATED PRICE ID'
GlobalVariable.priceId = WS.getElementPropertyValue(verifyPrice, 'results[0].prices[0].id')
println GlobalVariable.priceId 



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


WebUI.comment('TEST CASE: PRICES SEARCH VIA POST REQUEST')


'SEND REQUEST TO SEARCH FOR A PRICE'
GlobalVariable.productId = 'b4feae5f-4a1d-4717-8139-ce91317dee1d'
priceSearch = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Pricing/ProductsPricesPostSearch',[
	('productId') : GlobalVariable.productId
	]))
WS.verifyElementPropertyValue(priceSearch,'results[0].productId',GlobalVariable.productId)
WS.verifyElementPropertyValue(priceSearch,'totalCount','1')
return priceSearch
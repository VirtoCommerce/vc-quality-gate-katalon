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


WebUI.comment('TEST CASE: PRICELIST CREATE')


'CREATE PRICELIST AND EXTRACT ITS ID TO GLOBAL VARIABLE'
pricelistCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Pricing/PricelistCreate', [
	('name') : GlobalVariable.pricelistName
	]))
GlobalVariable.pricelistId = WS.getElementPropertyValue(pricelistCreate, 'id')
WebUI.comment('CREATED PRICELIST ID IS: ' + GlobalVariable.pricelistId)


'VERIFY THE PRICELIST HAS BEEN CREATED'
verifyCreated = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistGetSearch'),null)
WS.verifyElementPropertyValue(verifyCreated, 'totalCount', '1')
WS.verifyElementPropertyValue(verifyCreated, 'results[0].name', GlobalVariable.pricelistName)


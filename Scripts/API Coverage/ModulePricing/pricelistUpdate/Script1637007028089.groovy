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


WebUI.comment('TEST CASE: UPDATE PRICELIST')


'UPDATE A PRICELIST (by id)'
updatedName = GlobalVariable.pricelistName + 'UPD'
pricelistUpdate = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Pricing/PricelistUpdate', [
	('name') : updatedName,
	('id') : GlobalVariable.pricelistId
	]))


'VERIFY THE PRICELIST HAS BEEN UPDATED'
verifyUpdated = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistGetSearch'),null)
WS.verifyElementPropertyValue(verifyUpdated, 'totalCount', '1')
WS.verifyElementPropertyValue(verifyUpdated, 'results[0].name', updatedName)


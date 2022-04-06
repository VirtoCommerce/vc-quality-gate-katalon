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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonOutput
import com.kms.katalon.core.testobject.ResponseObject

WebUI.comment('TEST CASE: evaluate product completeness')


'SEND REQUEST TO EVALUATE CREATED PRODUCT COMPLETENESS'
//GlobalVariable.pricelistId = '423711a7-cef2-4828-8268-00129ef6a465'
//GlobalVariable.channelId = '36574e43-3360-4646-b19f-a2b5ea67a2fa'
//GlobalVariable.productId = 'c844b137-8199-4b8e-8197-7f6e9ca0208d'
productCompletenessEvaluate = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPublishing/completenessProductEvaluate',[
	('channelId') : GlobalVariable.channelId.last(),
	('productId') : GlobalVariable.productId
	]))
WS.verifyElementPropertyValue(productCompletenessEvaluate,'[0].channelId', GlobalVariable.channelId.last())
WS.verifyElementPropertyValue(productCompletenessEvaluate,'[0].productId', GlobalVariable.productId)
initialProductCompleteness = WS.getElementPropertyValue(productCompletenessEvaluate,'[0]. completenessPercent')


'PROCESS THE RESPONSE DATA TO SAVE THE EVALUAED COMPLETENESS'
channellCompletenessData = productCompletenessEvaluate.getResponseBodyContent()
RequestObject completenessSaveRequest = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPublishing/completenessSave')
completenessSaveRequest.setBodyContent(new HttpTextBodyContent(channellCompletenessData))
completenessSave = WS.sendRequestAndVerify(completenessSaveRequest)


'UPDATE PRODUCT TO INCREASE THE COMPLETENESS (add price)'
//priceAdd = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/priceAddToTheProduct'),null)
WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/pricelistProductsAdd'),null)


'GET THE UPDATED UPRODUCT COMPLETENSS TO VERIFY IT WAS INCREASED'
updatedProductCompletenessEvaluate = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPublishing/completenessProductEvaluate',[
	('channelId') : GlobalVariable.channelId.last(),
	('productId') : GlobalVariable.productId
	]))
updatedProductCompleteness = WS.getElementPropertyValue(updatedProductCompletenessEvaluate,'[0]. completenessPercent')
println initialProductCompleteness
println updatedProductCompleteness
assert initialProductCompleteness < updatedProductCompleteness


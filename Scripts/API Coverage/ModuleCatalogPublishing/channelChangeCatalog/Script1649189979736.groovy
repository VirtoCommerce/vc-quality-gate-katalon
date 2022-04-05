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

WebUI.comment('TEST CASE: chanel change')

'SAVE THE LAST CHANNEL COMPLETENESS VALUE TO THE GLOBAL VARIABLE'
initialChannelCompleteness = GlobalVariable.channelCompleteness.last()


'EVALUATE COMPLETENESS FOR THE CREATED CHANNEL'
productCompletenessEvaluate = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPublishing/completenessProductEvaluate',[
	('channelId') : GlobalVariable.channelId,
	('productId') : GlobalVariable.productId
	]))
WS.verifyElementPropertyValue(productCompletenessEvaluate,'[0].channelId', GlobalVariable.channelId)
WS.verifyElementPropertyValue(productCompletenessEvaluate,'[0].productId', GlobalVariable.productId)
//anotherCompleteness = WS.getElementPropertyValue(productCompletenessEvaluate,'[0]. completenessPercent')


'PROCESS,SAVE DATA TO CHANGE THE SELECTED CHANNEL'
channellCompletenessData = productCompletenessEvaluate.getResponseBodyContent()
RequestObject completenessSaveRequest = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPublishing/completenessSave')
completenessSaveRequest.setBodyContent(new HttpTextBodyContent(channellCompletenessData))
completenessSave = WS.sendRequestAndVerify(completenessSaveRequest)


'VERIFY THE COMPLETENESS HAS BEEN CHANGED'
productCompletenessEvaluate = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPublishing/completenessProductEvaluate',[
	('channelId') : GlobalVariable.channelId,
	('productId') : GlobalVariable.productId
	]))
WS.verifyElementPropertyValue(productCompletenessEvaluate,'[0].channelId', GlobalVariable.channelId)
WS.verifyElementPropertyValue(productCompletenessEvaluate,'[0].productId', GlobalVariable.productId)
finalchannelCompleteness = WS.getElementPropertyValue(productCompletenessEvaluate,'[0]. completenessPercent')
assert initialChannelCompleteness != finalchannelCompleteness
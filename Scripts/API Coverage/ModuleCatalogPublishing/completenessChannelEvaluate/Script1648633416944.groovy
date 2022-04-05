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

WebUI.comment('TEST CASE: evaluate channel completeness')


'SEND REQUEST TO GET EVALUATORS (simple endpoint check)'
evaluatorsGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPublishing/evaluatorsGet'))


'SEND REQUEST TO EVALUATE CREATED CHANNEL COMPLETENESS'
//GlobalVariable.channelId = '3da8d9bf-de9c-44b3-8412-04e8357772ca'
completenessEvaluate = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPublishing/completenessEvaluate',[
	('channelId') : GlobalVariable.channelId
	]))


'DROP INDEX'
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Search/index'))
WS.delay(60)


'SEARCH FOR THE UPDATED CHANNEL TO GET THE FINAL COMPLETENESS DATA'
updatedChannelSearchEvaluated = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPublishing/channelsSearch',[
	('keyword') : GlobalVariable.channelName
	]))
channelCompleteness = WS.getElementPropertyValue(updatedChannelSearchEvaluated ,'results[0].completenessPercent') 
GlobalVariable.channelCompleteness = [] 
GlobalVariable.channelCompleteness.add(channelCompleteness)


'VERIFY THE CHANNEL COMPLETENESS HAS BEEN INCREASED (in case it was updated beforehand)'
if (GlobalVariable.channelCompleteness.size() > 1) {
	assert GlobalVariable.channelCompleteness[0] < GlobalVariable.channelCompleteness[1]
	}


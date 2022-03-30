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


'SEND REQUEST TO EVALUATE CREATED CHANNEL COMPLETENESS'
//GlobalVariable.channelId = 'db5ceb7e-feca-4ec2-831b-cd5a850cc770'
//GlobalVariable.productId = 'd664ebc3-85d6-4404-b199-a4a4aa1bf35e'
completenessEvaluate = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPublishing/completenessProductEvaluate',[
	('channelId') : GlobalVariable.channelId,
	('productId') : GlobalVariable.productId
	]))
WS.verifyElementPropertyValue(completenessEvaluate,'[0].channelId', GlobalVariable.channelId)
WS.verifyElementPropertyValue(completenessEvaluate,'[0].productId', GlobalVariable.productId)


'PROCESS THE RESPONSE DATE TO SAVE THE EVALUAED COMPLETENESS (just enpoint check)'
channellCompletenessData = completenessEvaluate.getResponseBodyContent()
RequestObject completenessSaveRequest = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPublishing/completenessSave')
completenessSaveRequest.setBodyContent(new HttpTextBodyContent(channellCompletenessData))
completenessSave = WS.sendRequestAndVerify(completenessSaveRequest)


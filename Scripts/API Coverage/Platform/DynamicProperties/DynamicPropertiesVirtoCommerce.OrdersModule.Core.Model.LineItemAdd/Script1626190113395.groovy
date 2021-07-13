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

WebUI.comment('TEST CASE: Add new property to VirtoCommerce.OrdersModule.Core.Model.LineItem')

response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesAddNew', 
        [('propertyType') : 'VirtoCommerce.OrdersModule.Core.Model.LineItem', ('name') : 'Test Property Store']))

WS.verifyElementPropertyValue(response, 'objectType', 'VirtoCommerce.OrdersModule.Core.Model.LineItem')
WS.verifyElementPropertyValue(response, 'name', 'Test Property Store')

//Verify that property was added 
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesSearch', 
        [('objectType') : 'VirtoCommerce.OrdersModule.Core.Model.LineItem', 
		 ('keyword') : 'Test Property Store']))

WS.verifyElementPropertyValue(response, 'results[0].name', "Test Property Store")
WS.verifyElementPropertyValue(response, 'results[0].objectType', "VirtoCommerce.OrdersModule.Core.Model.LineItem")
WS.verifyElementPropertyValue(response, 'totalCount', 1)

//save ID to global variables for future manipulations
responseText = response.getResponseText();
def json = new JsonSlurper().parseText(responseText)
GlobalVariable.dynamicPropertyId = json.results[0].id.toString()
WebUI.comment(json.results[0].id.toString())
WebUI.comment(GlobalVariable.dynamicPropertyId) 
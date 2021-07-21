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

WebUI.comment('TEST CASE: Add new property to VirtoCommerce.CustomerModule.Core.Model.Employee')

response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesAddNew', 
        [('propertyType') : 'VirtoCommerce.CustomerModule.Core.Model.Employee', 
			('name') : 'Test Property Store'
		]))

WS.verifyElementPropertyValue(response, 'objectType', 'VirtoCommerce.CustomerModule.Core.Model.Employee')
WS.verifyElementPropertyValue(response, 'name', 'Test Property Store')

//Verify that property was added 
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesSearch', 
        [('objectType') : 'VirtoCommerce.CustomerModule.Core.Model.Employee', 
		 ('keyword') : 'Test Property Store']))

WS.verifyElementPropertyValue(response, 'results[0].name', "Test Property Store")
WS.verifyElementPropertyValue(response, 'results[0].objectType', "VirtoCommerce.CustomerModule.Core.Model.Employee")
WS.verifyElementPropertyValue(response, 'totalCount', 1)

//save ID to global variables for future manipulations
GlobalVariable.dynamicPropertyId = WS.getElementPropertyValue(response, "results[0].id")
WebUI.comment(GlobalVariable.dynamicPropertyId)

//------------------------------
WebUI.comment('TEST CASE: Update property VirtoCommerce.CustomerModule.Core.Model.Employee')

response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertyUpdate',
			[('propertyType') : 'VirtoCommerce.CustomerModule.Core.Model.Employee',
			 ('name') : 'Test Property Store', 
			 ('description') : 'description UPD'
			]))

//Verify that property was upadted
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesSearch',
		[('objectType') : 'VirtoCommerce.CustomerModule.Core.Model.Employee', 
		 ('keyword') : 'Test Property Store'
		 ]))

WS.verifyElementPropertyValue(response, 'results[0].name', 'Test Property Store')
WS.verifyElementPropertyValue(response, 'results[0].description', 'description UPD')
WS.verifyElementPropertyValue(response, 'results[0].objectType', 'VirtoCommerce.CustomerModule.Core.Model.Employee')
WS.verifyElementPropertyValue(response, 'totalCount', 1)

//--------------------------------
WebUI.comment('TEST CASE: Delete property VirtoCommerce.CustomerModule.Core.Model.Employee')

response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertyDelete',
	[('propertyType') : 'VirtoCommerce.CustomerModule.Core.Model.Employee']))

//Verify that property was added
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesSearch',
		[('objectType') : 'VirtoCommerce.CustomerModule.Core.Model.Employee', 
		 ('keyword') : 'Test Property Store'
		]))
WS.verifyElementPropertyValue(response, 'totalCount', 0)

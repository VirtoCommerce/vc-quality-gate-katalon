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

WebUI.comment('TEST CASE: Add new property to VirtoCommerce.MarketingModule.Core.Model.DynamicContentItem')

//Add a new dynamic property
propertyType = 'VirtoCommerce.MarketingModule.Core.Model.DynamicContentItem' 
propertyName = 'Test Property Store'
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesAddNew', [
	('propertyType') : propertyType,
	('name') : propertyName
	]))
WS.verifyElementPropertyValue(response, 'objectType', propertyType)
WS.verifyElementPropertyValue(response, 'name', propertyName)

//Verify that the property was added 
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesSearch', [
	('objectType') : propertyType, 
	('keyword') : propertyName
	]))
WS.verifyElementPropertyValue(response, 'results[0].name', propertyName)
WS.verifyElementPropertyValue(response, 'results[0].objectType', propertyType)
WS.verifyElementPropertyValue(response, 'totalCount', 1)

//save ID to global variables for future manipulations
GlobalVariable.dynamicPropertyId = WS.getElementPropertyValue(response, "results[0].id")
WebUI.comment(GlobalVariable.dynamicPropertyId)

//Update the created property
updatedPropertyName = 'updated ' + propertyName
description = 'updated description'
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertyUpdate',[
	('propertyType') : propertyType,
	('name') : updatedPropertyName, 
	('description') : description,
	('dynamicPropertyId') : GlobalVariable.dynamicPropertyId
	]))

//Verify that the property was upadted
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesSearch',[
	('objectType') : propertyType, 
	('keyword') : updatedPropertyName
	]))
WS.verifyElementPropertyValue(response, 'results[0].name', updatedPropertyName)
WS.verifyElementPropertyValue(response, 'results[0].description', description)
WS.verifyElementPropertyValue(response, 'results[0].objectType', propertyType)
WS.verifyElementPropertyValue(response, 'totalCount', 1)

//Delete the created property
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertyDelete', [
	('propertyType') : propertyType,
	('dynamicPropertyId') : GlobalVariable.dynamicPropertyId
    ]))

//Verify that the property was deleted
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesSearch',[
	('objectType') : propertyType, 
    ('keyword') : updatedPropertyName
	]))
WS.verifyElementPropertyValue(response, 'totalCount', 0)

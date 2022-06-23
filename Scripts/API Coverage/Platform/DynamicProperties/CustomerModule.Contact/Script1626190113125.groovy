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


WebUI.comment('TEST CASE: Add new property to VirtoCommerce.CustomerModule.Core.Model.Contact')

propertyType = 'VirtoCommerce.CustomerModule.Core.Model.Contact'
propertyName = 'Qwe Property Contact'


// Create new property
responseCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesAddNew', [
	('propertyType') : propertyType,
	('name') : propertyName
	]))
WS.verifyElementPropertyValue(responseCreate, 'objectType', propertyType)
WS.verifyElementPropertyValue(responseCreate, 'name', propertyName)


// Verify that property was added
responseSearch = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesSearch', [
	('objectType') : propertyType,
	('keyword') : propertyName
	]))
WS.verifyElementPropertyValue(responseSearch, 'results[0].name', propertyName)
WS.verifyElementPropertyValue(responseSearch, 'results[0].objectType', propertyType)
WS.verifyElementPropertyValue(responseSearch, 'totalCount', 1)
//save property ID to use in Update and Delete cases
propertyId = WS.getElementPropertyValue(responseSearch, "results[0].id")


// Update property
propertyNameUpdated = propertyName + 'Updated'
description = 'Qwe Description Updated'
responseUpdate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertyUpdate',[
	('propertyId') : propertyId,
	('name') : propertyNameUpdated,
	('propertyType') : propertyType,
	('description') : description
	]))


// Verify that property was upadted
responseSearch2 = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesSearch', [
	('objectType') : propertyType,
	('keyword') : propertyNameUpdated
	]))
WS.verifyElementPropertyValue(responseSearch2, 'results[0].description', description)
WS.verifyElementPropertyValue(responseSearch2, 'results[0].objectType', propertyType)
WS.verifyElementPropertyValue(responseSearch2, 'results[0].name', propertyNameUpdated)
WS.verifyElementPropertyValue(responseSearch2, 'totalCount', 1)


//Update property again but this time with another endpoint (check to cover endpoint)
propertyNameUpdated2 = propertyNameUpdated + 'Updated'
description = 'Qwe Description Updated'
responseUpdate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertyUpdate(cloneInSwagger)',[
	('propertyId') : propertyId,
	('name') : propertyNameUpdated2,
	('propertyType') : propertyType,
	('description') : description
	]))


// Verify that property was upadted with another endpoint
responseSearch3 = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesSearch', [
	('objectType') : propertyType,
	('keyword') : propertyNameUpdated2
	]))
WS.verifyElementPropertyValue(responseSearch3, 'results[0].description', description)
WS.verifyElementPropertyValue(responseSearch3, 'results[0].objectType', propertyType)
WS.verifyElementPropertyValue(responseSearch3, 'results[0].name', propertyNameUpdated2)
WS.verifyElementPropertyValue(responseSearch3, 'totalCount', 1)


// Delete property
responseDelete = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertyDelete',[
	('propertyType') : propertyType,
	('propertyIds') : propertyId
	]))


// Verify that property was deleted
responseSearch4 = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesSearch', [
	('objectType') : propertyType,
	('keyword') : propertyNameUpdated2
	]))
WS.verifyElementPropertyValue(responseSearch4, 'totalCount', 0)


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


WebUI.comment('TEST CASE: Add new property to Contact. Add dictionary item to property')


'CREATE A NEW PROPERTY'
propertyType = 'VirtoCommerce.CustomerModule.Core.Model.Contact'
propertyName = 'Qwe Property Contact'
propertyCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesAddNew', [
	('propertyType') : propertyType,
	('name') : propertyName,
	('isDictionary') : true
	]))
WS.verifyElementPropertyValue(propertyCreate, 'objectType', propertyType)
WS.verifyElementPropertyValue(propertyCreate, 'name', propertyName)


'VERIFY THAT THE PROPERTY HAS BEEN ADDED'
propertySearch = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesSearch', [
	('objectType') : propertyType,
	('keyword') : propertyName
	]))
WS.verifyElementPropertyValue(propertySearch, 'results[0].name', propertyName)
WS.verifyElementPropertyValue(propertySearch, 'results[0].objectType', propertyType)
WS.verifyElementPropertyValue(propertySearch, 'totalCount', 1)
propertyId = WS.getElementPropertyValue(propertySearch, "results[0].id") //save property ID to use in Update and Delete cases


// DICTIONARY ITEM //


'ADD A DICTIONARY ITEM TO THE PROPERTY'
firstDictionaryItemName = 'qwe dictionary item 1'
firstDictionaryItemCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertyDictionaryItemAddNew', [
	('propertyType') : propertyType,
	('propertyId') : propertyId,
	('name') : firstDictionaryItemName
	]))


'VERIFY THAT THE DICTIONARY ITEM HAS BEEN ADDED TO THE PROPERTY'
firstDictionaryItemGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertyDictionaryItemGet', [
	('propertyType') : propertyType,
	('propertyId') : propertyId
	]))
WS.verifyElementPropertyValue(firstDictionaryItemGet, '[0].propertyId', propertyId)
WS.verifyElementPropertyValue(firstDictionaryItemGet, '[0].name', firstDictionaryItemName)
firstDictionaryItemId = WS.getElementPropertyValue(firstDictionaryItemGet, "[0].id") //save dictionary item ID to use Delete cases


'DELETE THE DICTIONARY ITEM'
firstDictionaryItemDelete = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertyDictionaryItemDelete', [
	('propertyType') : propertyType,
	('propertyId') : propertyId,
	('dictionaryItemIds') : firstDictionaryItemId
	]))


'VERIFY THAT THE DICTIONARY ITEM HAS BEEN ADDED TO THE PROPERTY'
deletedFirstDictionaryItemSearch = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertyDictionaryItemSearch', [
	('propertyType') : propertyType,
	('propertyId') : propertyId,
	('keyword') : firstDictionaryItemName
	]))
WS.verifyElementPropertyValue(deletedFirstDictionaryItemSearch, 'totalCount', 0)


'ADD A DICTIONARY ITEM TO THE PROPERTY (CHECK TO COVER ANOTHER ENDPOINT)'
secondDictionaryItemName = 'qwe dictionary item 2'
secondDdictionaryItemCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertyDictionaryItemAddNew(cloneInSwagger)', [
	('propertyId') : propertyId,
	('name') : secondDictionaryItemName
	]))


'VERIFY THAT THE DICTIONARY ITEM HAS BEEN ADDED TO THE PROPERTY'
secondDictionaryItemSearch = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertyDictionaryItemSearch', [
	('propertyType') : propertyType,
	('propertyId') : propertyId,
	('keyword') : 'qwe dictionary item 2'
	]))
WS.verifyElementPropertyValue(secondDictionaryItemSearch, 'totalCount', 1)
WS.verifyElementPropertyValue(secondDictionaryItemSearch, 'results[0].propertyId', propertyId)
WS.verifyElementPropertyValue(secondDictionaryItemSearch, 'results[0].name', secondDictionaryItemName)
secondDictionaryItemId = WS.getElementPropertyValue(secondDictionaryItemSearch, "results[0].id") //save dictionary item ID to use Delete cases


'DELETE THE DICTIONARY ITEM (CHECK TO COVER ANOTHER ENDPOINT)'
secondDictionaryItemDelete = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertyDictionaryItemDelete(cloneInSwagger)', [
	('dictionaryItemIds') : secondDictionaryItemId
	]))


'VERIFY THAT THE DICTIONARY ITEM HAS BEEN ADDED TO THE PROPERTY'
deletedSecondDictionaryItemSearch = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertyDictionaryItemSearch', [
	('propertyType') : propertyType,
	('propertyId') : propertyId,
	('keyword') : secondDictionaryItemName
	]))
WS.verifyElementPropertyValue(deletedSecondDictionaryItemSearch, 'totalCount', 0)


// DICTIONARY ITEM. END //


'UPDATE THE PROPERTY'
propertyNameUpdated = propertyName + 'Updated'
description = 'Qwe Description Updated'
propertyUpdate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertyUpdate',[
	('propertyId') : propertyId,
	('name') : propertyNameUpdated,
	('propertyType') : propertyType,
	('description') : description
	]))


'VERIFY THAT THE PROPERTY HAS BEEN UPDATED'
updatedPropertySearch = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesSearch', [
	('objectType') : propertyType,
	('keyword') : propertyNameUpdated
	]))
WS.verifyElementPropertyValue(updatedPropertySearch, 'results[0].description', description)
WS.verifyElementPropertyValue(updatedPropertySearch, 'results[0].objectType', propertyType)
WS.verifyElementPropertyValue(updatedPropertySearch, 'results[0].name', propertyNameUpdated)
WS.verifyElementPropertyValue(updatedPropertySearch, 'totalCount', 1)


'UPDATE THE PROPERTY AGAIN. BUT THIS TIME WITH ANOTHER ENDPOINT (CHECK TO COVER ENDPOINT)'
propertyNameUpdated2 = propertyNameUpdated + 'Updated'
description = 'Qwe Description Updated'
updatedTwicePropertyUpdate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertyUpdate(cloneInSwagger)',[
	('propertyId') : propertyId,
	('name') : propertyNameUpdated2,
	('propertyType') : propertyType,
	('description') : description
	]))


'VERIFY THAT THE PROPERTY HAS BEEN UPDATED WITH ANOTHER ENDPOINT'
updatedTwicePropertySearch = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesSearch', [
	('objectType') : propertyType,
	('keyword') : propertyNameUpdated2
	]))
WS.verifyElementPropertyValue(updatedTwicePropertySearch, 'results[0].description', description)
WS.verifyElementPropertyValue(updatedTwicePropertySearch, 'results[0].objectType', propertyType)
WS.verifyElementPropertyValue(updatedTwicePropertySearch, 'results[0].name', propertyNameUpdated2)
WS.verifyElementPropertyValue(updatedTwicePropertySearch, 'totalCount', 1)


'DELETE THE PROPERTY'
updatedTwicePropertyDelete = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertyDelete',[
	('propertyType') : propertyType,
	('propertyIds') : propertyId
	]))


'VERIFY THAT THE PROPERTY HAS BEEN DELETED'
deletedPropertySearch = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesSearch', [
	('objectType') : propertyType,
	('keyword') : propertyNameUpdated2
	]))
WS.verifyElementPropertyValue(deletedPropertySearch, 'totalCount', 0)


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

WebUI.comment('TEST CASE: content piblications add')


'PREPARE DATA TO ADD A PUBLICATION (*requires placeholder an content item created as a precondition)'


'GET THE CREATED PLACEHOLDER DATA AND PARSE IT'
//GlobalVariable.placeholderId = 'c4769937-2676-418c-8f56-8b5608ca1bbd'
placeholderGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPlaces/ContentPlacesGetById',[
	('placeId') : GlobalVariable.placeholderId
	]))
placeholderData = placeholderGet.getResponseBodyContent()
placeholderDataParsed = new JsonSlurper().parseText(placeholderData)
placeholderDataJson = new groovy.json.JsonBuilder(placeholderDataParsed).toString()

'GET THE CREATED CONTENT ITEM DATA AND PARSE IT'
//GlobalVariable.contentItemId = '72c2027c-29ac-4cef-9e08-3fb268bb13b9'
getItem = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentItems/ContentItemsGet',[
	('itemId') : GlobalVariable.contentItemId
	]))
getItemBody = getItem.getResponseBodyContent()
getItemBodyParsed = new JsonSlurper().parseText(getItemBody)
getItemBodyJson = new groovy.json.JsonBuilder(getItemBodyParsed).toString()


'SEND REQUEST TO ADD A CONTENT PUBLICATION'
description = 'qwe description'
status ='false'
publicationAdd = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPublications/ContentPublicationsAdd',[
	('publicationName') : GlobalVariable.publicationName,
	('storeId') : GlobalVariable.storeId,
	('contentItems') : getItemBodyJson,
	('contentPlaces') : placeholderDataJson,
	('description') : description ,
	('status') : status
	]))
GlobalVariable.publicationId = WS.getElementPropertyValue(publicationAdd,'id')


'VERIFY THE CONTENT PUBLICATION HAS BEEN ADDED'
verifyCreated = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPublications/ContentPublicationsGet',[
	('publicationId') : GlobalVariable.publicationId
	]))
WS.verifyElementPropertyValue(verifyCreated,'name', GlobalVariable.publicationName)
WS.verifyElementPropertyValue(verifyCreated,'storeId', GlobalVariable.storeId)
WS.verifyElementPropertyValue(verifyCreated,'description', description)
WS.verifyElementPropertyValue(verifyCreated,'contentPlaces[0].id', placeholderDataParsed.id)
WS.verifyElementPropertyValue(verifyCreated,'contentItems[0].id', getItemBodyParsed.id)
WS.verifyElementPropertyValue(verifyCreated,'contentItems[0].id', getItemBodyParsed.id)
WS.verifyElementPropertyValue(verifyCreated,'isActive', status)


'ADDITIONAL STEP TO COVER THE UNUSED REQUEST (200ok is supposed to be enough)'
publicationGetNew = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPublications/ContentPublicationsGetNew'))

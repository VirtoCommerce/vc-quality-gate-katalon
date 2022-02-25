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

WebUI.comment('TEST CASE: content placeholder delete bulk')


'CREATE SEVERAL PLACEHOLDERS AND COLLECT IDs'
List publicationIds = [] 
for (int a; a < 3 ; a++) {
	
	
	'SEND REQUEST TO ADD A CONTENT PUBLICATION'
description = 'qwe description'
publicationAdd = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPublications/ContentPublicationsAdd',[
	('publicationName') : GlobalVariable.publicationName + a,
	('storeId') : GlobalVariable.storeId,
	('contentItems') : '',
	('contentPlaces') : '',
	('description') : description 
	]))
GlobalVariable.publicationId = WS.getElementPropertyValue(publicationAdd,'id')


	'VERIFY THE CONTENT PUBLICATION HAS BEEN ADDED'
verifyCreated = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPublications/ContentPublicationsGet',[
	('publicationId') : GlobalVariable.publicationId
	]))
WS.verifyElementPropertyValue(verifyCreated,'name', GlobalVariable.publicationName + a)
WS.verifyElementPropertyValue(verifyCreated,'storeId', GlobalVariable.storeId)
WS.verifyElementPropertyValue(verifyCreated,'description', description)
	
	
	'ADD ID TO THE LIST'
	publicationIds.add(GlobalVariable.publicationId)		
}


'SEND REQUEST TO DELETE CREATED PLACEHOLDERS'
contentPublicationDelete = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPublications/ContentPublicationsDeleteBulk',[
	('id0') : publicationIds[0],
	('id1') : publicationIds[1],
	('id2') : publicationIds[2]
	]))


'VERIFY THE PUBLICATION HAS BEEN DELETED'
searchDeleted = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPublications/ContentPublicationsSearch',[
	('searchPhrase') : GlobalVariable.publicationId
	]))
assert WS.containsString(searchDeleted, GlobalVariable.publicationName, false, FailureHandling.OPTIONAL) == false



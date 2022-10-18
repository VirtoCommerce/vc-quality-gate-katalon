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
List placeholderIds = [] 
for (int a; a < 3 ; a++) {
	
	
	'SEND REQUEST TO ADD A CONTENT PLACEHOLDER'
	//GlobalVariable.placeholderName = 'qwePlaceholder'
	placeholderDescription = 'qwe description'
	placeholderAdd = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPlaces/ContentPlacesAdd',[
		('placeName') : GlobalVariable.placeholderName + a,
		('description') : placeholderDescription
		]))
	
	
	'GET THE CREATED PLACEHOLDER ID'
	GlobalVariable.placeholderId = WS.getElementPropertyValue(placeholderAdd,'id')
	

	'VERIFY THE PLACEHOLDER HAS BEEN CREATED'
	verifyCreated = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPlaces/ContentPlacesGetById',[
		('placeId') : GlobalVariable.placeholderId
		]))
	WS.verifyElementPropertyValue(verifyCreated,'name', GlobalVariable.placeholderName + a)
	WS.verifyElementPropertyValue(verifyCreated,'description', placeholderDescription)
	
	
	'ADD ID TO THE LIST'
	placeholderIds.add(GlobalVariable.placeholderId)		
}


'SEND REQUEST TO DELETE CREATED PLACEHOLDERS'
contentItemDelete = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPlaces/ContentPlacesDeleteBulk',[
	('id0') : placeholderIds[0],
	('id1') : placeholderIds[1],
	('id2') : placeholderIds[2]
	]))


'VERIFY PLACEHOLDERS HAVE BEEN DELETED'
searchDeleted = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPlaces/ContentPlacesListEntriesSearch'
	))
assert WS.containsString(searchDeleted, GlobalVariable.contentItemName, false, FailureHandling.OPTIONAL) == false


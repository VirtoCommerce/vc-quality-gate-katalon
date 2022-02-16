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

WebUI.comment('TEST CASE: content item add')


'SEND REQUEST TO ADD A CONTENT ITEM'
contentItemAdd = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentItems/ContentItemsAdd',[
	('name') : GlobalVariable.contentItemName  
	]))


'GET CREATED CONTENT ITEM ID'
GlobalVariable.contentItemId = WS.getElementPropertyValue(contentItemAdd, 'id')
println GlobalVariable.contentItemId 


'VERIFY THE CONTENT ITEM HAS EXISTS ON THE BACKEND'
veifyCreated = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentItems/ContentItemsGet',[
	('itemId') : GlobalVariable.contentItemId 
	]))
WS.verifyElementPropertyValue(veifyCreated,'id', GlobalVariable.contentItemId )


'VERIFY THE ITEM IS AVAILABLE VIA SEARCH'
searchItem = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentItems/ContentItemsSearch',[
	]))
WS.containsString(searchItem, GlobalVariable.contentItemName, false)


return contentItemAdd


;import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
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
contentItemName = 'qweItem'
contentItemAdd = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentItems/ContentItemsAdd',[
	('name') : contentItemName 
	]))


'GET CREATED CONTENT ITEM ID'
contentItemId = WS.getElementPropertyValue(contentItemAdd, 'id')
println contentItemId


'VERIFY THE CONTENT ITEM HAS EXISTS ON THE BACKEND'
veifyCreated = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentItems/ContentItemsGet',[
	('itemId') : contentItemId
	]))
WS.verifyElementPropertyValue(veifyCreated,'id', contentItemId)


//return contentItemAdd


'UPDATE THE CREATED ITEM'
updatedItemName = contentItemName + 'UPD' 
updatedDescription = 'updated description'
contentItemUpdate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentItems/contentItemsUpdate',[
	('itemName') : updatedItemName,
	('description') : updatedDescription,
	('contentItemId') : contentItemId
	]))


'GET THE UPDATED ITEM TO VERIFY `IT WAS UPDATED'
veifyUpdated = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentItems/ContentItemsGet',[
	('itemId') : contentItemId
	]))
WS.verifyElementPropertyValue(veifyUpdated,'id', contentItemId)
WS.verifyElementPropertyValue(veifyUpdated,'description', updatedDescription)
WS.verifyElementPropertyValue(veifyUpdated,'name', updatedItemName)


'DELETE THE CREATED CONTENT ITEM'
contentItemDelete = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentItems/ContentItemsDelete',[
	('itemId') : contentItemId
	]))


'VERIFY THE ITEM HAS BEEN DELETED'
searchDeleted = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentItems/ContentItemsSearch'
	))
assert WS.containsString(searchDeleted, contentItemId, false, FailureHandling.OPTIONAL) == false




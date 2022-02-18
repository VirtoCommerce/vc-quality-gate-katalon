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


WebUI.comment('TEST CASE: content item update (name, description, html content)')


GlobalVariable.contentItemId = '308b2f92-4dda-4c5b-bfc9-9291c5914f44'


'UPDATE THE CREATED ITEM'
updatedItemName = GlobalVariable.contentItemName + 'UPD'
updatedDescription = 'updated description'
contentItemUpdate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentItems/contentItemsUpdate',[
	('itemName') : updatedItemName,
	('description') : updatedDescription,
	('contentItemId') : GlobalVariable.contentItemId
	]))


'GET THE UPDATED ITEM TO VERIFY `IT WAS UPDATED'
veifyUpdated = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentItems/ContentItemsGet',[
	('itemId') : GlobalVariable.contentItemId
	]))
WS.verifyElementPropertyValue(veifyUpdated,'id', GlobalVariable.contentItemId)
WS.verifyElementPropertyValue(veifyUpdated,'description', updatedDescription)
WS.verifyElementPropertyValue(veifyUpdated,'name', updatedItemName)





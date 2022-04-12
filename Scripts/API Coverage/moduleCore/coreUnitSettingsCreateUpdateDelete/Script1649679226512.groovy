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


WebUI.comment('TEST CASE: mass unit add')


'PROCESS EACH SETTING FROM THE LIST'
List settingsNames = ['VirtoCommerce.Core.General.WeightUnits','VirtoCommerce.Core.General.Languages','VirtoCommerce.Core.General.MeasureUnits']


for ( int i; i < settingsNames.size(); i++ ) {

	'GET PLATFORM SETTING BY NAME'
	settingName = settingsNames[i]
	unitSettingsGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Platform/SettingsGetByName',[
		('name') : settingName
		]))
	
	
	'SAVE THE INITIAL UNIT SETTINGS'
	newUnitName = 'qweUnit' + UUID.randomUUID().toString() //to be sure the name is unique when running the test multiple times
	unitSettingsParsed = new JsonSlurper().parseText(unitSettingsGet.getResponseBodyContent())
	initialUnitSettings = '[' + new groovy.json.JsonBuilder(unitSettingsParsed).toString() + ']'
	
	
	'UPDATE UNIT SETTINGS AND CONVERT TO PROPER FORMATTED JSON' 
	unitSettingsParsed.'allowedValues'.add(newUnitName)
	unitSettingsJson = '[' + new groovy.json.JsonBuilder(unitSettingsParsed).toString() + ']'
	
	
	'SEND REQUEST TO UPDATE PLATFORM SETTINGS'
	RequestObject settingsUpdateObject = findTestObject('API/backWebServices/VirtoCommerce.Core/_relatedSettingsCreateUpdate/settingsUnitOrLanguageCreate')
	settingsUpdateObject.setBodyContent(new HttpTextBodyContent(unitSettingsJson))
	settingsUpdate = WS.sendRequestAndVerify(settingsUpdateObject)
	
	
	'VERIFY THE UNIT HAS BEEN UPDATED'
	updatedUnitSettingsGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Platform/SettingsGetByName',[
		('name') : settingName
		]))
	WS.containsString(updatedUnitSettingsGet, newUnitName, false)
	
	
	'DELETE THE ADDED VALUE (send the initial settings)'
	RequestObject settingsDeleteObject = findTestObject('API/backWebServices/VirtoCommerce.Core/_relatedSettingsCreateUpdate/settingsUnitOrLanguageCreate')
	settingsDeleteObject.setBodyContent(new HttpTextBodyContent(initialUnitSettings))
	settingsDelete= WS.sendRequestAndVerify(settingsDeleteObject)
	
	
	'VERIFY THE UNIT HAS BEEN DELETED'
	deltedUnitSettingsGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Platform/SettingsGetByName',[
		('name') : settingName
		]))
	assert WS.containsString(deltedUnitSettingsGet, newUnitName, false, FailureHandling.OPTIONAL) == false
	
	}


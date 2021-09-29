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

WebUI.comment('TEST CASE: Products management - upload image, description type management')


'FUNCTION FOR UPDATING DESCRIPTION TYPE'
def UpdateTypes (ArrayList typesToUpdate) {
	
	'GET JSON FOR SETTING OF DESCRIPTIONS'
	settingsGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/SettingsGetByName', [
		('name') : 'Catalog.EditorialReviewTypes'
		]))
	settingsText = settingsGet.getResponseText()
	WebUI.comment(settingsText)
	 slurper = new JsonSlurper()
	Map parsedJson = slurper.parseText(settingsText)
	WebUI.comment(parsedJson.allowedValues.toString())
	
	'SET NEW VALUES TO JSON'
	parsedJson.allowedValues = typesToUpdate
	WebUI.comment(parsedJson.allowedValues.toString())
	
	'CRETE CORRECT BODY'
	parsedToJson = new groovy.json.JsonBuilder(parsedJson)
	updatedBody = "[" + parsedToJson.toString() + "]"
	WebUI.comment(updatedBody)
	
	'ADD NEW TYPE OF DESCRIPTIONS'
	addDescription = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/SettingsCreateUpdateDescriptionType',[
		('body') : updatedBody
		]))
	//Verify that types are updated
	addDescription = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/SettingsGetByName', [
		('name') : 'Catalog.EditorialReviewTypes'
		]))
	WS.verifyElementPropertyValue(addDescription, 'name', 'Catalog.EditorialReviewTypes')
	
}

'CREATE NEW DESCRIPTION TYPE'
ArrayList allowedValues = new ArrayList()
allowedValues.add('FullReview')
allowedValues.add('QuickReview')
allowedValues.add('TEST')
UpdateTypes(allowedValues)

'UPDATE NaME OF DESCRIPTION TYPE'
allowedValues = new ArrayList()
allowedValues.add('FullReview')
allowedValues.add('QuickReview')
allowedValues.add('TESTUPD')
UpdateTypes(allowedValues)

'REMOVE CREATED DESCRIPTION TYPE'
allowedValues = new ArrayList()
allowedValues.add('FullReview')
allowedValues.add('QuickReview')
UpdateTypes(allowedValues)
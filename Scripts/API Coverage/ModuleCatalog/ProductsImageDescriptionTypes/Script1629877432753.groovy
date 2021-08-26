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

productName = 'QweDrinkProductImaheAndDescriptions'

// Create new product
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductCreateUpdate', [('name') : productName]))
WS.verifyElementPropertyValue(response, 'name', productName)

//save catalog ID to use in Update and Delete cases
productId = WS.getElementPropertyValue(response, 'id')
WebUI.comment(productId)

def UpdateTypes (ArrayList typesToUpdate) {
	//Get json for setting of descriptions
	response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/SettingsGetByName', [('name') : 'Catalog.EditorialReviewTypes']))
	responseText = response.getResponseText()
	WebUI.comment(response.getResponseText())
	JsonSlurper slurper = new JsonSlurper()
	Map parsedJson = slurper.parseText(responseText)
	WebUI.comment(parsedJson.allowedValues.toString())
	
	//Set new valies to json
	parsedJson.allowedValues = typesToUpdate
	WebUI.comment(parsedJson.allowedValues.toString())
	
	//Create correct body
	parsedToJson = new groovy.json.JsonBuilder(parsedJson)
	updatedBody = "[" + parsedToJson.toString() + "]"
	WebUI.comment(updatedBody)
	
	//Add new type of descriptions
	response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/SettingsCreateUpdateDescriptionType',[('body') : updatedBody]))
	//Verify that types are updated
	response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/SettingsGetByName', [('name') : 'Catalog.EditorialReviewTypes']))
	WS.verifyElementPropertyValue(response, 'name', 'Catalog.EditorialReviewTypes')

}

//Create new  description type
ArrayList allowedValues = new ArrayList()
allowedValues.add('FullReview')
allowedValues.add('QuickReview')
allowedValues.add('TEST')
UpdateTypes(allowedValues)

//Update name of description type
allowedValues = new ArrayList()
allowedValues.add('FullReview')
allowedValues.add('QuickReview')
allowedValues.add('TESTUPD')
UpdateTypes(allowedValues)

//Remove created description type
allowedValues = new ArrayList()
allowedValues.add('FullReview')
allowedValues.add('QuickReview')
UpdateTypes(allowedValues)
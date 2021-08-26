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

//Function for updating description types
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
/*
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
*/
//Image verification
productName = 'QweDrinkProductImaheAndDescriptions'

// Create new product
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductCreateUpdate', [('name') : productName]))
WS.verifyElementPropertyValue(response, 'name', productName)

//save product ID to use in Update and Delete cases
productId = WS.getElementPropertyValue(response, 'id')
WebUI.comment(productId)

//Create new folder
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetCreateBlobFolder', [
	('folderName') : GlobalVariable.folderName,
	('parentUrl') : ''
	]))

// Find URL of assets
folderList = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetGetList', [
	('folderName') : '',
	('keyword') : GlobalVariable.folderName
	]))

// check if new folder is in the search results
WS.containsString(folderList, GlobalVariable.folderName, false)
localUrl = (WS.getElementPropertyValue(folderList, 'results[0].parentUrl'))
folderUrl = localUrl + GlobalVariable.folderName // Special url for test in docker

WebUI.comment ('Local URL is: ' + localUrl)
WebUI.comment ('Folder URL is: ' + folderUrl)

//Upload image for product
uploadFileUrl = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetFileUpload', [
	('folderUrl') : folderUrl,
	('url') : GlobalVariable.urlBack + '/images/userpic.svg'
	]))

//get file url
uploadFileUrl = WS.getElementPropertyValue(uploadFileUrl, '[0].url')
WebUI.comment ('Upload URL is: ' + uploadFileUrl)

//Get product


// Update images
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductCreateUpdate', [('name') : productName, ('images'): images]))
WS.verifyElementPropertyValue(response, 'name', productName)




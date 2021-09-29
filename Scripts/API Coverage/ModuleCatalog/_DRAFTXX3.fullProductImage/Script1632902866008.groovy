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


WebUI.comment('TEST CASE: Products management - upload image')


'CHECK DESCRIPTION TYPE MANAGEMENT' //I duplicate it here just to have this all as a copy of Volha's test
checkDescription = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/_DRAFTXX2.fullSettingsDescriptionTypeAddRemove'),
	null,
	FailureHandling.STOP_ON_FAILURE
	)


'CREATE ASEETS BLOB FOLDER'
createFolder = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/_DRAFTXX4.assetsCreateBlobFolder'),
	null,
	FailureHandling.STOP_ON_FAILURE
	)

	
'FIND URL OF ASSETS'
getUrls = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/_DRAFTXX5.assetGetList'),
	null,
	FailureHandling.STOP_ON_FAILURE
	)



'UPLOAD IMAGE FOR PRODUCT'
uploadImage = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/_DRAFTXX6.assetFileUpload'),
	null,
	FailureHandling.STOP_ON_FAILURE
	)


'CREATE NEW PRODUCT'
GlobalVariable.productName = 'QweDrinkProductImaheAndDescriptions'
productCreate = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/_DRAFT1.productCreateUpdate'),
	null,
	FailureHandling.STOP_ON_FAILURE
	)


'CREATE UPDATED IMAGE BODY & UPDATE IMAGES'
updateAsset = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/_DRAFTXX7.assetUpdateImage'),
	null,
	FailureHandling.STOP_ON_FAILURE
	)




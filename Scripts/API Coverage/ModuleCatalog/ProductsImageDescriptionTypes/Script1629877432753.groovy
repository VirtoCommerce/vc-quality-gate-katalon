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
	JsonSlurper slurper = new JsonSlurper()
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


'CREATE NEW FOLDER'
folderCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetCreateBlobFolder', [
	('folderName') : GlobalVariable.folderName,
	('parentUrl') : ''
	]))


'FIND URL OF ASSETS'
folderList = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetGetList', [
	('folderName') : '',
	('keyword') : GlobalVariable.folderName
	]))


'CHECK IF NEW FOLDER IS IN THE SEARCH RESULTS'
WS.containsString(folderList, GlobalVariable.folderName, false)
localUrl = (WS.getElementPropertyValue(folderList, 'results[0].parentUrl'))
folderUrl = localUrl + GlobalVariable.folderName // Special url for test in docker

WebUI.comment ('Local URL is: ' + localUrl)
WebUI.comment ('Folder URL is: ' + folderUrl)


'UPLOAD IMAGE FOR PRODUCT'
uploadFileUrl = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetFileUpload', [
	('folderUrl') : folderUrl,
	('url') : GlobalVariable.urlBack + '/images/userpic.svg'
	]))


'GET FILE URL'
uploadedFileUrl = WS.getElementPropertyValue(uploadFileUrl, '[0].url')
uploadedFileName = WS.getElementPropertyValue(uploadFileUrl, '[0].name')
WebUI.comment ('Upload URL is: ' + uploadedFileUrl)

'IMAGE VERIFICATION'
productName = 'QweDrinkProductImaheAndDescriptions'


'CREATE NEW PRODUCT'
productCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductCreateUpdate', [
	('name') : productName
	]))
WS.verifyElementPropertyValue(productCreate, 'name', productName)


'SAVE PRODUCT ID TO USE IN UPDATE AND DELETE CASES'
productId = WS.getElementPropertyValue(productCreate, 'id')
WebUI.comment(productId)


'CREATE UPDATED IMAGES BODY'
updatedImagestext = '{"size":6129,"contentType":"image/svg+xml", "type":"blob","name":"'+ uploadedFileName +'","url":"'+ uploadedFileUrl +'","relativeUrl":"' + uploadedFileUrl + '","createdDate":"0001-01-01T00:00:00Z","modifiedDate":"2021-08-26T09:57:56.6970941Z","isImage":true,"sortOrder":1,"group":"images"}'
WebUI.comment(updatedImagestext)


'UPDATE IMAGES'
imagesUpdate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductCreateUpdate', [
	('name') : productName, 
	('images'): updatedImagestext
	]))
WS.verifyElementPropertyValue(imagesUpdate, 'name', productName)
WS.verifyElementPropertyValue(imagesUpdate, 'images.url[0]', uploadedFileUrl)


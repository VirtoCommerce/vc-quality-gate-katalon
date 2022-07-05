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


WebUI.comment('TEST CASE: content placeholder update')


//GlobalVariable.placeholderId = 'a2bad928-edb4-44b4-ae90-28a9f80bc17b'
//GlobalVariable.placeholderName = 'evgTest'




'UPLOAD ASSET IMAGE TO THE PLACEHOLDER INAGES FOLDER'
GlobalVariable.folderUrl = 'placeholders-images'
assetFileUpload = WS.callTestCase(findTestCase('Test Cases/API Coverage/Platform/Asset/AssetFileUploadLocal'),
	null)



'GET THE CREATED PLACEHOLDER DATA'
placeholderGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPlaces/ContentPlacesGetById',[
	('placeId') : GlobalVariable.placeholderId
	]))


'PROCESS THE CREATED PLACEHOLDER DATA TO USE IN THE UPDATE REQUEST (change name, description, add uploaded image url)'
placeholderData = placeholderGet.getResponseBodyContent()
placeholderDataParced = new JsonSlurper().parseText(placeholderData)
updatedPlaceholderName = GlobalVariable.placeholderName + 'UPD'
placeholderDataParced.name = updatedPlaceholderName 
updatedPlaceholderDescription = 'updated description'
placeholderDataParced.description = updatedPlaceholderDescription
placeholderDataParced.imageUrl = GlobalVariable.uploadFileUrl
placeholderDataJson = new groovy.json.JsonBuilder(placeholderDataParced).toString()


'SEND REQUEST TO UPDATE THE CREATED PLACEHOLDER'
RequestObject updatePlaceholder = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPlaces/ContentPlacesUpdate')
updatePlaceholder.setBodyContent(new HttpTextBodyContent(placeholderDataJson))
WS.sendRequestAndVerify(updatePlaceholder)


'VERIFY THE PLACEHOLDER HAS BEEN UPDATED'
veifyUpdated = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPlaces/ContentPlacesListEntriesSearch',[
	('searchPhrase') : updatedPlaceholderName
	]))
WS.verifyElementPropertyValue(veifyUpdated,'results[0].id', GlobalVariable.placeholderId)
WS.verifyElementPropertyValue(veifyUpdated,'results[0].description', updatedPlaceholderDescription)
WS.verifyElementPropertyValue(veifyUpdated,'results[0].name', updatedPlaceholderName)
WS.verifyElementPropertyValue(veifyUpdated,'results[0].imageUrl', GlobalVariable.uploadFileUrl)




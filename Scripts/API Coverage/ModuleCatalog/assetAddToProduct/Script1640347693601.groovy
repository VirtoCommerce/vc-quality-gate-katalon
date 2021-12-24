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

import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonOutput
import com.kms.katalon.core.testobject.ResponseObject


WebUI.comment('TEST CASE: add asset to a product via widget')
//NOTE: requries running a productCreate test case beforehand

'Upload asset from the local storage'
folderURL = 'catalog' + GlobalVariable.sku
uploadAsset = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Assets/AssetFileUploadLocal',[
	('folderURL') : folderURL
	]))


'Get the uploaded file data to add it to the productUpdate body'
assetBodyContent = uploadAsset.getResponseBodyContent()
assetBodyParsed = new JsonSlurper().parseText(assetBodyContent)
GlobalVariable.assetsData = new groovy.json.JsonBuilder(assetBodyParsed[0])


'Extract the uploaded file name to use it for the verification'
fileName = assetBodyParsed[0].name
contentType = assetBodyParsed[0].contentType
url = assetBodyParsed[0].url
relativeUrl = assetBodyParsed[0].relativeUrl 


'Upload and process the assetsData template, pas it to global variable'
assetsTemplate = new File('Data Files/assetsTemplate.json').text
assetsTemplateParsed = new JsonSlurper().parseText(assetsTemplate)
assetsTemplateParsed.mimeType = contentType
assetsTemplateParsed.name = fileName
assetsTemplateParsed.url = url
assetsTemplateParsed.relativeUrl = relativeUrl
assetsData = new groovy.json.JsonBuilder(assetsTemplateParsed)
GlobalVariable.assetsData = assetsData


'Send request to update the created product via the assets data'
assetsAdd = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/productUpdate'),
	null)


'Verify the assets have been properly updated'
assetsAddedVerification = WS.verifyElementPropertyValue(assetsAdd,'assets[0].name', fileName)


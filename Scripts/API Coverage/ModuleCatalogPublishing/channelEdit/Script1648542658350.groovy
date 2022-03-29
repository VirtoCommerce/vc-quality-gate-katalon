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


WebUI.comment('TEST CASE: edit the created test case')


'SEARCH FOR THE CREATED CHANNEL TO GET ITS BODY'
channelSearch = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPublishing/channelsSearch',[
	('keyword') : GlobalVariable.channelName
	]))

 
'PARSE SEARCH RESULTS TO GET THE BODY DATA AND EDIT IT'
searchResults = channelSearch.getResponseBodyContent()
searchResultsParsed = new JsonSlurper().parseText(searchResults)
channelBodyParsed = searchResultsParsed.results[0] 

updatedName = GlobalVariable.channelName + 'UPD'
updatedLanguage = 'fr-FR'
updatedCurrency = 'EUR'
updatedCatalog = GlobalVariable.catalogId
updatedCatalogName = GlobalVariable.catalogName

channelBodyParsed.name = updatedName 
channelBodyParsed.languages[0] = updatedLanguage   
channelBodyParsed.currencies[0] = updatedCurrency
channelBodyParsed.catalogId = updatedCatalog
channelBodyParsed.catalogName = updatedCatalogName 

channelBodyJson = new groovy.json.JsonBuilder(channelBodyParsed ).toString()
println channelBodyJson  


'SEND REQUEST TO UPDATE THE CHANNEL'
RequestObject channelUpdateObject = findTestObject('API/backWebServices/VirtoCommerce.CatalogPublishing/channelsUpdate')
channelUpdateObject.setBodyContent(new HttpTextBodyContent(channelBodyJson))
channelUpdated = WS.sendRequestAndVerify(channelUpdateObject)


'VERIFY THE CHANNEL HAS BEEN UPDATED'
verifyUpdated = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPublishing/channelGet',[
	('channelId') : GlobalVariable.channelId
	]))
WS.verifyElementPropertyValue(verifyUpdated,'name', updatedName)
WS.verifyElementPropertyValue(verifyUpdated,'languages[0]', updatedLanguage)
WS.verifyElementPropertyValue(verifyUpdated,'currencies[0]', updatedCurrency)
WS.verifyElementPropertyValue(verifyUpdated,'catalogId', updatedCatalog)
WS.verifyElementPropertyValue(verifyUpdated,'catalogName',updatedCatalogName)


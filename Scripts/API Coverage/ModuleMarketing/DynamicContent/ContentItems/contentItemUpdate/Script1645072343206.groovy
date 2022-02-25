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


//GlobalVariable.contentItemId = '01bb114d-b726-44c4-980d-3ef9fdb51f98'


'FIRST UPLOAD AND PREPARE HTML CONTENT DATA'
promoDataContentItemHTMLObject = new File('Data Files/promoDataContentItemHTMLObject.json').text
promoDataContentItemHTMLObjectParsed = new JsonSlurper().parseText(promoDataContentItemHTMLObject)
updatedHtmlContent = 'qweUpdated'
promoDataContentItemHTMLObjectParsed[0].values[0].value = updatedHtmlContent


'GET THE CREATED ITEM'
getItem = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentItems/ContentItemsGet',[
	('itemId') : GlobalVariable.contentItemId
	]))


'PROCESS THE GET RESPONSE AND MODIFY TO UPDATE HTML CONTENT BLOCK'
getItemBody = getItem.getResponseBodyContent()
getItemBodyParsed = new JsonSlurper().parseText(getItemBody)
getItemBodyParsed.dynamicProperties = promoDataContentItemHTMLObjectParsed
updatedItemName = GlobalVariable.contentItemName + 'UPD'
getItemBodyParsed.name = updatedItemName
updatedDescription = 'descriptionUPD'
getItemBodyParsed.description = updatedDescription 
ItemBodyJson = new groovy.json.JsonBuilder(getItemBodyParsed).toString()
println ItemBodyJson


'SEND THE REQUEST TO UPDATED THE ITEM'
RequestObject updateContentItem = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentItems/contentItemsUpdate')
updateContentItem.setBodyContent(new HttpTextBodyContent(ItemBodyJson))
WS.sendRequestAndVerify(updateContentItem)


'GET THE UPDATED ITEM TO VERIFY IT WAS UPDATED'
veifyUpdated = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentItems/ContentItemsGet',[
	('itemId') : GlobalVariable.contentItemId
	]))
WS.verifyElementPropertyValue(veifyUpdated,'id', GlobalVariable.contentItemId)
WS.verifyElementPropertyValue(veifyUpdated,'description', updatedDescription)
WS.verifyElementPropertyValue(veifyUpdated,'name', updatedItemName)
WS.verifyElementPropertyValue(veifyUpdated,'dynamicProperties[0].values[0].value', updatedHtmlContent)





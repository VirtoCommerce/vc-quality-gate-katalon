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

WebUI.comment('TEST CASE: content piblication uodate')


//NOTE: publication/item/placeholder are required to be created (put separate cases into the suite)
//to add: description data update verification

'GET THE CREATED PLACEHOLDER DATA AND PARSE IT'
//GlobalVariable.placeholderId = '21cd6d69-9d1c-4a01-a800-fa09f87f4298'
placeholderGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPlaces/ContentPlacesGetById',[
	('placeId') : GlobalVariable.placeholderId
	]))
placeholderData = placeholderGet.getResponseBodyContent()
placeholderDataParsed = new JsonSlurper().parseText(placeholderData)


'GET THE CREATED CONTENT ITEM DATA AND PARSE IT'
//GlobalVariable.contentItemId = '835babdc-7d6c-4d23-b489-d84242c8b9a3'
getItem = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentItems/ContentItemsGet',[
	('itemId') : GlobalVariable.contentItemId
	]))
getItemBody = getItem.getResponseBodyContent()
getItemBodyParsed = new JsonSlurper().parseText(getItemBody)


'PREPARE PUBLICATION CONDITION DATA'
publicationConditionDataTemplate = new File('TestDataFiles/Marketing/publishingDynamicExpressionTemplate.json').text
publicationConditionDataParsed = new JsonSlurper().parseText(publicationConditionDataTemplate)
publicationConditionDataParsed.id = 'ConditionAgeIs'
publicationConditionDataParsed.value = '31'
publicationConditionDataParsed.compareCondition = 'AtLeast'


'GET THE CREATED PUBLICATION DATA, PARSE IT AND MODIFY'
//GlobalVariable.publicationId = '35db8564-e74d-449a-8801-5b31c1f9d596'
publicationGetBody = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPublications/ContentPublicationsGet',[
	('publicationId') : GlobalVariable.publicationId
	]))
publicationBody = publicationGetBody.getResponseBodyContent()
publicationBodyPased = new JsonSlurper().parseText(publicationBody)
updatedPublicationName = GlobalVariable.publicationName + 'UPD'
publicationBodyPased.name = updatedPublicationName
updatedStatus = 'true'
publicationBodyPased.isActive = updatedStatus  
updatedPublicationDescription = 'updated description' 
publicationBodyPased.description = updatedPublicationDescription 
publicationBodyPased.contentPlaces[0] = placeholderDataParsed
publicationBodyPased.contentItems[0] = getItemBodyParsed
publicationBodyPased.dynamicExpression.children[0].all = updatedStatus
publicationBodyPased.dynamicExpression.children[0].children[0] = publicationConditionDataParsed
publicationBodyParsedJson = new groovy.json.JsonBuilder(publicationBodyPased).toString()
println publicationBodyParsedJson 


'SEND REQEUST TO UPDATE THE CREATED PUBLICATION'
RequestObject publicationUpdate = findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPublications/ContentPublicationsUpdate') 
publicationUpdate.setBodyContent(new HttpTextBodyContent(publicationBodyParsedJson))
WS.sendRequestAndVerify(publicationUpdate)


'VERIFY THE PUBLICATION HAS BEEN UPDATED'
updatedPublicationGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPublications/ContentPublicationsGet',[
	('publicationId') : GlobalVariable.publicationId
	]))
WS.verifyElementPropertyValue(updatedPublicationGet,'name', updatedPublicationName)
WS.verifyElementPropertyValue(updatedPublicationGet,'contentPlaces[0].id', publicationBodyPased.contentPlaces[0].id) 
WS.verifyElementPropertyValue(updatedPublicationGet,'contentItems[0].id', publicationBodyPased.contentItems[0].id)
WS.verifyElementPropertyValue(updatedPublicationGet,'description', updatedPublicationDescription)
WS.verifyElementPropertyValue(updatedPublicationGet,'isActive', updatedStatus)
WS.verifyElementPropertyValue(updatedPublicationGet,'dynamicExpression.children[0].all', updatedStatus)
WS.verifyElementPropertyValue(updatedPublicationGet,'dynamicExpression.children[0].children[0].value', publicationConditionDataParsed.value)




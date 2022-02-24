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

WebUI.comment('TEST CASE: content piblication condition add/update/delete')


'PREPARE PUBLICATION CONDITION DATA'
publicationConditionDataTemplate = new File('Data Files/publishingDynamicExpressionTemplate.json').text
publicationConditionDataParsed = new JsonSlurper().parseText(publicationConditionDataTemplate)
publicationConditionDataParsed.id = 'ConditionAgeIs'
publicationConditionDataParsed.value = '31'
publicationConditionDataParsed.compareCondition = 'AtLeast'
//publicationConditionDataParsed.compareCondition = 'ConditionAgeIs'
//println publicationConditionDataParsed
//publicationConditionDataJson = new groovy.json.JsonBuilder(publicationConditionDataParsed).toString()
//println publicationConditionDataJson


'GET THE CREATED PUBLICATION DATA, PARSE IT AND MODIFY'
GlobalVariable.publicationId = 'ec958d5d-d461-4254-9f10-2a21453396c6'
publicationGetBody = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPublications/ContentPublicationsGet',[
	('publicationId') : GlobalVariable.publicationId
	]))
publicationBody = publicationGetBody.getResponseBodyContent()
publicationBodyPased = new JsonSlurper().parseText(publicationBody)
publicationBodyPased.dynamicExpression.children[0].children[0] = publicationConditionDataParsed 
publicationBodyParsedJson = new groovy.json.JsonBuilder(publicationBodyPased).toString()
println publicationBodyParsedJson 


'SEND REQEUST TO UPDATE THE CREATED PUBLICATION'
RequestObject publicationUpdate = findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPublications/ContentPublicationsUpdate') 
publicationUpdate.setBodyContent(new HttpTextBodyContent(publicationBodyParsedJson))
WS.sendRequestAndVerify(publicationUpdate)


'VERIFY THE PUBLICATION HAS BEEN UPDATED'
publicationGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentPublications/ContentPublicationsGet',[
	('publicationId') : GlobalVariable.publicationId
	]))
WS.verifyElementPropertyValue(publicationGet,'dynamicExpression.children[0].children[0].value', publicationConditionDataParsed.value)



//'PREPARE PUBLICATION CONDITION DATA'
//publicationConditionDataTemplate = new File('Data Files/publishingDynamicExpressionTemplate.json').text
//publicationConditionDataParsed = new JsonSlurper().parseText(publicationConditionDataTemplate)
//publicationConditionDataParsed.id = 'AtLeast'
//publicationConditionDataParsed.value = '31'
//publicationConditionDataParsed.compareCondition = 'ConditionAgeIs'
//println publicationConditionDataParsed
//publicationConditionDataJson = new groovy.json.JsonBuilder(publicationConditionDataParsed).toString()
//println publicationConditionDataJson
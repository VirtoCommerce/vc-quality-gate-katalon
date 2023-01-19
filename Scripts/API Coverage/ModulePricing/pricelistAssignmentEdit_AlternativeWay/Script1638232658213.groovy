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


WebUI.comment('TEST CASE: EDIT THE PRICELIST ASSIGNMENT (VIA PARSING)')


'PARSE AND EDIT THE DATA JSON TO PREPARE THE DYNAMIC EXPRESSION OBJECT (!!!OFF UNTILL CLARIFIED!!!!)'
//This part is commented out as updating dynamicExpression with 
//swagger or katalon sets prices widget to N/A even if the PUT request
//that successfully updates the dynamicExpression(condition) via GUI
//is copied and pasted


//GlobalVariable.pricelistId = '87b285fd-1c8e-49de-aed3-d62518f07375'
//GlobalVariable.assignmentId = '5de75e49-aecd-4a5e-bd20-298ccb99bd2d'
/*
condition = 'QweProduct'
assignment's 'Eligible shoppers' condition in
(used in 'If any of this conditions are true' section),
in this particular case it is 'Shopper searched in store for phrase:' ${condition%}
For GUI see Backend > Pricelist > Assignment > Edit catalog assignment blade
 */
/*
Object dynamicExpressionData = new File('Data Files/dynamicExpressionData.json').text
dynamicExpressionDataParsed = new JsonSlurper().parseText(dynamicExpressionData)
dynamicExpressionDataParsed.children[0].children[0].value = condition
dynamicExpression = dynamicExpressionDataParsed
*/	


'GET THE CREATED ASSIGNMENT BODY'
assignmentGet = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/pricelistAssignmentsGet'),
	null)

	
'PARSE THE ASSIGNMENT BODY CONTENT AND EDIT IT'
assignmentSearchBody = assignmentGet.getResponseBodyContent()
assignmentSearchResults = new JsonSlurper().parseText(assignmentSearchBody)
assignmentSearchResults.catalogId = GlobalVariable.catalogId
assignmentSearchResults.pricelistId = GlobalVariable.pricelistId
assignmentSearchResults.pricelist.name = GlobalVariable.pricelistName
assignmentNameUpdated = 'QweAssignmentUPD'
assignmentSearchResults.name = assignmentNameUpdated
assignmentSearchResults.id = GlobalVariable.assignmentId
//assignmentSearchResults.dynamicExpression.children[0].children[0] = dynamicExpression
assignmentSearchResultsJson = new groovy.json.JsonBuilder(assignmentSearchResults).toString()
WebUI.comment('The request body is: ' + assignmentSearchResultsJson)


'SEND THE REQUEST TO UPDATE THE ASSIGNMENT'
RequestObject assignmentUpdateObject = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Pricing/PricelistAssignmentsUpdate')
assignmentUpdateObject.setBodyContent(new HttpTextBodyContent(assignmentSearchResultsJson))
assignmentUpdate = WS.sendRequestAndVerify(assignmentUpdateObject)
	
	
'VERIFY THE ASSIGNMENT HAS BEEN UPDATED'
verifyUpdated = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistAssignmentsSearch'),
	null)
WS.verifyElementPropertyValue(verifyUpdated,'totalCount', '1')
WS.verifyElementPropertyValue(verifyUpdated,'results[0].name', assignmentNameUpdated)
WS.verifyElementPropertyValue(verifyUpdated,'results[0].id', GlobalVariable.assignmentId)
//WS.verifyElementPropertyValue(verifyUpdated,'results[0].dynamicExpression.children[0].children[0].value', condition)


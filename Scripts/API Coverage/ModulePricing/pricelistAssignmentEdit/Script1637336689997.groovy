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


WebUI.comment('TEST CASE: EDIT THE PRICELIST ASSIGNMENT')


'HERE IS THE OLD VERSION OF THIS TEST CASE (USES HARDCODED JSON THAT IS STORED IN THE REQUEST BODY'

'EDIT THE EXISTING  PRICELIST ASSIGNMENT'
assignmentNameUpdated = 'QweAssignmentUPD'
editAssignment = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Pricing/PricelistAssignmentsUpdate', [
	('catalogId') : GlobalVariable.catalogId,
	('pricelistId') : GlobalVariable.pricelistId,
	('pricelistname') : GlobalVariable.pricelistName,
	('assignmentName') : assignmentNameUpdated,
	('assignmentId') : GlobalVariable.assignmentId,
	]))


'VERIFY THE ASSIGNMENT HAS BEEN UPDATED'
verifyUpdated = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistAssignmentsSearch'),
	null
	)
//WS.verifyElementPropertyValue(verifyUpdated,'totalCount', '1')
WS.verifyElementPropertyValue(verifyUpdated,'results[0].name', assignmentNameUpdated)
WS.verifyElementPropertyValue(verifyUpdated,'results[0].id', GlobalVariable.assignmentId)



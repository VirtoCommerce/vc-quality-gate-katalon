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
import groovyjarjarantlr.collections.List


WebUI.comment('TEST CASE : Update organization BULK')


'UPDATE CREATED ORGANIZATIONS'
name1 = GlobalVariable.organizationName + 'Updated1'
name2 = GlobalVariable.organizationName + 'Updated2'
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Organizations/OrganizationsUpdateBulk', [
	('orgId1') : GlobalVariable.organizationId [0],
	('name1') : name1,
	('orgId2') : GlobalVariable.organizationId [1],
	('name2') : name2
	]))


'VERIFY ORGANIZATIONS ARE UPDATED'
//GET uses random generated id to rannge results, need to use 'if' operator to check each instance
verifyUpdated = WS.callTestCase(findTestCase('API Coverage/Contacts/_module_Customer/orgBulkGet'),
	null,
	FailureHandling.STOP_ON_FAILURE)

if (WS.verifyElementPropertyValue(verifyUpdated, 'name[0]', name1, FailureHandling.OPTIONAL)) {}
	else (WS.verifyElementPropertyValue(verifyUpdated, 'name[1]', name1))

if (WS.verifyElementPropertyValue(verifyUpdated, 'name[0]', name2, FailureHandling.OPTIONAL)) {}
	else (WS.verifyElementPropertyValue(verifyUpdated, 'name[1]', name2))
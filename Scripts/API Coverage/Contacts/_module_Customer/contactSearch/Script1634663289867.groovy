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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.exception.StepErrorException as StepErrorException


'Search new contact'

'DROP SEARCH INDEX FIRST'
dropIndex = WebUI.callTestCase(findTestCase('API Coverage/ModuleSearch/DropIndex'),
	null,
	FailureHandling.STOP_ON_FAILURE)


'SEARCH FOR THE NEW CONTACT'
WebUI.comment('TEST CASE: Contact search')
responseSearch = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Contacts/ContactsSearch',[
	('searchPhrase') : GlobalVariable.firstName
	]))
return responseSearch
//To keep this test case really atomic its better to implement all the neccessary 
//verifications inside of the test case that needs to be verified via callTestCase, e.g. 
//verify 'total count' == '0' inside of 'delete' test case by collingthis search
//and then applying verification code 


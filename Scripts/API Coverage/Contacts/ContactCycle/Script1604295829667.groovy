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

response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/DRAFT/ContactsCreate'))
def responseJson = new JsonSlurper().parseText(response.getResponseBodyContent())
GlobalVariable.contactId = responseJson.id
WebUI.comment('ContactId is: ' + GlobalVariable.contactId)

WebUI.callTestCase(findTestCase('API Coverage/DropIndex'), [ : ], FailureHandling.STOP_ON_FAILURE)
WS.delay(15)

WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/DRAFT/AddressesUpdate', [('contactId') : GlobalVariable.contactId])) 

WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/DRAFT/ContactsSearch'))
WS.delay(15)

WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/DRAFT/ContactsUpdate', [('contactId') : GlobalVariable.contactId]))

WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/DRAFT/ContactsGetId'))
WS.delay(10)

WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/DRAFT/ContactsDelete', [('contactId') : GlobalVariable.contactId]))
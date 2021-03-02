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


// Create new Contact and save Id
WebUI.comment('TEST CASE : Create contact')
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Contacts/ContactsCreate'))
def responseJson = new JsonSlurper().parseText(response.getResponseBodyContent())
GlobalVariable.contactId = responseJson.id
WebUI.comment('ContactId is: ' + GlobalVariable.contactId)


// Re-index important to search items
WebUI.callTestCase(findTestCase('API Coverage/backend/DropIndex'), [ : ], FailureHandling.STOP_ON_FAILURE)


// Search new contact
WebUI.comment('TEST CASE: Contact search')
responseSearch = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Contacts/ContactsSearch'))
WS.verifyElementPropertyValue(responseSearch, 'results[0].firstName', GlobalVariable.firstName)
WS.verifyElementPropertyValue(responseSearch, 'totalCount', 1)


// Update contact
WebUI.comment('TEST CASE : Update contact')
fullName = 'Qwe ContactUpdated'
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Contacts/ContactsUpdate', [('contactId') : GlobalVariable.contactId, ('fullName') : fullName]))


// Add address to contact
WebUI.comment('TEST CASE : Update address')
name = 'QwestUpdated'
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Contacts/AddressesUpdate', [('contactId') : GlobalVariable.contactId, ('name') : name]))


// Check Contact GET request by Id and verify updates
WebUI.comment('TEST CASE: Get contact by Id')
responseGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Contacts/ContactsGetId'))
WS.verifyElementPropertyValue(responseGet, 'fullName', fullName)
WS.verifyElementPropertyValue(responseGet, 'addresses[0].name', name)


// Delete contact
WebUI.comment('TEST CASE: Delete contact')
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Contacts/ContactsDelete', [('contactId') : GlobalVariable.contactId]))


// Re-index important to search items
WebUI.callTestCase(findTestCase('API Coverage/backend/DropIndex'), [ : ], FailureHandling.STOP_ON_FAILURE)


// Search new contact. Count 0 in result - contact was deleted
WebUI.comment('TEST CASE: Contact search')
responseSearch1 = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Contacts/ContactsSearch', [('searchPhrase') : GlobalVariable.firstName] ))
WS.verifyElementPropertyValue(responseSearch1, 'totalCount', 0)

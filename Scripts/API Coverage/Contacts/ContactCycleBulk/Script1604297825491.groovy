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


'CREATE NEW CONTACTS AND SAVE IDs'
fullName1 = GlobalVariable.contactName + 'Bulk1'
fullName2 = GlobalVariable.contactName + 'Bulk2'
WebUI.comment('TEST CASE : Create BULK contact')
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Contacts/ContactsCreateBulk',[
	('fullName1') : fullName1,
	('fullName2') : fullName2
	]))
def responseJson = new JsonSlurper().parseText(response.getResponseBodyContent())
GlobalVariable.contactId = responseJson.id
WebUI.comment('ContactId is: ' + GlobalVariable.contactId[0])
WebUI.comment('ContactId is: ' + GlobalVariable.contactId)


// Re-index important to search items
WebUI.callTestCase(findTestCase('API Coverage/ModuleSearch/DropIndex'), [ : ], FailureHandling.STOP_ON_FAILURE)


// Update contacts
WebUI.comment('TEST CASE : Update BULK contacts')
fullName1 = GlobalVariable.contactName + "Updated1"
fullName2 = GlobalVariable.contactName + "Updated2"
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Contacts/ContactsUpdateBulk', [
	('contactId1') : GlobalVariable.contactId[0],
	('contactId2') : GlobalVariable.contactId[1],
	('fullName1') : fullName1,
	('fullName2') : fullName2
	]))


// Check Contacts GET request by Id and verify update of first contact
WebUI.comment('TEST CASE: Get contact by Id')
responseGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Contacts/ContactsGetIdBulk', [
	('contactId1') : GlobalVariable.contactId[0],
	('contactId2') : GlobalVariable.contactId[1],
	])) 
WS.verifyElementPropertyValue(responseGet, '[0].fullName', fullName1)
WS.verifyElementPropertyValue(responseGet, '[1].fullName', fullName2)


// Delete contact
WebUI.comment('TEST CASE: Delete contacts')
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Contacts/ContactsDelete', [
	('contactId') : GlobalVariable.contactId[0],
	('contactId2') : GlobalVariable.contactId[1]
	]))


// Re-index important to search items
WebUI.callTestCase(findTestCase('API Coverage/ModuleSearch/DropIndex'), [ : ], FailureHandling.STOP_ON_FAILURE)


// Search new contact. Count 0 in result - contact was deleted
responseSearch1 = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Contacts/ContactsSearch',[
	('searchPhrase') : GlobalVariable.firstName
	]))
WS.verifyElementPropertyValue(responseSearch1, 'totalCount', 0)


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


WebUI.comment('TEST CASE: Bulk Delete Contact')

println GlobalVariable.contactId[0]
println GlobalVariable.contactId[1]

'DELETE CONTACT'
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Contacts/ContactsDelete', [
	('contactId') : GlobalVariable.contactId[0],
	('contactId2') : GlobalVariable.contactId[1]
	]))


'VERIFICATION'
verifyDeleted = WS.callTestCase(findTestCase('API Coverage/Contacts/_module_Customer/contactSearch'),
	null,
	FailureHandling.STOP_ON_FAILURE)
WS.verifyElementPropertyValue(verifyDeleted, 'totalCount', 0)
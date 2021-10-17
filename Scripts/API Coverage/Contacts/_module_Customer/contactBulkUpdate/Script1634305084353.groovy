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

'UPDATE CONTACTS'
WebUI.comment('TEST CASE : Update BULK contacts')
fullName1 = GlobalVariable.contactName + "Updated1"
fullName2 = GlobalVariable.contactName + "Updated2"
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Contacts/ContactsUpdateBulk', [
	('contactId1') : GlobalVariable.contactId[0],
	('fullName1') : fullName1,
	('contactId2') : GlobalVariable.contactId[1],
	('fullName2') : fullName2
	]))


'GET CONTACTS BY ID AND VERIFY IT WAS UPDATED'
verifyUpdated = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer/contactBulkGetByIds'),
	null,
	FailureHandling.STOP_ON_FAILURE)
//GET receives randomly generated ids and rannges the returned result upon its values
//So absolute paths to result can not be used as the position of the item in the list becomes random
//Using 'if' operator is suggested to process the response

if (WS.verifyElementPropertyValue(verifyUpdated, '[0].fullName', fullName1, FailureHandling.OPTIONAL)) {}
	else (WS.verifyElementPropertyValue(verifyUpdated, '[1].fullName', fullName1))

if (WS.verifyElementPropertyValue(verifyUpdated, '[0].fullName', fullName2, FailureHandling.OPTIONAL)) {}
	else (WS.verifyElementPropertyValue(verifyUpdated, '[1].fullName', fullName2))





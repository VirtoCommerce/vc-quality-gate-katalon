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

WebUI.comment('test suite dummy')


ContactCreate = WS.callTestCase(findTestCase('API Coverage/Contacts/_module_Customer/contactCreateNew'),
	null,
	FailureHandling.STOP_ON_FAILURE)


contactUpdate = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer/contactUpdate'),
	null,
	FailureHandling.STOP_ON_FAILURE)


contactAddAddressAndVerifyChanges = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer/contactAddAddress'),
	null,
	FailureHandling.STOP_ON_FAILURE)


contactDelete = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer/contactDelete'),
	null,
	FailureHandling.STOP_ON_FAILURE)


contactBulkCreate = WS.callTestCase(findTestCase('API Coverage/Contacts/_module_Customer/contactBulkCreate'),
	null,
	FailureHandling.STOP_ON_FAILURE)


contactBulkUpdate = WS.callTestCase(findTestCase('API Coverage/Contacts/_module_Customer/contactBulkUpdate'),
	null,
	FailureHandling.STOP_ON_FAILURE)


contactBulkDelete = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer/contactBulkDelete'),
	null,
	FailureHandling.STOP_ON_FAILURE)


orgCreate = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer/organizationCreate'),
	null,
	FailureHandling.STOP_ON_FAILURE)


orgUpdate = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer/organizationUpdate'),
	null,
	FailureHandling.STOP_ON_FAILURE)


orgDelete = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer/organizationDelete'),
	null,
	FailureHandling.STOP_ON_FAILURE)


orgBulkCreate = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer/orgBulkCreate'),
	null,
	FailureHandling.STOP_ON_FAILURE)


orgBulkUpdate = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer/orgBulkUpdate'),
	null,
	FailureHandling.STOP_ON_FAILURE)


orgBulkDelete = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer/orgBulkDelete'),
	null,
	FailureHandling.STOP_ON_FAILURE)



employeeCreate = WS.callTestCase(findTestCase('API Coverage/Contacts/_module_Customer/employeesCreate'),
	null,
	FailureHandling.STOP_ON_FAILURE)


employeeUpdate = WS.callTestCase(findTestCase('API Coverage/Contacts/_module_Customer/employeesUpdateBulk'),
	null,
	FailureHandling.STOP_ON_FAILURE)


employeeDelete = WS.callTestCase(findTestCase('API Coverage/Contacts/_module_Customer/employeesDeleteBulk'),
	null,
	FailureHandling.STOP_ON_FAILURE)


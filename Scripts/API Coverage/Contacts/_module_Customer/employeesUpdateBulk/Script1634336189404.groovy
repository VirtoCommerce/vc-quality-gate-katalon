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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import groovy.json.JsonSlurper as JsonSlurper
import groovy.json.JsonOutput as JsonOutput

WebUI.comment('TEST CASE : Update BULK employee')


GlobalVariable.contactName  = GlobalVariable.contactName + "Upd"
response = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Customer/Employees/EmployeesUpdateBulk', [
	('id') : GlobalVariable.employeeId,
	("fullName") : GlobalVariable.contactName,
	("firstName") : GlobalVariable.firstName,
	("lastName") : GlobalVariable.lastName,
	]))
WS.verifyElementPropertyValue(response, '[0].fullName', GlobalVariable.contactName)
//// STEP | Print json result
//def pretty = JsonOutput.prettyPrint(response.getResponseBodyContent())
//WebUI.comment(pretty)

//STEP 2 Verify name
//WebUI.comment('Verify if full name after sending request is correct or not')
//WS.verifyElementPropertyValue(response, '[0].id', GlobalVariable.employeeId)

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

WebUI.click(findTestObject('UI-B2B/RegistrationPage/InputFirstName'))

WebUI.setText(findTestObject('UI-B2B/RegistrationPage/InputFirstName'), GlobalVariable.FirstName)

WebUI.click(findTestObject('UI-B2B/RegistrationPage/InputLastName'))

WebUI.setText(findTestObject('UI-B2B/RegistrationPage/InputLastName'), GlobalVariable.LastName)

WebUI.click(findTestObject('UI-B2B/RegistrationPage/InputEmail'))

WebUI.setText(findTestObject('UI-B2B/RegistrationPage/InputEmail'), GlobalVariable.Email)

WebUI.click(findTestObject('UI-B2B/RegistrationPage/InputPhone'))

WebUI.setText(findTestObject('UI-B2B/RegistrationPage/InputPhone'), GlobalVariable.Phone)

WebUI.click(findTestObject('UI-B2B/RegistrationPage/InputSubmitContinueFirstStep'))


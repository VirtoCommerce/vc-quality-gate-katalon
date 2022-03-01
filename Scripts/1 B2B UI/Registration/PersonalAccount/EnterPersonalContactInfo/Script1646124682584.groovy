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

WebUI.click(findTestObject('1 UI-B2B ST/Registration/input_FirstName'))

WebUI.setText(findTestObject('1 UI-B2B ST/Registration/input_FirstName'), GlobalVariable.personFirstName)

WebUI.click(findTestObject('1 UI-B2B ST/Registration/input_LastName'))

WebUI.setText(findTestObject('1 UI-B2B ST/Registration/input_LastName'), GlobalVariable.personLastName)

WebUI.click(findTestObject('1 UI-B2B ST/Registration/input_Email'))

WebUI.setText(findTestObject('1 UI-B2B ST/Registration/input_Email'), GlobalVariable.personEmail)

WebUI.click(findTestObject('1 UI-B2B ST/Registration/input_Phone'))

WebUI.setText(findTestObject('1 UI-B2B ST/Registration/input_Phone'), GlobalVariable.personPhone)

WebUI.click(findTestObject('1 UI-B2B ST/Registration/button_SubmitContinueFirstStep'))


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

// select Organization

WebUI.click(findTestObject('1 UI-B2B ST/Registration/input_FirstName'))

//enter contact information information

WebUI.click(findTestObject('1 UI-B2B ST/Registration/input_FirstName'))

WebUI.setText(findTestObject('1 UI-B2B ST/Registration/input_FirstName'), GlobalVariable.contactFirstName)

WebUI.click(findTestObject('1 UI-B2B ST/Registration/input_lastName'))

WebUI.setText(findTestObject('1 UI-B2B ST/Registration/input_lastName'), GlobalVariable.contactLastName)

WebUI.click(findTestObject('1 UI-B2B ST/Registration/input_Email'))

WebUI.setText(findTestObject('1 UI-B2B ST/Registration/input_Email'), GlobalVariable.contactEmail)

//enter company info

WebUI.click(findTestObject('1 UI-B2B ST/Registration/input_CompanyName'))

WebUI.setText(findTestObject('1 UI-B2B ST/Registration/input_CompanyName'), GlobalVariable.organizationName)

//account information

WebUI.click(findTestObject('1 UI-B2B ST/Registration/input_UserName'))

WebUI.setText(findTestObject('1 UI-B2B ST/Registration/input_UserName'), GlobalVariable.userName)

WebUI.click(findTestObject('1 UI-B2B ST/Registration/input_Password'))

WebUI.setText(findTestObject('1 UI-B2B ST/Registration/input_Password'), GlobalVariable.userPassword)

WebUI.click(findTestObject('1 UI-B2B ST/Registration/input_PasswordConfirm'))

WebUI.setText(findTestObject('1 UI-B2B ST/Registration/input_PasswordConfirm'), GlobalVariable.userPassword)

WebUI.click(findTestObject('1 UI-B2B ST/Registration/button_SubmitFinal'))


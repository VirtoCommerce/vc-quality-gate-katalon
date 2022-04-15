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

WebUI.selectOptionByLabel(findTestObject('1 UI-B2B ST/Registration/select_Select countryCanada'), 'Canada', false)

WebUI.selectOptionByLabel(findTestObject('1 UI-B2B ST/Registration/select_Select ProvinceAlberta'), 'Alberta', false)

WebUI.click(findTestObject('1 UI-B2B ST/Registration/input_PostalCode'))

WebUI.setText(findTestObject('1 UI-B2B ST/Registration/input_PostalCode'), GlobalVariable.organizationPostalCode)

WebUI.click(findTestObject('1 UI-B2B ST/Registration/input_City'))

WebUI.setText(findTestObject('1 UI-B2B ST/Registration/input_City'), GlobalVariable.organizationCity)

WebUI.click(findTestObject('1 UI-B2B ST/Registration/input_Road'))

WebUI.setText(findTestObject('1 UI-B2B ST/Registration/input_Road'), GlobalVariable.organizationStreet)

WebUI.click(findTestObject('1 UI-B2B ST/Registration/button_SubmitContinueSecondStep'))


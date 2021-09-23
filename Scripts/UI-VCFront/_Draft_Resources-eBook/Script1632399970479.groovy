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


WebUI.navigateToUrl(GlobalVariable.urlFront + '/resources/ebook-trends-2021')

WebUI.setText(findTestObject('UI/UI-VCFront/main_Call_form_objects/input_First_name'), 'John QA')

WebUI.setText(findTestObject('UI/UI-VCFront/main_Call_form_objects/input_Last_name'), 'Doe QA')

WebUI.setText(findTestObject('UI/UI-VCFront/main_Call_form_objects/input_Email'), 'test@virtoway.com')

WebUI.setText(findTestObject('UI/UI-VCFront/main_Call_form_objects/input_Company'), 'VC QA test')

WebUI.selectOptionByValue(findTestObject('UI/UI-VCFront/main_Call_form_objects/select_Job_title'), 'Developer', true)

WebUI.scrollToElement(findTestObject('UI/UI-VCFront/main_Call_form_objects/input_Last_name'), 1)

WebUI.clickOffset(findTestObject('UI/UI-VCFront/main_Call_form_objects/checkbox_Terms'), 150, 10)

WebUI.click(findTestObject('UI/UI-VCFront/main_Call_form_objects/button_Download_case_study'))

WebUI.verifyElementText(findTestObject('UI/UI-VCFront/Page_ThankYou/div_Whats_next'), 'What\'s next')

assert WebUI.getUrl() == (GlobalVariable.urlFront + '/asset-download-thank-you')
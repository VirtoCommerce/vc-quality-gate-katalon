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

'Open browser on Request demo page'
WebUI.openBrowser(GlobalVariable.urlFront + '/request-demo')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/UI-VCFront/Page_DemoRequest/input_First_name'), 'John QA')

WebUI.setText(findTestObject('Object Repository/UI-VCFront/Page_DemoRequest/input_Last_name'), 'Doe QA')

WebUI.setText(findTestObject('UI-VCFront/Page_DemoRequest/input_Email'), 'test@virtoway.com')

WebUI.selectOptionByValue(findTestObject('UI-VCFront/Page_DemoRequest/select_Job_title'), 'Developer', true)

WebUI.setText(findTestObject('Object Repository/UI-VCFront/Page_DemoRequest/input_Company'), 'VC QA test')

WebUI.setText(findTestObject('UI-VCFront/Page_DemoRequest/input_Phone'), '0123456789')

WebUI.scrollToElement(findTestObject('UI-VCFront/Page_DemoRequest/input_RequestButton'), 1)

WebUI.click(findTestObject('UI-VCFront/Page_DemoRequest/input_RequestButton'))

WebUI.verifyElementText(findTestObject('UI-VCFront/Page_ThankYou/span_Thank you'), 'Thank you!')

assert WebUI.getUrl() == (GlobalVariable.urlFront + '/thank-you')

'Close browser'
WebUI.closeBrowser()


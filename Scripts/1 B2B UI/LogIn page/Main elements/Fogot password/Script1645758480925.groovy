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

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!FOGOT PASSWORD MAIN PAGE - NOT READY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//WebUI.click(findTestObject('1 UI-B2B ST/Login page/links/a_fogotPassword'))
//WebUI.waitForPageLoad(3)
//WebUI.setText(findTestObject('1 UI-B2B ST/Login page/links/input_mail'), GlobalVariable.contactEmail))
//WebUI.click(findTestObject('1 UI-B2B ST/Login page/links/button_submitNewPassword'))
//def search1 = WebUI.getText(findTestObject('1 UI-B2B ST/Login page/links/text_resetPasswordSuccess'))
//WebUI.verifyMatch(search1, "We've sent you an email with a link to update your password.", false)
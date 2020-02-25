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

WebUI.openBrowser('https://qa-demovc-store.azurewebsites.net/')

WebUI.waitForPageLoad(2)

WebUI.click(findTestObject('Header/SignInButtonHeader'))

WebUI.setText(findTestObject('Object Repository/SignInPage/EmailCustomerLogin'), GlobalVariable.UserLogPass)

WebUI.setText(findTestObject('Object Repository/SignInPage/PasswordCustomerLogin'), GlobalVariable.UserLogPass)

WebUI.click(findTestObject('Object Repository/SignInPage/SignInSubmitButton'))

WebUI.takeScreenshot('screenshots/login.png')

String GetText = WebUI.getText(findTestObject('Header/HeaderLogoutText'))

WebUI.verifyMatch(GetText, 'admin', false)

WebUI.click(findTestObject('Object Repository/Header/HeaderLogoutButton'))






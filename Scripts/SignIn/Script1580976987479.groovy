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

WebUI.setText(findTestObject('Page_Electronics/EmailCustomerLogin'), 'TestUser1')

WebUI.setText(findTestObject('Page_Electronics/PasswordCustomerLogin'), 'TestUser1')

WebUI.click(findTestObject('Page_Electronics/SignInSubmitButton'))

WebUI.takeScreenshot('screenshots/login.png')

WebUI.click(findTestObject('Page_Electronics/HeaderLogoutButton'))

WebUI.takeScreenshot('screenshots/logout.png')

WebUI.closeBrowser()


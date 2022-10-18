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
import java.util.Iterator as Iterator
import java.util.List as List
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import java.util.Arrays as Arrays

/*def DataFromFile = WebUI.callTestCase(findTestCase('Test Cases/SystemCases/PrepareData'), [:], FailureHandling.STOP_ON_FAILURE)

def Email = DataFromFile.Email

def FirstName = DataFromFile.FirstName

def LastName = DataFromFile.LastName
*/
WebUI.callTestCase(findTestCase('Test Cases/SystemCases/WindowtoFullSize'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('UI-Electronics/Header/SignUpButtonHeader'))

WebUI.verifyElementText(findTestObject('UI-Electronics/SignUpPage/H1SignUpPage'), 'CREATE ACCOUNT')

WebUI.click(findTestObject('UI-Electronics/SignUpPage/InputEmailSignUPPage'))

WebUI.setText(findTestObject('UI-Electronics/SignUpPage/InputEmailSignUPPage'), GlobalVariable.email)

WebUI.click(findTestObject('UI-Electronics/SignUpPage/InputFirstNameSignUPPage'))

WebUI.setText(findTestObject('UI-Electronics/SignUpPage/InputFirstNameSignUPPage'), GlobalVariable.firstName)

WebUI.click(findTestObject('UI-Electronics/SignUpPage/InputLastNameSignUpPage'))

WebUI.setText(findTestObject('UI-Electronics/SignUpPage/InputLastNameSignUpPage'), GlobalVariable.lastName)

WebUI.click(findTestObject('UI-Electronics/SignUpPage/InputPasswordSignUpPage'))

def userLogPass = WebUI.callTestCase(findTestCase('Test Cases/SystemCases/GetCurrentDate'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.UserLogPass = userLogPass

WebUI.setText(findTestObject('UI-Electronics/SignUpPage/InputPasswordSignUpPage'), GlobalVariable.UserLogPass)

WebUI.click(findTestObject('UI-Electronics/SignUpPage/InputUserNameSignUPPAge'))

WebUI.setText(findTestObject('UI-Electronics/SignUpPage/InputUserNameSignUPPAge'), GlobalVariable.UserLogPass)

WebUI.click(findTestObject('UI-Electronics/SignUpPage/SubminSignUpPage'))

String GetText = WebUI.getText(findTestObject('UI-Electronics/Header/HeaderLogoutText'))

WebUI.verifyMatch(GetText, GlobalVariable.firstName, false)

WebUI.click(findTestObject('UI-Electronics/Header/HeaderLogoutButton'))



WebUI.closeBrowser()


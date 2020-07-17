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

WebUI.click(findTestObject('Header/SignInButtonHeader'))

def DataFromFile = WebUI.callTestCase(findTestCase('Test Cases/SystemCases/PrepareData'), [:], FailureHandling.STOP_ON_FAILURE)
def Login = DataFromFile.Login
def Password = DataFromFile.Password
def FirstName = DataFromFile.FirstName

if( Login !=""&& Password!="" ){
	WebUI.setText(findTestObject('Object Repository/SignInPage/EmailCustomerLogin'), Login)
	
	WebUI.setText(findTestObject('Object Repository/SignInPage/PasswordCustomerLogin'), Password)
	
	WebUI.click(findTestObject('Object Repository/SignInPage/SignInSubmitButton'))
	
	String GetText = WebUI.getText(findTestObject('Header/HeaderLogoutText'))
	
	WebUI.verifyMatch(GetText, FirstName, false)
 }else{
	WebUI.setText(findTestObject('Object Repository/SignInPage/EmailCustomerLogin'), login)

	WebUI.setText(findTestObject('Object Repository/SignInPage/PasswordCustomerLogin'), password)
	
	WebUI.click(findTestObject('Object Repository/SignInPage/SignInSubmitButton'))
	
	String GetText = WebUI.getText(findTestObject('Header/HeaderLogoutText'))
	//Need variable for FirstName 
	//WebUI.verifyMatch(GetText, GlobalVariable.UserLogPass, false)
 }




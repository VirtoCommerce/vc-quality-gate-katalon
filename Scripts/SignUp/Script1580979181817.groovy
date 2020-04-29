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
import groovy.time.TimeCategory as TimeCategory

def DataFromFile = WebUI.callTestCase(findTestCase('Test Cases/SystemCases/PrepareData'), [:], FailureHandling.STOP_ON_FAILURE)

def Email = DataFromFile.Email

def FirstName = DataFromFile.FirstName

def LastName = DataFromFile.LastName


WebUI.callTestCase(findTestCase('Test Cases/SystemCases/WindowtoFullSize'), [:], FailureHandling.STOP_ON_FAILURE)


WebUI.click(findTestObject('Header/SignUpButtonHeader'))

WebUI.verifyElementText(findTestObject('SignUpPage/H1SignUpPage'), 'CREATE ACCOUNT')

WebUI.click(findTestObject('SignUpPage/InputEmailSignUPPage'))

WebUI.setText(findTestObject('SignUpPage/InputEmailSignUPPage'), Email)

WebUI.click(findTestObject('SignUpPage/InputFirstNameSignUPPage'))

WebUI.setText(findTestObject('SignUpPage/InputFirstNameSignUPPage'), FirstName)

WebUI.click(findTestObject('SignUpPage/InputLastNameSignUpPage'))

WebUI.setText(findTestObject('SignUpPage/InputLastNameSignUpPage'), LastName)

WebUI.click(findTestObject('SignUpPage/InputPasswordSignUpPage'))

use(TimeCategory, { 
        today = new Date()
    })

String todaysDate = today.format('MMddyyyy')

GlobalVariable.UserLogPass = ('TestUser' + todaysDate)

WebUI.setText(findTestObject('SignUpPage/InputPasswordSignUpPage'), GlobalVariable.UserLogPass)

WebUI.click(findTestObject('SignUpPage/InputUserNameSignUPPAge'))

WebUI.setText(findTestObject('SignUpPage/InputUserNameSignUPPAge'), GlobalVariable.UserLogPass)

WebUI.click(findTestObject('SignUpPage/SubminSignUpPage'))

String GetText = findTestObject('Object Repository/Header/HeaderLogoutText').getText()

WebUI.verifyMatch(GetText, GlobalVariable.UserLogPass, false)

WebUI.click(findTestObject('Header/HeaderLogoutButton'))

not_run: WebUI.acceptAlert()

WebUI.closeBrowser()


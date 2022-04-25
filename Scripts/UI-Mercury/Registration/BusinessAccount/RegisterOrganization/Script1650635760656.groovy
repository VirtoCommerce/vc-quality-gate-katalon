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

//open register page

WebUI.click(findTestObject('UI-Mercury/Registration/link_RegisterPage'))

WebUI.delay(5)

assert WebUI.getUrl() == (GlobalVariable.urlFront + '/sign-up')

WebUI.verifyElementText (findTestObject('UI-Mercury/Registration/h1_Registration'),'REGISTRATION')

WebUI.click(findTestObject('UI-Mercury/Registration/label_Organization'))

WebUI.click(findTestObject('UI-Mercury/Registration/input_FirstName'))

WebUI.setText(findTestObject('UI-Mercury/Registration/input_FirstName'), GlobalVariable.contactFirstName)

WebUI.click(findTestObject('UI-Mercury/Registration/input_LastName'))

WebUI.setText(findTestObject('UI-Mercury/Registration/input_LastName'), GlobalVariable.contactLastName)

WebUI.click(findTestObject('UI-Mercury/Registration/input_Email'))

WebUI.setText(findTestObject('UI-Mercury/Registration/input_Email'), GlobalVariable.contactEmail)


//enter company info

WebUI.click(findTestObject('UI-Mercury/Registration/input_CompanyName'))

WebUI.setText(findTestObject('UI-Mercury/Registration/input_CompanyName'), GlobalVariable.organizationName)


//enter account info

WebUI.click(findTestObject('UI-Mercury/Registration/input_UserName'))

WebUI.setText(findTestObject('/UI-Mercury/Registration/input_UserName'), GlobalVariable.userName)

WebUI.click(findTestObject('UI-Mercury/Registration/input_Password'))

WebUI.setText(findTestObject('UI-Mercury/Registration/input_Password'), GlobalVariable.userPassword)

WebUI.click(findTestObject('UI-Mercury/Registration/input_PasswordConfirm'))

WebUI.setText(findTestObject('UI-Mercury/Registration/input_PasswordConfirm'), GlobalVariable.userPassword)

WebUI.click(findTestObject('UI-Mercury/Registration/button_Register'))


//confirmation popup

WebUI.verifyElementPresent(findTestObject('UI-Mercury/Registration/div_RegistrationPopUp'),3)

WebUI.click(findTestObject('UI-Mercury/Registration/div_RegistrationPopUpButton'))

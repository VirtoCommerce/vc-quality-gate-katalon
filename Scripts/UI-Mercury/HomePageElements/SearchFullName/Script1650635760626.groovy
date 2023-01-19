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


WebUI.click(findTestObject('UI-Mercury/HomePageElements/Search/icon_Search'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/HomePageElements/Search/div_SearchBlock'), 4)

WebUI.verifyElementPresent(findTestObject('UI-Mercury/HomePageElements/Search/button_Search'), 4)

WebUI.verifyElementPresent(findTestObject('UI-Mercury/HomePageElements/Search/icon_CloseSearch'), 4)

WebUI.setText(findTestObject('UI-Mercury/HomePageElements/Search/input_SearchTab'), GlobalVariable.searchFullName)

WebUI.click(findTestObject('UI-Mercury/HomePageElements/Search/button_Search'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/HomePageElements/Search/div_SearchDropNDown'), 4)

WebUI.click(findTestObject('UI-Mercury/HomePageElements/Search/button_ViewAllResults'))

WebUI.mouseOver(findTestObject('UI-Mercury/HomePageElements/Search/h2_SearchResultFullName'))

def search1 = WebUI.getText(findTestObject('UI-Mercury/HomePageElements/Search/h2_SearchResultFullName'))

WebUI.verifyMatch(search1, 'Your search for "' + GlobalVariable.searchFullName + '" revealed the following', false)


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



WebUI.setText(findTestObject('1 UI-B2B ST/HomePageElements/Header/3rdHeader/input_SearchTab'), GlobalVariable.searchFullName)

WebUI.click(findTestObject('1 UI-B2B ST/HomePageElements/Header/3rdHeader/button_Search'))

WebUI.mouseOver(findTestObject('1 UI-B2B ST/HomePageElements/Search/h2_SearchResultFullName'))

def search1 = WebUI.getText(findTestObject('1 UI-B2B ST/HomePageElements/Search/h2_SearchResultFullName'))

// WebUI.verifyMatch(search1, 'YOUR SEARCH FOR "LASER" REVEALED THE FOLLOWING:', false)

WebUI.verifyMatch(search1, 'YOUR SEARCH FOR "' + GlobalVariable.searchFullName + '" REVEALED THE FOLLOWING:', false)

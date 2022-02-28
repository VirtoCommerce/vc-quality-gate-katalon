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

WebUI.click(findTestObject('1 UI-B2B ST/Home page elements/Bulk Order/a_OpenBulkOrderPad'))

WebUI.click(findTestObject('1 UI-B2B ST/Home page elements/Bulk Order/input_FillSku'))

WebUI.setText(findTestObject('1 UI-B2B ST/Home page elements/Bulk Order/input_FillSku'), GlobalVariable.skuCorrect)

WebUI.click(findTestObject('1 UI-B2B ST/Home page elements/Bulk Order/button_AddToCart'))

WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Home page elements/Bulk Order/a_VerifyCartOpens'),4)
 
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Bulk Order/div_CartProductList'))

WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Home page elements/Bulk Order/span_VerifyItemCorrectSku'),4)

WebUI.verifyTextPresent(GlobalVariable.skuCorrect,false)


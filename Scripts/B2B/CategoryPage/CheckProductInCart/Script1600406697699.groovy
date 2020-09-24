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


WebUI.click(findTestObject('UI-B2B/CartAndCheckoutPage/InputQTY'))

WebUI.setText(findTestObject('UI-B2B/CartAndCheckoutPage/InputQTY'), '20')

WebUI.click(findTestObject('UI-B2B/CartAndCheckoutPage/AUpdate'))
def TotalFromCart = WebUI.getText(findTestObject('UI-B2B/CartAndCheckoutPage/SpanTotal')).replace('$', '')
float val = Float.parseFloat(TotalFromCart)
String firstResult = String.format("%.2f", val);
GlobalVariable.TotalFromCategory = String.format("%.2f", GlobalVariable.TotalFromCategory);
WebUI.verifyEqual(firstResult, GlobalVariable.TotalFromCategory)

WebUI.click(findTestObject('UI-B2B/CartAndCheckoutPage/AProceedToCheckout'))


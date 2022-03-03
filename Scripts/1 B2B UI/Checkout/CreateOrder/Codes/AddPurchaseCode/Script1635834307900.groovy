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

WebUI.mouseOver(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/Codes/Purchased code/div_PurchaseCode'))

if (WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/Codes/Purchased code/button_RemovePurchasedCode'),10,FailureHandling.OPTIONAL) == true)
	{
	WebUI.click(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/Codes/Purchased code/button_RemovePurchasedCode'))
	WebUI.mouseOver(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/Codes/Purchased code/input_FieldPurchaseCode'))
	WebUI.setText(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/Codes/Purchased code/input_FieldPurchaseCode'), '1275675634')
	}
else
	{
	WebUI.mouseOver(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/Codes/Purchased code/input_FieldPurchaseCode'))
	WebUI.setText(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/Codes/Purchased code/input_FieldPurchaseCode'), '1275675634')
	}
	
WebUI.click(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/Codes/Purchased code/button_SubmitPurchaseCode'))

WebUI.waitForPageLoad(5)

WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/Codes/Purchased code/Message'),)

WebUI.mouseOver(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/Codes/Purchased code/Message'))

def messagePurchasedCode = WebUI.getText(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/Codes/Purchased code/Message'))

WebUI.verifyMatch(messagePurchasedCode, '× / Purchase order number has successfully changed', false)

WebUI.click(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/Codes/Promo code/button_CloseMessage2'))
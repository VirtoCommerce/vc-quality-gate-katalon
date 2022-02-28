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

WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/div_BlockOrderSummary'))

WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_OrderSummary'))

def OrderPage1 = WebUI.getText(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_OrderSummary'))

WebUI.verifyMatch(OrderPage1, 'ORDER SUMMARY', false)

WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/div_BlockShippingAddress'))

WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_PickUpAddress'))

def OrderPage2 = WebUI.getText(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_PickUpAddress'))

WebUI.verifyMatch(OrderPage2, 'PICKUP ADDRESS', false)

WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/div_BlockPaymentMethod'))

WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_PaymentMethod'))

def OrderPage3 = WebUI.getText(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_PaymentMethod'))

WebUI.verifyMatch(OrderPage3, 'PAYMENT METHOD', false)

WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/div_BlockMyPurchasedProducts'))

WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_MyPurchasedProducts'))

def OrderPage4 = WebUI.getText(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_MyPurchasedProducts'))

WebUI.verifyMatch(OrderPage4, 'MY PURCHASED PRODUCTS', false)
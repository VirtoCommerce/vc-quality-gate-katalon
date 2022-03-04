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

WebUI.mouseOver(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/OrderDetailsPage/OrderDetails/div_BlockOrderSummary'))

WebUI.mouseOver(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/OrderDetailsPage/OrderDetails/h5_OrderSummary'))

def testText1 = WebUI.getText(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/OrderDetailsPage/OrderDetails/h5_OrderSummary'))

WebUI.verifyMatch(testText1, 'ORDER SUMMARY', false)

WebUI.mouseOver(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/OrderDetailsPage/OrderDetails/div_BlockShippingAddress'))

WebUI.mouseOver(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/OrderDetailsPage/OrderDetails/h5_ShippingAddress'))

def testText2 = WebUI.getText(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/OrderDetailsPage/OrderDetails/h5_ShippingAddress'))

WebUI.verifyMatch(testText2, 'SHIPPING ADDRESS', false)

WebUI.mouseOver(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/OrderDetailsPage/OrderDetails/div_BlockPaymentMethod'))

WebUI.mouseOver(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/OrderDetailsPage/OrderDetails/h5_PaymentMethod'))

def testText3 = WebUI.getText(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/OrderDetailsPage/OrderDetails/h5_PaymentMethod'))

WebUI.verifyMatch(testText3, 'PAYMENT METHOD', false)

WebUI.mouseOver(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/OrderDetailsPage/OrderDetails/div_BlockMyPurchasedProducts'))

WebUI.mouseOver(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/OrderDetailsPage/OrderDetails/h5_MyPurchasedProducts'))

def testText4 = WebUI.getText(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/OrderDetailsPage/OrderDetails/h5_MyPurchasedProducts'))

WebUI.verifyMatch(testText4, 'MY PURCHASED PRODUCTS', false)
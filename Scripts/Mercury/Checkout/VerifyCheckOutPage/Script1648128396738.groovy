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

//verify checkout page

WebUI.mouseOver(findTestObject('UI-Mercury/Checkout/CreateOrder/CheckoutPage/DRAFT/1div_CheckOutPage'))

WebUI.mouseOver(findTestObject('UI-Mercury/Checkout/CreateOrder/CheckoutPage/h2_TitleCheckOut'))

WebUI.verifyTextPresent('Checkout', false)

//verify my products block

WebUI.mouseOver(findTestObject('UI-Mercury/Checkout/CreateOrder/CheckoutPage/ProductsBlock/div_ProductsBlock'))

WebUI.verifyElementVisible(findTestObject('UI-Mercury/Checkout/CreateOrder/CheckoutPage/ProductsBlock/div_ProductsBlock'))

WebUI.mouseOver(findTestObject('UI-Mercury/Checkout/CreateOrder/CheckoutPage/ProductsBlock/h3_TitleProducts'))

WebUI.verifyTextPresent('My products', false)

///verify Gifts block

WebUI.mouseOver(findTestObject('UI-Mercury/Checkout/CreateOrder/CheckoutPage/Gifts/div_GiftsBlock'))

WebUI.verifyElementVisible(findTestObject('UI-Mercury/Checkout/CreateOrder/CheckoutPage/Gifts/div_GiftsBlock'))

WebUI.mouseOver(findTestObject('UI-Mercury/Checkout/CreateOrder/CheckoutPage/Gifts/h3_TitleGifts'))

WebUI.verifyTextPresent('Checkout', false)

WebUI.verifyElementVisible(findTestObject('UI-Mercury/Checkout/CreateOrder/CheckoutPage/Gifts/div_Gift'))

//verify Shipping Details block

WebUI.mouseOver(findTestObject('UI-Mercury/Checkout/CreateOrder/CheckoutPage/ShippingDetails/div_ShippingDetailsBlock'))

WebUI.verifyElementVisible(findTestObject('UI-Mercury/Checkout/CreateOrder/CheckoutPage/ShippingDetails/div_ShippingDetailsBlock'))

WebUI.mouseOver(findTestObject('UI-Mercury/Checkout/CreateOrder/CheckoutPage/Gifts/h3_TitleGifts'))

WebUI.verifyTextPresent('Checkout', false)

//verify Payment Details block

WebUI.mouseOver(findTestObject('UI-Mercury/Checkout/CreateOrder/CheckoutPage/PaymentDetails/div_PaymentDetailsBlock'))

WebUI.verifyElementVisible(findTestObject('UI-Mercury/Checkout/CreateOrder/CheckoutPage/PaymentDetails/div_PaymentDetailsBlock'))

WebUI.mouseOver(findTestObject('UI-Mercury/Checkout/CreateOrder/CheckoutPage/Gifts/h3_TitleGifts'))

WebUI.verifyTextPresent('Checkout', false)

//verify Extra block

WebUI.mouseOver(findTestObject('null'))

WebUI.verifyElementVisible(findTestObject('null'))

WebUI.mouseOver(findTestObject('UI-Mercury/Checkout/CreateOrder/CheckoutPage/Gifts/h3_TitleGifts'))

WebUI.verifyTextPresent('Checkout', false)

//


WebUI.mouseOver(findTestObject('null'))

WebUI.verifyElementVisible(findTestObject('null'))

WebUI.verifyElementClickable (findTestObject('UI-Mercury/Checkout/CreateOrder/CheckoutPage/button_PlaceOrder'))





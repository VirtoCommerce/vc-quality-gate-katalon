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

WebUI.click(findTestObject('UI-B2B/CartAndCheckoutPage/AShippingAddress'))

WebUI.click(findTestObject('UI-B2B/CartAndCheckoutPage/ASelectAddress'))

WebUI.click(findTestObject('UI-B2B/CartAndCheckoutPage/ButtonSave'))

WebUI.click(findTestObject('UI-B2B/CartAndCheckoutPage/AShippingMethod'))

WebUI.click(findTestObject('UI-B2B/CartAndCheckoutPage/AChooseShippingMethod'))

WebUI.click(findTestObject('UI-B2B/CartAndCheckoutPage/ButtonOK'))

WebUI.click(findTestObject('UI-B2B/CartAndCheckoutPage/APaymentMethod'))

WebUI.waitForElementClickable(findTestObject('UI-B2B/CartAndCheckoutPage/AChoosePayment'), 20)

WebUI.click(findTestObject('UI-B2B/CartAndCheckoutPage/AChoosePayment'))

WebUI.mouseOver(findTestObject('UI-B2B/CartAndCheckoutPage/ButtonSavePayment'))

WebUI.click(findTestObject('UI-B2B/CartAndCheckoutPage/ButtonSavePayment'))

WebUI.waitForElementClickable(findTestObject('UI-B2B/CartAndCheckoutPage/SpanCreateOrder'), 20)

not_run: WebUI.click(findTestObject('UI-B2B/CartAndCheckoutPage/ButtonUpdate'))

WebUI.click(findTestObject('UI-B2B/CartAndCheckoutPage/SpanCreateOrder'))

WebUI.verifyTextPresent(' ORDER HAS SUCCESSFULLY BEEN SUBMITTED. YOU WILL BE SENT AN EMAIL NOTIFICATION AS SOON AS YOUR ORDER IS READY.', 
    false)

def spanSubTotal = WebUI.getText(findTestObject('UI-B2B/OrderCompletePage/SpanSubtotal'))

def spanShipping = WebUI.getText(findTestObject('UI-B2B/OrderCompletePage/SpanShipping'))

def spanTax = WebUI.getText(findTestObject('Object Repository/UI-B2B/OrderCompletePage/SpanTaxTotal'))

def spanDiscount = WebUI.getText(findTestObject('Object Repository/UI-B2B/OrderCompletePage/SpanDiscount'))

def spanTotal = WebUI.getText(findTestObject('Object Repository/UI-B2B/OrderCompletePage/SpanTotal'))

spanSubTotal = spanSubTotal.replace('$', '')

spanShipping = spanShipping.replace('$', '')

spanTax = spanTax.replace('$', '')

spanDiscount = spanDiscount.replace('$', '')

spanTotal = spanTotal.replace('$', '')

float FloatSpanShipping = Float.parseFloat(spanShipping)

float FloatSpanSubtotal = Float.parseFloat(spanSubTotal)

float FloatSpanTax = Float.parseFloat(spanTax)

float FloatSpanDiscount = Float.parseFloat(spanDiscount)

float FloatSpanTotal = Float.parseFloat(spanTotal)

float FloatResult = ((FloatSpanShipping + FloatSpanSubtotal) + FloatSpanTax) - FloatSpanDiscount

String FloatSpanTotalString = String.format('%.2f', FloatSpanTotal)

String FloatResultString = String.format('%.2f', FloatResult)

System.out.println(FloatResult)

WebUI.verifyEqual(FloatResultString, FloatSpanTotalString)


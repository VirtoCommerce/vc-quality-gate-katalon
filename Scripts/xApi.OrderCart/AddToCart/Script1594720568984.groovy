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

//WebUI.callTestCase(findTestCase('Test Cases/SystemCases/WindowtoFullSize'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Electronics/a_Headphones'))

WebUI.verifyElementText(findTestObject('AerialImagingCategory/H1CategoryPage'), 'HEADPHONES')
//---
WebUI.click(findTestObject('AerialImagingCategory/ButtonAddToCartIcon'))

WebUI.verifyElementText(findTestObject('PopupAddToCart/Page_Aerial Imaging  Drones - Electronics/H1PopupProductAddedTocart'), 'PRODUCT IS ADDED TO CART')

GlobalVariable.priceFromPopup = WebUI.getText(findTestObject('Object Repository/PopupAddToCart/Page_Aerial Imaging  Drones - Electronics/SpanPriceInPopup'))

WebUI.click(findTestObject('PopupAddToCart/Page_Aerial Imaging  Drones - Electronics/ButtonGoToCart'))

WebUI.mouseOver(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/SpanItemTotal'))

GlobalVariable.itemsTotalFromCart = WebUI.getText(findTestObject('Object Repository/CartCheckoutPage/Page_Electronics - Checkout/SpanItemTotal'))

println ("PRICE IS : "+GlobalVariable.itemsTotalFromCart)

WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics/ButtonCheckoutOnCart'))
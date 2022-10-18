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

def DataFromFile = WebUI.callTestCase(findTestCase('Test Cases/SystemCases/PrepareData'), [:], FailureHandling.STOP_ON_FAILURE)

def Email = DataFromFile.Email

def FirstName = DataFromFile.FirstName

def LastName = DataFromFile.LastName

def Company = DataFromFile.Company

def Address = DataFromFile.Address

def City = DataFromFile.City

def Apt = DataFromFile.Apt

def Zip = DataFromFile.Zip

WebUI.callTestCase(findTestCase('Test Cases/SystemCases/WindowtoFullSize'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('UI-Electronics/Page_Electronics/Theater'))

WebUI.click(findTestObject('UI-Electronics/Page_Electronics/Theater'))

WebUI.verifyElementText(findTestObject('UI-Electronics/AerialImagingCategory/H1CategoryPage'), 'HOME THEATER')

WebUI.click(findTestObject('UI-Electronics/AerialImagingCategory/ButtonAddToCartIcon'))

WebUI.verifyElementText(findTestObject('UI-Electronics/PopupAddToCart/Page_Aerial Imaging  Drones - Electronics/H1PopupProductAddedTocart'), 
    'PRODUCT IS ADDED TO CART')
def PriceFromPopup = WebUI.getText(findTestObject('UI-Electronics/PopupAddToCart/Page_Aerial Imaging  Drones - Electronics/SpanPriceInPopup'))

WebUI.click(findTestObject('UI-Electronics/PopupAddToCart/Page_Aerial Imaging  Drones - Electronics/ButtonGoToCart'))

WebUI.click(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics/ButtonCheckoutOnCart'))

WebUI.click(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/InputEmailCheckout'))

WebUI.setText(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/InputEmailCheckout'), Email)

WebUI.click(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/FirstNameCheckout'))

WebUI.setText(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/FirstNameCheckout'), FirstName)

WebUI.click(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/LastNameCheckout'))

WebUI.setText(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/LastNameCheckout'), LastName)

WebUI.click(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/CompanyCheckout'))

WebUI.setText(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/CompanyCheckout'), Company)

WebUI.click(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/AddressCheckout'))

WebUI.setText(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/AddressCheckout'), Address)

WebUI.click(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/AptCheckout'))

WebUI.setText(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/AptCheckout'), Apt)

WebUI.click(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/CityCheckout'))

WebUI.setText(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/CityCheckout'), City)

WebUI.selectOptionByIndex(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/SelectCountry'), 2)

WebUI.selectOptionByIndex(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/SelectRegion'), 2)

WebUI.click(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/ZIpCheckout'))

WebUI.setText(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/ZIpCheckout'), Zip)

WebUI.click(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/ShippingMethodCheckout'))

WebUI.click(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/CheckShippingmethodAir'))

WebUI.click(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/PaymentBtnCheckout'))

WebUI.click(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/AuthorizeNetCheck'))

WebUI.waitForPageLoad(2)

WebUI.scrollToElement(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/CreateORderCheckout'), 0)

not_run: WebUI.waitForElementClickable(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/CreateORderCheckout'), 
    10)

WebUI.click(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/CreateORderCheckout'))

WebUI.waitForElementNotVisible(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/CreateORderCheckout'), 10)

WebUI.setText(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/InputCardNumber'), '4242424242424242')

WebUI.setText(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/InputCardCVV'), '111')

WebUI.setText(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/InputCardDate'), '11/22')

WebUI.click(findTestObject('UI-Electronics/CartCheckoutPage/Page_Electronics - Checkout/InputSubmitCard'))

WebUI.getText(findTestObject('UI-Electronics/Thank you page/H1Subtotal'))

def PriceFromTotalBlock = WebUI.getText(findTestObject('UI-Electronics/Thank you page/H1Subtotal'))

WebUI.verifyEqual(PriceFromPopup, PriceFromTotalBlock)


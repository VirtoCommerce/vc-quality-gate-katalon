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

WebUI.callTestCase(findTestCase('Login'), [('login') : GlobalVariable.UserLogPass, ('password') : GlobalVariable.UserLogPass], 
    FailureHandling.OPTIONAL)

//WebUI.mouseOver(findTestObject('Page_Electronics/Theater'))
//
//WebUI.click(findTestObject('Page_Electronics/Theater'))
//
//WebUI.verifyElementText(findTestObject('AerialImagingCategory/H1CategoryPage'), 'HOME THEATER')

WebUI.mouseOver(findTestObject('Object Repository/Page_Electronics/a_Headphones'))

WebUI.click(findTestObject('Object Repository/Page_Electronics/a_Headphones'))

WebUI.verifyElementText(findTestObject('AerialImagingCategory/H1CategoryPage'), 'HEADPHONES')

WebUI.click(findTestObject('AerialImagingCategory/ButtonAddToCartIcon'))

WebUI.verifyElementText(findTestObject('PopupAddToCart/Page_Aerial Imaging  Drones - Electronics/H1PopupProductAddedTocart'), 
    'PRODUCT IS ADDED TO CART')

def PriceFromPopup = WebUI.getText(findTestObject('Object Repository/PopupAddToCart/Page_Aerial Imaging  Drones - Electronics/SpanPriceInPopup'))

WebUI.click(findTestObject('PopupAddToCart/Page_Aerial Imaging  Drones - Electronics/ButtonGoToCart'))

WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics/ButtonCheckoutOnCart'))

def CheckAddressResult = WebUI.verifyElementPresent(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/SelectAddress'), 
    5, FailureHandling.OPTIONAL)

if (CheckAddressResult == false) {
    WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/InputEmailCheckout'))

    WebUI.setText(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/InputEmailCheckout'), Email)

    WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/FirstNameCheckout'))

    WebUI.setText(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/FirstNameCheckout'), FirstName)

    WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/LastNameCheckout'))

    WebUI.setText(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/LastNameCheckout'), LastName)

    WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/CompanyCheckout'))

    WebUI.setText(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/CompanyCheckout'), Company)

    WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/AddressCheckout'))

    WebUI.setText(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/AddressCheckout'), Address)

    WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/AptCheckout'))

    WebUI.setText(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/AptCheckout'), Apt)

    WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/CityCheckout'))

    WebUI.setText(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/CityCheckout'), City)

    WebUI.selectOptionByIndex(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/SelectCountry'), 2)

    WebUI.selectOptionByIndex(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/SelectRegion'), 2)

    WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/ZIpCheckout'))

    WebUI.setText(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/ZIpCheckout'), Zip)
} else {
    WebUI.selectOptionByIndex(findTestObject('Object Repository/CartCheckoutPage/Page_Electronics - Checkout/SelectAddress'), 
        1)
}

WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/ShippingMethodCheckout'))

WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/CheckShippingmethodAir'))

WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/PaymentBtnCheckout'))

WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/TestPaymentMethod'))

WebUI.waitForPageLoad(2)

not_run: WebUI.scrollToElement(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/CreateORderCheckout'), 0)

WebUI.waitForElementClickable(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/CreateORderCheckout'), 10)

//WebUI.waitForElementNotVisible(findTestObject('Object Repository/CartCheckoutPage/Page_Electronics - Checkout/CreateOrderSpinner'), 30)

//WebUI.mouseOver(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/CreateORderCheckout'))

WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/CreateORderCheckout'))

//WebUI.waitForElementNotVisible(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/CreateORderCheckout'), 30)

WebUI.verifyElementPresent(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/GetInvoiceButton'), 30)

WebUI.verifyElementPresent(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/BillingAddressThankyoupage'), 30)

WebUI.closeBrowser()
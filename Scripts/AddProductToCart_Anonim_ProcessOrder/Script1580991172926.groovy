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

WebUI.openBrowser('https://qa-demovc-store.azurewebsites.net/')

WebUI.mouseOver(findTestObject('Page_Electronics/Camcorders'))

WebUI.click(findTestObject('Page_Electronics/AeriaImagingDrones'))

WebUI.verifyElementText(findTestObject('AerialImagingCategory/H1CategoryPage'), 'AERIAL IMAGING & DRONES')

WebUI.click(findTestObject('AerialImagingCategory/IconCartOnProductsCard'))

WebUI.verifyElementText(findTestObject('PopupAddToCart/Page_Aerial Imaging  Drones - Electronics/H1PopupProductAddedTocart'), 
    'PRODUCT IS ADDED TO CART')

WebUI.click(findTestObject('PopupAddToCart/Page_Aerial Imaging  Drones - Electronics/ButtonGoToCart'))

WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics/ButtonCheckoutOnCart'))

WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/InputEmailCheckout'))

WebUI.setText(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/InputEmailCheckout'), 'test@test.ru')

WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/FirstNameCheckout'))

WebUI.setText(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/FirstNameCheckout'), 'TestFirstName')

WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/LastNameCheckout'))

WebUI.setText(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/LastNameCheckout'), 'TestLastName')

WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/CompanyCheckout'))

WebUI.setText(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/CompanyCheckout'), 'Company')

WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/AddressCheckout'))

WebUI.setText(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/AddressCheckout'), 'TestAddress')

WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/AptCheckout'))

WebUI.setText(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/AptCheckout'), '3321')

WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/CityCheckout'))

WebUI.setText(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/CityCheckout'), 'TestCity')

WebUI.selectOptionByIndex(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/SelectCountry'), 2)

WebUI.selectOptionByIndex(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/SelectRegion'), 2)

WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/ZIpCheckout'))

WebUI.setText(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/ZIpCheckout'), '99999')

WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/ShippingMethodCheckout'))

WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/CheckShippingmetgod'))

WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/PaymentBtnCheckout'))

WebUI.click(findTestObject('CartCheckoutPage/Page_Electronics - Checkout/CreateORderCheckout'))

WebUI.takeScreenshot()


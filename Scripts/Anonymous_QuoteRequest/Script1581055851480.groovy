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

WebUI.openBrowser(GlobalVariable.StoreURL)

WebUI.click(findTestObject('ProductPage/AddtoQouteProductPage'))

WebUI.click(findTestObject('PopupAddToQuoteRequest/ButtonGoToQuote'))

WebUI.navigateToUrl('https://qa-demovc-store.azurewebsites.net/en-US/headphones/beats-by-dre-powerbeats-2-in-ear-bluetooth-wi')

WebUI.click(findTestObject('ProductPage/AddtoQouteProductPage'))

WebUI.click(findTestObject('PopupAddToQuoteRequest/ButtonGoToQuote'))

WebUI.click(findTestObject('QuoteRequestPage/EmailQuoteRequestPage'))

WebUI.setText(findTestObject('QuoteRequestPage/EmailQuoteRequestPage'), 'atz@virtoway.com')

WebUI.click(findTestObject('QuoteRequestPage/FirstNameBillingQuote'))

WebUI.setText(findTestObject('QuoteRequestPage/FirstNameBillingQuote'), 'Alex')

WebUI.click(findTestObject('QuoteRequestPage/LastNameBillingQuote'))

WebUI.setText(findTestObject('QuoteRequestPage/LastNameBillingQuote'), 'Test')

WebUI.click(findTestObject('QuoteRequestPage/AddressBillingQuote'))

WebUI.setText(findTestObject('QuoteRequestPage/AddressBillingQuote'), 'AddressTest1')

WebUI.click(findTestObject('QuoteRequestPage/input_Company_BillingAddressOrganization'))

WebUI.setText(findTestObject('QuoteRequestPage/input_Company_BillingAddressOrganization'), 'Companytest')

WebUI.click(findTestObject('QuoteRequestPage/ZipQuote'))

WebUI.setText(findTestObject('QuoteRequestPage/ZipQuote'), '2888')

WebUI.click(findTestObject('QuoteRequestPage/PhoneBillingQuote'))

WebUI.setText(findTestObject('QuoteRequestPage/PhoneBillingQuote'), '555555')

WebUI.click(findTestObject('QuoteRequestPage/CityBillingQuote'))

WebUI.setText(findTestObject('QuoteRequestPage/CityBillingQuote'), 'TestCity')

WebUI.selectOptionByIndex(findTestObject('QuoteRequestPage/SelectCountryBillingQuote'), 2)

WebUI.selectOptionByIndex(findTestObject('QuoteRequestPage/SelectStateBillingQuote'), 2)

WebUI.check(findTestObject('QuoteRequestPage/CheckBillingEqualShipping'))

WebUI.click(findTestObject('QuoteRequestPage/SubmitQuoteRequest'))

WebUI.closeBrowser()


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


WebUI.callTestCase(findTestCase('Another Cases/Login'), [('login') : GlobalVariable.UserLogPass, ('password') : GlobalVariable.UserLogPass], 
    FailureHandling.OPTIONAL)

WebUI.navigateToUrl(GlobalVariable.urlFront + '/en-US/headphones/beats-by-dre-powerbeats-2-in-ear-bluetooth-wi')

WebUI.click(findTestObject('UI-Electronics/ProductPage/AddtoQouteProductPage'))

WebUI.click(findTestObject('UI-Electronics/PopupAddToQuoteRequest/ButtonGoToQuote'))

WebUI.navigateToUrl(GlobalVariable.urlFront + '/en-US/headphones/beats-by-dre-powerbeats-2-in-ear-bluetooth-wi')

WebUI.click(findTestObject('UI-Electronics/ProductPage/AddtoQouteProductPage'))

WebUI.click(findTestObject('UI-Electronics/PopupAddToQuoteRequest/ButtonGoToQuote'))

WebUI.click(findTestObject('UI-Electronics/QuoteRequestPage/EmailQuoteRequestPage'))

WebUI.setText(findTestObject('UI-Electronics/QuoteRequestPage/EmailQuoteRequestPage'), Email)

WebUI.click(findTestObject('UI-Electronics/QuoteRequestPage/FirstNameBillingQuote'))

WebUI.setText(findTestObject('UI-Electronics/QuoteRequestPage/FirstNameBillingQuote'), FirstName)

WebUI.click(findTestObject('UI-Electronics/QuoteRequestPage/LastNameBillingQuote'))

WebUI.setText(findTestObject('UI-Electronics/QuoteRequestPage/LastNameBillingQuote'), LastName)

WebUI.click(findTestObject('UI-Electronics/QuoteRequestPage/AddressBillingQuote'))

WebUI.setText(findTestObject('UI-Electronics/QuoteRequestPage/AddressBillingQuote'), Address)

WebUI.click(findTestObject('UI-Electronics/QuoteRequestPage/input_Company_BillingAddressOrganization'))

WebUI.setText(findTestObject('UI-Electronics/QuoteRequestPage/input_Company_BillingAddressOrganization'), Company)

WebUI.click(findTestObject('UI-Electronics/QuoteRequestPage/ZipQuote'))

WebUI.setText(findTestObject('UI-Electronics/QuoteRequestPage/ZipQuote'), Zip)


WebUI.click(findTestObject('UI-Electronics/QuoteRequestPage/CityBillingQuote'))

WebUI.setText(findTestObject('UI-Electronics/QuoteRequestPage/CityBillingQuote'), City)

WebUI.selectOptionByIndex(findTestObject('UI-Electronics/QuoteRequestPage/SelectCountryBillingQuote'), 2)

WebUI.selectOptionByIndex(findTestObject('UI-Electronics/QuoteRequestPage/SelectStateBillingQuote'), 2)

WebUI.check(findTestObject('UI-Electronics/QuoteRequestPage/CheckBillingEqualShipping'))

WebUI.click(findTestObject('UI-Electronics/QuoteRequestPage/SubmitQuoteRequest'))

WebUI.closeBrowser()


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

WebUI.click(findTestObject('UI-Electronics/QuoteRequestPage/EmailQuoteRequestPage'))

WebUI.setText(findTestObject('UI-Electronics/QuoteRequestPage/EmailQuoteRequestPage'), GlobalVariable.email)

WebUI.click(findTestObject('UI-Electronics/QuoteRequestPage/FirstNameBillingQuote'))

WebUI.setText(findTestObject('UI-Electronics/QuoteRequestPage/FirstNameBillingQuote'), GlobalVariable.firstName)

WebUI.click(findTestObject('UI-Electronics/QuoteRequestPage/LastNameBillingQuote'))

WebUI.setText(findTestObject('UI-Electronics/QuoteRequestPage/LastNameBillingQuote'), GlobalVariable.lastName)

WebUI.click(findTestObject('UI-Electronics/QuoteRequestPage/AddressBillingQuote'))

WebUI.setText(findTestObject('UI-Electronics/QuoteRequestPage/AddressBillingQuote'), GlobalVariable.address)

WebUI.click(findTestObject('UI-Electronics/QuoteRequestPage/input_Company_BillingAddressOrganization'))

WebUI.setText(findTestObject('UI-Electronics/QuoteRequestPage/input_Company_BillingAddressOrganization'), GlobalVariable.company)

WebUI.click(findTestObject('UI-Electronics/QuoteRequestPage/ZipQuote'))

WebUI.setText(findTestObject('UI-Electronics/QuoteRequestPage/ZipQuote'), GlobalVariable.zip)

WebUI.click(findTestObject('UI-Electronics/QuoteRequestPage/CityBillingQuote'))

WebUI.setText(findTestObject('UI-Electronics/QuoteRequestPage/CityBillingQuote'), GlobalVariable.city)

WebUI.selectOptionByIndex(findTestObject('UI-Electronics/QuoteRequestPage/SelectCountryBillingQuote'), 2)

WebUI.selectOptionByIndex(findTestObject('UI-Electronics/QuoteRequestPage/SelectStateBillingQuote'), 2)

WebUI.check(findTestObject('UI-Electronics/QuoteRequestPage/CheckBillingEqualShipping'))

WebUI.click(findTestObject('UI-Electronics/QuoteRequestPage/SubmitQuoteRequest'))




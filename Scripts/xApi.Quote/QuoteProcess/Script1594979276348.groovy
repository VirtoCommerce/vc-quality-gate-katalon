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

WebUI.click(findTestObject('UI/QuoteRequestPage/EmailQuoteRequestPage'))

WebUI.setText(findTestObject('UI/QuoteRequestPage/EmailQuoteRequestPage'), GlobalVariable.email)

WebUI.click(findTestObject('UI/QuoteRequestPage/FirstNameBillingQuote'))

WebUI.setText(findTestObject('UI/QuoteRequestPage/FirstNameBillingQuote'), GlobalVariable.firstName)

WebUI.click(findTestObject('UI/QuoteRequestPage/LastNameBillingQuote'))

WebUI.setText(findTestObject('UI/QuoteRequestPage/LastNameBillingQuote'), GlobalVariable.lastName)

WebUI.click(findTestObject('UI/QuoteRequestPage/AddressBillingQuote'))

WebUI.setText(findTestObject('UI/QuoteRequestPage/AddressBillingQuote'), GlobalVariable.address)

WebUI.click(findTestObject('UI/QuoteRequestPage/input_Company_BillingAddressOrganization'))

WebUI.setText(findTestObject('UI/QuoteRequestPage/input_Company_BillingAddressOrganization'), GlobalVariable.company)

WebUI.click(findTestObject('UI/QuoteRequestPage/ZipQuote'))

WebUI.setText(findTestObject('UI/QuoteRequestPage/ZipQuote'), GlobalVariable.zip)

WebUI.click(findTestObject('UI/QuoteRequestPage/CityBillingQuote'))

WebUI.setText(findTestObject('UI/QuoteRequestPage/CityBillingQuote'), GlobalVariable.city)

WebUI.selectOptionByIndex(findTestObject('UI/QuoteRequestPage/SelectCountryBillingQuote'), 2)

WebUI.selectOptionByIndex(findTestObject('UI/QuoteRequestPage/SelectStateBillingQuote'), 2)

WebUI.check(findTestObject('UI/QuoteRequestPage/CheckBillingEqualShipping'))

WebUI.click(findTestObject('UI/QuoteRequestPage/SubmitQuoteRequest'))




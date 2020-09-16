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

WebUI.click(findTestObject('QuoteRequestPage/EmailQuoteRequestPage'))

WebUI.setText(findTestObject('QuoteRequestPage/EmailQuoteRequestPage'), GlobalVariable.email)

WebUI.click(findTestObject('QuoteRequestPage/FirstNameBillingQuote'))

WebUI.setText(findTestObject('QuoteRequestPage/FirstNameBillingQuote'), GlobalVariable.firstName)

WebUI.click(findTestObject('QuoteRequestPage/LastNameBillingQuote'))

WebUI.setText(findTestObject('QuoteRequestPage/LastNameBillingQuote'), GlobalVariable.lastName)

WebUI.click(findTestObject('QuoteRequestPage/AddressBillingQuote'))

WebUI.setText(findTestObject('QuoteRequestPage/AddressBillingQuote'), GlobalVariable.address)

WebUI.click(findTestObject('QuoteRequestPage/input_Company_BillingAddressOrganization'))

WebUI.setText(findTestObject('QuoteRequestPage/input_Company_BillingAddressOrganization'), GlobalVariable.company)

WebUI.click(findTestObject('QuoteRequestPage/ZipQuote'))

WebUI.setText(findTestObject('QuoteRequestPage/ZipQuote'), GlobalVariable.zip)

WebUI.click(findTestObject('QuoteRequestPage/CityBillingQuote'))

WebUI.setText(findTestObject('QuoteRequestPage/CityBillingQuote'), GlobalVariable.city)

WebUI.selectOptionByIndex(findTestObject('QuoteRequestPage/SelectCountryBillingQuote'), 2)

WebUI.selectOptionByIndex(findTestObject('QuoteRequestPage/SelectStateBillingQuote'), 2)

WebUI.check(findTestObject('QuoteRequestPage/CheckBillingEqualShipping'))

WebUI.click(findTestObject('QuoteRequestPage/SubmitQuoteRequest'))




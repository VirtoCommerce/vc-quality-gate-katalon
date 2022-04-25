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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//verify Shipping Details block
WebUI.verifyElementPresent(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/div_ShippingDetailsBlock'), 
    3)

WebUI.verifyElementText(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/h3_ShippingDetailsTitle'), 
    'SHIPPING DETAILS')

//add Shipping address
WebUI.mouseOver(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/div_ShippingAddress'))

WebUI.click(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/btn_ShippingAddress'))

//WebUI.verifyElementPresent(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/DRAFT/1div_ShippingAddressPopUp'),3)
//WebUI.click(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/btn_AddNewShippingAddress'))
//enter contact information information
WebUI.click(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/FillInShippingAddress/input_FirstName'))

WebUI.setText(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/FillInShippingAddress/input_FirstName'), 
    GlobalVariable.contactFirstName)

WebUI.click(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/FillInShippingAddress/input_LastName'))

WebUI.setText(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/FillInShippingAddress/input_LastName'), 
    GlobalVariable.contactLastName)

WebUI.setText(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/FillInShippingAddress/input_Email'), 
    GlobalVariable.contactEmail)

WebUI.click(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/FillInShippingAddress/input_Phone'))

WebUI.click(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/FillInShippingAddress/input_Email'))

WebUI.setText(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/FillInShippingAddress/input_Phone'), 
    GlobalVariable.contactPhone)

//enter address
WebUI.click(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/FillInShippingAddress/select_Country'))

WebUI.click(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/FillInShippingAddress/select_CountryCanada'))

WebUI.click(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/FillInShippingAddress/select_Province'))

WebUI.click(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/FillInShippingAddress/select_ProvinceAlberta'))

WebUI.click(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/FillInShippingAddress/input_PostalCode'))

WebUI.setText(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/FillInShippingAddress/input_PostalCode'), 
    GlobalVariable.organizationPostalCode)

WebUI.click(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/FillInShippingAddress/input_City'))

WebUI.setText(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/FillInShippingAddress/input_City'), 
    GlobalVariable.organizationCity)

WebUI.click(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/FillInShippingAddress/input_Road'))

WebUI.setText(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/FillInShippingAddress/input_Road'), 
    GlobalVariable.organizationStreet)

WebUI.click(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingAddress/btn_ShippingAddressConfirm'))

//add Shipping method  
 
WebUI.mouseOver(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingMethod/div_ShippingMethod'))

WebUI.click(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingMethod/btn_ShippingMethod'))

WebUI.click(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingMethod/btn_ShippingMethodSelect'))

WebUI.click(findTestObject('UI-Mercury/Checkout/CheckoutPage/ShippingDetails/ShippingMethod/btn_ShippingMethodConfirm'))


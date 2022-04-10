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

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1div_ShippingDetailsBlock'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1div_ShippingDetailsBlock'), 3)

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1h3_ShippingDetailsTitle'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1h3_ShippingDetailsTitle'), 3)

//WebUI.verifyTextPresent('Shipping details', false)

//add Shipping address

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1div_ShippingAddress'))

WebUI.click(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1btn_ShippingAddress'))

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1div_ShippingAddressPopUp'))

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1div_ShippingAddressLine'))

WebUI.click(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1btn_ShippingAddressSelect'))

WebUI.click(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1btn_ShippingAddressConfirm'))


//add Shipping method 

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1div_ShippingMethod'))

WebUI.click(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1btn_ShippingMethod'))

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1div_ShippingMethodPopUp'))

//WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1div_ShippingMethodLine'))

WebUI.click(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1btn_ShippingMethodSelect'))

WebUI.click(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1btn_ShippingMethodConfirm'))



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

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1div_ShippingDetailsBlock'),3)

WebUI.verifyElementText(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1h3_ShippingDetailsTitle'),'SHIPPING DETAILS')


//WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1div_ShippingDetailsBlock'))

//WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1div_ShippingDetailsBlock'), 3)

//WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1h3_ShippingDetailsTitle'))

//WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/1h3_ShippingDetailsTitle'), 3)

//WebUI.verifyTextPresent('Shipping details', false)

//add Shipping address

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/ShippingAddress/1div_ShippingAddress'))

WebUI.click(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/ShippingAddress/1btn_SelectShippingAddress'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/ShippingAddress/1div_ShippingAddressPopUp'),3)


WebUI.click(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/ShippingAddress/1btn_AddNewShippingAddress'))



//enter contact information information

WebUI.click(findTestObject('UI-Mercury/Registration/input_FirstName'))

WebUI.setText(findTestObject('UI-Mercury/Registration/input_FirstName'), GlobalVariable.contactFirstName)

WebUI.click(findTestObject('UI-Mercury/Registration/input_LastName'))

WebUI.setText(findTestObject('UI-Mercury/Registration/input_LastName'), GlobalVariable.contactLastName)

WebUI.click(findTestObject('UI-Mercury/Registration/input_Email'))

WebUI.setText(findTestObject('UI-Mercury/Registration/input_Email'), GlobalVariable.contactEmail)

WebUI.click(findTestObject('UI-Mercury/Registration/input_Phone'))

WebUI.setText(findTestObject('UI-Mercury/Registration/input_Phone'), GlobalVariable.contactPhone)

//enter address

WebUI.click(findTestObject('UI-Mercury/Registration/select_Country'))

//WebUI.scrollToElement(findTestObject('UI-Mercury/Registration/select_CountryCanada'), 3)

//WebUI.scrollToPosition(40, 40)

WebUI.click(findTestObject('UI-Mercury/Registration/select_CountryCanada'))

//WebUI.selectOptionByIndex(findTestObject('UI-Mercury/Registration/select_CountryCanada'), 40)

//WebUI.selectOptionByValue(findTestObject('UI-Mercury/Registration/select_CountryCanada'), 40, false)

//WebUI.selectOptionByLabel(findTestObject('UI-Mercury/Registration/select_CountryCanada'), 40, false)

//WebUI.click(findTestObject('UI-Mercury/Registration/select_CountryCanada'))

WebUI.click(findTestObject('UI-Mercury/Registration/select_Province'))

WebUI.click(findTestObject('UI-Mercury/Registration/select_ProvinceAlberta'))

WebUI.click(findTestObject('UI-Mercury/Registration/input_PostalCode'))

WebUI.setText(findTestObject('UI-Mercury/Registration/input_PostalCode'), GlobalVariable.organizationPostalCode)

WebUI.click(findTestObject('UI-Mercury/Registration/input_City'))

WebUI.setText(findTestObject('UI-Mercury/Registration/input_City'), GlobalVariable.organizationCity)

WebUI.click(findTestObject('UI-Mercury/Registration/input_Road'))

WebUI.setText(findTestObject('UI-Mercury/Registration/input_Road'), GlobalVariable.organizationStreet)




//WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/ShippingAddress/div_ShippingAddressLine'))

//WebUI.click(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/ShippingAddress/btn_ShippingAddressSelect'))

WebUI.click(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/ShippingAddress/1btn_ShippingAddressConfirm'))
           

//add Shipping method   

//WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/ShippingMethod/1div_ShippingMethod'))
  
//WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/ShippingMethod/1div_ShippingMethod'),3)

WebUI.click(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/ShippingMethod/1btn_ShippingMethod'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/ShippingMethod/1div_ShippingMethodPopUp'),3)

//WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/ShippingMethod/1div_ShippingMethodLine'))

WebUI.click(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/ShippingMethod/1btn_ShippingMethodSelect'))

WebUI.click(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/ShippingDetails/ShippingMethod/1btn_ShippingMethodConfirm'))



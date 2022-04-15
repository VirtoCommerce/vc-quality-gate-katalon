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

//verify my products block

//WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/Products/1div_ProductsBlock'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/Products/1div_ProductsBlock'),3)

WebUI.verifyElementText (findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/Products/1h3_TitleProducts'),'MY PRODUCTS')

//WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/Products/1h3_TitleProducts'))

//WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/Products/1h3_TitleProducts'), 3)

//on product page - get price - variables - on checkout page check price/

//WebUI.verifyTextPresent('My products', false)

//update product amount

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/Products/1div_Product'),3)

WebUI.verifyElementText (findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/Products/txt_PriceOnCheckout'), GlobalVariable.priceFromPopup)

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/Products/1input_UpdateProductCount'))

WebUI.click(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/Products/1input_UpdateProductCount'))

WebUI.setText(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/Products/1input_UpdateProductCount'), GlobalVariable.productAmount)

WebUI.click(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/Products/1button_UnpdateProductCount'))

//verify update product amount

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/Products/1input_UpdateProductCount'))

GlobalVariable.updateQuantity = WebUI.verifyTextPresent('5', false)

println ("QUANTITY IS : " + GlobalVariable.updateQuantity)

WebUI.delay(10)



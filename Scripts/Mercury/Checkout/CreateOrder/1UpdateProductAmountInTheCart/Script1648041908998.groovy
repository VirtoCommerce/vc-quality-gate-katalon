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

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/1div_ProductsBlock'))

WebUI.verifyElementVisible(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/1div_ProductsBlock'))

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/1h3_TitleProducts'))

WebUI.verifyTextPresent('My products', false)

//update product amount

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/1div_ProductsBlock'))

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/1input_UpdateProductCount'))

WebUI.click(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/1input_UpdateProductCount'))

WebUI.setText(findTestObject('UI-Mercury/CheckOut/CreateOrder/AddProduct/1input_QuantityForProductWithVariables'), '5')

WebUI.click(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/1button_UnpdateProductCount'))
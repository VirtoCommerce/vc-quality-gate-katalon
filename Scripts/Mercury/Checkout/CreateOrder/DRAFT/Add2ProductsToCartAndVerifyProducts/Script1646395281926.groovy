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

//add product 1 with variables
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_AllProductsCatalog'))

WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_CarriageBolts'))

WebUI.mouseOver(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/AddProduct/div_ProductBlock'))

WebUI.click(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/AddProduct/a_OpenProduct'))

WebUI.mouseOver(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/AddProduct/div_CustomizeOrderBlock'))

WebUI.setText(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/AddProduct/input_QuantityForProductWithVariables'), '1')

def productName1 = WebUI.getText(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/AddProduct/h1_ProductTitle1'))

WebUI.click(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/AddProduct/button_AddToCart'))

WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/AddProduct/div_PopUpProductAdded'))

WebUI.click(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/AddProduct/button_PopUpButtonContinueShopping'))

//add product 2 without variation
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_AllProductsCatalog'))

WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_InkjetPrinters'))

WebUI.mouseOver(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/AddProduct/div_ProductBlock'))

WebUI.click(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/AddProduct/a_OpenProduct'))

WebUI.mouseOver(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/AddProduct/h1_ProductTitle2'))

def productName2 = WebUI.getText(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/AddProduct/h1_ProductTitle2'))

WebUI.click(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/AddProduct/button_AddFromProductPage'))

WebUI.mouseOver(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/AddProduct/div_PopUpProductAdded'))

WebUI.click(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/AddProduct/button_PopUpButtonViewCart'))

//verify cart Page 1
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/MainElementsForCheckOut/div_MyCartPage1Opens'))

productName1 == WebUI.getText(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/MainElementsForCheckOut/div_MyCartPage1Opens'))

productName2 == WebUI.getText(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/MainElementsForCheckOut/div_MyCartPage1Opens'))


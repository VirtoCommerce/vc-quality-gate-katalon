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

WebUI.openBrowser(GlobalVariable.urlFront)

WebUI.maximizeWindow()

WebUI.mouseOver(findTestObject('UI-B2B store/Catalog/CategoryPages/a_AllProductsCatalog'))

WebUI.click(findTestObject('UI-B2B store/Catalog/CategoryPages/a_CarriageBolts'))

WebUI.mouseOver(findTestObject('UI-B2B store/CheckOut/CreateOrder/AddProduct/div_ProductBlock'))

WebUI.click(findTestObject('UI-B2B store/CheckOut/CreateOrder/AddProduct/a_OpenProduct'))

WebUI.mouseOver(findTestObject('UI-B2B store/CheckOut/CreateOrder/AddProduct/div_CustomizeOrderBlock'))

WebUI.setText(findTestObject('UI-B2B store/CheckOut/CreateOrder/AddProduct/input_QuantityForProductWithVariables'), '1')

WebUI.click(findTestObject('UI-B2B store/CheckOut/CreateOrder/AddProduct/button_AddToCart'))

WebUI.mouseOver(findTestObject('UI-B2B store/CheckOut/CreateOrder/AddProduct/div_PopUpProductAdded'))

def AddCartProductPage = WebUI.getText(findTestObject('UI-B2B store/CheckOut/CreateOrder/AddProduct/h4_PopupTitle'))

WebUI.verifyMatch(AddCartProductPage, "1 ITEM WAS ADDED TO CART", false)



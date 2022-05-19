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

WebUI.click(findTestObject('UI-Mercury/Catalog/CategoryPages/a_AllProductsCatalog'))

WebUI.click(findTestObject('UI-Mercury/Catalog/CategoryPages/a_CarriageBolts'))

WebUI.mouseOver(findTestObject('UI-Mercury/Catalog/ProductBlockViewOnCategory/div_ProductBlock'))

WebUI.click(findTestObject('UI-Mercury/Catalog/ProductBlockViewOnCategory/a_ProductTitle'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/Checkout/AddProduct/div_AllVariationsBlock'),3)

WebUI.mouseOver(findTestObject('UI-Mercury/Checkout/AddProduct/div_OneVariationBlock'))

WebUI.click(findTestObject('UI-Mercury/Checkout/AddProduct/btn_AddToCart'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/Checkout/AddProduct/div_PopUpProductAdded'), 3)

def AddCartProductPage = WebUI.getText(findTestObject('UI-Mercury/Checkout/AddProduct/txt_PopupTitle'))

WebUI.verifyMatch(AddCartProductPage, "1 Product added to cart", false)

GlobalVariable.priceFromPopup = WebUI.getText(findTestObject('UI-Mercury/Checkout/AddProduct/txt_PriceOnPopup'))

println ("PRICE FROM POPUP IS : " + GlobalVariable.priceFromPopup)





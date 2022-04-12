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

WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_AllProductsCatalog'))

WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_InkjetPrinters'))

WebUI.mouseOver(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/AddProduct/div_ProductBlock'))

WebUI.click(findTestObject('1 UI-B2B ST/CheckOut/CreateOrder/AddProduct/a_OpenProduct'))

WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Catalog/ProductPage/ProductLinks/AddToTheList/span_ChooseWishList'), 3)

WebUI.click(findTestObject('1 UI-B2B ST/Catalog/ProductPage/ProductLinks/AddToTheList/span_ChooseWishList'))

WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Catalog/ProductPage/ProductLinks/AddToTheList/div_PopUpAddToList'))

WebUI.click(findTestObject('1 UI-B2B ST/Catalog/ProductPage/ProductLinks/AddToTheList/label_AddToWishList'))

WebUI.click(findTestObject('1 UI-B2B ST/Catalog/ProductPage/ProductLinks/AddToTheList/button_AddToList'))

WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Catalog/ProductPage/ProductLinks/AddToTheList/div_PopUpItemAddedToList'))

WebUI.click(findTestObject('1 UI-B2B ST/Catalog/ProductPage/ProductLinks/AddToTheList/button_ViewListPage'))

WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Catalog/ProductPage/ProductLinks/AddToTheList/div_CheckYourListPage'))

WebUI.click(findTestObject('1 UI-B2B ST/Catalog/ProductPage/ProductLinks/AddToTheList/button_RemoveItemFromWishList'))

WebUI.verifyElementNotPresent(findTestObject('1 UI-B2B ST/Catalog/ProductPage/ProductLinks/AddToTheList/div_CheckYourListPage'), 4)
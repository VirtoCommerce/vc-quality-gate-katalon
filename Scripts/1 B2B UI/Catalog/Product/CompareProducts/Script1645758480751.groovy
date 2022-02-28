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

WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_CarriageBolts'))

WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Product/Compare product/div_ComparedProduct1'))

WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Product/Product view/div_CompareCheckBox'))

WebUI.waitForPageLoad(5)

WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Add product/div_ProductBlock'))

WebUI.scrollToElement(findTestObject('1 UI-B2B ST/Catalog/Add product/div_ProductBlock'),3)

WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Product/Compare product/div_ComparedProduct2'))

WebUI.waitForPageLoad(5)

WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Catalog/Product/Compare product/ul_Item 553390824'))

WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Catalog/Product/Compare product/div_Object1'))

WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Catalog/Product/Compare product/div_Object2'))

WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Product/Compare product/button_CleanComparedProducts'))

WebUI.verifyElementNotPresent(findTestObject('1 UI-B2B ST/Catalog/Product/Compare product/ul_Item 553390824'),3)
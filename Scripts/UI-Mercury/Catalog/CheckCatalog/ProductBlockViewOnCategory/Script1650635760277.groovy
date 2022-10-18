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

WebUI.click(findTestObject('UI-Mercury/Catalog/CategoryPages/a_InkjetPrinters'))

WebUI.mouseOver(findTestObject('UI-Mercury/Catalog/ProductBlockViewOnCategory/div_ProductBlock'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/Catalog/ProductBlockViewOnCategory/img_ImageProduct'), 4)

WebUI.verifyElementPresent(findTestObject('UI-Mercury/Catalog/ProductBlockViewOnCategory/div_CompareCheckBox'), 4)

WebUI.verifyElementPresent(findTestObject('UI-Mercury/Catalog/ProductBlockViewOnCategory/a_ProductTitle'), 4)

WebUI.verifyElementText(findTestObject('UI-Mercury/Catalog/ProductBlockViewOnCategory/text_TitleProductItem'), 'Item #')

//WebUI.verifyElementText(findTestObject('UI-Mercury/Catalog/ProductBlockViewOnCategory/text_ProductSKU'), 4)

WebUI.verifyElementText(findTestObject('UI-Mercury/Catalog/ProductBlockViewOnCategory/text_TitleProductModel'), 'Mfr. model #')

WebUI.verifyElementText(findTestObject('UI-Mercury/Catalog/ProductBlockViewOnCategory/text_TitleYourPrice'), 'Your price')

//WebUI.verifyElementText(findTestObject('UI-Mercury/Catalog/ProductBlockViewOnCategory/text_ProductPrice'), 3)

WebUI.verifyElementPresent(findTestObject('UI-Mercury/Catalog/ProductBlockViewOnCategory/input_ProductAmountField'), 4)

WebUI.verifyElementPresent(findTestObject('UI-Mercury/Checkout/AddProduct/btn_AddFromCatalog'),4)
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

//filter 1
WebUI.mouseOver(findTestObject('UI-B2B store/Catalog/CategoryPages/a_AllProductsCatalog'))

WebUI.click(findTestObject('UI-B2B store/Catalog/CategoryPages/a_CarriageBolts'))

WebUI.mouseOver(findTestObject('UI-B2B store/Catalog/Filters/filter1/div_FilterPriceBlock'))

WebUI.click(findTestObject('UI-B2B store/Catalog/Filters/filter1/a_FilterPrice10-20'))
WebUI.waitForPageLoad(5)

WebUI.mouseOver(findTestObject('UI-B2B store/Catalog/Filters/div_Applied filtersBlock'))

WebUI.verifyElementText(findTestObject('UI-B2B store/Catalog/Filters/filter1/li_10-20'), '10-20')

WebUI.mouseOver(findTestObject('UI-B2B store/Catalog/Filters/filter1/div_FilterPriceBlock'))

WebUI.click(findTestObject('UI-B2B store/Catalog/Filters/filter1/a_FilterPrice10-20'))
WebUI.waitForPageLoad(5)

//filter 2
WebUI.mouseOver(findTestObject('UI-B2B store/Catalog/Filters/Filter2/div_FilterMaterialBlock'))

WebUI.click(findTestObject('UI-B2B store/Catalog/Filters/Filter2/a_FilterMaterial5'))
WebUI.waitForPageLoad(5)

WebUI.mouseOver(findTestObject('UI-B2B store/Catalog/Filters/div_Applied filtersBlock'))

WebUI.verifyElementText(findTestObject('UI-B2B store/Catalog/Filters/Filter2/li_5'), '5')

WebUI.mouseOver(findTestObject('UI-B2B store/Catalog/Filters/Filter2/div_FilterMaterialBlock'))

WebUI.click(findTestObject('UI-B2B store/Catalog/Filters/Filter2/a_FilterMaterial5'))
WebUI.waitForPageLoad(5)
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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.click(findTestObject('UI-Mercury/Catalog/1CategoryPages/a_AllProductsCatalog'))

WebUI.click(findTestObject('UI-Mercury/Catalog/1CategoryPages/a_CarriageBolts'))
      
//???WebUI.mouseOver(findTestObject('UI-Mercury/Catalog/1CategoryPages/h2_CarriageBolts'))

WebUI.verifyTextPresent('Carriage Bolts', false)

WebUI.click(findTestObject('UI-Mercury/Catalog/1CategoryPages/a_AllProductsCatalog'))

WebUI.click(findTestObject('UI-Mercury/Catalog/1CategoryPages/a_FlangeBolts'))
      
WebUI.mouseOver(findTestObject('UI-Mercury/Catalog/1CategoryPages/h2_FlangeBolts'))
 
WebUI.verifyTextPresent('Flange Bolts', false)

WebUI.click(findTestObject('UI-Mercury/Catalog/1CategoryPages/a_AllProductsCatalog'))

WebUI.click(findTestObject('UI-Mercury/Catalog/1CategoryPages/a_InkjetPrinters'))

WebUI.mouseOver(findTestObject('UI-Mercury/Catalog/1CategoryPages/h2_InkjetPrinters'))

WebUI.verifyTextPresent('Inkjet Printers', false)

WebUI.click(findTestObject('UI-Mercury/Catalog/1CategoryPages/a_AllProductsCatalog'))

WebUI.click(findTestObject('UI-Mercury/Catalog/1CategoryPages/a_LaserPrinters'))

WebUI.mouseOver(findTestObject('UI-Mercury/Catalog/1CategoryPages/h2_LaserPrinters'))

WebUI.verifyTextPresent('Laser Printers', false)




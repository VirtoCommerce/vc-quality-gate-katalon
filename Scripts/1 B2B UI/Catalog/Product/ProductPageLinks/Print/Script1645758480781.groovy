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

//import java.awt.Robot;
//import java.awt.event.KeyEvent;



//3 - print
//doesnt work!!!
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_AllProductsCatalog'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_InkjetPrinters'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Add product/div_ProductBlock'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Add product/a_OpenProduct'))
WebUI.verifyElementText(findTestObject('1 UI-B2B ST/Catalog/Product/Product links/a_Print'), 'Print')
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Product/Product links/a_Print'))
WebUI.closeWindowUrl('/html/body/print-preview-app')
//Robot robot = new Robot();
//robot.keyPress(KeyEvent.VK_ESCAPE)
//WebUI.sendKeys(findTestObject('txt_Comment'), Keys.chord(Keys.ESCAPE))
// CTRL+P is now pressed

//WebUI.switchToFrame(findTestObject('1 UI-B2B ST/Catalog/Product/Product links/a_PrintPopUp'),5)
//WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Catalog/Product/Product links/a_PrintPopUp'))
//WebUI.switchToWindowTitle('Virto Commerce Demo B2B Online Shopping for Epson Expression Premium XP-820 Wireless Color Photo Printer/Copier/Scanner/Fax Machine - B2B-store')
//WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Product/Product links/a_PrintPopUpButtonCancel'))
//WebUI.sendKeys('1 UI-B2B ST/Catalog/Product/Product links/a_PrintPopUp', Keys.chord(Keys.ESCAPE))

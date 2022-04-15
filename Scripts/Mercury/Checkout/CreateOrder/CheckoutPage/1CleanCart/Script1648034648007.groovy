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

//remove item from the card

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/CheckOutPage/Products/1div_ProductsBlock'))

WebUI.click(findTestObject('UI-Mercury/CheckOut/CreateOrder/1CleanCart/span_RemoveItemLink'))

//verify empty cart presented

//WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/1CleanCart/div_CleanCartBlock'))

WebUI.verifyElementVisible(findTestObject('UI-Mercury/CheckOut/CreateOrder/1CleanCart/div_CleanCartBlock'))

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/1CleanCart/text_EmptyCart'))

WebUI.verifyTextPresent('Your cart is empty', false)

WebUI.verifyElementClickable (findTestObject('UI-Mercury/CheckOut/CreateOrder/1CleanCart/button_ContinueShopping'))
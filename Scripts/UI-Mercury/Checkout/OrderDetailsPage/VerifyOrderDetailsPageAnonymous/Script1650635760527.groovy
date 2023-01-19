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

//verify title

WebUI.verifyElementText (findTestObject('UI-Mercury/Checkout/OrderDetailsPage/OrderDetails/h2_OrderCompleted'),'ORDER COMPLETED')

WebUI.verifyElementPresent(findTestObject('UI-Mercury/Checkout/OrderDetailsPage/OrderDetails/div_OrderNotification'), 3)


//verify purchased products

WebUI.verifyElementPresent(findTestObject('UI-Mercury/Checkout/OrderDetailsPage/OrderDetails/div_PurchasedProducts'),3)


//verify summary block

WebUI.verifyElementPresent(findTestObject('UI-Mercury/Checkout/OrderDetailsPage/OrderDetails/div_BlockOrderSummary'), 3)

WebUI.verifyElementPresent(findTestObject('UI-Mercury/Checkout/OrderDetailsPage/OrderDetails/div_BlockShippingAddress'), 3)


//verify shipping method block 

WebUI.verifyElementPresent(findTestObject('UI-Mercury/Checkout/OrderDetailsPage/OrderDetails/div_BlockShippingMethod'), 3)


//verify payment method block

WebUI.verifyElementPresent(findTestObject('UI-Mercury/Checkout/OrderDetailsPage/OrderDetails/div_BlockPaymentMethod'), 3)


//verify billing address block

WebUI.verifyElementPresent(findTestObject('UI-Mercury/Checkout/OrderDetailsPage/OrderDetails/div_BlockBillingAddress'), 3)


//verify print

WebUI.verifyElementClickable(findTestObject('UI-Mercury/Checkout/OrderDetailsPage/OrderDetails/a_PrintButton'))





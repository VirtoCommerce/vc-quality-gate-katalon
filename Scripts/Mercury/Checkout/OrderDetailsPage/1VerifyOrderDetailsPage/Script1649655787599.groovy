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

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_BlockOrderCompleted'))

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_OrderNotification'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_OrderNotification'), 3)

//verify purchased products

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_BlockPurchasedProducts'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_BlockPurchasedProducts'),3)

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/h5_MyPurchasedProducts'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/h5_MyPurchasedProducts'), 3)

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_PurchasedProducts'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_PurchasedProducts'),3)

//verify gift

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_BlockGift'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_BlockGift'), 3)

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/h5_Gift'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/h5_Gift'), 3)

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_Gift'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_Gift'), 3)


//verify summary block

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_BlockOrderSummary'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_BlockOrderSummary'), 3)

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/h5_OrderSummary'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/h5_OrderSummary'), 3)

//verify shipping address block

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_BlockShippingAddress'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_BlockShippingAddress'), 3)

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/h5_ShippingAddress'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/h5_ShippingAddress'), 3)

//verify shipping method block 

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_BlockShippingMethod'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_BlockShippingMethod'), 3)

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/h5_ShippingMethod'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/h5_ShippingMethod'), 3)

//verify payment method block

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_BlockPaymentMethod'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_BlockPaymentMethod'), 3)

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/h5_PaymentMethod'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/h5_PaymentMethod'), 3)

//verify billing address block

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_BlockBillingAddress'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/div_BlockBillingAddress'), 3)

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/h5_BillingAddress'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/h5_BillingAddress'), 3)

//verify print

WebUI.mouseOver(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/a_PrintButton'))

WebUI.verifyElementPresent(findTestObject('UI-Mercury/CheckOut/CreateOrder/OrderDetailsPage/1OrderDetails/a_PrintButton'), 3)




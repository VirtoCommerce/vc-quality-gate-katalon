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

//Send request with order data to create an order

orderId = '25333618-21cb-4518-919c-0c0e46d7a921'
int quantity = 1
order = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderCreate', [
	('orderId') : orderId,
	('quantity') : quantity
	]))
WS.verifyElementPropertyValue(order,'id', orderId)

//Update the created order

int updatedQuantity = (quantity + 1)
updateOrder = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderUpdate', [
	('orderId') : orderId,
	('quantity') : updatedQuantity
	]))

//Get the created order to verify changes

updatedOrder = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderGetById', [
	('orderId') : orderId
	]))
WS.verifyElementPropertyValue(updatedOrder,'items[0].quantity', updatedQuantity)

//Delete the created order
deleteOrder = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderDelete', [
	('orderId') : orderId
	]))

//Search for the deleted order to verify it's gone
deletedOrder = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderSearch', [
	('keyword') : orderId
	]))
WS.verifyElementPropertyValue(deletedOrder, 'totalCount', '0')

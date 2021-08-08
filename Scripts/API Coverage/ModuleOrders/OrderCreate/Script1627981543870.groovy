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

import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonOutput

//Send request with order data to create an order
orderId = '8383028c-4d80-46bc-887e-282d0707a070'
int quantity = 1
order = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderCreate', [
	('orderId') : orderId,
	('quantity') : quantity,
	('userName') : GlobalVariable.userName
	]))
WS.verifyElementPropertyValue(order,'id', orderId)
actualQuantity = WS.getElementPropertyValue(order,'items[0].quantity')
int updatedQuantity = actualQuantity + 1
println updatedQuantity

//Get the initial changes number to compare it to the final changes number later
searchChanges = WS.sendRequest(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderSearchChanges', [
	('orderId') : orderId
	]))
int initialCount = WS.getElementPropertyValue(searchChanges,'totalCount')

//Get the created order data
order = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderGetById', [
	('orderId') : orderId
	]))
WS.verifyElementPropertyValue(order,'id', orderId)

//Update the created order (change items quantity) and convert it to the acceptable format
orderMap = order.getResponseBodyContent()
orderParsed = new JsonSlurper().parseText(orderMap)
orderParsed.items[0].quantity = updatedQuantity
def orderJson = new groovy.json.JsonBuilder(orderParsed)
def orderString = orderJson.toString()

//Send the updated order
RequestObject request = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderUpdate')
// Create and set body content property
request.setBodyContent(new HttpTextBodyContent(orderString))
WS.sendRequestAndVerify(request)

//Get the updated order to verify it was changed
updatedOrder = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderGetById', [
	('orderId') : orderId
	]))
WS.verifyElementPropertyValue(updatedOrder,'items[0].quantity',updatedQuantity)

//Check total recalculation
price = WS.getElementPropertyValue(updatedOrder,'items[0].price')
total = WS.getElementPropertyValue(updatedOrder,'total')
actualQuantity = WS.getElementPropertyValue(updatedOrder,'items[0].quantity')
WS.verifyEqual(price*actualQuantity, total)

//Get the final number of changes to compare it to the initial number and verify it was updated
searchChanges = WS.sendRequest(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderSearchChanges', [
	('orderId') : orderId
	]))
WS.verifyElementPropertyValue(searchChanges,'totalCount', initialCount+1)

//Delete the created order
deleteOrder = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderDelete', [
	('orderId') : orderId
	]))

//Search for the deleted order to verify it's gone
deletedOrder = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderSearch', [
	('keyword') : orderId
	]))
WS.verifyElementPropertyValue(deletedOrder, 'totalCount', '0')


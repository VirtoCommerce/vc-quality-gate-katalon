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


//SEND REQUEST WITH ORDER DATA TO CREATE AN ORDER
int quantity = 1
orderId = UUID.randomUUID().toString()
order = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderCreate', [
	('orderId') : orderId,
	('quantity') : quantity,
	('userName') : GlobalVariable.userName
	]))
WS.verifyElementPropertyValue(order,'id', orderId)


//GET THE INITIAL CHANGES NUMBER TO COMPARE IT TO THE FINAL CHANGES NUMBER LATER
searchChanges = WS.sendRequest(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderSearchChanges', [
	('orderId') : orderId
	]))
int initialCount = WS.getElementPropertyValue(searchChanges,'totalCount')


//GET THE CREATED ORDER DATA
order = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderGetById', [
	('orderId') : orderId
	]))
WS.verifyElementPropertyValue(order,'id', orderId)
actualQuantity = WS.getElementPropertyValue(order,'items[0].quantity')
int updatedQuantity = actualQuantity + 1


//UPDATE THE CREATED ORDER (change items quantity) and convert it to the acceptable format
orderMap = order.getResponseBodyContent()
orderParsed = new JsonSlurper().parseText(orderMap)
orderParsed.items[0].quantity = updatedQuantity
def orderJson = new groovy.json.JsonBuilder(orderParsed)
def orderString = orderJson.toString()


//SEND THE UPDATED ORDER
RequestObject request = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderUpdate')
request.setBodyContent(new HttpTextBodyContent(orderString))
WS.sendRequestAndVerify(request)


//GET THE UPDATED ORDER TO VERIFY IT WAS CHANGED
updatedOrder = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderGetById', [
	('orderId') : orderId
	]))
WS.verifyElementPropertyValue(updatedOrder,'items[0].quantity',updatedQuantity)


//CHECK TOTAL RECALCULATION
price = WS.getElementPropertyValue(updatedOrder,'items[0].price')
total = WS.getElementPropertyValue(updatedOrder,'total')
actualQuantity = WS.getElementPropertyValue(updatedOrder,'items[0].quantity')
WS.verifyEqual(price*actualQuantity, total)


//GET THE FINAL CHANGES NUMBER TO COMPARE IT TO THE INITIAL NUMBER AND VERIFY IT WAS UPDATED
searchChanges = WS.sendRequest(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderSearchChanges', [
	('orderId') : orderId
	]))
WS.verifyElementPropertyValue(searchChanges,'totalCount', initialCount+1)


//DELETE THE CREATED ORDER
deleteOrder = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderDelete', [
	('orderId') : orderId
	]))


//SEARCH THE DELETED ORDER TO VERIFY IT'S GONE
deletedOrder = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderSearch', [
	('keyword') : orderId
	]))
WS.verifyElementPropertyValue(deletedOrder, 'totalCount', '0')


//VERIFY ORDER NUMBER HAS 64 SYMBOL NAME LIMITATION
orderId = UUID.randomUUID().toString()
HashMap<String, String> responseMap = GlobalVariable.orderNameListContent
for (String orderNumber : responseMap.keySet()){
	order = WS.sendRequest(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderCreate', [
		('orderId') : orderId,
		('quantity') : quantity,
		('userName') : GlobalVariable.userName,
		('orderNumber') : orderNumber
		]))
	WS.verifyResponseStatusCode(order,500)}

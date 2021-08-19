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
import com.kms.katalon.core.util.KeywordUtil


//SEND REQUEST WITH ORDER DATA TO CREATE AN ORDER
int quantity = 1
orderId = UUID.randomUUID().toString()
order = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderCreate', [
	('orderId') : orderId,
	('quantity') : quantity,
	('userName') : GlobalVariable.userName
	]))
WS.verifyElementPropertyValue(order,'id', orderId)


//EXTRACT CUSTOMER ID TO CHECK GENEATED PAYMENT ON LATER STAGES
customerId = WS.getElementPropertyValue(order,'customerId')


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


//EXTRACT ORDER DATA TO USE ON LATER STAGES
orderNumber = WS.getElementPropertyValue(order,'number')
actualQuantity = WS.getElementPropertyValue(order,'items[0].quantity')
updatedQuantity = actualQuantity + 1


//GENERATE(GET) THE NEW PAYMENT BY ORDERID
getPayment = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderPaymentsGetByOrderId',[
	('orderId') : orderId
	]))
WS.verifyElementPropertyValue(getPayment,'customerId', customerId)


//EXTRACT PAYMENT NUMBER FOR FURTHER VERIFYCATION
//PARSE AND FORMAT PAYMENTS DATA TO PUT IT TO THE ORDER LATER
paymentNumber = WS.getElementPropertyValue(getPayment,'number')
generatedPayment = getPayment.getResponseBodyContent()
parsedPayments = new JsonSlurper().parseText(generatedPayment)
def Object payments = new Object [1]
payments[0] = parsedPayments
  


//GENERATE(GET) THE NEW  SHIPMENT BY ORDER ID
getShipment = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderShipmentsGetById', [
	('orderId') : orderId
	]))


//EXTRACT SHIPMENT NUMBER FOR FURTHER VERIFYCATION
//PARSE AND FORMAT SHIPMENT DATA TO PUT IT TO THE ORDER LATER
shipmentNumber = WS.getElementPropertyValue(getShipment,'number')
generatedShipment = getShipment.getResponseBodyContent()
slurper = new JsonSlurper()
parsedShipments = slurper.parseText(generatedShipment)
def Object shipments = new Object [1]
shipments[0] = parsedShipments


//PARSE THE CREATED ORDER DATA
orderMap = order.getResponseBodyContent()
orderParsed = new JsonSlurper().parseText(orderMap)


//ADD SHIPMENTS AND PAYMENTS TO THE ORDER BODY, CHANGE QUANTITY VALUE(for total recalculation check)
orderParsed.inPayments = payments
orderParsed.shipments = shipments
orderParsed.items[0].quantity = updatedQuantity
def orderJson = new groovy.json.JsonBuilder(orderParsed)
def orderString = orderJson.toString()
println orderJson
println orderString


//SEND THE ORDER BODY TO "RECALCULATE" ENDPOINT TO GENERATE THE UPDATED ORDER BODY
RequestObject recalculate = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderRecalculate')
recalculate.setBodyContent(new HttpTextBodyContent(orderString))
recalculated = WS.sendRequestAndVerify(recalculate)


//EXTRACT THE UPDATED ORDER BODY
newBody = recalculated.getResponseBodyContent()
parsedNewBody = new JsonSlurper().parseText(newBody)
println parsedNewBody
def newOrderJson = new groovy.json.JsonBuilder(parsedNewBody)
def newOrderString = newOrderJson.toString()


//SEND REQUEST WITH THE UPDATED ORDER BODY TO "UPDATE ORDER" ENDPOINT
RequestObject updatedRequest = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderUpdate')
updatedRequest.setBodyContent(new HttpTextBodyContent(newOrderString))
WS.sendRequestAndVerify(updatedRequest)


//GET THE UPDATED ORDER (by order number) TO VERIFY REQUIRED VALUES ARE UPDATED
updatedOrder = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderGetByOrderNumber', [
	('orderNumber') : orderNumber
	]))
WS.verifyElementPropertyValue(updatedOrder,'items[0].quantity', updatedQuantity)
WS.verifyElementPropertyValue(updatedOrder,'inPayments[0].number', paymentNumber)
WS.verifyElementPropertyValue(updatedOrder,'shipments[0].number', shipmentNumber)


//CHECK IF THE TOTAL WAS RECALCULATED PROPERLY
actualQuantity = WS.getElementPropertyValue(updatedOrder,'items[0].quantity')
price = WS.getElementPropertyValue(updatedOrder,'items[0].price')
total = WS.getElementPropertyValue(updatedOrder,'total')
WS.verifyEqual(total, price*actualQuantity)


//GET THE FINAL CHANGES NUMBER TO COMPARE IT TO THE INITIAL NUMBER AND VERIFY IT WAS UPDATED
searchChanges = WS.sendRequest(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderSearchChanges', [
	('orderId') : orderId
	]))
WS.verifyElementPropertyValue(searchChanges,'totalCount', initialCount+3)


//DELETE THE CREATED ORDER
deleteOrder = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderDelete', [
	('orderId') : orderId
	]))
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


//GET THE DASHNOARD STATISTICS
initialStatistics = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderDashboardStatistics'))
initialRevenue = WS.getElementPropertyValue(initialStatistics,'revenue[0].amount')
println initialRevenue


//SEND REQUEST WITH ORDER DATA TO CREATE AN ORDER
int quantity = 1
orderId = UUID.randomUUID().toString()
order = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderCreate', [
	('orderId') : orderId,
	('quantity') : quantity,
	('userName') : GlobalVariable.userName
	]))
WS.verifyElementPropertyValue(order,'id', orderId)
orderTotal = WS.getElementPropertyValue(order,'total')
println orderTotal


//GET THE CREATED ORDER DATA
order = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderGetById', [
	('orderId') : orderId
	]))
WS.verifyElementPropertyValue(order,'id', orderId)
customerId = WS.getElementPropertyValue(order,'customerId')

////UPLOAD THE PAYMENTS DATA AND SET ITS' VALUES UP
paymentId = UUID.randomUUID().toString()
slurper = new JsonSlurper()
String paymentsData = new File('Data Files/paymentsData.json').text
parsedPayments = slurper.parseText(paymentsData)
parsedPayments.orderId = orderId
parsedPayments.id = paymentId
println parsedPayments.orderId
println parsedPayments.id
def Object paymentsArray = new Object [1]
paymentsArray[0] = parsedPayments


//UPDATE THE CREATED ORDER (add payments) and convert it to the acceptable format
orderMap = order.getResponseBodyContent()
orderParsed = new JsonSlurper().parseText(orderMap)
orderParsed.inPayments = paymentsArray
def orderJson = new groovy.json.JsonBuilder(orderParsed)
def orderString = orderJson.toString()
println orderString


//UPDATE PAYMENTS
RequestObject request = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderUpdate')
request.setBodyContent(new HttpTextBodyContent(orderString))
updateOrder = WS.sendRequestAndVerify(request)


//GET THE UPDATED ORDER TO VERIFY IT WAS UPDATED WITH THE REQUIRED PAYMENT
order = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderGetById', [
	('orderId') : orderId
	]))
WS.verifyElementPropertyValue(order,'inPayments[0].id', paymentId)


//PROCESS THE ADDED PAYMENT
processPayment = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderProcessPayment', [
	('orderId') : orderId,
	('paymentId') : paymentId
	]))
WS.verifyElementPropertyValue(processPayment,'isSuccess', true)


//GET THE FINAL DASHNOARD STATISTICS
finalStatistics = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderDashboardStatistics'))
finalRevenue = WS.getElementPropertyValue(finalStatistics,'revenue[0].amount')


//VERIFY THE REVENUE HAS BEEN CHANGED PROPERLY
String actualRevenue = initialRevenue + orderTotal  
check = WS.verifyEqual(finalRevenue, actualRevenue)


//GET THE NEW PAYMENT BY ITS ORDERID (JUST AN ENDPOINT CHECK)
getPayment = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderPaymentsGetByOrderId',[
	('orderId') : orderId
	]))
WS.verifyElementPropertyValue(getPayment,'customerId', customerId)


//DELETE THE CREATED ORDER
deleteOrder = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderDelete', [
	('orderId') : orderId
	]))

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


//CHECK IF(GET) INDEXED SEARCH ENABLE(simple endpoint check)
indexedSearchState = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Order/OrderIndexedSearchEnabled'))


//GET THE DASHBOARD STATISTICS AND EXTRACT THE INITIAL REVENUE FOR FURTHER TESTING
initialStatistics = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderDashboardStatistics'))
initialRevenue = WS.getElementPropertyValue(initialStatistics,'revenue[0].amount')


//SEND REQUEST WITH ORDER DATA TO CREATE AN ORDER
int quantity = 1
orderId = UUID.randomUUID().toString()
order = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderCreate', [
	('orderId') : orderId,
	('quantity') : quantity,
	('userName') : GlobalVariable.userName
	]))
WS.verifyElementPropertyValue(order,'id', orderId)


//GET CHANGES BY ID ENDPOINT CHECK (simple endpoint check)
initialChanges = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderChangesGetById', [
	('orderId') : orderId
	]))
WS.verifyElementPropertyValue(initialChanges, '[0]', null)


//GET THE CREATED ORDER DATA 
order = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderGetById', [
	('orderId') : orderId
	]))
WS.verifyElementPropertyValue(order,'id', orderId)


//EXTRACT ORDER NUMBER TO USE IN FURTHER REQUESTS
//EXTRACT ORDER TOTAL TO CHECK THE FINAL REVENUE CALCULATION
orderNumber = WS.getElementPropertyValue(order,'number')
orderTotal = WS.getElementPropertyValue(order,'total')


////UPLOAD THE PAYMENTS DATA AND CHANGE ITS VALUES TO FIT THE CREATED ORDER
paymentId = UUID.randomUUID().toString()
slurper = new JsonSlurper()
String paymentsData = new File('Data Files/paymentsData.json').text
parsedPayments = slurper.parseText(paymentsData)
parsedPayments.orderId = orderId
parsedPayments.id = paymentId
def Object paymentsArray = new Object [1]
paymentsArray[0] = parsedPayments


//ADD PAYMENTS TO THE CREATED ORDER BODY (and convert it to the acceptable format then)
orderMap = order.getResponseBodyContent()
orderParsed = new JsonSlurper().parseText(orderMap)
orderParsed.inPayments = paymentsArray
def orderJson = new groovy.json.JsonBuilder(orderParsed)
def orderString = orderJson.toString()


//SEND THE REQUEST WITH THE ORDER BODY TO UPDATE PAYMENTS
RequestObject request = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderUpdate')
request.setBodyContent(new HttpTextBodyContent(orderString))
updateOrder = WS.sendRequestAndVerify(request)


//GET THE UPDATED ORDER TO VERIFY IT WAS UPDATED WITH THE REQUIRED PAYMENT
order = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderGetById', [
	('orderId') : orderId
	]))
WS.verifyElementPropertyValue(order,'inPayments[0].id', paymentId)


//PROCESS THE ADDED PAYMENT (WILL CHANGE THE FINAL REVENUE AMOUNT)
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



//DELETE THE CREATED ORDER
deleteOrder = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderDelete', [
	('orderId') : orderId
	]))
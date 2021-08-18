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


//GET THE CREATED ORDER DATA
order = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderGetById', [
	('orderId') : orderId
	]))
WS.verifyElementPropertyValue(order,'id', orderId)
actualQuantity = WS.getElementPropertyValue(order,'items[0].quantity')
updatedQuantity = actualQuantity + 1


//UPDATE THE CREATED ORDER (change items quantity) and convert it to the acceptable format
orderMap = order.getResponseBodyContent()
orderParsed = new JsonSlurper().parseText(orderMap)
orderParsed.items[0].quantity = updatedQuantity
def orderJson = new groovy.json.JsonBuilder(orderParsed)
def orderString = orderJson.toString()
println orderString


//SEND THE UPDATED ORDER
RequestObject request = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderRecalculate')
request.setBodyContent(new HttpTextBodyContent(orderString))
recalculate = WS.sendRequestAndVerify(request)
recalculateBody = recalculate.getResponseBodyContent()
slurper = new JsonSlurper()
parsedBody = slurper.parseText(recalculateBody)


//VERIFY THE TOTAL WAS RECALCULATED PROPERLY
price = parsedBody.items[0].price
total = parsedBody.total
actualQuantity = parsedBody.items[0].quantity
if (price*actualQuantity == total) {
	println 'THE TOTAL IS PROPERLY RECALCULATED'
} else {
	KeywordUtil.markFailed('THE TOTAL IS NOT RECALCULATED PROPERLY'); //FailureHandling.CONTINUE_ON_FAILURE
}	


//DELETE THE CREATED ORDER
deleteOrder = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderDelete', [
	('orderId') : orderId
	]))

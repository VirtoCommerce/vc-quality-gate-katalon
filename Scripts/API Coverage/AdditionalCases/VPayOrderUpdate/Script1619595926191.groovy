import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable



List <String> orderId = GlobalVariable.orderId
for (currentOrderId in orderId) {
	
// Get order parameters
customerOrders = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Orders/OrderSearchById', [('id') : currentOrderId]))
//WS.verifyResponseStatusCode(customerOrders, 200)
//println (customerOrders.getResponseBodyContent())

// get name for "carType"
def itemName = WS.getElementPropertyValue(customerOrders, 'items[0].name')
// Need to find property name "ssl_car_program_year" and get "values.value" for "year"
String itemPropertyName = "ssl_car_program_year";
// Need to find property name "ssl_merchant_txn_id_dealer_code" and get "values.value" for "dealershipCode"
String shipmentPropertyName = "ssl_merchant_txn_id_dealer_code";


def JsonSlurper responseJson = new JsonSlurper()
def parsedJson = responseJson.parseText(customerOrders.getResponseBodyContent())

// Display state of those values in order
println parsedJson.carType
println parsedJson.year
println parsedJson.dealershipCode


// Update parameter "carType"
parsedJson["carType"] = itemName

// Update parameter "year"
for (def dynamicPropertiesField : parsedJson.items[0].dynamicProperties) {
	if (dynamicPropertiesField.name == itemPropertyName) {
		
		def yearValue = dynamicPropertiesField.values.value[0]
		parsedJson["year"] = yearValue
		println(parsedJson.year)
		break
	}
}

// Update parameter "dealershipCode"
for (def dynamicPropertiesField : parsedJson.shipments[0].dynamicProperties) {
	if (dynamicPropertiesField.name == shipmentPropertyName) {
		
		def dealershipCodeValue = dynamicPropertiesField.values.value[0]
		parsedJson["dealershipCode"] = dealershipCodeValue;	
		println(parsedJson.dealershipCode)
		break
	}
}

		
// Convert map into Json
def jsonBodyContent = new groovy.json.JsonBuilder(parsedJson)
// Convert Json into String
String bodyContent = jsonBodyContent.toString()
//println bodyContent
// Update the order with new data
RequestObject request = findTestObject('API/backWebServices/VirtoCommerce.Orders/OrderUpdate')
// Set body content property
request.setBodyContent(new HttpTextBodyContent(bodyContent))
// Send Update order request
//WS.sendRequestAndVerify(request)

}



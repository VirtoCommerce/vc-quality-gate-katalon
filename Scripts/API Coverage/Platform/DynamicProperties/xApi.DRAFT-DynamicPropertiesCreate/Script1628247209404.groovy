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

import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.verification.WSResponseManager

import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil


WebUI.comment('TEST CASE: Add new property for all tests')

'Get list of all Properties in array'
//response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesGetTypes'))
//List<String> propertyTypeList = new JsonSlurper().parseText(response.getResponseBodyContent())
//println propertyTypeList

String propertyType = 'VirtoCommerce.CartModule.Core.Model.ShoppingCart';
String[] arr = propertyType.split("\\.");
String module = arr[1];
String model = arr[4];

propertyName = (module + '_' + model + '_LineItem_' + GlobalVariable.valueType[0]);
println propertyName;



List<String> propertyNameList = new ArrayList<>();
propertyNameList.add("CartLineItem_shorttext_0_0_0");
propertyNameList.add("CartLineItem_shorttext_1_0_0");
propertyNameList.add("CartLineItem_shorttext_1_1_0");
propertyNameList.add("CartLineItem_shorttext_1_1_1");

println(propertyNameList)

prop.foreach((prop) => {
	obj = {
		1: {
			('propertyType') : prop,
			('name') : propertyName + '_0_0_0');,
			('isArray') : false,
			('isMultilingual') : false,
			('isDictionary') : false
		},
		2: {
			('propertyType') : prop,
			('name') : (module + '_' + model + '_LineItem_' + GlobalVariable.valueType[0] + '_0_0_1');,
			('isArray') : false,
			('isMultilingual') : false,
			('isDictionary') : false
		},
		2: {
			('propertyType') : prop,
			('name') : (module + '_' + model + '_LineItem_' + GlobalVariable.valueType[0] + '_0_1_1');,
			('isArray') : false,
			('isMultilingual') : false,
			('isDictionary') : false
		}
	}
	responseCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesAddNew', obj[1]))
	responseCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesAddNew', obj[2]))
})

// Create new property
responseCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesAddNew', [
	('propertyType') : propertyType, 
	('name') : propertyName,
	('isArray') : false,
	('isMultilingual') : false,
	('isDictionary') : false
	]))



WS.verifyElementPropertyValue(responseCreate, 'objectType', propertyType)
WS.verifyElementPropertyValue(responseCreate, 'name', propertyName)

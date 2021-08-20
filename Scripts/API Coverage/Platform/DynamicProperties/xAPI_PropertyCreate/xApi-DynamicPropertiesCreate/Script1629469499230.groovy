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

// splitting a property name into entities
String propertyType = 'VirtoCommerce.CartModule.Core.Model.ShoppingCart';
String[] splitedType = propertyType.split("\\.");
String module = splitedType[1];
String model = splitedType[4];

// forming property name
String propName = (module + '_' + model + '_LineItem_');
println propName;


ArrayList <String> valueType = GlobalVariable.valueType;
// create all types without parameters
for (int i; i < valueType.size(); i++) {
	WebUI.comment('Field proprty type ' + valueType.get(i));
	
	propertyName = propName + valueType.get(i) + "_0_0_0";
	println propertyName
	responseCreate = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesAddNew', [
		('propertyType') : propertyType,
		('valueType') : valueType.get(i),
		('name') : propertyName,
		]))
	WS.verifyElementPropertyValue(responseCreate, 'name', propertyName)
}

//
create all types with Multivalue
for (int i; i < 4; i++) {
	WebUI.comment('Field proprty type ' + valueType.get(i));
	
	propertyName = propName + valueType.get(i) + "_1_0_0";
	println propertyName
	responseCreate = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesAddNew', [
		('propertyType') : propertyType,
		('valueType') : valueType.get(i),
		('name') : propertyName,
		('isArray') : true,
		]))
	WS.verifyElementPropertyValue(responseCreate, 'name', propertyName)
}


// create remaining properties combinations for ShortText 
String valType = "ShortText"

propertyName = propName + valType + "_0_0_1";
println propertyName
responseCreate = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesAddNew', [
	('propertyType') : propertyType,
	('valueType') : valType,
	('name') : propertyName,
	('isArray') : false,
	('isMultilingual') : false,
	('isDictionary') : true
	]))
WS.verifyElementPropertyValue(responseCreate, 'name', propertyName)


propertyName = propName + valType + "_0_1_1";
println propertyName
responseCreate = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesAddNew', [
	('propertyType') : propertyType,
	('valueType') : valType,
	('name') : propertyName,
	('isArray') : false,
	('isMultilingual') : true,
	('isDictionary') : true
	]))
WS.verifyElementPropertyValue(responseCreate, 'name', propertyName)


propertyName = propName + valType + "_1_0_0";
println propertyName
responseCreate = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesAddNew', [
	('propertyType') : propertyType,
	('valueType') : valType,
	('name') : propertyName,
	('isArray') : true,
	('isMultilingual') : false,
	('isDictionary') : false
	]))
WS.verifyElementPropertyValue(responseCreate, 'name', propertyName)


propertyName = propName + valType + "_1_0_1";
println propertyName
responseCreate = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesAddNew', [
	('propertyType') : propertyType,
	('valueType') : valType,
	('name') : propertyName,
	('isArray') : true,
	('isMultilingual') : false,
	('isDictionary') : true
	]))
WS.verifyElementPropertyValue(responseCreate, 'name', propertyName)


propertyName = propName + valType + "_1_1_0";
println propertyName
responseCreate = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesAddNew', [
	('propertyType') : propertyType,
	('valueType') : valType,
	('name') : propertyName,
	('isArray') : true,
	('isMultilingual') : true,
	('isDictionary') : false
	]))
WS.verifyElementPropertyValue(responseCreate, 'name', propertyName)


propertyName = propName + valType + "_1_1_1";
println propertyName
responseCreate = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Platform/DynamicPropertiesAddNew', [
	('propertyType') : propertyType,
	('valueType') : valType,
	('name') : propertyName,
	('isArray') : true,
	('isMultilingual') : true,
	('isDictionary') : true
	]))
WS.verifyElementPropertyValue(responseCreate, 'name', propertyName)

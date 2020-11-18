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
import groovy.json.JsonSlurper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

KeywordUtil.logInfo("Test Case: ProductGet")

//STEP | Get product list, find new producta and save productId to the GlobalVariable
productResponse = WS.sendRequestAndVerify(findTestObject('frontWebServices/getProductList'))

def JsonSlurper responseList = new JsonSlurper()

HashMap<String, String> productList = responseList.parseText(productResponse.getResponseBodyContent());
ArrayList productsArray = productList.get("products");

def notfound = true;

for (Map map : productsArray) {
	if (map.sku == GlobalVariable.sku) {
		GlobalVariable.productId = map.id
		KeywordUtil.logInfo("PRODUCT ID IN LOOP : " + GlobalVariable.productId)
		notfound = false;
		break;
	}
}

// If sku was not found in results > test fail
if (notfound){
	KeywordUtil.markFailed("Error: Can't find SKU " + GlobalVariable.sku + " in search results")
	} else {
	KeywordUtil.logInfo("Product with SKU " + GlobalVariable.sku + " is found in search results")
}


////STEP | Save productId to the GlobalVariable
//productResponse = WS.sendRequest(findTestObject('frontWebServices/getProductList'))
//def JsonSlurper responseList = new JsonSlurper()
//
//Map<String, String> productList = responseList.parseText(productResponse.getResponseBodyContent());
//ArrayList productsArray = productList.get("products");
//for(int i=0;i<productsArray.size;i++) {
//	HashMap<String, String> product = productsArray[i];
//	if(product.containsValue(GlobalVariable.sku)) {
//		GlobalVariable.productId = product.get("id");
//		println ("productId in loop : "+GlobalVariable.productId)
//		break;
//	}
//}
//WebUI.comment("productId READY : "+GlobalVariable.productId)
//WS.delay(10)
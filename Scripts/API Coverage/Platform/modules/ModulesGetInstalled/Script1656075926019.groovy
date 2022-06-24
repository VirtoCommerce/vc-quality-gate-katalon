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
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.comment('TEST CASE: Get installed modules')

response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/Modules/ModulesGetInstalled'))

WS.verifyElementPropertyValue(response, '[0].title', 'Authorize.Net DPM payment gateway')
WS.verifyElementPropertyValue(response, '[0].description', 'APIs and UI for Authorize.Net Direct Post Method (DPM) payment gateway')
WS.verifyElementPropertyValue(response, '[0].authors', '[Virto Commerce]')
WS.verifyElementPropertyValue(response, '[0].owners', '[Virto Commerce]')
WS.verifyElementPropertyValue(response, '[0].projectUrl', 'https://virtocommerce.com/apps/extensions/authorizenet-dpm-payment-gateway')
WS.verifyElementPropertyValue(response, '[0].isRemovable', false)
WS.verifyElementPropertyValue(response, '[0].isInstalled', true)
WS.verifyElementPropertyValue(response, '[0].id', 'VirtoCommerce.AuthorizeNet')

responseText = response.getResponseText();
def json = new JsonSlurper().parseText(responseText)
WebUI.comment( json.results.size().toString());

//loop is to find store module and set stoe version to global variables, because we do not know what number of modules is in demo version, and when store is
for (def i : (0..json.results.size()) ) {
	//WebUI.comment(json.title[i].toString())
	if((json.id[i] == "VirtoCommerce.Store"))  {
		GlobalVariable.storeModuleVersion = json.version[i].toString()
		WebUI.comment(json.version[i].toString())
		//exit the loop if store module is found
		break;
	}
	WebUI.comment(GlobalVariable.storeModuleVersion)
	
	
}


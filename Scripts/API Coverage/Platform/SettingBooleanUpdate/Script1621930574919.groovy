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

WebUI.comment('TEST CASE: Update setting')

response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UpdateSettingsBoolean', [('name') : 'VirtoCommerce.Platform.Security.EnablePruneExpiredTokensJob'
            , ('value') : false, ('groupName') : 'Security', ('moduleId') : 'Platform']))

//verify that updates appllies
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/SettingsGetByModuleID', [('moduleID') : 'Platform']))

WS.verifyElementPropertyValue(response, '[0].moduleId', "Platform")

responseText = response.getResponseText();
def json = new JsonSlurper().parseText(responseText)
WebUI.comment( json.results.size().toString());

//loop is to find and verify updated setting 
for (def i : (0..json.results.size()) ) {
	//WebUI.comment(json.title[i].toString())
	if((json.name[i] == "VirtoCommerce.Platform.Security.EnablePruneExpiredTokensJob"))  {
		WebUI.comment(json.name[i])
		WebUI.comment(json.value[i].toString())
		def realvalue =  json.value[i]
		WS.verifyElementPropertyValue(response, [i].value.value, false)

		//exit the loop if setting  is found
		break;
	}

	
	
}
//WS.verifyElementPropertyValue(response, '[0].value', true)
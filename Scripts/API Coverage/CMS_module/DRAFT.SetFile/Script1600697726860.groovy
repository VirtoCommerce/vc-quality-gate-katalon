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

//import com.kms.katalon.core.testobject.impl.HttpBodyContent
import com.kms.katalon.core.testobject.FormDataBodyParameter
import groovy.json.JsonSlurper as JsonSlurper

def request = findTestObject('API/backWebServices/CMS Content module/DRAFT.ContentFileNew')

List<FormDataBodyParameter> body = new ArrayList()
body.add(new FormDataBodyParameter('name1', 'passw'))
//body.add(new FormDataBodyParameter('type', '', 'blob'))
//body.add(new UrlEncodedBodyParameter('username', 'admin'))
//body.add(new UrlEncodedBodyParameter('password', 'store'))

request.setBodyContent(new FormDataBodyParameter(body))
println("REQUEST IS : " + request)
response = WS.sendRequestAndVerify(request)


// STEP | Parse request and save token to the GlobalVariable
//def responseJson = new JsonSlurper().parseText(response.getResponseBodyContent())
//GlobalVariable.token = ((responseJson.token_type + ' ') + responseJson.access_token)

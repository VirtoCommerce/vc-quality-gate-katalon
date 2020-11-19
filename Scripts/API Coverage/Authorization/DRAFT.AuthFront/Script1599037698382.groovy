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

import com.kms.katalon.core.testobject.impl.HttpUrlEncodedBodyContent
import com.kms.katalon.core.testobject.UrlEncodedBodyParameter
import groovy.json.JsonSlurper


// STEP | Authorization request to get Token
//def request = findTestObject('API/frontWebServices/DRAFT.AuthFrontToken')
def request = findTestObject('API/frontWebServices/getToken')

List<UrlEncodedBodyParameter> body = new ArrayList<UrlEncodedBodyParameter>()
body.add(new UrlEncodedBodyParameter("grant_type","password"))
body.add(new UrlEncodedBodyParameter("scope","offline_access"))
body.add(new UrlEncodedBodyParameter("username",GlobalVariable.userName))
body.add(new UrlEncodedBodyParameter("password",GlobalVariable.userPassword))

println(body);

request.setBodyContent(new HttpUrlEncodedBodyContent(body))

response = WS.sendRequestAndVerify(request)
println("TOKEN IS : " + response)

// STEP | Parse request and save token to the GlobalVariable
def responseJson = new JsonSlurper().parseText(response.getResponseBodyContent())
GlobalVariable.token = responseJson.token_type+ " " +responseJson.access_token

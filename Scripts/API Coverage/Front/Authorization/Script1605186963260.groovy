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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

import com.kms.katalon.core.testobject.impl.HttpUrlEncodedBodyContent
import com.kms.katalon.core.testobject.UrlEncodedBodyParameter

import groovy.json.JsonSlurper

KeywordUtil.logInfo("Test Case: Authorization") 

// STEP | Authorization request to get Token
def userName = GlobalVariable.userName
def userPassword = GlobalVariable.userPassword


List<UrlEncodedBodyParameter> body = new ArrayList<UrlEncodedBodyParameter>()
//body.add(new UrlEncodedBodyParameter("grant_type", "password"))
//body.add(new UrlEncodedBodyParameter("scope", "offline_access"))
body.add(new UrlEncodedBodyParameter("customer[user_name]", userName))
body.add(new UrlEncodedBodyParameter("customer[password]", userPassword))

println(body)

def request = findTestObject('API/frontWebServices/getToken')
request.setBodyContent(new HttpUrlEncodedBodyContent(body))

WebUI.comment(request)

KeywordUtil.logInfo("Try to authorize with username = " +  userName + ", Password = " + userPassword)
response = WS.sendRequestAndVerify(request)


// STEP | Parse request and save token to the GlobalVariable
def responseJson = new JsonSlurper().parseText(response.getResponseBodyContent())
GlobalVariable.token = responseJson.token_type+ " " +responseJson.access_token

KeywordUtil.logInfo("Current token = "+GlobalVariable.token)
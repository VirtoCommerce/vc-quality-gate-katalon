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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonOutput
import com.kms.katalon.core.testobject.ResponseObject

import com.kms.katalon.core.testobject.UrlEncodedBodyParameter as UrlEncodedBodyParameter
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.impl.HttpUrlEncodedBodyContent as HttpUrlEncodedBodyContent


WebUI.comment('TEST CASE: chec api availability and user locking when apiKey is active')


'SEND REQUEST TO LOCK THE USER'
userLock = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/userLock', [
	('userId') : GlobalVariable.userId
	]))


'VERIFY THE LOCK STATE HAS BEEN SET AS EXPECTED'
lockStateGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/userLockStateGet',[
	('userId') : GlobalVariable.userId
	]))
WS.verifyElementPropertyValue(lockStateGet,'locked', true)


'VERIFY A LOCKED USER CANT LOG IN'//covers a part of /AuthorizationFlow scenario
def getTokenObject = findTestObject('API/backWebServices/VirtoCommerce.Platform/Authorization/AuthorizationToken')
List<UrlEncodedBodyParameter> body = new ArrayList()
body.add(new UrlEncodedBodyParameter('grant_type', 'password'))
body.add(new UrlEncodedBodyParameter('scope', 'offline_access'))
body.add(new UrlEncodedBodyParameter('username', GlobalVariable.userName))
body.add(new UrlEncodedBodyParameter('password', GlobalVariable.userPassword))
getTokenObject.setBodyContent(new HttpUrlEncodedBodyContent(body))
getToken = WS.sendRequest(getTokenObject)
WS.verifyResponseStatusCode(getToken, 400)
WS.verifyElementPropertyValue(getToken,'errorDescription', 'The username/password couple is invalid.')


'CHECK LOCKED STATE RESPONSE'
lockedStateResponseCheck = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Platform/apiKeyResponseCheck',[
	('apiKey') : GlobalVariable.userApiKey
	]))
WS.verifyResponseStatusCode(lockedStateResponseCheck, 401)


'SEND REQUEST TO UNLOCK THE CREATED USER'
userUnlock = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/userUnlock', [
	('userId') : GlobalVariable.userId
	]))


'VERIFY THE LOCK STATE HAS BEEN SET AS EXPECTED'
lockStateGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/userLockStateGet',[
	('userId') : GlobalVariable.userId
	]))
WS.verifyElementPropertyValue(lockStateGet,'locked', false)


lockedStateResponseCheck = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Platform/apiKeyResponseCheck',[
	('apiKey') : GlobalVariable.userApiKey
	]))
WS.verifyResponseStatusCode(lockedStateResponseCheck, 200)



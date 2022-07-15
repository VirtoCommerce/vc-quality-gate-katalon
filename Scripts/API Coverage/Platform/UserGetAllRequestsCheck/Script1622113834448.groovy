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
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonOutput
import com.kms.katalon.core.testobject.ResponseObject


WebUI.comment('TEST CASE: Check all GET requests related to User')

//operatorId = '0a773137-7ac5-4ebc-8d24-94419ed988b6'

currentUser = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserGetCurrentuser'))
operatorId = WS.getElementPropertyValue(currentUser, 'id')
body = currentUser.getResponseBodyContent()
bodyParsed = new JsonSlurper().parseText(body)
bodyJson = new groovy.json.JsonBuilder(bodyParsed).toString()
println operatorId
println bodyJson


userByEmail = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserGetUserByEmail'))
body2 = userByEmail.getResponseBodyContent()
body2Parsed = new JsonSlurper().parseText(body2)
body2Json = new groovy.json.JsonBuilder(body2Parsed).toString()
println body2Json
WS.verifyElementPropertyValue(userByEmail, 'id', operatorId)

userByName = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserGetUserByName'))
WS.verifyElementPropertyValue(userByName, 'id', operatorId)

userInfo = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserGetUserinfo'))
WS.verifyElementPropertyValue(userInfo, 'sub', operatorId)

responseById = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserGetUserById'))
WS.verifyElementPropertyValue(responseById, 'userName', 'operator@mail.com')

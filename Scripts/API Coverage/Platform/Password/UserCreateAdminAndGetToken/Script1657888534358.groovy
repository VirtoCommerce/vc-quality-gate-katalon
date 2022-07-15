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


'CREATE A USER FIRST'
 userCreate = WS.callTestCase(findTestCase('Test Cases/API Coverage/Platform/UserCreate'),
	 null)
 'Get the created user by name id'
 getUserId = WS.callTestCase(findTestCase('Test Cases/API Coverage/Platform/UserSearchSetUserID'),
	 null)

 
 'UPDATE REQUIRED, AS ITS IMPOSSIBLE CREATE ADMIN USER WITH JUST ONE REQUEST (PLATFORM SPECIFIC BEHAVIOR)'
 'GET USER DATA'
 userGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserGetUserById', [
	 ('userId') : GlobalVariable.userId
	 ]))
 userGetBody = userGet.getResponseBodyContent()
 println userGetBody
 userBodyParsed = new JsonSlurper().parseText(userGetBody)
 userBodyParsed.userType = 'Administrator'
 userBodyJson = new groovy.json.JsonBuilder(userBodyParsed).toString()
 println userBodyJson
 
 
 'SEND REQUEST TO UPDATE THE CREATED USER (update is required to make a user lockble (workflow peculiarity))'
 RequestObject userBodyObject = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Platform/UserUpdate')
 userBodyObject.setBodyContent(new HttpTextBodyContent(userBodyJson))
 userBodyUpdate = WS.sendRequestAndVerify(userBodyObject)
 
 'Authorize and get the auth token'
 auth = WS.callTestCase(findTestCase('Test Cases/API Coverage/Platform/AuthBackToken(Generic)'),
	 null)
 println GlobalVariable.token
 
 

 
 
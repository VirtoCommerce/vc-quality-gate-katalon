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


import com.kms.katalon.core.testobject.impl.HttpUrlEncodedBodyContent as HttpUrlEncodedBodyContent
import com.kms.katalon.core.testobject.UrlEncodedBodyParameter as UrlEncodedBodyParameter


import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.HttpBodyContent
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import java.util.List
import java.util.ArrayList


WebUI.comment('TEST CASE: authorization(get token) scenarios')
//NOTE: 
//"userLocked = true" scenario is covered at: Test Cases/API Coverage/ModulePlatform/UserLock/UserLock_apiKeyIsActive
//"isAdministrator = true" scenario is covered by any contact/catalog request authorized via operator@mail's api_key
//Invalid password scenario is skipped, as this api validates login/pass couple match, so no big difference, 
//may be considered a lower priority task, though


'PREPARE A USER'
userCreate = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePlatform/UserCreate'),
	null)
userUpdate = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePlatform/UserUpdate'),
	null)


'AUTHORIZE AND VERIFY RESULTS'
validUserName = GlobalVariable.userName
userNameList = ['', 'wrongUserName', validUserName ]

for (int a; a < userNameList.size(); a++) {
authorize = findTestObject('API/backWebServices/VirtoCommerce.Platform/Authorization/AuthorizationToken')
List<UrlEncodedBodyParameter> body = new ArrayList()
body.add(new UrlEncodedBodyParameter('grant_type', 'password'))
body.add(new UrlEncodedBodyParameter('scope', 'offline_access'))
body.add(new UrlEncodedBodyParameter('username', userNameList[a]))
body.add(new UrlEncodedBodyParameter('password', GlobalVariable.userPassword))
authorize.setBodyContent(new HttpUrlEncodedBodyContent(body))
response = WS.sendRequest(authorize)
def authorizeJson = new JsonSlurper().parseText(response.getResponseBodyContent())
GlobalVariable.token = ((authorizeJson.token_type + ' ') + authorizeJson.access_token)


'VERIFY AUTHORIZATION RESULTS'
	if (userNameList[a] == userNameList[0]) {
	assert authorizeJson.error_description == "The mandatory 'username' and/or 'password' parameters are missing."
	WS.verifyResponseStatusCode(response, 400)
	} else {
	  if (userNameList[a] == userNameList[1]) {
	  WS.verifyResponseStatusCode(response, 400)
	  assert authorizeJson.errorDescription == "Login attempt failed. Please check your credentials."
	  } else {
		WS.verifyResponseStatusCode(response, 200)
		RequestObject modulesAccessObject = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Platform/Modules/ModulesGetInstalled')
		ArrayList<TestObjectProperty> headers = new ArrayList<TestObjectProperty>()
		headers.add(new TestObjectProperty('Authorization', ConditionType.EQUALS, GlobalVariable.token))
		headers.add(new TestObjectProperty('ContentType', ConditionType.EQUALS, 'application/json'))
		modulesAccessObject.setHttpHeaderProperties(headers)
		checkModulesAccess = WS.sendRequest(modulesAccessObject)
		WS.verifyResponseStatusCode(checkModulesAccess, 403)
		WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePlatform/UserDelete'),null)
	  }
	}
}


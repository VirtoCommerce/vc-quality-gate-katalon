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


'TEST CASE: Search member'
responseSearch = WS.sendRequestAndVerify(findTestObject('UI-Mercury/Registration/API/ContactsSearch', 
	[('searchPhrase') : GlobalVariable.contactName
	]))

JsonSlurper slurper = new JsonSlurper()
Map productJson = slurper.parseText(responseSearch.getResponseBodyContent())


'TEST CASE: delete User'
def userName = GlobalVariable.userName
WS.sendRequestAndVerify(findTestObject('UI-Mercury/Registration/API/UserDelete', 
	[('userName') : GlobalVariable.userName
	]))


'TEST CASE: delete Contact'
def contactId = productJson.results[0].securityAccounts[0].memberId
WS.sendRequestAndVerify(findTestObject('UI-Mercury/Registration/API/ContactsDelete',
	[('contactId') : contactId
	]))


'TEST CASE: delete Organization' 
def orgId = productJson.results[0].organizations[0]
println('Organization:' + orgId)
WS.sendRequestAndVerify(findTestObject('UI-Mercury/Registration/API/OrganizationsDelete', 
	[('orgId') : orgId
	]))


'TEST CASE: Verify that User is deleted'  
response = WS.sendRequestAndVerify(findTestObject('UI-Mercury/Registration/API/UserSearch',
	[('searchPhrase') : GlobalVariable.userName
	]))
WS.verifyElementPropertyValue(response, 'totalCount', 0)
WS.verifyElementPropertyValue(response, 'results', '[]')


'TEST CASE: Verify that Contact is deleted'
response = WS.sendRequestAndVerify(findTestObject('UI-Mercury/Registration/API/ContactsSearch',
	[('searchPhrase') : contactId
	]))
WS.verifyElementPropertyValue(response, 'totalCount', 0)
WS.verifyElementPropertyValue(response, 'results', '[]')


'TEST CASE: Verify that Organization is deleted'
response = WS.sendRequestAndVerify(findTestObject('Object Repository/UI-Mercury/Registration/API/OrganizationsSearch',
	[('searchPhrase') : orgId
	]))
WS.verifyElementPropertyValue(response, 'totalCount', 0)
WS.verifyElementPropertyValue(response, 'results', '[]')



















////_________________________________
////search contact
//responseSearch = WS.sendRequestAndVerify(findTestObject('Object Repository/UI-Mercury/Registration/API/MemberSearch', 
//[('searchPhrase') : GlobalVariable.FirstNameB2B]))
//
//
//JsonSlurper slurper = new JsonSlurper()
//Map productJson = slurper.parseText(responseSearch.getResponseBodyContent())
//
////delete Account
//def userName = productJson.results[0].securityAccounts[0].userName
//WS.sendRequestAndVerify(findTestObject('UI-Mercury/Registration/API/UserDelete'), [('userName') : userName])
//
////delete Organization
//def organizationID = productJson.results[0].organizations[0]
//println('Organization:' + organizationID)
//WS.sendRequestAndVerify(findTestObject('UI-Mercury/Registration/API/OrganizationsDelete'), 
//        [('orgId1') : organizationID])
//
////delete Contact
//def ContactId = productJson.results[0].id
//WS.sendRequestAndVerify(findTestObject('null') [('id') : ContactId])
//
//
//// Verify that user is deleted
//response = WS.sendRequestAndVerify(findTestObject('UI-Mercury/Registration/API/UserSearch'))
//WS.verifyElementPropertyValue(response, 'totalCount', 0)
//WS.verifyElementPropertyValue(response, 'results', '[]')
//

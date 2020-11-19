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
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

WebUI.comment("TEST CASE: Org creation")
def response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/MemberCreate', [('memberType') : GlobalVariable.memberType[0]]))
//def memberJson = JsonOutput.prettyPrint(response.getResponseBodyContent())
def memberJson = new JsonSlurper().parseText(response.getResponseBodyContent())
println ('RESPONSE : ' + memberJson.('id'))
GlobalVariable.memberId = memberJson.id
WebUI.comment("TYPE ID IS : " + GlobalVariable.memberId)


WebUI.comment("TEST CASE: Contact creation")
println ('RESPONSE : ' + GlobalVariable.memberId[0])
//def response2 = WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/MemberCreate', [('memberType') : GlobalVariable.memberType[1], ('organizations') : GlobalVariable.memberId[0]]))
//def response2 = WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/MemberCreate', [('organizations') : GlobalVariable.memberId[0]]))
//def memberJson2 = JsonOutput.prettyPrint(response2.getResponseBodyContent())
//GlobalVariable.contactId = memberJson2
//WebUI.comment("TYPE ID IS : " + GlobalVariable.contactId)


//WebUI.comment("TEST CASE: Account user creation")
////response3 = WS.sendRequestAndVerify(findTestObject('API/backWebServices/AccountCreateUser', [('userName') : 'tempuser', ('storeId') : GlobalVariable.storeId, ('contactId') : GlobalVariable.contactId]))
//response3 = WS.sendRequestAndVerify(findTestObject('API/backWebServices/AccountCreateUser', [('userName') : 'tempuser', ('contactId') : GlobalVariable.contactId]))
//def memberJson3 = JsonOutput.prettyPrint(response3.getResponseBodyContent())
//GlobalVariable.userName = memberJson3.name
//WebUI.comment("ContactId is: " + GlobalVariable.userName)
//
//
////WebUI.comment("TEST CASE: Account password validation")
////response4 = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/Platform module/ValidatePassword'))
//
//
//WebUI.comment("TEST CASE: Reset to new password")
//response5 = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/Platform module/ResetPassword'))
//
//
//WebUI.comment("TEST CASE: Delete user")
//response5 = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/Platform module/DeleteUser', [ ('userName') : GlobalVariable.userName] ))
//
//
//WebUI.comment("TEST CASE: Members BULK delete")
//WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/MemberDeleteBulk', [('keyword') : GlobalVariable.firstName] ))
//

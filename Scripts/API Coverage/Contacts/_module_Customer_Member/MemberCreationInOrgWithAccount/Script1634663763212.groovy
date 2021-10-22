import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.concurrent.Delayed

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
import com.sun.media.sound.SoftReverb.Delay

import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper
import groovy.json.JsonOutput


WebUI.comment("TEST CASE : Create new organization")
def responseMemberCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Members/MemberCreate', [
		('memberType') : GlobalVariable.memberType[0],
		('name') : GlobalVariable.firstName,
		('firstName') : GlobalVariable.firstName,
		('lastName') : GlobalVariable.lastName,
		('fullName') : GlobalVariable.contactName,
		]))
def memberJson = new JsonSlurper().parseText(responseMemberCreate.getResponseBodyContent())
GlobalVariable.memberId = memberJson.id


WebUI.comment("TEST CASE : Create contact in the organization")
def responseMemberCreateInOrg = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Members/MemberCreateInOrg', [
	('memberType') : GlobalVariable.memberType[1],
	('orgId') : GlobalVariable.memberId
	]))
def memberJson2 = new JsonSlurper().parseText(responseMemberCreateInOrg.getResponseBodyContent())
GlobalVariable.contactId = memberJson2.id


WebUI.comment('TEST CASE : Check Contact in Org')
responseContactsGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Members/MemberGetId', [
	('id') : GlobalVariable.contactId
	]))
WS.verifyElementPropertyValue(responseContactsGet, 'organizations[0]', GlobalVariable.memberId)


WebUI.comment('TEST CASE : Remove Org and Contact relation')
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Contacts/ContactsUpdate', [
	('contactId') : GlobalVariable.contactId,
	('fullName') : GlobalVariable.firstName
	]))


// Re-index important to search items
WebUI.callTestCase(findTestCase('API Coverage/ModuleSearch/DropIndex'), [ : ], FailureHandling.STOP_ON_FAILURE)


WebUI.comment('TEST CASE: Check Contact in Org')
responseContactsGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Members/MemberGetId', [
	('id') : GlobalVariable.contactId
	]))
WS.verifyElementPropertyValue(responseContactsGet, 'organizations[0]', null)


WebUI.comment("TEST CASE : Create user in account-contact")
GlobalVariable.userName = 'tempuser'
Random rnd = new Random()
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserCreate', [
	('email') : rnd.nextInt(100)+'@email.com',
	('userName') : GlobalVariable.userName,
	('contactId') : GlobalVariable.contactId
	]))


WebUI.comment("TEST CASE : Update user password as admin way")
responseResetPassword = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/ResetPassword', [
	('userName') : GlobalVariable.userName
	]))
WS.verifyElementPropertyValue(responseResetPassword, 'succeeded', true)


WebUI.comment("TEST CASE : Delete created user")
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserDelete', [
	('userName') : GlobalVariable.userName
	]))
WS.delay(10)


WebUI.comment(" TEST CASE : Delete all created members")
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Members/MemberDeleteBulk', [
	('keyword') : GlobalVariable.firstName
	]))


// Re-index important to search items
WebUI.callTestCase(findTestCase('API Coverage/ModuleSearch/DropIndex'), [ : ], FailureHandling.STOP_ON_FAILURE)
WS.delay(10)


WebUI.comment('TEST CASE : Search members. Count 0 in result - contact was deleted')
responseContactsSearch = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Members/MemberSearch', [
	('searchPhrase') : GlobalVariable.firstName
	]))
// Count verification couldn't be stable for use, because it depends on the time of build index
//WS.verifyElementPropertyValue(responseContactsSearch, 'totalCount', 0)
WS.verifyElementPropertyValue(responseContactsSearch, 'results', '[]')
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
import groovy.json.JsonSlurper as JsonSlurper


WebUI.comment('TEST CASE: Member BULK update')
WebUI.comment("0 ID IS : " + GlobalVariable.memberId[0] + ' AND ' + GlobalVariable.memberType[0])


'UPDATE CREATED MEMBERS'
updatedName1 = GlobalVariable.firstName + ' 1_BulkUPD'
updatedName2 = GlobalVariable.firstName + ' 2_BulkUPD'
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Members/MemberUpdateBulk', [
	('id1') : GlobalVariable.memberId[0],
	('name1') : updatedName1,
	('id2') : GlobalVariable.memberId[1],
	('name2') : updatedName2,
	('memberType') : GlobalVariable.memberType[0],
	]))


'CHECK UPDATED MEMBER'
checkUpdated = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MembersGitIdGroup'), 
	null)
WS.verifyElementPropertyValue(checkUpdated, 'name', updatedName1)


'VERIFY UPDATED NAMES'
verifyUpdated = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberSearch'),
	null)
WS.verifyElementPropertyValue(verifyUpdated, 'totalCount', 2)
WS.verifyElementPropertyValue(verifyUpdated, 'results[0].name', updatedName1)
WS.verifyElementPropertyValue(verifyUpdated, 'results[1].name', updatedName2)


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


WebUI.comment("TEST CASE: Members BULK Create")


'CREATE BULK MEMBERS'
name1 = GlobalVariable.firstName + '1'
name2 = GlobalVariable.firstName + '2'
//WebUI.comment("MEMBER ORG ID IS : " + GlobalVariable.memberType[0])
responseBulk = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Members/MemberCreateBulk', [
	('name1') : name1,
	('name2') : name2,
	('memberType') : GlobalVariable.memberType[0]
	]))
def memberJson = new JsonSlurper().parseText(responseBulk.getResponseBodyContent())
GlobalVariable.memberId = memberJson.id
WebUI.comment("MEMBER ID IS : " + GlobalVariable.memberId)
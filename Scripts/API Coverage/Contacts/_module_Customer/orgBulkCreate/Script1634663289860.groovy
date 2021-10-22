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
import groovyjarjarantlr.collections.List


WebUI.comment('TEST CASE : Create 2 new organizations BULK')


'CREATE 2 BULK ORGANIZATIONS'
GlobalVariable.organizationName = GlobalVariable.organizationName + 'Bulk'
orgCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Organizations/OrganizationsCreateBulk',[
	('name1') : GlobalVariable.organizationName + '1',
	('name2') : GlobalVariable.organizationName + '2'
	]))

'VERIFY ORGs ARE CREATED AND GET IDs'
responseOrg = WS.callTestCase(findTestCase('API Coverage/Contacts/_module_Customer/orgBulkSearch'),
	null,
	FailureHandling.STOP_ON_FAILURE)
def responseOrgJson = new JsonSlurper().parseText(responseOrg.getResponseBodyContent())
GlobalVariable.organizationId = responseOrgJson.results.id
WebUI.comment('Organization ID : ' + GlobalVariable.organizationId)
WS.verifyElementPropertyValue(responseOrg, 'totalCount', 2)
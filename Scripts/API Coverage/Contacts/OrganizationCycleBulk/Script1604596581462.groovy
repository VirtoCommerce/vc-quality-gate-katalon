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


WebUI.comment('TEST CASE : Create BULK organization')
WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/DRAFT/OrganizationsCreateBulk'))

WebUI.callTestCase(findTestCase('API Coverage/DropIndex'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TEST CASE: Organization search')
responseOrg = WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/DRAFT/OrganizationsSearch'))
def responseOrgJson = new JsonSlurper().parseText(responseOrg.getResponseBodyContent())
orgId = responseOrgJson.results.id
WebUI.comment('OPA : ' + orgId)


WebUI.comment('TEST CASE : Update BULK organization')
WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/DRAFT/OrganizationsUpdateBulk', [('orgId1') : orgId[0], ('orgId2') : orgId[1]]))


WebUI.comment('TEST CASE: Get organizations by Id')
WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/DRAFT/OrganizationsGetIdBulk', [('orgId1') : orgId[0], ('orgId2') : orgId[1]]))


WebUI.comment('TEST CASE: Organization BULK delete')
WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/DRAFT/OrganizationsDelete', [('orgId1') : orgId[0], ('orgId2') : orgId[1]]))

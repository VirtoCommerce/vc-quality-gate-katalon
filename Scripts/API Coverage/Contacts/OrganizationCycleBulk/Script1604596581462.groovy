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
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Organizations/OrganizationsCreateBulk'))


// Re-index important to search items
WebUI.callTestCase(findTestCase('API Coverage/backend/DropIndex'), [ : ], FailureHandling.STOP_ON_FAILURE)


WebUI.comment('TEST CASE : Search new organizations and save Ids')
responseOrg = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Organizations/OrganizationsSearch', [ ('searchPhrase') : GlobalVariable.firstName ] ))
def responseOrgJson = new JsonSlurper().parseText(responseOrg.getResponseBodyContent())
orgId = responseOrgJson.results.id
WebUI.comment('Organization ID : ' + orgId)
WS.verifyElementPropertyValue(responseOrg, 'totalCount', 2)


WebUI.comment('TEST CASE : Update organization BULK')
name1 = 'Qwe OrgBulkUpd1'
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Organizations/OrganizationsUpdateBulk', [('orgId1') : orgId[0], ('orgId2') : orgId[1], ('name1') : name1]))


WebUI.comment('TEST CASE : Check Organization GET request by Id')
//responseGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Organizations/OrganizationsGetIdBulk', [('orgId1') : orgId[0], ('orgId2') : orgId[1]]))
responseGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Organizations/OrganizationsGetIdBulk', [('orgId1') : orgId[0]]))
WS.verifyElementPropertyValue(responseGet, 'name[0]', name1)


WebUI.comment('TEST CASE : Delete created organization BULK')
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Organizations/OrganizationsDelete', [('orgId1') : orgId[0], ('orgId2') : orgId[1]]))


// Re-index important to search items
WebUI.callTestCase(findTestCase('API Coverage/backend/DropIndex'), [ : ], FailureHandling.STOP_ON_FAILURE)


WebUI.comment('TEST CASE : Search deleted orgs. Count 0 in result - orgs were deleted')
responseOrg1 = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Organizations/OrganizationsSearch', [ ('searchPhrase') : GlobalVariable.firstName ] ))
WS.verifyElementPropertyValue(responseOrg1, 'totalCount', 0)

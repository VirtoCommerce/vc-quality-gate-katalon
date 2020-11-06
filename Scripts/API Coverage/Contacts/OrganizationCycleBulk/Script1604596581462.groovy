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


// Create 2 new organizations
WebUI.comment('TEST CASE : Create BULK organization')
WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/DRAFT/OrganizationsCreateBulk'))


// Re-index important to search items
WebUI.callTestCase(findTestCase('API Coverage/DropIndex'), [ : ], FailureHandling.STOP_ON_FAILURE)


// Search new organizations and save Id's
WebUI.comment('TEST CASE: Organization search')
responseOrg = WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/DRAFT/OrganizationsSearch'))
def responseOrgJson = new JsonSlurper().parseText(responseOrg.getResponseBodyContent())
orgId = responseOrgJson.results.id
WebUI.comment('Organization ID : ' + orgId)
WS.verifyElementPropertyValue(responseOrg, 'totalCount', 2)


// Update Orgs
WebUI.comment('TEST CASE : Update BULK organization')
name1 = 'Qwe OrgBulkUpd1'
WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/DRAFT/OrganizationsUpdateBulk', [('orgId1') : orgId[0], ('orgId2') : orgId[1], ('name1') : name1]))


// Check Organization GET request by Id
WebUI.comment('TEST CASE: Get organizations by Id')
responseGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/DRAFT/OrganizationsGetIdBulk', [('orgId1') : orgId[0], ('orgId2') : orgId[1]]))
WS.verifyElementPropertyValue(responseGet, 'name[0]', name1)

// Delete 2 Orgs
WebUI.comment('TEST CASE: Organization BULK delete')
WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/DRAFT/OrganizationsDelete', [('orgId1') : orgId[0], ('orgId2') : orgId[1]]))


// Re-index important to search items
WebUI.callTestCase(findTestCase('API Coverage/DropIndex'), [ : ], FailureHandling.STOP_ON_FAILURE)


// Search deleted orgs. Count 0 in result - orgs were deleted
WebUI.comment('TEST CASE: Organization search')
responseOrg1 = WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/DRAFT/OrganizationsSearch'))
WS.verifyElementPropertyValue(responseOrg1, 'totalCount', 0)

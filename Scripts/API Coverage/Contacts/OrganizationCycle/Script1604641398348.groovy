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


// Create new organization and save Id
WebUI.comment('TEST CASE : Create organization')
responseId = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Organizations/OrganizationsCreate'))
def responseIdJson = new JsonSlurper().parseText(responseId.getResponseBodyContent())
GlobalVariable.organizationId = responseIdJson.id
WebUI.comment('Organization ID : ' + GlobalVariable.organizationId)


// Re-index important to search items
WebUI.callTestCase(findTestCase('API Coverage/ModuleSearch/DropIndex'), [ : ], FailureHandling.STOP_ON_FAILURE)


// Update org
WebUI.comment('TEST CASE : Update organization')
name = 'Qwe OrgUpdated'
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Organizations/OrganizationsUpdate', [('orgId') : GlobalVariable.organizationId, ('name') : name]))


// Check get request by Id
WebUI.comment('TEST CASE : Get organization')
responseName = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Organizations/OrganizationsGetId', [('orgId') : GlobalVariable.organizationId]))
WS.verifyElementPropertyValue(responseName, 'name', name)


// Delete org
WebUI.comment('TEST CASE: Organization delete')
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Organizations/OrganizationsDelete', [('orgId1') : GlobalVariable.organizationId]))


// Re-index important to search items
WebUI.callTestCase(findTestCase('API Coverage/ModuleSearch/DropIndex'), [ : ], FailureHandling.STOP_ON_FAILURE)


// Search deleted org. Count 0 in result - org was deleted
WebUI.comment('TEST CASE: Organization search')
responseOrg = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Organizations/OrganizationsSearch', [ ('searchPhrase') : GlobalVariable.firstName ] ))
WS.verifyElementPropertyValue(responseOrg, 'totalCount', 0)

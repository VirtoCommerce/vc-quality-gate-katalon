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


WebUI.comment("TEST CASE: Get member in organization")


'GET ALL MEMBERS ORGANIZATIONS'
//NEED EXPLANATION FOR REQUEST (from dev as it doubles the functionality of memberGetOrgs)
//JUST CHECKS THE ENDPOINT
//BY VERIFIYING THE DEFAULT DOCKER DATA
b2bOrganizationId = 'd690f3df-8782-4dcc-99be-a1f644220e50'
b2bMemberId = 'cb0a5340-f9fb-4f49-bd62-9d03518868ff'
getAllMembers = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Members/MemberGetAllInOrganizations',[
	('orgId') : b2bOrganizationId,
	('memberId') : b2bMemberId 
	]))
return getAllMembers
WS.containsString(getAllMembers, b2bOrganizationId, false)

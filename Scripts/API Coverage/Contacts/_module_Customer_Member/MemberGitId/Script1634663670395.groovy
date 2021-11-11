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


WebUI.comment("TEST CASE: Member get by ID")


'USE IDs OF MEMBERS FROM THE LIST TO VERIFY THE RESULTS'
List <String> memberTypeId = GlobalVariable.memberId


'GET MEMBER BY ID, VERIFY IF NAMES ARE UPDATED'
/*NOTE:GlobalVariable.TEMP  = GlobalVariable.firstName + UPD
TEMP is used in "memberUpdate" TC to prevent 'firstName' of being overwritten, as
 it's used in delete cases in its initial state*/
for (int i; i < memberTypeId.size(); i++) {
    WebUI.comment("MEMBER ID IS : " + memberTypeId.get(i))
    memberGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Members/MemberGetId', [
		('id') : memberTypeId.get(i)
		]))
	WS.verifyElementPropertyValue(memberGet, 'name', GlobalVariable.TEMP)
	}
	
	
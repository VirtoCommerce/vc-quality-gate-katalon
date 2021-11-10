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
import groovy.json.JsonSlurper


WebUI.comment("TEST CASE: Member update")


'MEMBER DATA STORED IN THE LISTS'
List <String> memberType = GlobalVariable.memberType
List <String> memberId = GlobalVariable.memberId


'SEND REQUEST TO UPDATE MEMBERS FROM LISTS'
//Here TEMP is used to prevent firstName of being overwritten, as
//it's used in delete case in its initial state
GlobalVariable.TEMP  = GlobalVariable.firstName + ' UPD'
//GlobalVariable.contactName  = GlobalVariable.contactName + 'UPD'
for (int i; i < memberId.size(); i++) {
    WebUI.comment("MEMBER ID IS : " + memberId.get(i))
    WebUI.comment("MEMBER TYPE IS : " + memberType.get(i))	
    updateContact = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Members/MemberUpdate', [
		('name') : GlobalVariable.TEMP,
		//('fullName') : GlobalVariable.firstName,
		('id') : memberId.get(i), 
		('memberType') : memberType.get(i)
		]))
}

//
//'VERIFY MEMBERS ARE UPDATED'
//verifyCreated = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberSearch'),
//	null)
//WS.verifyElementPropertyValue(verifyCreated, 'totalCount', 4)
//WS.verifyElementPropertyValue(verifyCreated, 'results[0].name', GlobalVariable.TEMP)
//WS.verifyElementPropertyValue(verifyCreated, 'results[1].name', GlobalVariable.TEMP)
//WS.verifyElementPropertyValue(verifyCreated, 'results[2].name', GlobalVariable.TEMP)
//WS.verifyElementPropertyValue(verifyCreated, 'results[3].name', GlobalVariable.TEMP)



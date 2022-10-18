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


WebUI.comment("TEST CASE: Member delete")


'DELETE MEMBER BY ID FROM LIST'
List <String> memberId = GlobalVariable.memberId


'SEND REQUEST TO DELETE MEMBERS'
for (int i; i < memberId.size(); i++) {
	WebUI.comment("MEMBER ID IS : " + memberId.get(i))
	WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Members/MemberDelete', [
		('id') : memberId.get(i)]))
}


'VERIFY DELETED'
VerifyDeleted = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/MemberSearch'), 
	null)
WS.verifyElementPropertyValue(VerifyDeleted, 'totalCount', 0)


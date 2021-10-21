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

'Delete member by Id from list'
List <String> memberId = GlobalVariable.memberId


'SEND REQUEST TO DELETE MEMBERS'
for (int i; i < memberId.size(); i++) {
	WebUI.comment("MEMBER ID IS : " + memberId.get(i))
	WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Members/MemberDelete', [
		('id') : memberId.get(i)]))
}


'Re-index important to search items'
WebUI.callTestCase(findTestCase('API Coverage/ModuleSearch/DropIndex'), [ : ], FailureHandling.STOP_ON_FAILURE)


'Search new contact. Count 0 in result - contact was deleted'
WebUI.comment("TEST CASE: Member search")
responseSearch = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Members/MemberSearch', [
	('searchPhrase') : GlobalVariable.firstName] ))
WS.verifyElementPropertyValue(responseSearch, 'totalCount', 0)


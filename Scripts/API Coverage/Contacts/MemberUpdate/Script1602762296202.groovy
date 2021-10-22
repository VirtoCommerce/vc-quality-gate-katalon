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
List <String> memberType = GlobalVariable.memberType
List <String> memberId = GlobalVariable.memberId

for (int i; i < memberId.size(); i++) {
    WebUI.comment("MEMBER ID IS : " + memberId.get(i))
    WebUI.comment("MEMBER TYPE IS : " + memberType.get(i))
    GlobalVariable.TEMP  = GlobalVariable.firstName + 'UPD'
updateContact =  WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Members/MemberUpdate', [
		('id') : memberId.get(i), 
		('memberType') : memberType.get(i),
		('name') : GlobalVariable.TEMP
		]))
}
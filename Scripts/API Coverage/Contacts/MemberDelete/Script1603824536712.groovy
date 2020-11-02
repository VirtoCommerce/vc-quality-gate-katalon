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

KeywordUtil.logInfo("Member delete test case")

// TEMP SOLUTION
//def mtid = GlobalVariable.memberId
//    KeywordUtil.logInfo('Delete user type ' + mtid)
//
//    WebUI.comment("TYPE ID IS : " + GlobalVariable.memberId)
//    
//    WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/MemberDelete', [('id') : GlobalVariable.memberId]))
//


List <String> memberTypeId = GlobalVariable.memberId

for (int i; i < memberTypeId.size(); i++) {
    KeywordUtil.logInfo('Delete user type ' + memberTypeId.get(i))

    WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/MemberDelete', [('id') : memberTypeId.get(i)]))
}
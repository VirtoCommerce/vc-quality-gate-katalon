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


WebUI.comment("TEST CASE: Member creation")
List <String> memberType = GlobalVariable.memberType

WebUI.comment("TYPES IS : " + memberType)

for (int i; i < memberType.size(); i++) {
    WebUI.comment('Create user type ' + memberType.get(i))

    def response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/Members/MemberCreate', [('memberType') : memberType.get(i)]))

    def memberJson = new JsonSlurper().parseText(response.getResponseBodyContent())
    (GlobalVariable.memberId[i]) = memberJson.id 
    WebUI.comment(memberType.get(i) + " ID is : " + GlobalVariable.memberId[i])
}
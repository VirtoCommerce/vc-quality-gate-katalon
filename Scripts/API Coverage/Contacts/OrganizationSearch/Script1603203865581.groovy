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
import groovy.json.JsonSlurper as JsonSlurper

KeywordUtil.logInfo('Organization search test case')

response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/Customer management module/DRAFT/OrganizationsSearch'))

//WS.delay(10)

// STEP | Parse request and verify with  GlobalVariable
def responseJson = new JsonSlurper().parseText(response.getResponseBodyContent())
KeywordUtil.logInfo(response.getResponseBodyContent())

KeywordUtil.logInfo('Organization Name: ' + responseJson.results[0].name)
KeywordUtil.logInfo('Organization NameD. Global: ' + GlobalVariable.organizationName)

WS.verifyEqual(responseJson.results[0].name[0], (GlobalVariable.organizationName))
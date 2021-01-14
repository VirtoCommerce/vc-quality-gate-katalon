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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.comment('TEST CASE: Get installed modules')

response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/Platform module/GetInstalledModules'))


WS.verifyElementPropertyValue(response, '[0].title', "Authorize.Net DPM payment gateway")
WS.verifyElementPropertyValue(response, '[0].description', "APIs and UI for Authorize.Net Direct Post Method (DPM) payment gateway")
WS.verifyElementPropertyValue(response, '[0].projectUrl', "https://virtocommerce.com/apps/extensions/authorizenet-dpm-payment-gateway")
WS.verifyElementPropertyValue(response, '[0].requireLicenseAcceptance', false)
WS.verifyElementPropertyValue(response, '[0].releaseNotes', "First version.")
WS.verifyElementPropertyValue(response, '[0].id', "VirtoCommerce.AuthorizeNet")
WS.verifyElementPropertyValue(response, '[0].owners', "[Virto Commerce]")

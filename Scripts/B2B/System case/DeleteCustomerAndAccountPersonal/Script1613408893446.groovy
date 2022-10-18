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


responseSearch = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Customer/Members/MemberSearch', 
        [('searchPhrase') : GlobalVariable.FirstName]))

JsonSlurper slurper = new JsonSlurper()
Map productJson = slurper.parseText(responseSearch.getResponseBodyContent())


println('productJson:' + productJson)
//Block Account
def userName = productJson.results[0].securityAccounts[0].userName
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserDelete', [('userName') : userName]))
//Block Contact
def ContactId = productJson.results[0].id
WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Customer/Members/MemberDelete', [('id') : ContactId]))


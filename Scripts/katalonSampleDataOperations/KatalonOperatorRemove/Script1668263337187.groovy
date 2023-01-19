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


WebUI.comment('TEST CASE: KATALON OPERATOR REMOVE')


'REMOVE OPERATOR'
GlobalVariable.userName = GlobalVariable.katalonUserName
katalonOperatorRemove = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserDelete', [
	('userName') : GlobalVariable.userName]
))


'RUN TOKEN AUTHORIZED INDEXATION'
authorize = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePlatform/Authorization/AuthBackToken'),
	null)
WS.sendRequestAndVerify(findTestObject('Object Repository/API/katalonDataCreation/indexKatalon'))

WebUI.comment('Waiting for drop index 10 sec')

WS.delay(10)

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

WebUI.comment('TEST CASE: categories management - add, update, delete')


'GET CATEGORY TEMPLATE AND EXTRACT CATEGORY CODE'

getCategoryCode = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/categoryGetTemplate'),
	null,
FailureHandling.STOP_ON_FAILURE)


'CREATE NEW CATEGORY'
categoryCreate = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/categoryCreate'),
	null,
FailureHandling.STOP_ON_FAILURE)
WebUI.comment(GlobalVariable.categoryId)


'UPDATE CATEGORY'
updateCategory = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/categoryUpdate'),
	null,
FailureHandling.STOP_ON_FAILURE)


'GET THE CREATED CATEGORY'
categoryGet = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/categoryGetById'),
	null,
FailureHandling.STOP_ON_FAILURE)


'DELETE CATEGORY'
categoryDelete = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/categoryDelete'),
	null,
FailureHandling.STOP_ON_FAILURE)


'VERIFY DELETED'
GlobalVariable.keyword = GlobalVariable.categoryName
verifyDeleted = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/catalogListentriesSearch'),
	null,
FailureHandling.STOP_ON_FAILURE)
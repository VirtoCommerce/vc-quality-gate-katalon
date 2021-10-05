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
categoryCreate = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/_DRAFTX2.categoryCreate'),
	null,
FailureHandling.STOP_ON_FAILURE)
WebUI.comment(GlobalVariable.categoryId)


'UPDATE CATEGORY'
updateCategory = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/_DRAFTX3.categoryUpdate'),
	null,
FailureHandling.STOP_ON_FAILURE)


'GET THE CREATED CATEGORY'
categoryGet = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/_DRAFTX4.categoryGetById'),
	null,
FailureHandling.STOP_ON_FAILURE)


'DELETE CATEGORY'
categoryDelete = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/_DRAFTX5.categoryDelete'),
	null,
FailureHandling.STOP_ON_FAILURE)


'VERIFY DELETED'
GlobalVariable.keyword = GlobalVariable.categoryName
verifyDeleted = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/productsListentriesSearch'),
	null,
FailureHandling.STOP_ON_FAILURE)
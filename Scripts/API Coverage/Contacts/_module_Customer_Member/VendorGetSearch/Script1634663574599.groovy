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


'GET VENDOR DATA FROM DIFFERENT ENDPOINTS'


'DROP INDEX FIRST'
dropIndex = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleSearch/DropIndex'), null)


'GET VENDOR DATA BY ID'
WebUI.comment('Vendor ID : ' + GlobalVariable.memberId[2])
WebUI.comment('TEST CASE : Vendor Get by Id 1 check')
getVendorId = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Vendors/VendorsGetId', [
	('id') : GlobalVariable.memberId[2]
	]))


'GET BULK VENDOR DATA BY IDs'
WebUI.comment('TEST CASE : Vendor Get by Id BULK 2 check')
getVendorIdBulk = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Vendors/VendorsGetIdsBulk', [
	('id') : GlobalVariable.memberId[2],
	('storeId') : GlobalVariable.storeId,
	('parentId') : GlobalVariable.memberId[0]
	]))


'SEARCH VENDOR'
WebUI.comment('TEST CASE : Vendor seach')
searchVendor = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Vendors/VendorsSearch', [
	('searchPhrase') : GlobalVariable.firstName
	]))



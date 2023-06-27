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


WebUI.comment('TEST CASE: KATALON DATA REMOVE')



'GET KATALON CONTACT ID'
katalonContactGetId = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Customer/Members/MemberSearch',[
	('searchPhrase') : GlobalVariable.katalonContactName
	]))
katalonContactId = WS.getElementPropertyValue(katalonContactGetId,'results[0].id')


'DELETE KATALON CONTACT'
katalonContactDelete = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Customer/Members/MemberDelete',[
	('id') : katalonContactId
	]))


'DELETE THE CATALOG'
searchCreated = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsSearch', [
	('keyword') : GlobalVariable.catalogName
	]))
WS.verifyElementPropertyValue(searchCreated, 'results[0].name', GlobalVariable.catalogName)
WS.verifyElementPropertyValue(searchCreated, 'totalCount', 1)
GlobalVariable.catalogId = WS.getElementPropertyValue(searchCreated, 'results[0].id')
WebUI.comment(GlobalVariable.catalogId)

catalogDelete = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CatalogsDeleteById', [
	('id') : GlobalVariable.catalogId
	]))


'REMOVE STORE'
storeDelete = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Store/StoreDelete', [
	('storeId') : GlobalVariable.storeId
	]))


'GET PRICELISTID TO DELETE ITS ASSIGNMENT'
GlobalVariable.pricelistName = 'katalonPricelist'
pricelistGet = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/pricelistGet'),null)
GlobalVariable.pricelistId = WS.getElementPropertyValue(pricelistGet,'results[0].id')


'DELETE PRICELIST ASSIGNMENT'
verifyAssignment = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistAssignmentsSearch'),
	null)
GlobalVariable.assignmentId = WS.getElementPropertyValue(verifyAssignment,'results[0].id')
deleteAssignment = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Pricing/PricelistAssignmentsDelete',[
	('assignmentId') : GlobalVariable.assignmentId
	]))


'VERIFY THE ASSIGNMENT HAS BEEN DELETED'
verifyDeleted = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistAssignmentsSearch'),
	null
	)
WS.verifyElementPropertyValue(verifyDeleted, 'totalCount', '0')


'DELETE THE PRICELIST'
deletePricelist = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Pricing/PricelistDelete',[
	('id') : GlobalVariable.pricelistId
	]))


'VERIFY THE PRICELIST HAS BEEN DELETED'
verifyDeleted = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/pricelistGet'),
	null
	)
WS.verifyElementPropertyValue(verifyDeleted,'totalCount','0')


'RUN TOKEN AUTHORIZED INDEXATION'
authorize = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePlatform/Authorization/AuthBackToken'),
	null)
WS.sendRequestAndVerify(findTestObject('Object Repository/API/katalonDataCreation/indexKatalon'))

WebUI.comment('Waiting for drop index 10 sec')

WS.delay(10)

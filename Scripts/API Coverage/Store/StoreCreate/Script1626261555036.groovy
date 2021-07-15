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

WebUI.comment('TEST CASE: Store. Create/Delete store')

GlobalVariable.storeId = 'qwestore'

//Create a store
store = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Store/StoreCreate',[
	('storeId') : GlobalVariable.storeId,
	('name') : GlobalVariable.storeId,
	('catalogId') : GlobalVariable.catalogId,
	('defaultLanguage') : GlobalVariable.gql_cultureName,
	('defaultCurrency') : GlobalVariable.gql_currencyCode,
	('storeState') : 'Open',
	('languages') : 'fr-FR',
	('currencies') : 'EUR'
	]))

//Check if the new store is in the list of available stores now
getStores = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Store/StoreGetAll'))
WS.verifyElementPropertyValue(getStores, '[3].id', GlobalVariable.storeId)

//Delete the created store
delete = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Store/StoreDelete', [
	('storeId') : GlobalVariable.storeId
	]))

//Search for the created store to verify it was successfully deleted
search = WS.sendRequest(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Store/StoreSearch',[
	('keyword') : GlobalVariable.storeId
	]))
WS.verifyElementPropertyValue(search, 'totalCount', '0')

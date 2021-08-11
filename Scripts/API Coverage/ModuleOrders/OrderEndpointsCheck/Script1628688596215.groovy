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


//SEND REQUEST WITH ORDER DATA TO CREATE AN ORDER
int quantity = 1
orderId = UUID.randomUUID().toString()
order = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderCreate', [
	('orderId') : orderId,
	('quantity') : quantity,
	('userName') : GlobalVariable.userName
	]))
WS.verifyElementPropertyValue(order,'id', orderId)
orderNumber = WS.getElementPropertyValue(order,'number')


//GET ORDER BY NUMBER
orderNumber = WS.getElementPropertyValue(order,'number')
getOrder = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Order/OrderGetByNumber', [
	('orderNumber') : orderNumber
	]))
WS.verifyElementPropertyValue(getOrder,'number', orderNumber)


//GET CHANGES BY ID ENDPOINT CHECK
initialChanges = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderChangesGetById', [
    ('orderId') : orderId
	]))
WS.verifyElementPropertyValue(initialChanges, '[0]', null)


//GET INDEXED SEARCH ENABLE 
indexedSearchState = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Order/OrderIndexedSearchEnabled',))


//DELETE ORDER
deleteOrder = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderDelete', [
	('orderId') : orderId
	]))


//VERIFY DELETION
deletedOrder = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Order/OrderSearch', [
	('keyword') : orderId
	]))
WS.verifyElementPropertyValue(deletedOrder, 'totalCount', '0')

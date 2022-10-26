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

import com.kms.katalon.core.testobject.ResponseObject
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper as JsonSlurper

WebUI.comment('TEST CASE: Link list.')


String menuName = 'QweMenuLink'
GlobalVariable.contentMenuId = UUID.randomUUID()

//Get the list count to get initial state. Set MENU count to compare with final result
int count
getList = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Content/MenuLinkGet', [
	('storeId') : GlobalVariable.storeId
	]))
getListResponse = getList.getResponseBodyContent()
println getListResponse 
if (getListResponse == "") {
	count = 0
	println "initial count is '0'"
} else {
	count = WS.getElementsCount(getList, "")
	println "initial count is: " + count
}


//Check if the menuName we are going to use is vacant or not
checkName = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/MenuLinkCheckname', [
	('storeId') : GlobalVariable.storeId,
	('menuName') : menuName
	]))
WS.verifyElementPropertyValue(checkName, 'result' , 'true')


//Create a list and a link 
list = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/MenuLinkCreateUpdate',[
	('storeId') : GlobalVariable.storeId,
	('menuName') : menuName,
	('menuListId') : GlobalVariable.contentMenuId
	]))


//Get the list data to verify that the added link exists
getList = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Content/MenuLinkGet', [
	('storeId') : GlobalVariable.storeId
	]))
WS.containsString(getList, menuName, false)


//Verify the created list exists
listVerification = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/MenuLinkIdGet',[
	('storeId') : GlobalVariable.storeId,
	('menuListId') : GlobalVariable.contentMenuId
	]))


//Rename a link
newMenuName = menuName + 'Renamed'
rename = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/MenuLinkCreateUpdate',[
	('storeId') : GlobalVariable.storeId,
	('menuName') : newMenuName,
	('menuListId') : GlobalVariable.contentMenuId
	]))


//Check if the new name is occupied
checkRename = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Content/MenuLinkCheckname', [
	('storeId') : GlobalVariable.storeId,
	('menuName') : newMenuName
	]))
WS.verifyElementPropertyValue(checkRename, 'result' , 'false')


//Delete the created list
delete = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/MenuLinkDelete' , [
	('menuListId') : GlobalVariable.contentMenuId
	]))


//Verify the created list was successfully deleted
deleteVerification = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Content/MenuLinkIdGet',[
	('storeId') : GlobalVariable.storeId,
	('menuListId') : GlobalVariable.contentMenuId
	]))
WS.verifyResponseStatusCode(deleteVerification, 500)


//Get the count list state after delete. Compare with start result
int finalCount
getListFinal = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Content/MenuLinkGet', [
	('storeId') : GlobalVariable.storeId
	]))
getListFinalResponse = getListFinal.getResponseBodyContent()
println getListFinalResponse 
if (getListFinalResponse == "") {
	finalCount = 0
	println "final count is '0'"
} else {
	finalCount = WS.getElementsCount(getListFinal, "")
	println "final count is: " + finalCount
}
assert count == finalCount


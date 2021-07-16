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

WebUI.comment('TEST CASE: Link list.')

//Create a list and a link 
list = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/MenuLinkUpdate',[
	('storeId') : GlobalVariable.storeId,
	('menuName') : GlobalVariable.menuName,
	('menuListId') : GlobalVariable.menuListId
	]))

//Verify the created list exists
listVerification = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/MenuLinkIdGet',[
	('storeId') : GlobalVariable.storeId,
	('menuListId') : GlobalVariable.menuListId
	]))

//Get the list data to verify that the added link exists
getList = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/MenuLinkGet', [
	('storeId') : GlobalVariable.storeId
	]))
WS.containsString(getList, 'QweLinkTitle 2', false)

//Delete the created list
delete = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/MenuLinkDelete' , [
	('menuListId') : GlobalVariable.menuListId
	]))

//Verify the created list was successfully deleted
deleteVerification = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Content/MenuLinkIdGet',[
	('storeId') : GlobalVariable.storeId,
	('menuListId') : GlobalVariable.menuListId
	]))
WS.verifyResponseStatusCode(deleteVerification, 500)

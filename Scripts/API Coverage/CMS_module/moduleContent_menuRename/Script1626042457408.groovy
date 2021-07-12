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

WebUI.comment('TEST CASE: Rename a link.')

//Check if the menuName we are going to use is vacant or not
checkName = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/MenuLinkCheckname', [
	('storeId') : GlobalVariable.storeId,
	('menuName') : GlobalVariable.menuName 
	])) 

nameVerification = WS.verifyElementPropertyValue(checkName, 'result' , 'true')

//Create a menu link
list = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/MenuLinkUpdate',[
	('storeId') : GlobalVariable.storeId,
	('menuName') : GlobalVariable.menuName,
	('menuListId') : GlobalVariable.menuListId
	]))

//Rename a link
list = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/MenuLinkUpdate',[
	('storeId') : GlobalVariable.storeId,
	('menuName') : 'renamed',
	('menuListId') : GlobalVariable.menuListId
	]))

//Check if the new name is not vacant
checkRename = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Content/MenuLinkCheckname', [
	('storeId') : GlobalVariable.storeId,
	('menuName') : 'renamed'
	]))

renameVerification = WS.verifyElementPropertyValue(checkRename, 'result' , 'false')
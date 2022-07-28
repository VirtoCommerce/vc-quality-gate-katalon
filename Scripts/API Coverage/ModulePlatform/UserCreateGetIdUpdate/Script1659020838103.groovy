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

WebUI.comment('TEST CASE: Create and update')


'GENERATE UNIQUE EMAIL'
GlobalVariable.email = new Random().nextInt(100)+'@email.com'


'CREATE USER'
userCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserCreate', [
	('email') : GlobalVariable.email, 
	('userName') : GlobalVariable.userName,
	('userType') : 'Customer'//hardcoded as user can not be manually created with any other userType
	]))
WS.verifyElementPropertyValue(userCreate, 'succeeded', true)


'SEARCH FOR THE CREATED USER'
userSearch = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserSearch', [
	('searchPhrase') : GlobalVariable.userName
	]))
WS.verifyElementPropertyValue(userSearch, 'users[0].userName', GlobalVariable.userName)
WS.verifyElementPropertyValue(userSearch, 'users[0].emailConfirmed', 'true', FailureHandling.STOP_ON_FAILURE)


'GET CREATED USER ID'
GlobalVariable.userId = WS.getElementPropertyValue(userSearch, 'users[0].id')
WebUI.comment('USER ID is: ' + GlobalVariable.userId)


'UPDATE THE CREATED USER'
//GlobalVariable.userName = GlobalVariable.userName + "UPD"
GlobalVariable.email = "Updated" + GlobalVariable.email
userUpdate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserUpdate', [
	('userName') : GlobalVariable.userName,
	('email') : GlobalVariable.email,
	('userId') : GlobalVariable.userId,
	('userType') : GlobalVariable.userType,
	('isAdministrator') : GlobalVariable.isAdminStatus,
	('emailConfirmed')	: 'false',
	('roles') : GlobalVariable.roleFull
	]))
WS.verifyElementPropertyValue(userUpdate, 'succeeded', true)









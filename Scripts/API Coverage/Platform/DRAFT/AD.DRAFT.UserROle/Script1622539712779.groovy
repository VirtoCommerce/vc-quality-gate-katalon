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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


WebUI.comment('TEST CASE: Create new user')

// create unique email
GlobalVariable.email = new Random().nextInt(100)+'@email.com'
response1 = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserCreate', [
	('email') : GlobalVariable.email,
	('userName') : GlobalVariable.userName
	]))
WS.verifyElementPropertyValue(response1, 'succeeded', true)



userByName = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserGetUserByName', [
	('userName') : GlobalVariable.userName
	]))
//WS.verifyElementPropertyValue(userByName, 'id', GlobalVariable.userId)
GlobalVariable.userId = WS.getElementPropertyValue(userByName, 'id')



WebUI.comment('TEST CASE: Create new role')
response2 = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/RolesAdd', [
	('name') : GlobalVariable.roleName
	]))
WS.verifyElementPropertyValue(response2, 'succeeded', true)



WebUI.comment('TEST CASE: Get role by Name')
//make sure tha role created and set roleID to global Variables
response3 = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/RolesByName', [
	('roleName') : GlobalVariable.roleName
	]))
GlobalVariable.roleId = WS.getElementPropertyValue(response3, 'id')



responseUp = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/RolesUpdate', [
	('id') : GlobalVariable.roleId,
	('name') : GlobalVariable.roleName,
	('description') : 'Description Updated',
	('permissions') : GlobalVariable.rolePermission
	]))
WS.verifyElementPropertyValue(responseUp, 'succeeded', true)



WebUI.comment('TEST CASE: Get role by Name')
//make sure tha role created and set roleID to global Variables
response3 = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/RolesByName', [
	('roleName') : GlobalVariable.roleName
	]))
GlobalVariable.roleFull = response3.getResponseText()
WebUI.comment(GlobalVariable.roleFull)



WebUI.comment('TEST CASE: Update userName/email/userType')
//set new userName in global variables
GlobalVariable.userName = GlobalVariable.userName + "Updated"
GlobalVariable.email = "Updated" + GlobalVariable.email
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserUpdate', [
	('userName') : GlobalVariable.userName,
	('email') : GlobalVariable.email,
	('userId') : GlobalVariable.userId,
	('userType') : 'Manager',
	('emailConfirmed')	: 'false',
	('roles') : GlobalVariable.roleFull
	]))
WS.verifyElementPropertyValue(response, 'succeeded', true)

//{
//	"description": "Description Updated",
//	"permissions": [],
//	"id": "${roleId}",
//	"name": "RoleNameAPIUpdated",
//	"normalizedName": "ROLENAMEAPIUPDATED",
//	"concurrencyStamp": "21841004-37db-4b22-a5aa-2805cf6dcb90",
//  }

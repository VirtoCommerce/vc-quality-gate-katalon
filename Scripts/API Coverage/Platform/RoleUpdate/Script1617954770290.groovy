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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.comment('TEST CASE: Update role')

//get variable to create API request
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/RoleByName', [('roleName') : 'RoleNameAPI']))
String id,stamp,name
id = WS.getElementPropertyValue(response, 'id')
name = WS.getElementPropertyValue(response, 'name')

//API to update roles information
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/RolesUpdate', 
	[('name') : name, 
	 ('id') : id, 
	 ('concurrencyStamp') : stamp,
	 ('permissions') : '[]', 
	 ('description') : 'description updated']))

WS.verifyElementPropertyValue(response, 'succeeded', true)

//make sure tha role updated, get update role
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/RoleByName', [('roleName') : 'RoleNameAPI']))

//verify that received requested user
WS.verifyElementPropertyValue(response, 'description', 'description updated')
/*WebUI.comment(GlobalVariable.roleID)
String res = response.getResponseText()
WebUI.comment(res)
*/

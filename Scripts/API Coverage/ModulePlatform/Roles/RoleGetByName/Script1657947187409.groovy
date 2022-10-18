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

WebUI.comment('TEST CASE: Get role by Name')

// verify that role updated and has an new assigned permissons
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/RolesByName', [
	('roleName') : GlobalVariable.roleName
	]))
WS.verifyElementPropertyValue(response, 'description', 'Description Updated')
WS.verifyElementPropertyValue(response, 'permissions[0].id', "security:call_api")
WS.verifyElementPropertyValue(response, 'permissions[0].name', "security:call_api")
WS.verifyElementPropertyValue(response, 'permissions[0].assignedScopes', '[]')
WS.verifyElementPropertyValue(response, 'permissions[0].availableScopes', '[]')

// set roleId
GlobalVariable.roleId = WS.getElementPropertyValue(response, 'id')
// set full role JSON (could be used to assign it to user)
GlobalVariable.roleFull = response.getResponseText()
WebUI.comment(GlobalVariable.roleFull)
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


'PRECONDITION'
'First create a user'
userCreate = WS.callTestCase(findTestCase('API Coverage/ModulePlatform/UserCreate'),
	null)
'Get the created user by name id'
getUserId = WS.callTestCase(findTestCase('API Coverage/ModulePlatform/UserSearchSetUserID'),
	null)
'Authorize and get the auth token'
auth = WS.callTestCase(findTestCase('API Coverage/ModulePlatform/AuthBackToken'),
	null)
'****************'


s1 = WS.callTestCase(findTestCase('API Coverage/ModulePlatform/UserLock/userCreateWithActivateLockSwitching')
	,null)
s2 = WS.callTestCase(findTestCase('API Coverage/ModulePlatform/UserLock/UserLock_apiKeyIsActive')
		,null)
s3 = WS.callTestCase(findTestCase('API Coverage/ModulePlatform/UserLock/UserLock_apiKeyIsInactive')
		,null)
s4 = WS.callTestCase(findTestCase('API Coverage/ModulePlatform/UserLock/UserLock_userDeleted')
		,null)

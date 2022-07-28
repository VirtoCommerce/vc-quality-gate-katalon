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


import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonOutput
import com.kms.katalon.core.testobject.ResponseObject




WS.callTestCase(findTestCase('API Coverage/ModulePlatform/UserGetAllRequestsCheck'),
	    null)
WS.callTestCase(findTestCase('API Coverage/ModulePlatform/UserCreateAndGetId'),
	null)
//WS.callTestCase(findTestCase('API Coverage/ModulePlatform/UserCreateAlreadyExisted'),
//		null)
//WS.callTestCase(findTestCase('API Coverage/ModulePlatform/UserSendVerifictaionEmail'),
//		null)
//WS.callTestCase(findTestCase('API Coverage/ModulePlatform/UserPassword/UserPasswordValidate'),
//		null)
//WS.callTestCase(findTestCase('API Coverage/ModulePlatform/UserPassword/UserPasswordResetOnLoginPage/UserPasswordResetOnLoginPageConfirm'),
//		null)
//WS.callTestCase(findTestCase('API Coverage/ModulePlatform/UserPassword/UserPasswordOperationsAdminPath'),
//		null)
//WS.callTestCase(findTestCase('API Coverage/ModulePlatform/UserPassword/UserPasswordOperationsCurrentUser'),
//		null)
WS.callTestCase(findTestCase('API Coverage/ModulePlatform/UserDelete'),
		null)

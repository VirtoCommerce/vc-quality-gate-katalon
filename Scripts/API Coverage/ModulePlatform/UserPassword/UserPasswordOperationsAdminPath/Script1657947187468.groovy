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


WebUI.comment('TEST CASE: Change or edit password as admin')


'CHECK NEGATIVE PASSWORD CHANGE SCENARIOS (invalid/old passwords)'
//use map to cover both scenarios in a single loop
HashMap<String, String> passwordsMap = [ 'Password0' : 'Incorrect password.', 'Password1!' : 'You have used this password in the past. Choose another one.']
for (String password : passwordsMap.keySet()) {
passwordChangeNegative = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserPassword/UserPasswordChangeByUserName',[
	 ('userName') : GlobalVariable.userName,
	 ('oldPassword') : password,
	 ('newPassword') : passwordsMap.keySet().toArray()[1],
	 ]))
response = passwordChangeNegative.getResponseBodyContent()
WS.verifyElementPropertyValue(passwordChangeNegative,'errors[0]',passwordsMap.get(password))
WebUI.comment('Password: "' + password + '"' +  ' and the related message: "' + passwordsMap.get(password) + '"' + ' are confirmed to work as expected')
}


'RESET USER PASSWORD'
passwordResetValue = GlobalVariable.userPassword + '!'
passwordReset = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserPassword/UserPasswordReset',[
	('newPassword') : passwordResetValue,
	('userName') : GlobalVariable.userName
	]))
WS.verifyElementPropertyValue(passwordReset, 'succeeded', true)


'VERIFY LOGIN BEHAVIOR AFTER PASSWORD RESET'//both new and old password scenarios are checked
passwordsList = [GlobalVariable.userPassword, passwordResetValue]
for (int a; a < passwordsList.size(); a++) {
	loginAfterChange = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Platform/UserLogin(generic)',[
		('userName') : GlobalVariable.userName,
		('userPassword') : passwordsList[a]
		]))
	if (passwordsList[a] == passwordResetValue) {
		WS.verifyElementPropertyValue(loginAfterChange, 'succeeded', true)	
	} else {
	  WS.verifyElementPropertyValue(loginAfterChange, 'succeeded', false)
	}
}


//As admin change user password by userName
'CHANGE PASSWORD BY USERNAME (set back to the initial)'
paswordChangeGeneric = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserPassword/UserPasswordChangeByUserName',[
	 ('userName') : GlobalVariable.userName,
	 ('oldPassword') : passwordResetValue,
	 ('newPassword') : GlobalVariable.userPassword,
	 ]))
WS.verifyElementPropertyValue(paswordChangeGeneric, 'succeeded', true)


'VERIFY LOGIN BEHAVIOR AFTER PASSWORD CHANGE'
for (int b; b < passwordsList.size(); b++) {
	loginAfterChange = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Platform/UserLogin(generic)',[
		('userName') : GlobalVariable.userName,
		('userPassword') : passwordsList[b]
		]))
	if (passwordsList[b] == GlobalVariable.userPassword) {
		WS.verifyElementPropertyValue(loginAfterChange, 'succeeded', true)	
	} else {
	  WS.verifyElementPropertyValue(loginAfterChange, 'succeeded', false)
	}
}


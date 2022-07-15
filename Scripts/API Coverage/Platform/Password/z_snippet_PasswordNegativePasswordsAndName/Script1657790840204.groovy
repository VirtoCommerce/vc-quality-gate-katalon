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

userNameList = [GlobalVariable.userName, 'invalidUserName']
HashMap<String, String> passwordsMap = [ 'Password0' : 'Incorrect password.', 'Password1!' : 'You have used this password in the past. Choose another one.']
for (int a; a < userNameList.size();a++) {
	if (userNameList[a] == GlobalVariable.userName) {
		for (String password : passwordsMap.keySet()) {
		passwordChangeWrongPasswords = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Platform/_Password/PasswordChangeByUserName',[
			 ('userName') : GlobalVariable.userName,
			 ('oldPassword') : password,
			 ('newPassword') : passwordsMap.keySet().toArray()[1],
			 ]))
		WS.verifyElementPropertyValue(passwordChangeWrongPasswords,'errors[0]',passwordsMap.get(password))
		println 'Password: "' + password + '"' +  ' and the related message: "' + passwordsMap.get(password) + '"' + ' are confirmed to work as expected'
		//WebUI.comment('Password: "' + password + '"' +  ' and the related message: "' + passwordsMap.get(password) + '"' + ' are confirmed to work as expected')
		}
	} else {
	  passwordChangeWrongUserName = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Platform/_Password/PasswordChangeByUserName',[
		     ('userName') : userNameList[a],
			 ('oldPassword') : GlobalVariable.userPassword,
			 ('newPassword') : 'newPassword',
			 ]))
//	 response = new JsonSlurper().parseText(passwordChangeWrongUserName.getResponseBodyContent())
//	 json = new groovy.json.JsonBuilder(response).toString()
//	 println json
	 WS.verifyElementPropertyValue(passwordChangeWrongUserName,'succeeded', false)
	 println 'Not able to change password for username: ' + '"' + userNameList[a] + '"'
	 }
}


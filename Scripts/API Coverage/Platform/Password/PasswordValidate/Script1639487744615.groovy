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

WebUI.comment('TEST CASE: password validation check')


'PREPARE A MAP OF PASSWORD PARAMETERS'
HashMap<String, String> passwordsMap = GlobalVariable.passwordsListContent


'CRETE LOOP TO VALIDATE PAIRS OF RELATED PASSWORDS/ERROR-MESSAGES BY LOOP ITERATIONS'
for (String password : passwordsMap.keySet()) {
	validatePassword = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/_Password/PasswordValidate', [
		('password') : password
		]))
	WS.containsString(validatePassword, passwordsMap.get(password), false)
	WebUI.comment('Password: ' + password + ' and the related message: "' + passwordsMap.get(password) + '" are validated')
}


'REPEAT THE SAME OPERATION, BUT THIS TIME FOR ANOTHER VALIDATION ENDPOINT'
for (String password : passwordsMap.keySet()) {
	validatePassword = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Platform/_Password/PasswordValidateUser', [
		('newPassword') : password,
		('userName') : GlobalVariable.userName
		]))
	WS.containsString(validatePassword, passwordsMap.get(password), false)
	WebUI.comment('Password: ' + password + ' and the related message: "' + passwordsMap.get(password) + '" are validated')
}


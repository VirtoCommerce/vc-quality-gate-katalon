import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


WebUI.comment('TEST CASE: create katalon test operator user')


'GET TOKEN'
WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePlatform/Authorization/AuthBackToken'),
	null)


'PREPARE DATA FOR KATALON OPERATOR ACCOUNT'
//GlobalVariable.email = Randomly generated in userCreate
GlobalVariable.userName = GlobalVariable.katalonUserName
GlobalVariable.userType = 'SiteAdministrator'
GlobalVariable.isAdministratorStatus = true


'CREATE USER'
WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePlatform/UserCreate'),
	null)


'UPDATE USER'
WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePlatform/UserUpdate'),
	null)


'SET OPERATOR API KEY'
WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePlatform/ApiKeySet'),
	null)






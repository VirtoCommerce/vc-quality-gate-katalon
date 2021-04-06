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

WebUI.comment('TEST CASE: Create new user')

/*response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AccountCreateUser', 
	[('userType') : 'Customer',
	 ('email') : 'qwer@qwer.qwe', 
	 ('userName') : GlobalVariable.userName, 
	 ('storeId') : GlobalVariable.storeId, 
	 ('contactId') : GlobalVariable.contactId
	 ]))
*/
Random rnd = new Random()
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AccountCreateUser', 
	[('email') : rnd.nextInt(100)+'@email.com', 
	 ('userName') : GlobalVariable.userName, 
	 ('storeId') : GlobalVariable.storeId, 
	 ('contactId') : GlobalVariable.contactId
	]))


WS.verifyElementPropertyValue(response, 'succeeded', false)



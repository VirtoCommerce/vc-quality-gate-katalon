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

'1'
createMembers = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberCreation'),
	null)

'2 - Index step has been moved to "3""'


'3'
'???SPLIT THIS STEP???'
getSearch = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/VendorGetSearch'),
null)


'4'
getAllInOrganizations = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberGetAllInOrganizations'),
null)


'5'
getOrgs = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberGetOrganizations'),
null)


'6'
memberSearch = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberSearch'),
	null)


'7'
WS.delay(10)


'8'
memberUpdate = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberUpdate'),
	null)

'9'
WS.delay(10)


'10'
memberGitId = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberGitId'),
	null)


'11'
'???SPLIT THIS STEP???'
memberDelete = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberDelete'),
	null)


'12'
memberCreationBulk = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberCreationBulk'),
	null) 	


'13' 
'dropindex is in 12 test'


'14' 
'I just left it the way it originally was, as it got me frustrated'
memberUpdateBulk = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberUpdateBulk'),
	null) 	

'15'
memberGitIdGroup = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MembersGitIdGroup'),
	null) 	


'16' 
memberDeleteBulk = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberDeleteBulk'),
	null) 	


'17'
createOrgWithAccount = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberCreationInOrgWithAccount'),
	null)


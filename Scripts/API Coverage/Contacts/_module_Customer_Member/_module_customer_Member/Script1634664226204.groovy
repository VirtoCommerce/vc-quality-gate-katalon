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


'2'
getSearch = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/VendorGetSearch'),
null)


'3'
getAllInOrganizations = WS.callTestCase(findTestCase('API Coverage/Contacts/_module_Customer_Member/MemberGetAllInOrganizations'),
null)


'4'
getOrgs = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberGetOrganizations'),
null)


'5'
memberUpdate = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberUpdate'),
	null)

//memberUpdateDebug = WS.callTestCase(findTestCase('Test Cases/_DEBUG/_debug'),
//	null)


'6'
memberGitId = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberGitId'),
	null)


'7'
memberDelete = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberDelete'),
	null)


'8!!!!!!!'
memberCreationBulk = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberCreationBulk'),
	null) 	


'9' 
memberUpdateBulk = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberUpdateBulk'),
	null) 		


'10' 
memberDeleteBulk = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberDeleteBulk'),
	null) 	


'11'
createOrgWithAccount = WS.callTestCase(findTestCase('Test Cases/API Coverage/Contacts/_module_Customer_Member/MemberCreationInOrgWithAccount'),
	null)


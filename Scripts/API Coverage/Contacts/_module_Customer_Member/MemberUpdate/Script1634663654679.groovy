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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import groovy.json.JsonSlurper


WebUI.comment("TEST CASE: Member update")


'MEMBER DATA STORED IN THE LISTS'
List <String> memberType = GlobalVariable.memberType
List <String> memberId = GlobalVariable.memberId
List <String> addressTypes = GlobalVariable.addressTypes


'CREATE ADDRESSES TEMPLATE'
List <Object>addressesList = []
for (int b = 0; b < addressTypes.size(); b++) {
	addressDataTemplate = new File('Data Files/addressDataTemplate.json').text
	addressDataTemplateDefault = new JsonSlurper().parseText(addressDataTemplate)
	addressDataTemplateDefault.isDefault = 'true'
	addressDataTemplateDefault.addressType = addressTypes.get(b)
	
	addressDataTemplate = new JsonSlurper().parseText(addressDataTemplate)
	addressDataTemplate.isDefault = 'false'
	addressDataTemplate.addressType = addressTypes.get(b)
	
	addressDataDefault = new groovy.json.JsonBuilder(addressDataTemplateDefault)
	addressData = new groovy.json.JsonBuilder(addressDataTemplate)
	println addressDataDefault
	println addressData

	addressesList.add(addressDataDefault)
	addressesList.add(addressData)
		}
		addressesString = addressesList.toString()
		String regex = "\\[|\\]";
		addresses = addressesString.replaceAll(regex, "");
		System.out.println(addresses);
		

'UPDATE CREATED ACCOUNTS'
for (int c; c < memberId.size(); c++) {
	WebUI.comment("MEMBER ID IS : " + memberId.get(c))
	WebUI.comment("MEMBER TYPE IS : " + memberType.get(c))
	GlobalVariable.updatedMemberName  = GlobalVariable.firstName + 'UPD'
updateContact =  WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Customer/Members/MemberUpdate', [
		('id') : memberId.get(c),
		('memberType') : memberType.get(c),
		('name') : GlobalVariable.updatedMemberName,
		('addresses')  : addresses
		]))
}


'VERIFY ACCOUNTS ARE  UPDATED'
for (int d; d < addressTypes.size(); d++) {
	for(int e; e < memberId.size(); e++) {
	membersGetAll = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Members/MemberGetId', [
		('id') : memberId.get(e)
		]))
	memberData = new JsonSlurper().parseText(membersGetAll.getResponseBodyContent())
	List addressesGet = memberData.addresses
	def x
	for (int f; f < addressesGet.size(); f++) {
	if (addressesGet[f].addressType == addressTypes[d] && addressesGet[f].isDefault == true) {
		println 'match ' + addressTypes[d] + ' ' + addressesGet[f].isDefault
		x = addressesGet[f].isDefault
		break
		} else {
			println 'no match ' + addressTypes[d] + ' ' + addressesGet[f].isDefault}
			}
	assert x == true
	}
}
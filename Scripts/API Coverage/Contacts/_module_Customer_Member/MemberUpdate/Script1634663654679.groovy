import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonSlurper
import internal.GlobalVariable


WebUI.comment("TEST CASE: Member update")


'MEMBER DATA STORED IN THE LISTS'
List <String> memberType = GlobalVariable.memberType
List <String> memberId = GlobalVariable.memberId
List <String> addressTypes = GlobalVariable.addressTypes



List <Object>addressesList = []
for (int b; b < addressTypes.size(); b++) {
	//create both variations for each address type, ecept Billing and Shipping, as it can only be
	//is default = false
	//collect each created variation into the list
	addressDataTemplate = new File('TestDataFiles/addressDataTemplate.json').text
	if(addressTypes.get(b) != 'BillingAndShipping') {
	addressDataTemplateDefault = new JsonSlurper().parseText(addressDataTemplate)
	addressDataTemplateDefault.isDefault = 'true'
	addressDataTemplateDefault.addressType = addressTypes.get(b)
	
	addressDataTemplate = new JsonSlurper().parseText(addressDataTemplate)
	addressDataTemplate.isDefault = 'false'
	addressDataTemplate.addressType = addressTypes.get(b)
	
	addressDataDefault = new groovy.json.JsonBuilder(addressDataTemplateDefault)
	addressData = new groovy.json.JsonBuilder(addressDataTemplate)
	addressesList.add(addressDataDefault)
	addressesList.add(addressData)
	
		} else {
		addressDataTemplate = new JsonSlurper().parseText(addressDataTemplate)
		addressDataTemplate.isDefault = 'false'
		addressDataTemplate.addressType = addressTypes.get(b)
		addressData = new groovy.json.JsonBuilder(addressDataTemplate)
		addressesList.add(addressData)
		}}

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
//for each member get all addresses and verify, that
//Billing and Shipping types have at isDefault = true address and
// that BillingAndShipping is false
List addressStatus = []
	for(int e; e < memberId.size(); e++) {
	membersGetAll = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Customer/Members/MemberGetId', [
		('id') : memberId.get(e)
		]))
	memberData = new JsonSlurper().parseText(membersGetAll.getResponseBodyContent())
	List addressesGet = memberData.addresses
	for (int f; f < addressesGet.size(); f++) {
 	 	if (addressesGet[f].addressType == 'BillingAndShipping') {
			  assert addressesGet[f].isDefault == false		  
	} else if (addressesGet[f].addressType != 'BillingAndShipping') {
		//println addressesGet[f].addressType + ' ' + addressesGet[f].isDefault
		String pair = addressesGet[f].addressType + ', ' + addressesGet[f].isDefault
		addressStatus.add(pair)
		}
	}	
	assert addressStatus.contains('Shipping, true') && addressStatus.contains('Billing, true')
	}

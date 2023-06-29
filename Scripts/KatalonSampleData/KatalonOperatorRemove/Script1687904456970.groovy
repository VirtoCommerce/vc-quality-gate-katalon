import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable as GlobalVariable

'REMOVE OPERATOR'
GlobalVariable.userName = GlobalVariable.katalonUserName
katalonOperatorRemove = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/UserDelete', [
	('userName') : GlobalVariable.userName]
))
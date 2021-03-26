import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable



WebUI.comment('TEST CASE: Assets. Create new folder')
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetCreateBlobFolder', [('folderName') : GlobalVariable.folderName, ('parentUrl') : '']))
//save folder URL
folderUrl = GlobalVariable.localUrl + '/' + GlobalVariable.folderName



//WebUI.comment('TEST CASE: Assets. Check list on CI environment. Added /assets in url')
//assetsList = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetGetList', [
//	('folderName') : GlobalVariable.localUrl+'/assets'
//	]))
////check if new folder in the list
//WS.verifyElementPropertyValue(assetsList, 'results[1].name', GlobalVariable.folderName)
////save folder URL
//folderUrl = GlobalVariable.localUrl+'/assets/'+GlobalVariable.folderName


 
WebUI.comment('TEST CASE: Assets. Upload file by URL')
uploadRequest = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetFileUpload', [
	('folderUrl') : folderUrl, 
	('url') : 'https://github.com/VirtoCommerce/vc-module-cart/releases/download/3.15.0/VirtoCommerce.Cart_3.15.0.zip'
	]))
//get file url 
uploadFileUrl = WS.getElementPropertyValue(uploadRequest, '[0].url')



//WebUI.comment('TEST CASE: Assets. Upload file from local')
//uploadFileLocal = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetFileUpload', [
//	('folderUrl') : folderUrl
//	]))



WebUI.comment('TEST CASE: Assets. Check list on QA environment. Without /assets in url')
getList = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetGetList', [('folderName') : folderUrl]))
WS.verifyElementPropertyValue(getList, 'totalCount', 1)



WebUI.comment('TEST CASE: Assets. Check access to file')
fileAccessA = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetFileAccess', [('fileUrl') : uploadFileUrl]))
WS.verifyResponseStatusCode(fileAccessA, 200)


//WS.delay(10)
WebUI.comment('TEST CASE: Assets. Delete file')
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetDelete', [('itemName') : uploadFileUrl]))



WebUI.comment('TEST CASE: Assets. Check access to file')
fileAccessB = WS.sendRequest(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetFileAccess', [('fileUrl') : uploadFileUrl]))
WS.verifyResponseStatusCode(fileAccessB , 404)



WebUI.comment('TEST CASE: Assets. Delete folder')
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetDelete', [('itemName') : folderUrl]))



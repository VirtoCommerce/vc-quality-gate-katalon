import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable



WebUI.comment('TEST CASE: Assets. Create new folder')
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetCreateBlobFolder', [
	('folderName') : GlobalVariable.folderName,
	('parentUrl') : ''
	]))



WebUI.comment('TEST CASE: Assets. Check list on CI environment. Added /assets in url')
assetsList = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetGetList', [
	('folderName') : GlobalVariable.localUrl+'/assets'
	]))
//check if new folder in the list
WS.verifyElementPropertyValue(assetsList, 'results[1].name', GlobalVariable.folderName)
//save folder URL
folderUrl = GlobalVariable.localUrl+'/assets/'+GlobalVariable.folderName


 
//WebUI.comment('TEST CASE: Assets. Check list on QA environment. Without /assets in url')
//WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetGetList', [('folderName') : '${GlobalVariable.localUrl}/${GlobalVariable.folderName}']))



WebUI.comment('TEST CASE: Assets. Upload file by URL')
uploadFileUrl = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetUploadFile', [
	('folderUrl') : folderUrl, 
	('url') : 'https://github.com/VirtoCommerce/vc-module-cart/releases/download/3.15.0/VirtoCommerce.Cart_3.15.0.zip'
	]))
//save uploaded file name 
fileNameUrl = WS.getElementPropertyValue(uploadFileUrl, '[0].name')



WebUI.comment('TEST CASE: Assets. Upload file from local')
uploadFileLocal = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetUploadFile', [
	('folderUrl') : folderUrl
	]))



//WS.delay(10)
WebUI.comment('TEST CASE: Assets. Delete file')
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetDelete', [
	('folderName') : folderUrl + '/' + fileNameUrl
]))



WebUI.comment('TEST CASE: Assets. Delete folder')
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetDelete', [
	('folderName') : folderUrl 
]))


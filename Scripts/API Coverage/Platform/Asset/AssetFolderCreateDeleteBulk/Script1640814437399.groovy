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


WebUI.comment('TEST CASE: Assets. Bulk delete folders')

//WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DRAFT/Assets/AssetCreateBlobFolder', [
//	('folderName') : "store"
//	]))

// Create new folders
for (i = 1; i < 3; i++ ) {
	WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DRAFT/Assets/AssetCreateBlobFolder', [
		('folderName') : GlobalVariable.folderName + i,
		('parentUrl') : GlobalVariable.folderParentUrl
		]))
	WebUI.comment(GlobalVariable.folderParentUrl)
}

//TEMP
WebUI.comment(GlobalVariable.folderParentUrl)
getAssetList = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DRAFT/Assets/AssetGetList', [
	('folderName') : GlobalVariable.folderParentUrl,
	('keyword') : ''
	]))
def folderUrl1 = WS.getElementPropertyValue(getAssetList, "results[0].relativeUrl")
WebUI.comment(folderUrl1)
def folderUrl2 = WS.getElementPropertyValue(getAssetList, "results[1].relativeUrl")



//// Find created folders in the list
//WebUI.comment(GlobalVariable.folderName)
//folderList = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DRAFT/Assets/AssetGetList', [
//	('folderName') : GlobalVariable.folderName
//	]))
////WS.verifyElementPropertyValue(folderList, 'totalCount', '2')
//
//
//// Save folder Url's
//def folderUrl1 = GlobalVariable.folderParentUrl + GlobalVariable.folderName + 1
//WebUI.comment(folderUrl1)
//def folderUrl2 = GlobalVariable.folderParentUrl + GlobalVariable.folderName + 2


// Bulk delete of both folders using folderUrls's
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DRAFT/Assets/AssetDeleteBulk', [
	('itemName1') : folderUrl1, 
	('itemName2') : folderUrl2
	]))

'SEND REQUEST TO DELETE A STORE FOLDER'
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DRAFT/Assets/AssetDelete', [
	('itemName') : "stores"
	]))

// Check that folders are deleted
WebUI.comment(GlobalVariable.folderName)
folderList = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/DRAFT/Assets/AssetGetList', [
	('keyword') : ''
	]))
WS.verifyElementPropertyValue(folderList, 'totalCount', '2')


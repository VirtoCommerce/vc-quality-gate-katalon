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

// Create new folders
for (i = 1; i < 3; i++ ) {
	WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/_DRAFT/Assets/AssetCreateBlobFolder', [
		('folderName') : GlobalVariable.folderName + i,
		('parentUrl') : GlobalVariable.folderParentUrl
		]))
}


// Find created folders in the list
WebUI.comment(GlobalVariable.folderParentUrl)
folderList = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/_DRAFT/Assets/AssetGetList', [
	('folderName') : GlobalVariable.folderParentUrl
	]))
WS.verifyElementPropertyValue(folderList, 'totalCount', '2')

def folderUrl1 = WS.getElementPropertyValue(folderList, "results[0].relativeUrl")
WebUI.comment(folderUrl1)
def folderUrl2 = WS.getElementPropertyValue(folderList, "results[1].relativeUrl")
def parentUrl = WS.getElementPropertyValue(folderList, "results[0].parentUrl")
WebUI.comment(parentUrl)


// Bulk delete of both folders using folderUrls's
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/_DRAFT/Assets/AssetDeleteBulk', [
	('itemName1') : folderUrl1, 
	('itemName2') : folderUrl2
	]))


// Check that folders are deleted
WebUI.comment(GlobalVariable.folderName)
folderList = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/_DRAFT/Assets/AssetGetList', [
	('folderName') : parentUrl,
	('keyword') : ''
	]))
//WS.verifyElementPropertyValue(folderList, 'totalCount', '3')


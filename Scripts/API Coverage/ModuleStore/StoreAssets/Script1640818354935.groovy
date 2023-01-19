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

import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonOutput
import com.kms.katalon.core.testobject.ResponseObject


WebUI.comment('TEST CASE: Store assets')


'SET THE STORES DIRECTORY PATH SO ALL THE OPERATIONS TAKE PLACE AT /stores/...'
directoryPath = '/stores/'


'CHECK FOLDER NAME VALIDATION'
GlobalVariable.folderParentUrl = directoryPath + GlobalVariable.storeName
validateFolderName = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleAssets/AssetFolderCreateErrorValidation'), 
	null)


'CREATE AND DELETE SEVERAL FOLDERS SIMULTANEOUSLY'
assetsFolderDeleteBulk = WS.callTestCase(findTestCase('API Coverage/ModuleAssets/AssetFolderCreateDeleteBulk'),
	null)


'CREATE A SINGLE FOLDER'
assetsFolderCreateSingle = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleAssets/AssetFolderCreateNew'),
	null)


'VERIFY THE FOLDER HAS BEEN CREATED'
assetsFolderSearchCreated = WS.callTestCase(findTestCase('API Coverage/ModuleAssets/AssetFolderSearch'), 
	null)


'UPLOAD A FILE(picture) FROM LOCAL STORAGE'
assetsUploadLocalImage = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleAssets/AssetFileUploadLocal'), 
	null)


'UPLOAD AN ARCHIVE FROM URL'
assetsFileUploadUrlZip = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleAssets/AssetFileUploadUrl'), 
	null)


'DELETE THE CREATED SINGLE FOLDER'
GlobalVariable.folderUrl = GlobalVariable.folderParentUrl 
assetsSingleFolderDelete = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleAssets/AssetFolderDelete'), 
	null)


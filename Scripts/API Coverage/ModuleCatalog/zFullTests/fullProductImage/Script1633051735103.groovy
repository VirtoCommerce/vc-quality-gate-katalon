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
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.comment('TEST CASE: Products management - upload image, description type management')


'DESCRIPTION TYPE MANAGEMENT'
operateDescriptionType = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/productsDescriptionTypes'),
	null,
	FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TEST CASE: Products management - upload image')


'CREATE ASEETS BLOB FOLDER'
createFolder = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/assetsCreateBlobFolder'),
	null,
	FailureHandling.STOP_ON_FAILURE
	)

	
'FIND URL OF ASSETS'
getUrls = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/assetGetList'),
	null,
	FailureHandling.STOP_ON_FAILURE
	)



'UPLOAD IMAGE FOR PRODUCT'
uploadImage = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/assetFileUpload'),
	null,
	FailureHandling.STOP_ON_FAILURE
	)


'CREATE NEW PRODUCT'
GlobalVariable.productName = 'QweDrinkProductImaheAndDescriptions'
productCreate = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/productUpdate'),
	null,
	FailureHandling.STOP_ON_FAILURE
	)


'CREATE UPDATED IMAGE BODY & UPDATE IMAGES'
updateAsset = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/productUpdateImage'),
	null,
	FailureHandling.STOP_ON_FAILURE
	)




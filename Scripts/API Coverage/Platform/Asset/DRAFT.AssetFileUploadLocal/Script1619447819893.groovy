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



//String textShipment = new File('Data Files/testUploadFile.jpg')
//println textShipment
//
//
//def jsonBodyContent = new groovy.json.JsonBuilder(textShipment)
//// Convert Json into String
//String bodyContent = jsonBodyContent.toString()
//RequestObject fileUploadRequest = findTestObject('')
//// Create and set body content property
//fileUploadRequest.setBodyContent(new HttpTextBodyContent(bodyContent))


WebUI.comment('TEST CASE: Assets. Upload file from local')
uploadFileLocal = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetFileUploadLocal', [
	('folderUrl') : GlobalVariable.folderUrl
	]))

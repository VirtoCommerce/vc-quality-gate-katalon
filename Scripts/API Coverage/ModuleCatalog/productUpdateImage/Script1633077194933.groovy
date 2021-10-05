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

WebUI.comment('TEST CASE: Products management - assets update')


'CREATE UPDATED IMAGE BODY & UPDATE IMAGES'
updatedImagestext = '{"size":6129,"contentType":"image/svg+xml", "type":"blob","name":"'+ GlobalVariable.uploadedFileName +'","url":"'+ GlobalVariable.uploadedFileUrl +'","relativeUrl":"' + GlobalVariable.uploadedFileUrl + '","createdDate":"0001-01-01T00:00:00Z","modifiedDate":"2021-08-26T09:57:56.6970941Z","isImage":true,"sortOrder":1,"group":"images"}'
WebUI.comment(updatedImagestext)


'UPDATE IMAGES'
imagesUpdate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductUpdate', [
	('name') : GlobalVariable.productName,
	('code') : GlobalVariable.sku,
	('catalogId') : GlobalVariable.catalogId,
	('categoryId') : GlobalVariable.categoryId,
	('id') : GlobalVariable.productId,
	('content') : GlobalVariable.content,
	('weightUnit') : GlobalVariable.weightUnit,
	('weight') : GlobalVariable.weight,
	('height') : GlobalVariable.height,
	('width') : GlobalVariable.width,
	('length') : GlobalVariable.length,
	('images'): updatedImagestext
	]))
WS.verifyElementPropertyValue(imagesUpdate, 'name', GlobalVariable.productName)
WS.verifyElementPropertyValue(imagesUpdate, 'images.url[0]', GlobalVariable.uploadedFileUrl)

'SAVE CATALOG ID TO USE IN UPDATE AND DELETE CASES'
GlobalVariable.productId = WS.getElementPropertyValue(imagesUpdate, 'id')
WebUI.comment(GlobalVariable.productId)


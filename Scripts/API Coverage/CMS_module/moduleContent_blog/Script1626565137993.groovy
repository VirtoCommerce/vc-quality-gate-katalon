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

WebUI.comment('TEST CASE: Blogs. Rename a blog/delete a renamed blog')

GlobalVariable.contentType = "blogs"

//Create a blog folder 
folder = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentFolderCreate', [
	('contentType') : GlobalVariable.contentType ,
	('storeId') : GlobalVariable.storeId,
	('folderName') : GlobalVariable.folderName
	]))

//To the folder upload a post
post = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentFileNew', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('folderName') : GlobalVariable.folderName,
	('fileName') : 'qwepage.en-US.md'
	]))

//Get the blog Url to set variables for the ContentMove request
postData = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentSearch', [
	('contentType') : GlobalVariable.contentType ,
	('storeId') : GlobalVariable.storeId,
	('keyword') : 'qwepage.en-US.md'
	]))
WS.verifyElementPropertyValue(postData,'[0].name', 'qwepage.en-US.md')

//Set variables for the ContentMove request and Content Get requests
oldUrl = WS.getElementPropertyValue(postData, '[0].url')
newUrl = oldUrl.replaceAll(/qwepage/, /renamed/)
relativeUrl = WS.getElementPropertyValue(postData, '[0].relativeUrl')

//Send ContentMove request to rename the blog
rename = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentMove', [
	('contentType') : GlobalVariable.contentType ,
	('storeId') : GlobalVariable.storeId,
	('oldUrl') : oldUrl,
	('newUrl') : newUrl
	]))

//Verify that the blog name has been changed
renamedPost = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentSearch', [
	('contentType') : GlobalVariable.contentType ,
	('storeId') : GlobalVariable.storeId,
	('keyword') : 'renamed'
	]))
WS.verifyElementPropertyValue(renamedPost, '[0].url', newUrl)

//Delete the created blog
deletePost = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentDelete', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('folderName') : newUrl
	]))

//Verify that the blog was successfully deleted
deletedPost = WS.sendRequest(findTestObject('API/backWebservices/virtoCommerce.Content/ContentGet', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('relativeUrl') : relativeUrl
	]))
WS.verifyResponseStatusCode(deletedPost, 404)

//Delete the created folder
deleteFolder = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentDelete', [
	('contentType') : GlobalVariable.contentType,
	('storeId') : GlobalVariable.storeId,
	('folderName') : GlobalVariable.folderName
	]))

//Get store stats to verify blogs count has been changed
deleteVerification = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Content/ContentStatsStoreGet', [
	('storeId') : GlobalVariable.storeId
	]))
WS.verifyElementPropertyValue(deleteVerification, 'blogsCount', 1)

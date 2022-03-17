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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonOutput
import com.kms.katalon.core.testobject.ResponseObject

WebUI.comment('TEST CASE: create a new tag')


//'CREATE A PRODUCT FIRST'
//productCreate = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/productCreate'), 
//	null)


'ADD A NEW TAG TO THE DICTIONARY'
tag = 'qweTag'
tagAdd = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.CatalogPersonalisation/_DRAFT/settingsDictionaryTagAddUpdate',[
	('tag') : tag
	]))


'GET THE LIST OF TAGS AND VERIFY THE NEW TAG HAS BEEN ADDED'
changedTagsGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.CatalogPersonalisation/settingsTagsGet'))
verifyAdded = WS.containsString(changedTagsGet, tag, false)


'UPDATE THE CREATED TAG'
updatedTag = tag + 'UPD' 
tagUpdate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.CatalogPersonalisation/_DRAFT/settingsDictionaryTagAddUpdate',[
	('tag') : updatedTag 
	]))


'VERIFY THE TAG HAS BEEN UPDATED'
tagsUpdatedGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.CatalogPersonalisation/settingsTagsGet'))
verifyUpdated = WS.containsString(tagsUpdatedGet, tag, false)


'DELETE THE CREATED TAG (revert to the initial state)'
tagDelete = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.CatalogPersonalisation/_DRAFT/settingsDictionaryTagDelete'))
 

'VERIFY THE TAG HAS BEEN DELETED'
tagsDeletedGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.CatalogPersonalisation/settingsTagsGet'))
verifyDeleted =  WS.containsString(tagsUpdatedGet, tag, false, FailureHandling.CONTINUE_ON_FAILURE) == false


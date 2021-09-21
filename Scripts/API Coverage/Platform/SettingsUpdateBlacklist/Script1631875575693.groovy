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

import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonOutput
import com.kms.katalon.core.util.KeywordUtil

//GET THE BLACKLIST CONFIGURATION
def settingName = 'VirtoCommerce.Platform.Security.FileExtensionsBlackList'
getData = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Platform/SettingsGetByName', [
	('name') : settingName
	]))
blacklistItems = WS.getElementPropertyValue(getData,'allowedValues')


//GET THE RESPONSE BODY CONTENT, PARSE IT AND EXTRACT THE BLACKLIST DATA
responseData = getData.getResponseBodyContent()
settingBody = new JsonSlurper().parseText(responseData)
blacklist =  settingBody.allowedValues


//ADD A NEW EXTENSION TO THE BLACKLIST DATA 
newExtension = '.exe'
blacklist.push(newExtension)
println blacklist


//ADD THE UPDATED BLACKLIST TO THE BODY
settingBody.allowedValues = blacklist
def newBodyJson = new groovy.json.JsonBuilder(settingBody)
def bodyString = newBodyJson.toString()
updatedBody = '[' + bodyString + ']'


//SEND THE REQUEST WITH THE ORDER BODY TO UPDATE PAYMENTS
RequestObject blacklistUpdate = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Platform/SettingsCreateUpdateDescriptionType')
blacklistUpdate.setBodyContent(new HttpTextBodyContent(updatedBody))
updateBlacklist = WS.sendRequestAndVerify(blacklistUpdate)


//VERIFY THE LIST HAS BEEN UPDATED
updatedData = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Platform/SettingsGetByName', [
	('name') : settingName
	]))
WS.containsString(updatedData, newExtension, false)


//THIS PART REVERTS CHANGES BACK TO THE INITIAL STATE

////USE THE INITIAL GET RESPONSE THAT DOESNT CONTAIN ANY CHANGES (INITIAL SETTING STATE)
// initialSettingsData = '[' + responseData + ']'
//
// 
// //SEND THE REQUEST WITH THE INITIAL SETTING DATA TO UNDO ALL THE CHANGES
// RequestObject revertChanges = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Platform/SettingsCreateUpdateDescriptionType')
// revertChanges.setBodyContent(new HttpTextBodyContent(initialSettingsData))
// undoChanges = WS.sendRequestAndVerify(revertChanges)
// 
// 
// //VERIFY IF THE CHANGES ARE DISCARD
// updatedData = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Platform/SettingsGetByName', [
//	 ('name') : settingName
//	 ]))
//boolean verification = WS.containsString(updatedData, newExtension, false, FailureHandling.OPTIONAL)
//assert verification == false

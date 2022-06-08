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


WebUI.comment('TEST CASE: new channel create')


'CREATE A NEW CHANNEL AND GET THE ID'
GlobalVariable.channelName = 'qweChan'
channelCreate = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPublishing/channelsCreate',[
	('channelName') : GlobalVariable.channelName,
	('catalogId') : GlobalVariable.catalogId,
	('catalogName') : GlobalVariable.catalogName
	]))
channelId = WS.getElementPropertyValue(channelCreate,'id')
GlobalVariable.channelId.add(channelId)


'VERIFY THE CHANNEL HAS BEEN CREATED'
channelGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPublishing/channelGet',[
	('channelId') : GlobalVariable.channelId.last()
	]))
WS.verifyElementPropertyValue(channelGet,'name', GlobalVariable.channelName)


'VERIFY THE CHANNEL IS ACCESSIBLE VIA SEARCH'
channelSearch = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPublishing/channelsSearch',[
		('keyword') : GlobalVariable.channelName
		]))
WS.containsString(channelSearch, GlobalVariable.channelId.last(), false)


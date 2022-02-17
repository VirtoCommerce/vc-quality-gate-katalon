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


WebUI.comment('TEST CASE: content fodler update')


//GlobalVariable.folderId = 'cac877ff-33e1-4850-834e-b124bc352bd7'


'GET THE CREATED FOLDER BODY BY ITS ID'
folderBodyGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentFolder/ContentFodlerGet',[
	('folderId') : GlobalVariable.folderId 
	]))


'PROCESS FOLDER BODY TO UPDATE THE FOLDER'
folderBody = folderBodyGet.getResponseBodyContent()
folderBodyParsed = new JsonSlurper().parseText(folderBody)
updatedFolderName = GlobalVariable.folderName + 'UPD'
folderBodyParsed.name = updatedFolderName
updatedFolderDescription = 'updated description'
folderBodyParsed.description = updatedFolderDescription
println folderBodyParsed.name 
println folderBodyParsed.description 
updatedFolderBodyJson = new groovy.json.JsonBuilder(folderBodyParsed).toString()
println updatedFolderBodyJson 


'SEND THE REQUEST TO UPDATED THE ITEM'
RequestObject updateFodler= findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentFolder/ContentFolderUpdate')
updateFodler.setBodyContent(new HttpTextBodyContent(updatedFolderBodyJson))
WS.sendRequestAndVerify(updateFodler)


'VERIFY THE FOLDER HAS BEEN UPDATED'
updatedFolderGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/DynamicContent/ContentFolder/ContentFodlerGet',[
	('folderId') : GlobalVariable.folderId
	]))
WS.verifyElementPropertyValue(updatedFolderGet,'name', updatedFolderName)
WS.verifyElementPropertyValue(updatedFolderGet,'description', updatedFolderDescription)





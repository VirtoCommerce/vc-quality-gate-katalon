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


WebUI.comment('TEST CASE: package type. create, update, delete')


'VERIFY THE PACKAGE NAME IS NOT OCCUPIED'
packageName = 'qwePackage' + UUID.randomUUID().toString() //to make sure its unique
initialPackagesGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Core/packageGet'))
assert WS.containsString(initialPackagesGet, packageName, false, FailureHandling.OPTIONAL) == false


'SEND REQUEST TO CREATE A PACKAGE TYPE AND GET THE ID'
packageCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Core/packageCreate',[
	('packageName') : packageName
	]))


'VERIFY PACKAGE HAS BEEN CREATED'
packageGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Core/packageGet'))
//packageName = WS.getElementPropertyValue(packageGet,'[0].name') 
WS.containsString(packageGet, packageName, false)
packageId = WS.getElementPropertyValue(packageGet,'[0].id')
println packageId
 

'UPDATE THE CREATED PACKAGE'
packageUpdatedName = 'qweUPD' + UUID.randomUUID().toString() //to makes sure its unique
packageUpdate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Core/packageUpdate',[
	('packageName') : packageUpdatedName,
	('packageId') : packageId
	]))


'VERIFY THE PACKAGE HAS BEEN UPDATED'
updatedPackageGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Core/packageGet'))
WS.containsString(updatedPackageGet, packageUpdatedName, false)
assert WS.containsString(updatedPackageGet, packageName, false, FailureHandling.OPTIONAL) == false


'DELETE THE CREATED PACKAGE'
packageDelete = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Core/packageDelete',[
	('packageId') : packageId
	]))


'VERIFY THE PACKAGE HAS BEEN DELETED'
deletedPackageGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Core/packageGet'))
assert WS.containsString(deletedPackageGet, packageUpdatedName, false, FailureHandling.OPTIONAL) == false


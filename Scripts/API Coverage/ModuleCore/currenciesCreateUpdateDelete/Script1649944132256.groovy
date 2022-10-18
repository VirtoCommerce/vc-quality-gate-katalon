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


WebUI.comment('TEST CASE: Currency. create, update, delete')


'VERIFY THE CURRENCY NAME IS NOT OCCUPIED'
currencyName = 'qweCurrency' + UUID.randomUUID().toString() //to make sure its unique
currencyCode = 'QWE'
initialCurrenciesGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Core/currencyGet'))
assert WS.containsString(initialCurrenciesGet, currencyName, false, FailureHandling.OPTIONAL) == false


'SEND REQUEST TO CREATE A CURRENCY TYPE'
currencieCreate = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Core/currencyCreate',[
	('currencyName') : currencyName,
	('currencyCode') : currencyCode
	]))


'VERIFY CURRENCY HAS BEEN CREATED'
currencieGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Core/currencyGet'))
WS.containsString(currencieGet, currencyName, false)
 

'UPDATE THE CREATED CURRENCY'
currencyUpdatedName = 'qweUPD' + UUID.randomUUID().toString() //to makes sure its unique
currencyUpdate = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Core/currencyUpdate',[
	('currencyName') : currencyUpdatedName,
	('currencyCode') : currencyCode
	]))


'VERIFY THE CURRENCY HAS BEEN UPDATED'
updatedCurrencyGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Core/currencyGet'))
WS.containsString(updatedCurrencyGet, currencyUpdatedName, false)
assert WS.containsString(updatedCurrencyGet, currencyName, false, FailureHandling.OPTIONAL) == false


'DELETE THE CREATED CURRENCY'
currencieDelete = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Core/currencyDelete',[
	('currencyCode') : currencyCode
	]))


'VERIFY THE CURRENCY HAS BEEN DELETED'
deletedCurrencieGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Core/currencyGet'))
assert WS.containsString(deletedCurrencieGet, currencyCode, false, FailureHandling.OPTIONAL) == false


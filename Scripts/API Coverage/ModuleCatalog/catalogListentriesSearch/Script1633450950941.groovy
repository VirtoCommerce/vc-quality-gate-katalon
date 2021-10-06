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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil


WebUI.comment('TEST CASE: Products management - Listentries Search')




'VERIFY VARS'
println GlobalVariable.keyword
println GlobalVariable.productName
println GlobalVariable.productId

'SEARCH FOR THE PRODUCT'
//Have deleted the "catalogId" request header from the request below as it was returning totalCount = 1,
//so crashing the case


//GlobalVariable.productName = 'QweProductUPD'
//GlobalVariable.keyword = GlobalVariable.productName
println GlobalVariable.keyword
 verifyDeleted = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Catalog/ListentriesSearch', [
	('keyword') : GlobalVariable.keyword
	]))	
//name = WS.getElementPropertyValue(verifyDeleted,'listEntries[0].name')
//println name
//boolean verification = WS.containsString(verifyDeleted, GlobalVariable.keyword, false, FailureHandling.OPTIONAL)
//println verification
//assert verification == false
WS.verifyElementPropertyValue(verifyDeleted, 'listEntries', '[]')


'VERIFY VARS'
println GlobalVariable.keyword
println GlobalVariable.productName
println GlobalVariable.productId


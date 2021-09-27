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


WebUI.comment('TEST CASE: categories management - create a new category')


'CREATE NEW CATEGORY'
categoryCreate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/CategoriesCreate', [
	('catalogId') : GlobalVariable.catalogId,
	('code') : GlobalVariable.categoryCode,
	('name') : GlobalVariable.categoryName
	]))
WS.verifyElementPropertyValue(categoryCreate, 'catalogId', GlobalVariable.catalogId)
WS.verifyElementPropertyValue(categoryCreate, 'name', GlobalVariable.categoryName)
WS.verifyElementPropertyValue(categoryCreate, 'code', GlobalVariable.categoryCode)
//return categoryCreate


'EXTRACT CATEGORY ID'
//I guess it would be better to stick to the generic 'id' global variable
//To keep things versitale, need to discuss
//Ive read that it is possible to write return(test case name variable)
//And it is possible to receive this in another test case, need to explore
GlobalVariable.categoryId = WS.getElementPropertyValue(categoryCreate, 'id')
//WebUI.comment(GlobalVariable.categoryId)




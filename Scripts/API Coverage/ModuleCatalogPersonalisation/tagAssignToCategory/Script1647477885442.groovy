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

WebUI.comment('TEST CASE: assign a tag to a category')


'CREATE A CATEGORY FIRST'
categoryCreate = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/categoryCreate'),
	null)


'GET THE NECESSARY DATA OF THE CATEGORY (BY ID)'
categoryGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Catalog/CategoriesGetById',[
	('id') : GlobalVariable.categoryId
	]))
label = WS.getElementPropertyValue(categoryGet,'name')
entityType = WS.getElementPropertyValue(categoryGet,'seoObjectType')
entityId = WS.getElementPropertyValue(categoryGet,'id')
assignmentId = UUID.randomUUID().toString()

println label
println entityType
println entityId
println assignmentId


'ADD A NEW TAG TO THE DICTIONARY'
tag = 'qweTag2'
tagAdd = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.CatalogPersonalisation/_DRAFT/settingsDictionaryTagAddUpdate',[
	('tag') : tag
	]))


'ASSIGN THE CREATED TAG TO THE PRODUCT'
tagAssign = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPersonalisation/tagAssign',[
	('entityType'): entityType,
	('entityId'): entityId,
	('tag'): tag,
	('label'): label,
	('assignmentId') : assignmentId
	]))


'VERIFY THE TAG HAS BEEN ADDED'
verifyTag = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPersonalisation/taggedItemGetById',[
	('taggedItemId') : GlobalVariable.categoryId
	]))
WS.verifyElementPropertyValue(verifyTag,'tags[0]', tag)


'UNASSIGN THE TAG'
tagUnassign = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.CatalogPersonalisation/tagUnassign',[
	('entityType'): entityType,
	('entityId'): entityId,
	('label'): label,
	('assignmentId') : assignmentId
	]))


'VERIFY THE TAG HAS BEEN UNASSIGNED'
verifyUnassigned = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPersonalisation/taggedItemGetById',[
	('taggedItemId') : GlobalVariable.categoryId
	]))
verification = WS.containsString(verifyUnassigned, tag, false, FailureHandling.OPTIONAL) == false

  
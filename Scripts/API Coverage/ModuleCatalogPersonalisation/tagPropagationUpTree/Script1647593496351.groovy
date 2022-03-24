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


WebUI.comment('TEST CASE: policy propagate uptree')


'SET THE PROPAGATION POLICY TO UPTREE'
policySet = 'UpTree'
policySetUpTree = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.CatalogPersonalisation/_relatedSettingsUpdate/settingsPropagationChange',[
	('value') : policySet
	]))


'RUN THE OUTLINES SYNC'
oulinesSync = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalogPersonalisation/tagOutlinesSync'), 
	null)


'GET THE CURRENT PROPAGATION POLICY'
policyGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Platform/SettingsGetByName',[
	('name') : 'CatalogPersonalization.TagsInheritancePolicy'
	]))
WS.verifyElementPropertyValue(policyGet,'value', policySet )


'Create a tag'
tagCreate = WS.callTestCase(findTestCase('API Coverage/ModuleCatalogPersonalisation/tagCreate'),
	null)


'Create a category'
categoryCreate = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/categoryCreate'),
	null)


'Create a product'
productCreate = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/productCreate'),
	null)


'ASSIGN THE TAG TO THE CATEGORY'
tagAssignToCategory = WS.callTestCase(findTestCase('API Coverage/ModuleCatalogPersonalisation/tagPutAssignToCategory'), 
	null)


'VERIFY THE PRODUCT DOESNT INHERIT THE TAG FROM THE CATEGORY'
productInheritedTagGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPersonalisation/taggedItemGetById',[
	('taggedItemId') : GlobalVariable.productId 
	])) 
WS.verifyElementPropertyValue(productInheritedTagGet,'inheritedTags','[]')


'UPDATE (CHANGE) THE CREATED TAG'
tagUpdate = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalogPersonalisation/tagUpdate'),
	null)


'ASSIGN THE UPDATED TAG TO THE PRODUCT'
updatedTagAssignToTheProduct = WS.callTestCase(findTestCase('API Coverage/ModuleCatalogPersonalisation/tagPutAssignToProduct'), 
	null)


'GET THE PRODUCT TAGS NUMBER (simple endpoint check)'
tagsAssignedCountGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPersonalisation/taggedItemCountGet',[
	('taggedItemId') : GlobalVariable.productId
	]))
tagsAssignedCount = new JsonSlurper().parseText(tagsAssignedCountGet.getResponseBodyContent())
assert tagsAssignedCount == 1


'VERIFY THE CATEGORY INHERITS A TAG FROM THE PRODUCT'
categoryInheriterTagGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.CatalogPersonalisation/taggedItemGetById',[
	('taggedItemId') : GlobalVariable.categoryId
	]))
WS.verifyElementPropertyValue(categoryInheriterTagGet,'inheritedTags[0]', GlobalVariable.tag)


'UNASSIGN THE TAG FROM THE PRODUCT'
tagUnassign = WS.callTestCase(findTestCase('API Coverage/ModuleCatalogPersonalisation/tagPutUnassignOfTheProduct'),
	null)


'DELETE THE CREATED PRODUCT'
productDelete = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/productsDelete'),
	null)


'DELETE THE CREATED CATEGORY'
categoryDelete = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/categoryDelete'),
	null)


'DELETE THE CREATED TAG'
tagDelete = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalogPersonalisation/tagDeleteFromDictionary'),
	null)


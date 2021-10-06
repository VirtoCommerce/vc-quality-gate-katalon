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


WebUI.comment('TEST CASE: Products management - add product')

'CREATE A NEW PRODUCT'
createUpdateProduct = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductCreate', 
	[
	('name') : GlobalVariable.productName,
	('code') : GlobalVariable.sku,
	('catalogId') : GlobalVariable.catalogId,
	('categoryId') : GlobalVariable.categoryId,
	('content') : GlobalVariable.content,
	('weightUnit') : GlobalVariable.weightUnit,
	('weight') : GlobalVariable.weight,
	('height') : GlobalVariable.height,
	('width') : GlobalVariable.width,
	('length') : GlobalVariable.length
	]))
WS.verifyElementPropertyValue(createUpdateProduct, 'name', GlobalVariable.productName)
WS.verifyElementPropertyValue(createUpdateProduct, 'reviews[0].content', GlobalVariable.content)
WS.verifyElementPropertyValue(createUpdateProduct, 'weightUnit', GlobalVariable.weightUnit)
WS.verifyElementPropertyValue(createUpdateProduct, 'weight', GlobalVariable.weight)
WS.verifyElementPropertyValue(createUpdateProduct, 'height', GlobalVariable.height)
WS.verifyElementPropertyValue(createUpdateProduct, 'width', GlobalVariable.width)
WS.verifyElementPropertyValue(createUpdateProduct, 'length', GlobalVariable.length)


'SAVE CATALOG ID TO USE IN UPDATE AND DELETE CASES'
GlobalVariable.productId = WS.getElementPropertyValue(createUpdateProduct, 'id')
WebUI.comment(GlobalVariable.productId)


'SAVE CATEGORY NAME'
GlobalVariable.categoryName = WS.getElementPropertyValue(createUpdateProduct, 'path')
WebUI.comment(GlobalVariable.categoryName)


//'RETURN DATA'
//return createUpdateProduct


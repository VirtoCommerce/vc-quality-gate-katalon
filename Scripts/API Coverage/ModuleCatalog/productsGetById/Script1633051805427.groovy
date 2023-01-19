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


WebUI.comment('TEST CASE: GET PRODUCT BY ID')



//'CREATE A NEW PRODUCT'
//productName = GlobalVariable.productName = 'QweDrink'
//createProduct = WS.callTestCase(findTestCase('API Coverage/ModuleCatalog/productUpdate'),null,
//FailureHandling.STOP_ON_FAILURE)


'GET PRODUCT BY ID AND GROUP'
//productName = GlobalVariable.productName
verifyCreated = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetByIdAndGroup', [
	('id') : GlobalVariable.productId
	]))
WS.verifyElementPropertyValue(verifyCreated, '[0].id', GlobalVariable.productId)
WS.verifyElementPropertyValue(verifyCreated, '[0].name', GlobalVariable.productName)
WS.verifyElementPropertyValue(verifyCreated, '[0].reviews[0].content', GlobalVariable.content)
WS.verifyElementPropertyValue(verifyCreated, '[0].weightUnit', GlobalVariable.weightUnit)
WS.verifyElementPropertyValue(verifyCreated, '[0].weight', GlobalVariable.weight)
WS.verifyElementPropertyValue(verifyCreated, '[0].height', GlobalVariable.height)
WS.verifyElementPropertyValue(verifyCreated, '[0].width', GlobalVariable.width)
WS.verifyElementPropertyValue(verifyCreated, '[0].length', GlobalVariable.length)


'GET CATALOG NAME'
GlobalVariable.catalogName = WS.getElementPropertyValue(verifyCreated, '[0].outlines[0].items[0].name')
//WebUI.comment("KATALOG NAME IS " + GlobalVariable.catalogName)


'VERIFY VARS'
println GlobalVariable.keyword
println GlobalVariable.productName
println GlobalVariable.productId

//'START TESTCASE TEARDOWN IN SUITE'
//"TEMP" variable launches teardown in
//"module_Catalog_Product" test suit's scrip
//GlobalVariable.TEM = true


//'RETURN DATA'
//return verifyCreated




	
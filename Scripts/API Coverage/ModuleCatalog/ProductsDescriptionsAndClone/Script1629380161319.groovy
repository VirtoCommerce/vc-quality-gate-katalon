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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.comment('TEST CASE: Products management - add, update, delete')
productName = 'QweDrinkProduct'

// Create new product
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductCreateUpdate', [('name') : productName]))
WS.verifyElementPropertyValue(response, 'name', productName)

//save catalog ID to use in Update and Delete cases
productId = WS.getElementPropertyValue(response, 'id')
WebUI.comment(productId)

//Verify that product was added 
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetByIdAndGroup', [
            ('id') : productId]))
WS.verifyElementPropertyValue(response, '[0].name', productName)

///Update name, to use for after update verification
content = 'Updated quick description'
WebUI.comment(content)

//Update product
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductCreateUpdate', 
	[('name') : productName,
	 ('content') : content
	 ]))

//Verify that product was upadted
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetByIdAndGroup', [('id') : productId]))
WS.verifyElementPropertyValue(response, '[0].reviews[0].content', content)

// Clone product
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetCloneByProductId', [('productId') : productId]))

//Verify that product clone is return
WS.verifyElementPropertyValue(response, 'reviews[0].content', content)
WS.verifyElementPropertyValue(response, 'name', productName)

//Save body of clone
clonnedProductBody = response.getResponseBodyContent()

// Create cloned product
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductCreateUpdateWithBody', 
        [('body') : clonnedProductBody]))

//save catalog ID to use in Update and Delete cases
productId = WS.getElementPropertyValue(response, 'id')
WebUI.comment(productId)

//Verify that product was upadted
response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Catalog/ProductsGetByIdAndGroup', [
			('id') : productId]))
WS.verifyElementPropertyValue(response, '[0].reviews[0].content', content)
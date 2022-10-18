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

import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonOutput
import com.kms.katalon.core.testobject.ResponseObject


WebUI.comment('TEST CASE: ADD ANOTHER PRICE TO THE PRODUCT')


'GET THE INITIAL PRICES COUNT'
getInitialPricesCount = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/priceSearchGet'),
	null)
initialPricesCount = WS.getElementPropertyValue(getInitialPricesCount, 'totalCount') 


'PARSE AND PREPARE JSON TEMPLATE'
productListPrice = 888
Object priceTemplate = new File('TestDataFiles/productPriceTemplate.json').text
priceTemplateParsed = new JsonSlurper().parseText(priceTemplate)
priceTemplateParsed.productId = GlobalVariable.productId
priceTemplateParsed.list = productListPrice
priceTemplateParsed.priceListId = GlobalVariable.pricelistId  


'GET PRODUCT BODY TO MODIFY IT and use in a PUT request)'
productSearch = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/priceSearchGet'),
	null)


'PARSE THE PRODUCT BODY AND MODIFY IT (add the additional price)'
searchResults = productSearch.getResponseBodyContent()
searchResultsParsed = new JsonSlurper().parseText(searchResults)
productBody = searchResultsParsed.results[0]
productBody.prices[1] = priceTemplateParsed
productBodyJson = new groovy.json.JsonBuilder(productBody).toString()


'SEND THE REQUEST TO ADD THE PDATED PRODUCT PRICE TO THE PRODUCT'
RequestObject addPriceRequest = findTestObject('API/backWebServices/VirtoCommerce.Pricing/PricesAddUpdateByProductId')
addPriceRequest.setBodyContent(new HttpTextBodyContent(productBodyJson))
addPrice = WS.sendRequestAndVerify(addPriceRequest)


'VERIFY THE CHANGES HAVE BEEN MADE'
pricesSearch = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/priceSearchGet'),
	null)
WS.verifyElementPropertyValue(pricesSearch,'totalCount', (initialPricesCount + 1))
WS.verifyElementPropertyValue(pricesSearch,'results[0].productId',GlobalVariable.productId)
WS.verifyElementPropertyValue(pricesSearch,'results[0].prices[1].list',productListPrice + '.0000')


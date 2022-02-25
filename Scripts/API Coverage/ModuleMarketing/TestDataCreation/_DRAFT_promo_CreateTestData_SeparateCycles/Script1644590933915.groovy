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



'PREPAER REWARD OBJECT'//Static unless rewritten on the later stages of test
dynamicExpessionData = new File('Data Files/promoDynamicExpressionTemplate.json').text
rewardDataParsed = new JsonSlurper().parseText(dynamicExpessionData)
rewardCondition = 'RewardCartGetOfAbsSubtotal'
rewardDataParsed.id = rewardCondition
rewardDataParsed << ['amount' : '1']


'PREPARE NAMES AND PROMO DATA CONFIGURATIONS FOR EACH POSSIBLE CONDITION'
//CATEGORY
List namesForCategory = ['Category - fully', 'Category - without Subcategory', 'Category - without Items']
promoDataCategory = new File('Data Files/promoDataCategory.json').text
List promoDataCategoryParsed = new JsonSlurper().parseText(promoDataCategory)


//PRODUCT
List namesForProduct = ['Product - contains SKU', 'Product - contains Name', 'Product - full price']
pomoDataProduct = new File('Data Files/promoDataProduct.json').text
List productConditionsParsed = new JsonSlurper().parseText(pomoDataProduct)


//CURRENCY
List namesForCurrency = ['Currency is [] USD, but the current currency in storefront is EUR - promo not applied', 'Currency is [] USD, and current currency in storefront is USD - promo applied']
currencyCondition = new File('Data Files/promoDataCurrency.json').text
List currencytConditionsParsed = new JsonSlurper().parseText(currencyCondition )


//IN STOCK QUANTITY
List namesForInStockQuantity = ['InStock quantity - at least', 'InStock quantity - exactly', 'InStock quantity - less than or equals', 'InStock quantity - between']
qtyCondition = new File('Data Files/promoDataQty.json').text
List qtyConditionsParsed = new JsonSlurper().parseText(qtyCondition)


//CART ITEMS
List namesForCartItemsConditions = ['Cart items - at least', 'Cart items - exactly', 'Cart items - less than or equals', 'Cart items - between', 'Cart items - with excluding items', 'Cart items of category', 'Cart items of entry']
cartItemsCondition = new File('Data Files/promoDataCartItems.json').text
List cartItemsConditionsParsed = new JsonSlurper().parseText(cartItemsCondition)


//CART SUBTOTAL
List namesForCartSubtotalConditions = ['Cart subtotal - at least', 'Cart subtotal - exactly', 'Cart subtotal - less than or equals', 'Cart subtotal - between']
cartSubtotalCondition = new File('Data Files/promoDataCartSubtotal.json').text
List cartSubtotalConditionsParsed = new JsonSlurper().parseText(cartSubtotalCondition)


'START CYCLE OF USERGROUP CONDITIONS' //as it is higher in the hierarchy 
userGroupDataParsed = new JsonSlurper().parseText(dynamicExpessionData)
List userGroupPromoCondition = ['ConditionIsEveryone','ConditionIsRegisteredUser','ConditionIsFirstTimeBuyer', 'UserGroupsContainsCondition' ]
List ListUserGroupNames = ['Everyone','Registered', 'FirstTime','UserGroupsContains']//Use it to make naming more compact and obvious
//this is the initial b cycle
for (int i; i < userGroupPromoCondition.size();i++) {	
	GlobalVariable.promoName = i + ' ' + ListUserGroupNames[i] + ' '
	userGroupDataParsed.id = userGroupPromoCondition[i]
	if (userGroupPromoCondition[i] == 'UserGroupsContainsCondition') {
		userGroupDataParsed << ['group' : 'qwe' , 'groupName' : 'Shopper profile']
		//adding this statement as 'UserGroupsContainsCondition' has 
		//differences in body structure
	}
	
	
	'PREPARE THE REQUEST TEMPLATE'
	postRequestTemplate = new File('Data Files/promoPostTemplate.json').text
	promoPostTemplateParsed = new JsonSlurper().parseText(postRequestTemplate)
	promoPostTemplateParsed.dynamicExpression.children[0].children[0] = userGroupDataParsed //'userGroup'
	promoPostTemplateParsed.dynamicExpression.children[3].children[0] = rewardDataParsed //'reward'
	
	
	'START SERIES OF CYCLES OF PROMO CONDITIONS'
	'CATEGORY'
	for (int a; a < promoDataCategoryParsed.size(); a++) {
		'PREPARE THE REQUEST BODY'
		promoPostTemplateParsed.name = 'qwe ' + GlobalVariable.promoName + ' ' + '0.' + a + ' ' + namesForCategory[a]
		promoPostTemplateParsed.dynamicExpression.children[1].children[0] = promoDataCategoryParsed[a]
		promoCategoryJson = new groovy.json.JsonBuilder(promoPostTemplateParsed).toString()
		'SEND THE REQUEST'
		RequestObject promoCreateCategory = findTestObject('API/backWebServices/VirtoCommerce.Marketing/Promotions/PromoCreate_no_hardcoded_id')
		promoCreateCategory.setBodyContent(new HttpTextBodyContent(promoCategoryJson))
		WS.sendRequestAndVerify(promoCreateCategory)
	}
	
	
	'PRODUCT'
	for(int a; a < productConditionsParsed .size();a++) {
		'PREPARE REQUEST BODY'
		promoPostTemplateParsed.name = 'qwe ' + GlobalVariable.promoName + ' ' + '1.' + a + ' ' + namesForProduct[a]
		promoPostTemplateParsed.dynamicExpression.children[1].children[0] = productConditionsParsed[a]
		promoJsonProduct = new groovy.json.JsonBuilder(promoPostTemplateParsed).toString()
		'SEND THE REQUEST'
		RequestObject promoCreateProduct = findTestObject('API/backWebServices/VirtoCommerce.Marketing/Promotions/PromoCreate_no_hardcoded_id')
		promoCreateProduct.setBodyContent(new HttpTextBodyContent(promoJsonProduct))
		WS.sendRequestAndVerify(promoCreateProduct)
	}
	
	
	'CURRENCY'
	for(int a; a < currencytConditionsParsed .size();a++) {
		'PREPARE REQUEST BODY'
		promoPostTemplateParsed.name = 'qwe ' + GlobalVariable.promoName + ' ' + '2.' + a + ' ' + namesForCurrency[a]
		promoPostTemplateParsed.dynamicExpression.children[1].children[0] = currencytConditionsParsed[a]
		promoJsonCurrency = new groovy.json.JsonBuilder(promoPostTemplateParsed).toString()
		'SEND THE REQUEST'
		RequestObject promoCreateCurrency = findTestObject('API/backWebServices/VirtoCommerce.Marketing/Promotions/PromoCreate_no_hardcoded_id')
		promoCreateCurrency.setBodyContent(new HttpTextBodyContent(promoJsonCurrency))
		WS.sendRequestAndVerify(promoCreateCurrency)
	}
	
	
	'IN STOCK  QUANTITY'
	for(int a; a < qtyConditionsParsed .size();a++) {
		'PREPARE REQUEST BODY'
		promoPostTemplateParsed.name = 'qwe ' + GlobalVariable.promoName + ' ' + '3.' + a + ' ' + namesForInStockQuantity[a]
		promoPostTemplateParsed.dynamicExpression.children[1].children[0] = qtyConditionsParsed[a]
		promoJsonQty = new groovy.json.JsonBuilder(promoPostTemplateParsed).toString()
		'SEND THE REQUEST'
		RequestObject promoCreateQty = findTestObject('API/backWebServices/VirtoCommerce.Marketing/Promotions/PromoCreate_no_hardcoded_id')
		promoCreateQty.setBodyContent(new HttpTextBodyContent(promoJsonQty))
		WS.sendRequestAndVerify(promoCreateQty)
	}
	
	
	'CART ITEMS' //locator change here
	for(int a; a < cartItemsConditionsParsed.size();a++) {
		'PREPARE REQUEST BODY'
		promoPostTemplateParsed.name = 'qwe ' + GlobalVariable.promoName + ' ' + '4.' + a + ' ' + namesForCartItemsConditions[a]
		promoPostTemplateParsed.dynamicExpression.children[2].children[0]  = cartItemsConditionsParsed[a]
		promoJsonCartItems = new groovy.json.JsonBuilder(promoPostTemplateParsed).toString()
		'SEND THE REQUEST'
		RequestObject promoCreatecartItems = findTestObject('API/backWebServices/VirtoCommerce.Marketing/Promotions/PromoCreate_no_hardcoded_id')
		promoCreatecartItems.setBodyContent(new HttpTextBodyContent(promoJsonCartItems))
		WS.sendRequestAndVerify(promoCreatecartItems)
	}
	
	
	'CART SUBTOTAL'
	for(int a; a < cartSubtotalConditionsParsed.size();a++) {
		'PREPARE REQUEST BODY'
		promoPostTemplateParsed.name = 'qwe ' + GlobalVariable.promoName + ' ' + '5.' + a + ' ' + namesForCartSubtotalConditions[a]
		promoPostTemplateParsed.dynamicExpression.children[2].children[0]  = cartSubtotalConditionsParsed[a]
		promoJsonCartSubtotal = new groovy.json.JsonBuilder(promoPostTemplateParsed).toString()
		'SEND THE REQUEST'
		RequestObject promoCreatecartSubtotal = findTestObject('API/backWebServices/VirtoCommerce.Marketing/Promotions/PromoCreate_no_hardcoded_id')
		promoCreatecartSubtotal.setBodyContent(new HttpTextBodyContent(promoJsonCartSubtotal))
		WS.sendRequestAndVerify(promoCreatecartSubtotal)
	}	
}


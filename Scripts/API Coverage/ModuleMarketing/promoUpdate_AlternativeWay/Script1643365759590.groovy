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

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonOutput
import com.kms.katalon.core.testobject.ResponseObject


WebUI.comment('test case: UPDATE PROMOTION')


'USER GROUP'
dynamicExpessionData = new File('Data Files/promoDynamicExpressionTemplate.json').text
userGroupDataParsed = new JsonSlurper().parseText(dynamicExpessionData)
userGroupPromoCondition = 'ConditionIsEveryone'
userGroupDataParsed.id = userGroupPromoCondition


'CATALOG'
dynamicExpessionData = new File('Data Files/promoDynamicExpressionTemplate.json').text
catalogConditionDataParsed = new JsonSlurper().parseText(dynamicExpessionData)
catalogPromoCondition = 'ConditionCategoryIs'
//HERE IM ADDING AN ID OF THE CATEGORY TO EXCLUDE (exclude condition)
categoryToExclude = '4b50b398ff584af9b6d69c082c94844b' //"HEADPHONES" ID
catalogConditionDataParsed.excludingCategoryIds[0] = categoryToExclude

//HERE IM ADDING THE MAIN CONDITION ID
catalogConditionDataParsed.id = catalogPromoCondition

//HERE IM ADDING AN TTEM TO EXCLUDE
itemToExclude = 'cbd8eab4f76b4e34b779d9c59dbc13fe' //THE FIRST HOME THEATRE ON THE LIST 
catalogConditionDataParsed.excludingProductIds[0] = itemToExclude

catalogConditionDataParsed << ['categoryId' : GlobalVariable.categoryId, 'categoryName' : GlobalVariable.categoryName]
conditionDataJson = new groovy.json.JsonBuilder(catalogConditionDataParsed).toString()
println conditionDataJson


'REWARD'
dynamicExpessionData = new File('Data Files/promoDynamicExpressionTemplate.json').text
rewardDataParsed = new JsonSlurper().parseText(dynamicExpessionData)
rewardCondition = 'RewardCartGetOfAbsSubtotal'
rewardDataParsed.id = rewardCondition
rewardDataParsed << ['amount' : '1']
rewardDataJson = new groovy.json.JsonBuilder(rewardDataParsed).toString()
println rewardDataParsed


'GET THE CREATED PROMO DATA'
promoDataGet = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/PromoGetById',[
	('promoId') : GlobalVariable.promoId 
	]))


'PROCESS PROMO DATA TO UPDATE THE PROMOTION LATER'
createdPromoData = promoDataGet.getResponseBodyContent()
createdPromoDataParsed = new JsonSlurper().parseText(createdPromoData)
GlobalVariable.promoName = (GlobalVariable.promoName + 'UPD')
createdPromoDataParsed.name = GlobalVariable.promoName
createdPromoDataParsed.dynamicExpression.children[0].children[0] = userGroupDataParsed 
createdPromoDataParsed.dynamicExpression.children[1].children[0] = catalogConditionDataParsed
createdPromoDataParsed.dynamicExpression.children[3].children[0] = rewardDataParsed
promoJson =  new groovy.json.JsonBuilder(createdPromoDataParsed).toString()


'SEND REQUEST TO UPDATE A PROMOTION'
RequestObject promoUpdateObject = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/PromoUpdate')
promoUpdateObject.setBodyContent(new HttpTextBodyContent(promoJson))
promoUpdate = WS.sendRequestAndVerify(promoUpdateObject)


'SEARCH FOR THE PROMO VERIFY THE PROMOTION HAS BEEN UPDATED SUCCESSFULLY'
searchPromo = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/PromoSearch',[
	('keyword') : GlobalVariable.firstName
	]))
WS.verifyElementPropertyValue(searchPromo,'results[0].name', GlobalVariable.promoName)
WS.verifyElementPropertyValue(searchPromo,'results[0].dynamicExpression.children[0].children[0].id', userGroupPromoCondition)
WS.verifyElementPropertyValue(searchPromo,'results[0].dynamicExpression.children[1].children[0].id', catalogPromoCondition)
WS.verifyElementPropertyValue(searchPromo,'results[0].dynamicExpression.children[3].children[0].id', rewardCondition)


return promoUpdate


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


'QUESTION: Do we really need verification for this '

'FIRST PREPARE CATALOG CONDITION DATA'
catalogConditionData = new File('Data Files/dynamicExpressionDataTable.json').text
List catalogConditionDataParsed = new JsonSlurper().parseText(catalogConditionData)


'REWARD   (prepare data)'//Static throughout all the catalog conditions
dynamicExpessionData = new File('Data Files/promoDynamicExpressionTemplate.json').text
rewardDataParsed = new JsonSlurper().parseText(dynamicExpessionData)
rewardCondition = 'RewardCartGetOfAbsSubtotal'
rewardDataParsed.id = rewardCondition
rewardDataParsed << ['amount' : '1']


'USER GROUP   (prepare data)' 
userGroupDataParsed = new JsonSlurper().parseText(dynamicExpessionData)
List userGroupPromoCondition = ['ConditionIsEveryone','ConditionIsRegisteredUser','ConditionIsFirstTimeBuyer', 'UserGroupsContainsCondition' ]
for (int b; b < userGroupPromoCondition.size();b++) {	
	GlobalVariable.promoName = 'qwePromo' + b + '_'
	userGroupDataParsed.id = userGroupPromoCondition[b]
	if (userGroupPromoCondition[b] == 'UserGroupsContainsCondition') {
		userGroupDataParsed << ['group' : 'qwe' , 'groupName' : 'Shopper profile']
		//adding this statement as 'UserGroupsContainsCondition' has 
		//differences in body structure
	}
	
	
	'PREPARE THE REQUEST TEMPLATE'
	postRequestTemplate = new File('Data Files/promoPostTemplate.json').text
	promoPostTemplateParsed = new JsonSlurper().parseText(postRequestTemplate)
	promoPostTemplateParsed.dynamicExpression.children[0].children[0] = userGroupDataParsed //'userGroup'
	promoPostTemplateParsed.dynamicExpression.children[3].children[0] = rewardDataParsed //'reward'
	
	
	'CREATE A PROMOTION FOR EACH CATALOG CONDITION'
	for (int a; a < catalogConditionDataParsed.size(); a++) {
		println "a = " + a
		
		
		'PREPARE THE REQUEST BODY'
		promoPostTemplateParsed.name =  GlobalVariable.promoName + a
		
		if (a > 10) {
			promoPostTemplateParsed.dynamicExpression.children[2].children[0] = catalogConditionDataParsed[a]
		} else {
				promoPostTemplateParsed.dynamicExpression.children[1].children[0] = catalogConditionDataParsed[a]
		  }
		  
		promoJson = new groovy.json.JsonBuilder(promoPostTemplateParsed).toString()
		
		
		'SEND THE REQUEST'
		RequestObject promoCreate = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/_DARFT_PromoCreate')
		promoCreate.setBodyContent(new HttpTextBodyContent(promoJson))
		WS.sendRequestAndVerify(promoCreate)
		//promoPostTemplateParsed.dynamicExpression.children[1].children[0]
		//promoPostTemplateParsed.dynamicExpression.children[3].children[0]
		println 'THIS IS THE END OF THE >>>' + a + '<<< CYCLE'
	}	
}
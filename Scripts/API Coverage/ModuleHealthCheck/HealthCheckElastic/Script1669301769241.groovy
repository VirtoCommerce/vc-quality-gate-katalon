import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonOutput
import groovy.json.JsonSlurper


WebUI.comment('TEST CASE: Get information about cache and modules health')


healthyStatus = 'Healthy'
healthyModulesDecription = 'All modules are loaded'
healthyCacheDescription = 'Cache is active'
healthyElasticDescription = 'Elastic server is reachable'


'GET AND VERIFY HEALTH DATA'
healthInformationGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.HealthCheck/HealthCheck'))
if (WS.getElementPropertyValue(healthInformationGet, '"Modules health".Status') == healthyStatus) {
	WS.verifyElementPropertyValue(healthInformationGet, '"Modules health".Description', healthyModulesDecription)
	WS.verifyElementPropertyValue(healthInformationGet, '"Cache health".Description', healthyCacheDescription)
	WS.verifyElementPropertyValue(healthInformationGet, '"Cache health".Status', healthyStatus)
	WS.verifyElementPropertyValue(healthInformationGet, '"Elastic server connection".Description', healthyElasticDescription)
	WS.verifyElementPropertyValue(healthInformationGet, '"Elastic server connection".Status', healthyStatus)
} else {
		'DISPLAY ERRORS DATA'
		responseBody = healthInformationGet.getResponseBodyContent()
		responseBodyParsed = new JsonSlurper().parseText(responseBody)
		errorsData = responseBodyParsed."Modules health".Data//['VirtoCommerce.ProfileExperienceApiModule'].Errors
		errorsDataJson = new groovy.json.JsonBuilder(errorsData).toString()
		WebUI.comment("\n\n" + "\nMODULES HEALTH STATUS IS: \n" + WS.getElementPropertyValue(healthInformationGet, '"Modules health".Status') + "\nMODULES HEAlTH DESCRIPTION IS: \n" + WS.getElementPropertyValue(healthInformationGet, '"Modules health".Description') + "\nMODULES ERRORS DATA: \n" +JsonOutput.prettyPrint(errorsDataJson) + "\n\n")
		KeywordUtil.markFailed("UNHEALTHY")//just as an alternative way to fail a test case
//		WebUI.comment("\nMODULES HEALTH STATUS IS: \n" + WS.getElementPropertyValue(healthInformationGet, '"Modules health".Status'))
//		WebUI.comment("\nMODULES HEAlTH DESCRIPTION IS: \n" + WS.getElementPropertyValue(healthInformationGet, '"Modules health".Description'))
//		WebUI.comment("\nMODULES ERRORS DATA: \n" +JsonOutput.prettyPrint(errorsDataJson))
//      probably we should also cover scenarios for cache failu
//      need to explore
		
}

	
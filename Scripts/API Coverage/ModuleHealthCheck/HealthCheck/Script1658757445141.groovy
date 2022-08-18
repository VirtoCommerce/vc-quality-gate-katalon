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
//unhealthyStatus = 'Degraded'
//unhealthyModulesDecription = 'Some modules have errors'


'GET HEALTH STATUS AND DESCRIPTION OF MODULES AND CACHE'
healthInformationGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.HealthCheck/HealthCheck'))
if (WS.getElementPropertyValue(healthInformationGet, '"Modules health".Status') == healthyStatus) {
	WS.verifyElementPropertyValue(healthInformationGet, '"Modules health".Description', healthyModulesDecription)
	WS.verifyElementPropertyValue(healthInformationGet, '"Cache health".Description', healthyCacheDescription)
	WS.verifyElementPropertyValue(healthInformationGet, '"Cache health".Status', healthyStatus)
} else {
		WebUI.comment("\nMODULES HEALTH STATUS IS: \n" + WS.getElementPropertyValue(healthInformationGet, '"Modules health".Status'))
		WebUI.comment("\nMODULES HEAlTH DESCRIPTION IS: \n" + WS.getElementPropertyValue(healthInformationGet, '"Modules health".Description'))
		responseBody = healthInformationGet.getResponseBodyContent()
		responseBodyParsed = new JsonSlurper().parseText(responseBody)
		errorsData = responseBodyParsed."Modules health".Data
		errorsDataJson = new groovy.json.JsonBuilder(errorsData).toString()
		WebUI.comment("\nMODULES ERRORS DATA: \n" +JsonOutput.prettyPrint(errorsDataJson))
		//WS.verifyElementPropertyValue(healthInformationGet, '"Modules health".Status', healthyStatus)
		KeywordUtil.markFailed("UNHEALTHY")//just as an alternative way to fail test case
		//probably we should also cover scenarios for cache failure
		//need to explore
}


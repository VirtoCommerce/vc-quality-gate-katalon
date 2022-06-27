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


WebUI.comment('TEST CASE: modules managemet')


'SEND REQUEST TO RELOAD MODULES'//simple endpoints check
modulesReload = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/Modules/ModulesReload'
	))


'GET THE LIST OF INSTALLED MODULES'
modulesGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/Modules/ModulesGetInstalled'
	))


'PARSE modulesGet RESPONSE TO ANALYZE IT'
modulesGetBody = new JsonSlurper().parseText(modulesGet.getResponseBodyContent())


'GET THE QUANTITY OF MODULES IN THE LIST AND VERIFY ITS NOT EMPTY'
modulesListSize =  modulesGetBody.results.size()
assert modulesListSize != 0 && modulesListSize != null 


'FIND ASSETS MODULE IN THE LIST OF MODULES TO USE IT AS A REQUEST BODY (SEE BELOW)'//actually any module body can be used e.g. the first in the list
moduleBody = []
for (def i : (0..modulesListSize) ) {
	if((modulesGetBody.id[i] == "VirtoCommerce.Assets"))  {
		WebUI.comment(modulesGetBody.version[i].toString())
		moduleBody.add(modulesGetBody[i])
		break;
	}
}


'CONVERT moduleBody TO JSON TO USE IT AS A REQUEST BODY LATER'
moduleBodyJson = new groovy.json.JsonBuilder(moduleBody).toString()


'SEND REQUEST TO GET DEPENDENCIES'//simple endpoint check for OK status
RequestObject dependanciesGetRequest = findTestObject('API/backWebServices/VirtoCommerce.Platform/Modules/ModulesGetDependent')
dependanciesGetRequest.setBodyContent(new HttpTextBodyContent(moduleBodyJson))
dependanciesGet = WS.sendRequestAndVerify(dependanciesGetRequest)


'SEND REQUEST TO GET MISSING DEPENDENCIES'//simple endpoint check for OK status
RequestObject missingDependanciesGetRequest = findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Platform/Modules/ModulesGetMissingDependancies')
missingDependanciesGetRequest.setBodyContent(new HttpTextBodyContent(moduleBodyJson))
missingDependanciesGet = WS.sendRequestAndVerify(missingDependanciesGetRequest)



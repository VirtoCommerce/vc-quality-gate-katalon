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
import com.kms.katalon.core.testobject.ResponseObject
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper

def categoryRequest = findTestObject('API/backWebServices/VirtoCommerce.Catalog/ZHybrid/searchCategory', [('categoryName') : GlobalVariable.categoryName])
ResponseObject categoryResponse = WS.sendRequestAndVerify(categoryRequest, FailureHandling.STOP_ON_FAILURE)


def categoryJson = new JsonSlurper().parseText(categoryResponse.getResponseBodyContent());
def categoryJson2 = (categoryJson.'items')
println ("HERE RESULTS : " + categoryJson2)
for (Map map : categoryJson2) {
	if (map.name == GlobalVariable.categoryName) {
		GlobalVariable.categoryId = map.id
		println ("CATEGORY ID : " + GlobalVariable.categoryId)
		break;
	}
}
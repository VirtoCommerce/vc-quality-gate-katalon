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



WebUI.comment('TEST CASE: Assets. Check errors during to creation a new folder')

HashMap<String, String> responseMap = GlobalVariable.folderNameList
 
for (String name : responseMap.keySet()) {
	WebUI.comment("Attempt to create folder with name: \"" + name + "\". Received error should be is: " + responseMap.get(name));
	response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/_DRAFT/Assets/AssetCreateBlobFolder', [
		('folderName') : name,
		('parentUrl') : GlobalVariable.folderParentUrl
		]))
	WS.verifyElementPropertyValue(response, 'message', responseMap.get(name))
}

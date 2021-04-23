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



WebUI.comment('TEST CASE: Assets. Create new folder')

<<<<<<< Updated upstream
HashMap<String, String> responseMap = GlobalVariable.folderNameList
//println responseMap

println GlobalVariable.folderNameList

//for (String name : responseMap.keySet()) {
//	println("Attempt to create folder with name: \"" + name + "\". Received error should be: " + responseMap.get(name));
//	response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetCreateBlobFolder', [
//		('folderName') : name,
//		('parentUrl') : ''
//		]))
//	if (response.statusCode == 400) {
//		WS.verifyElementPropertyValue(response, 'message', responseMap.get(name))
//	} else if (response.statusCode == 204) {
//	println("Folder with name: \"" + name + "\" should be created on backend.");
//	}
//}



//folderUrl = GlobalVariable.urlBack + '/assets/' + GlobalVariable.folderNameList[6]
//
//WebUI.comment('TEST CASE: Assets. Delete folder')
//WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetDelete', [('itemName') : folderUrl]))


=======

HashMap<String, String> responseMap = GlobalVariable.folderNameList
println responseMap

for (String name : responseMap.keySet()) {
	println("Try name : " + name + ". Received error : " + responseMap.get(name));
	response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetCreateBlobFolder', [
		('folderName') : name,
		('parentUrl') : ''
		]))
	WS.verifyElementPropertyValue(response, 'message', responseMap.get(name))
}
>>>>>>> Stashed changes

//Map<String, String> map = new HashMap<>();
//map.put("1", "Jan");
//map.put("2", "Feb");
//for (Map.Entry<String, String> entry : map.entrySet()) {
//	System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
//}

//String status = responseMap.get('status')
//if (GlobalVariable.lastOrderStatus.equals(status)) {


//List <String> orderStatuses = GlobalVariable.folderNameList
//for (name in orderStatuses) {
//	println("The try name " + name + " with integration API")
//	WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetCreateBlobFolder', [
//		('folderName') : name,
//		('parentUrl') : ''
//		]))
//}


//save folder URL
//folderUrl = GlobalVariable.urlBack + '/assets/' + GlobalVariable.folderName
//println folderUrl

//WS.verifyElementPropertyValue(response, 'message', "Minimum length is 3. You entered 2")



//WebUI.comment('TEST CASE: Assets. Check list on CI environment. Added /assets in url')
//
//assetsList = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/AssetGetList', [
//	('folderName') : GlobalVariable.localUrl+'/assets'
//	]))
////check if new folder in the list
//WS.verifyElementPropertyValue(assetsList, 'results[1].name', GlobalVariable.folderName)
////save folder URL
//folderUrl = GlobalVariable.localUrl+'/assets/'+GlobalVariable.folderName
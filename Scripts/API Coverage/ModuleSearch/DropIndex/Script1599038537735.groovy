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


WebUI.comment('TEST CASE: run indexation and check if it is completed')


'GET INITIAL SYSTEM EVENTS COUNT'//to verify the examined operation is the expected one
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Platform/PushNotificationMarkAsRead'))
getRecentNotifications = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Platform/PushNotificationSearch'))
eventsInitialCount = WS.getElementPropertyValue(getRecentNotifications,'totalCount')
eventsActualCount = eventsInitialCount


'RUN INDEXATION'
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Search/index'))


'VERIFY THE OPERATION IS LOGGED IN THE SYSTEM EVENTS'
int a
while (eventsActualCount == eventsInitialCount) {
	a++
	getRecentNotifications = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Platform/PushNotificationSearch'))
	eventsActualCount = WS.getElementPropertyValue(getRecentNotifications,'totalCount')
	println eventsInitialCount
	println eventsActualCount
	println a
	if (a > 200) {
		throw new com.kms.katalon.core.exception.StepFailedException('ERROR: Indexation cant be logged in system events')
	}
}


'VERIFY OPERATION HAS BEEN FINISHED'
int b
def indexFinishingStatus
while (indexFinishingStatus == null) {
	b++
	getRecentNotifications = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Platform/PushNotificationSearch'))
	//assert  "title":"Indexation process",
	indexFinishingStatus = WS.getElementPropertyValue(getRecentNotifications,'notifyEvents[0].finished')
	println indexFinishingStatus
	println b
	if (b > 200) {
		throw new com.kms.katalon.core.exception.StepFailedException('ERROR: Indexation is not egtting "finished" timestamp')
	}
}

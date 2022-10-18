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


WebUI.comment('TEST CASE: RUN AND VERIFY PLATFORM INDEXATION')
/*
 * The test is timing dependant. 
 * Cancellation is only activated if indexation lasts long enough. 
 * Otherwise assertion for data not being updated fails.
 * */

'GET THE INITIAL LAST INDEXATION DATE'
initialIndexation = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleSearch/GetIndex'),
	null)
documentType = WS.getElementPropertyValue(initialIndexation, '[0].documentType')
initialDate = WS.getElementPropertyValue(initialIndexation, '[0].lastIndexationDate')


'SEND REQUEST TO RUN PLATFORM INDEXATION'
indexationRun = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Search/index'))
WebUI.comment('Waiting for drop index 10 sec')
GlobalVariable.taskId = WS.getElementPropertyValue(indexationRun, 'id')//used in index cancel test case


'SEND REQUEST TO CANCEL INDEXATION'
indexationCancel = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleSearch/IndexCancel'),
	null)
WS.delay(10)


'GET THE UPDATED INDEXATION DATE'
updatedIndexation = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleSearch/GetIndex'),
	null)
updatedDocumentType = WS.getElementPropertyValue(updatedIndexation, '[0].documentType')
updatedDate = WS.getElementPropertyValue(updatedIndexation, '[0].lastIndexationDate')


'VERIFY THE DATA HASN BEEN UPDATED'
//The initial data was deleted and the new data wasnt et so the value will be 'null'
println initialDate
println updatedDate
assert updatedDate == null


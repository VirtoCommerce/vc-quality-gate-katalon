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


'DROP INDEX'
//required to the the newly created product
dropIndex = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleSearch/DropIndex'),
	null)


'GET THE INITIAL LAST INDEXATION DATE'
initialIndexation = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleSearch/GetIndex'),
	null)
documentType = WS.getElementPropertyValue(initialIndexation, '[0].documentType')
initialDate = WS.getElementPropertyValue(initialIndexation, '[0].lastIndexationDate')


'GET THE INITIAL INDEXATION DATE FOR THE PRODUCT'
productInitialIndexationGet = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleSearch/GetIndexForProduct'),
	null)
productInitalDate = WS.getElementPropertyValue(productInitialIndexationGet, '[0].indexationdate')


'SEND REQUEST TO RUN PLATFORM INDEXATION'
//Uncomment the code and delete whats below when the bug is fixed
//https://virtocommerce.atlassian.net/browse/PT-10217	
//indexationRun = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Search/index'))
//WebUI.comment('Waiting for drop index 10 sec')
//WS.delay(10)
WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Search/index'))
WebUI.comment('Waiting for drop index 10 sec')
WS.delay(10)
indexationRun = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Search/indexWithoutDeleting'))
WebUI.comment('Waiting for build index 10 sec')
WS.delay(10)

GlobalVariable.taskId = WS.getElementPropertyValue(indexationRun, 'id')//used in index cancel test case


'GET THE UPDATED INDEXATION DATE'
updatedIndexation = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleSearch/GetIndex'),
	null)
updatedDocumentType = WS.getElementPropertyValue(updatedIndexation, '[0].documentType')
updatedDate = WS.getElementPropertyValue(updatedIndexation, '[0].lastIndexationDate')


'GET THE UPDATED INDEXATION DATE FOR THE PRODUCT'
productUpdatedIndexationGet = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleSearch/GetIndexForProduct'),
	null)
productUpdatedDate = WS.getElementPropertyValue(productUpdatedIndexationGet, '[0].indexationdate')


'VERIFY THE DATA WAS UPDATED'
assert documentType == updatedDocumentType
assert initialDate < updatedDate
assert productInitalDate < productUpdatedDate


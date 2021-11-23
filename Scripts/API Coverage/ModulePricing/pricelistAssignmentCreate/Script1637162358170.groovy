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


WebUI.comment('TEST CASE: CREATE AN ASSIGNMENT FOR THE PRICELIST')


'CREATE AN ASSIGNMENT FOR THE PRICELIST'
assignmentName = 'QweAssignment'
createAssignment = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Pricing/PricelistCreateAssignment',[
	('catalogId') : GlobalVariable.catalogId,
	('pricelistId') : GlobalVariable.pricelistId,
	('name') : assignmentName
	]))


'VERIFY THE ASSIGNMENT HAS BEEN CREATED'
verifyAssignment = WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistAssignmentsSearch'),
	null
	)
WS.verifyElementPropertyValue(verifyAssignment,'totalCount', '1')	
WS.verifyElementPropertyValue(verifyAssignment,'results[0].catalogId', GlobalVariable.catalogId)
WS.verifyElementPropertyValue(verifyAssignment,'results[0].pricelistId', GlobalVariable.pricelistId)
WS.verifyElementPropertyValue(verifyAssignment,'results[0].name', assignmentName)


'EXTRACT THE CREATED ASSIGNMENT ID'
GlobalVariable.id = WS.getElementPropertyValue(verifyAssignment,'results[0].id')
WebUI.comment('ASSIGNMENT ID IS: ' + GlobalVariable.id)


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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


'PART 1'


'PRECONDITION'
contentItemAdd = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleMarketing/ContentItems/contentItemCreate'), 
	null)

contentPlaceholderAdd = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleMarketing/ContentPlaceholders/contentPlaceholderAdd'), 
	null)


'ACTUAL SUITE'
contentPublicationAdd = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleMarketing/ContentPublications/contentPublicationAdd'), 
	null)

contentPublicationUpdate = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleMarketing/ContentPublications/contentPublicationUpdate'), 
	null)

deletePublication = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleMarketing/ContentPublications/contentPublicationDelete'), 
	null)


'POSTCONDITION'
deleteItem = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleMarketing/ContentItems/contentItemDelete'), 
	null)

deletePlaceholder = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleMarketing/ContentPlaceholders/contentPlaceholderDelete'),
	null)


'PART 2 (Bulk case)'
publicationsDeleteBulk = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleMarketing/ContentPublications/contentPublicationDeleteBulk'),
	null)
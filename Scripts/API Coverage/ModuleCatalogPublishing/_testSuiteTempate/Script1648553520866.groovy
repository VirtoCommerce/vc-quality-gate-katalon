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


'PRECONDITION'
WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/catalogCreate'), null)
WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/categoryCreate'), null)
WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/productCreate'), null)

WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/pricelistCreate'), null)
WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistAssignmentCreate'), null)


channelCreate = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalogPublishing/сhannelCreate'), 
	null)

channelCompletenessEvaluate = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalogPublishing/completenessChannelEvaluate'), 
	null)

productCompletenessEvaluateAndUpdate = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalogPublishing/competenessProductEvaluateAndSave'), 
	null)

channelCompletenessEvaluate = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalogPublishing/completenessChannelEvaluate'),
	null)

//another channel part
channelCreate = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalogPublishing/сhannelCreate'), 
	null)

channelEdit = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalogPublishing/channelEdit'), 
	null)

channelChange = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalogPublishing/channelChangeCatalog'), 
	null)

channelDelete = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalogPublishing/channelsDelete'),
	null)

'POSTCONDITION'
WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/categoryDelete'),null)
WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/productsDelete'),null)
WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/catalogDelete'),null)
WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/pricelistDelete'),null)



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

WebUI.comment('TEST CASE: Update store')

//Update the created store
GlobalVariable.storeName = 'updated' + GlobalVariable.storeName
GlobalVariable.catalogId = '7829d35f417e4dd98851f51322f32c23' //Bolts catalog Id
updateStore = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Store/StoreUpdate',[
	('storeId') : GlobalVariable.storeId,
	('name') : GlobalVariable.storeName,
	('catalogId') : GlobalVariable.catalogId,
	('defaultLanguage') : 'fr-FR',
	('defaultCurrency') : 'EUR',
	('storeState') : 'Closed',
	('storeUrl') : GlobalVariable.urlFront
	]))

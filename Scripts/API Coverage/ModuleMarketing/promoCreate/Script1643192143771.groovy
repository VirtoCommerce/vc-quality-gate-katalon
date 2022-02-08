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
import groovy.json.JsonSlurper


WebUI.comment('CREATE PROMOTION')

//For now this promotion doesnt have any conditions
'CREATE A PROMOTION'
GlobalVariable.promoName = GlobalVariable.firstName + 'Promo'
promoCreate = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/PromoCreate',[
	('name') : GlobalVariable.promoName
	]))


'SEARCH FOR THE PROMO VERIFY THE PROMOTION HAS BEEN CREATED SUCCESSFULLY'
searchPromo = WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/VirtoCommerce.Marketing/PromoSearch',[
	('keyword') : GlobalVariable.firstName
	]))
WS.verifyElementPropertyValue(searchPromo,'results[0].name', GlobalVariable.promoName)


'GET THE ID OF THE CREATED PROMOTION'
GlobalVariable.promoId = WS.getElementPropertyValue(promoCreate,'id')

return promoCreate
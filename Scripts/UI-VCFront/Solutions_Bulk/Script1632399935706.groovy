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


List<String> urls = [
	//B2X ECOMMERCE SOLUTIONS
	'b2c-webshop',
	'digital-catalog',
	'saas-on-top-of-virto-commerce-platform',
	'page-builder',
	'chatbot',
	//B2B PORTALS
	'b2b-portal',
	'vendor-portal',
	'loyalty-portal',
	//BY INDUSTRY
	//B2B ecommerce solutions for distributors
	'b2b-portal-for-distributors',
	'b2b2c-webshop-for-distributors',
	'b2b2c-marketplace-for-distributors',
	//Manufacturing + HVAC B2B solutions 
	'digital-catalog-for-manufacturers',
	'b2b-portal-for-manufacturers',
	'd2c-loyalty-portal',
	//Retail
	'vendor-portal-for-retail',
	'b2c-webshop-for-retail'
	]

for (int i; i < urls.size(); i++) {
	
    WebUI.navigateToUrl(GlobalVariable.urlFront + '/solutions/' + urls.get(i))

    WebUI.setText(findTestObject('UI/UI-VCFront/main_Call_form_objects/input_First_name'), 'John QA')

    WebUI.setText(findTestObject('UI/UI-VCFront/main_Call_form_objects/input_Last_name'), 'Doe QA')

    WebUI.setText(findTestObject('UI/UI-VCFront/main_Call_form_objects/input_Email'), 'test@virtoway.com')

    WebUI.setText(findTestObject('UI/UI-VCFront/main_Call_form_objects/input_Company'), 'VC QA test')

    WebUI.selectOptionByValue(findTestObject('UI/UI-VCFront/main_Call_form_objects/select_Job_title'), 'Developer', true)

    WebUI.scrollToElement(findTestObject('UI/UI-VCFront/main_Call_form_objects/input_Last_name'), 1)

	WebUI.clickOffset(findTestObject('UI/UI-VCFront/main_Call_form_objects/checkbox_Terms'), 150, 10)
		
    WebUI.click(findTestObject('UI/UI-VCFront/main_Call_form_objects/button_Submit'))

	WebUI.verifyElementText(findTestObject('UI/UI-VCFront/Page_ThankYou/span_Thank_you'), 'Thank you!')
	
	assert WebUI.getUrl() == (GlobalVariable.urlFront + '/thank-you')
}
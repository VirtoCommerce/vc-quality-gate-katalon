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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.Cookie as Cookie

WebUI.openBrowser(GlobalVariable.urlFront+'/en-US/account/login')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('UI-Electronics/SignInPage/EmailCustomerLogin'), GlobalVariable.userName)

WebUI.setText(findTestObject('UI-Electronics/SignInPage/PasswordCustomerLogin'), GlobalVariable.userPassword)

WebUI.click(findTestObject('UI-Electronics/SignInPage/SignInSubmitButton'))


//WebUI.click(findTestObject('UI-Electronics/Header/SignInButtonHeader'))
//if (GlobalVariable.userName != "" && GlobalVariable.userPassword != ""){
//	
//	WebUI.setText(findTestObject('UI-Electronics/SignInPage/EmailCustomerLogin'), GlobalVariable.userName)
//	
//	WebUI.setText(findTestObject('UI-Electronics/SignInPage/PasswordCustomerLogin'), GlobalVariable.userPassword)
//	
//	WebUI.click(findTestObject('UI-Electronics/SignInPage/SignInSubmitButton'))
//	
//	String GetText = WebUI.getText(findTestObject('UI-Electronics/Header/HeaderLogoutText'))
//	
//	WebUI.verifyMatch(GetText, GlobalVariable.firstName, false)
//	
//	}

driver = DriverFactory.getWebDriver()
//x = driver.manage().getCookies() // all cookies
//x = driver.manage().getCookieNamed("cookie") // part of cookies
//println('COOKIE : ' + x )


String cookieString = ''
// get all the cookies
Set<Cookie> cookieCollection = driver.manage().getCookies()
println(cookieCollection)


// a list of the cookies we want to use in our API calls later (these will get copied) ** must match EXACTLY
def interestingCookies = ['ASP.NETSession', '.AspNetCookies']
// loop through each cookie and append COOKIENAME=COOKIEVALUE; to the temp variable
for (Cookie currentCookie : cookieCollection) {
	if (interestingCookies.contains(currentCookie.getName())) {
		cookieString += (((currentCookie.getName() + '=') + currentCookie.getValue()) + '; ')
	}
}
// print the cookies for debugging
println(cookieString)
// set the cookies to our global variable. This is the most important bit!
GlobalVariable.cookies = cookieString


// done! close the browser
WebUI.closeBrowser()


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

WebUI.openBrowser('https://qa-demovc-store.azurewebsites.net/en-US/camcorders/aerial-imaging-drones/3dr-solo-quadcopter-no-gimbal')

WebUI.verifyElementClickable(findTestObject('Breadcrumb/LastItemBreadcrumbs'))

WebUI.click(findTestObject('Breadcrumb/ItemBreadCrumbs'))

String ExpectedUrl = 'https://qa-demovc-store.azurewebsites.net/en-US/camcorders/aerial-imaging-drones'

String CurrentUrl = WebUI.getUrl()

WebUI.verifyEqual(CurrentUrl, ExpectedUrl)

WebUI.navigateToUrl('https://qa-demovc-store.azurewebsites.net/en-US/camcorders/aerial-imaging-drones/3dr-solo-quadcopter-no-gimbal')

WebUI.click(findTestObject('Breadcrumb/HomeBreadCrumbs'))

String ExpectedUrlHome = 'https://qa-demovc-store.azurewebsites.net/en-US/'

String CurrentUrlHome = WebUI.getUrl()

WebUI.verifyEqual(CurrentUrlHome, ExpectedUrlHome)


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
import java.util.Iterator as Iterator
import java.util.List as List
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import java.util.Arrays as Arrays

WebUI.callTestCase(findTestCase('Test Cases/SystemCases/WindowtoFullSize'), [:], FailureHandling.STOP_ON_FAILURE)


WebUI.waitForPageLoad(2)

WebUI.mouseOver(findTestObject('UI/Page_Electronics/a_Camcorders'))

WebUI.click(findTestObject('UI/Page_Electronics/AeriaImagingDrones'))

List<String> ProductsInCategoryPage = WebUI.findWebElements(findTestObject('UI/AerialImagingCategory/ItemProduct'), 
    2)

float[] ArrayFloatPrice = new float[ProductsInCategoryPage.size()]

for (int i = 0; i < ProductsInCategoryPage.size(); i++) {
    String ProductPrice = (ProductsInCategoryPage[i]).findElement(By.tagName('small')).getText()

    String OnlyPrice = ProductPrice.replace('$', '').replace(',', '')

    Float FloatOnlyPrice = Float.parseFloat(OnlyPrice)

    (ArrayFloatPrice[i]) = FloatOnlyPrice
}

Arrays.sort(ArrayFloatPrice)

float FirstNumberFloatPrice = ArrayFloatPrice[0]

float LastNumberFloatPrice = ArrayFloatPrice[(ArrayFloatPrice.size() - 1)]

WebUI.selectOptionByIndex(findTestObject('UI/AerialImagingCategory/SortBySelect'), 4)

List<String> SortingProductsInCategoryPage = WebUI.findWebElements(findTestObject('UI/AerialImagingCategory/ItemProduct'), 
    2)

float[] ArrayFloatPriceSorting = new float[SortingProductsInCategoryPage.size()]

for (int i = 0; i < SortingProductsInCategoryPage.size(); i++) {
    String ProductPrice = (SortingProductsInCategoryPage[i]).findElement(By.tagName('small')).getText()

    String OnlyPrice = ProductPrice.replace('$', '').replace(',', '')

    Float FloatOnlyPrice = Float.parseFloat(OnlyPrice)

    (ArrayFloatPriceSorting[i]) = FloatOnlyPrice
}

float FirstNumberFloatPriceSorting = ArrayFloatPriceSorting[0]

float LastNumberFloatPriceSorting = ArrayFloatPriceSorting[(ArrayFloatPriceSorting.size() - 1)]

WebUI.verifyEqual(FirstNumberFloatPriceSorting, LastNumberFloatPrice)

WebUI.verifyEqual(LastNumberFloatPriceSorting, FirstNumberFloatPrice)

WebUI.closeBrowser()


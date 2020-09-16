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

def DataFromFile =  WebUI.callTestCase(findTestCase('Test Cases/SystemCases/PrepareData'), [:], FailureHandling.STOP_ON_FAILURE)

def CorrectSearchRequest = DataFromFile.CorrectSearchRequest

WebUI.callTestCase(findTestCase('Test Cases/SystemCases/WindowtoFullSize'), [:], FailureHandling.STOP_ON_FAILURE)


WebUI.click(findTestObject('UI-Electronics/Header/Search line'))

String SearchResult = CorrectSearchRequest

WebUI.setText(findTestObject('UI-Electronics/Header/Search line'), SearchResult)

String TextinHelper = WebUI.getText(findTestObject('UI-Electronics/Header/SearchLineHelper')).toLowerCase()
System.out.println(TextinHelper)
System.out.println(SearchResult)
int indexSearchlineHelper = TextinHelper.indexOf(SearchResult)

if (indexSearchlineHelper == -1) {
   System.out.println('word is absent in the helper')
} else {
    WebUI.click(findTestObject('UI-Electronics/Header/ButtonSearchHeader'))

    String SearchResultUp = SearchResult.toUpperCase()

    String SearchResultLow = SearchResult.toLowerCase()

    String SearchResultCheck = ('YOUR SEARCH FOR "' + SearchResultUp) + '" REVEALED THE FOLLOWING:'

    WebUI.verifyElementText(findTestObject('UI-Electronics/SearchResultPage/H2SearchResultTitle'), SearchResultCheck)

    List<String> SearchResultItem = WebUI.findWebElements(findTestObject('UI-Electronics/Page_Electronics/ItemSearchResult'), 
        2)

    for (int i = 0; i < SearchResultItem.size(); i++) {
        String ProductNameSearchResultItem = (SearchResultItem[i]).findElement(By.tagName('p')).getText()

        String LowerProductNameSearch = ProductNameSearchResultItem.toLowerCase()

        int indexSearch = LowerProductNameSearch.indexOf(SearchResultLow)
    }
    
    WebUI.verifyElementPresent(findTestObject('UI-Electronics/SearchResultPage/PriceSearchResultItem'), 0)

    WebUI.verifyElementPresent(findTestObject('UI-Electronics/SearchResultPage/PTagSearchResultItem'), 0)

    WebUI.closeBrowser()
}


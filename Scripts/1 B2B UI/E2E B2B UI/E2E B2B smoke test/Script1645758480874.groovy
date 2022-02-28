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

//OPEN BROWSER
WebUI.openBrowser(GlobalVariable.urlFront)
WebUI.maximizeWindow()

/*
//LINKS ON THE MAIN PAGE
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!FOGOT PASSWORD MAIN PAGE - NOT READY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//WebUI.click(findTestObject('1 UI-B2B ST/Login page/links/a_fogotPassword'))
//WebUI.waitForPageLoad(3)
//WebUI.setText(findTestObject('1 UI-B2B ST/Login page/links/input_mail'), GlobalVariable.contactEmail))
//WebUI.click(findTestObject('1 UI-B2B ST/Login page/links/button_submitNewPassword'))
//def search1 = WebUI.getText(findTestObject('1 UI-B2B ST/Login page/links/text_resetPasswordSuccess'))
//WebUI.verifyMatch(search1, "We've sent you an email with a link to update your password.", false)


//check subscribe
WebUI.setText(findTestObject('1 UI-B2B ST/Login page/links/input_SubscribeEmail'), GlobalVariable.mailSubscribe)
WebUI.click(findTestObject('1 UI-B2B ST/Login page/links/button_Subscribe'))

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!how to change window!!!!!!!!!!!!!!!!!!!!!

//check link to B2B credentials
WebUI.click(findTestObject('1 UI-B2B ST/Login page/links/a_follow the link to access the B2B'))
WebUI.switchToWindowUrl(GlobalVariable.B2BCredentialsPage)
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Login page/links/a_B2BCredentialsPage'))
WebUI.verifyTextPresent('B2B theme: demo environments details', false)
WebUI.closeWindowUrl(GlobalVariable.B2BCredentialsPage)
//WebUI.switchToWindowUrl(GlobalVariable.urlFront)
*/



//REGISTER AS PERSON
//open register page
WebUI.click(findTestObject('1 UI-B2B ST/Registration/a_RegisterPage'))

//select personal
WebUI.click(findTestObject('1 UI-B2B ST/Registration/personal account/LabelPersonal'))

//enter contact information information
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_FirstName'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_FirstName'), GlobalVariable.personFirstName)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_LastName'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_LastName'), GlobalVariable.personLastName)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_Email'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_Email'), "3" + GlobalVariable.personEmail)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_Phone'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_Phone'), GlobalVariable.personPhone)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/button_SubmitContinueFirstStep'))

//enter company address
WebUI.selectOptionByLabel(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/select_Select countryCanada'), 'Canada', false)
WebUI.selectOptionByLabel(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/select_Select ProvinceAlberta'), 'Alberta', false)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_PostalCode'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_PostalCode'), GlobalVariable.organizationPostalCode)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_City'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_City'), GlobalVariable.organizationCity)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_Road'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_Road'), GlobalVariable.organizationStreet)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/button_SubmitContinueSecondStep'))

//enter user credentials
//password = GlobalVariable.UserName + "!"
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_UserName'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_UserName'), GlobalVariable.personUserName)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_Password'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_Password'), GlobalVariable.userPassword)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_PasswordConfirm'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_PasswordConfirm'), GlobalVariable.userPassword)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/button_SubmitFinal'))


//CHECK account name after  login
WebUI.waitForPageLoad(10)
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Registration/text_VerifyAccountName'), 0)
def PersonName = WebUI.getText(findTestObject('1 UI-B2B ST/Registration/text_VerifyAccountName'))
def PersonFullName = GlobalVariable.personFirstName +' '+ GlobalVariable.personLastName
WebUI.verifyMatch(PersonName, PersonFullName, false)
String urlPerson = GlobalVariable.urlFront + 'account#/'
WebUI.verifyEqual(WebUI.getUrl(), urlPerson)


//LOG OUT
WebUI.click(findTestObject('1 UI-B2B ST/Home page elements/Log out/a_AccountDropDownMenu'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Log out/ISignOut'))
WebUI.click(findTestObject('1 UI-B2B ST/Home page elements/Log out/ISignOut'))
WebUI.waitForPageLoad(10)
WebUI.verifyElementNotPresent(findTestObject('1 UI-B2B ST/Registration/text_VerifyAccountName'), 2)





//REGISTER AS ORGANIZATION
//open register page
WebUI.click(findTestObject('1 UI-B2B ST/Registration/a_RegisterPage'))

//enter contact information information
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_FirstName'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_FirstName'), GlobalVariable.contactFirstName)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_lastName'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_lastName'), GlobalVariable.contactLastName)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_Email'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_Email'), "3" + GlobalVariable.contactEmail)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_Phone'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_Phone'), GlobalVariable.contactPhone)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/button_SubmitContinueFirstStep'))

//enter company name
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_CompanyName'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_CompanyName'), GlobalVariable.organizationName)

//enter company address
WebUI.selectOptionByLabel(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/select_Select countryCanada'), 'Canada', false)
WebUI.selectOptionByLabel(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/select_Select ProvinceAlberta'), 'Alberta', false)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_PostalCode'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_PostalCode'), GlobalVariable.organizationPostalCode)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_City'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_City'), GlobalVariable.organizationCity)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_Road'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_Road'), GlobalVariable.organizationStreet)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/button_SubmitContinueSecondStep'))

//enter user credentials
//password = GlobalVariable.UserName + "!"
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_UserName'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_UserName'), GlobalVariable.userName)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_Password'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_Password'), GlobalVariable.userPassword)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_PasswordConfirm'))
WebUI.setText(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/input_PasswordConfirm'), GlobalVariable.userPassword)
WebUI.click(findTestObject('1 UI-B2B ST/Registration/registerBusinessAccount/button_SubmitFinal'))


//CHECK account name after  login
WebUI.waitForPageLoad(10)
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Registration/text_VerifyAccountName'), 0)
def AccountName = WebUI.getText(findTestObject('1 UI-B2B ST/Registration/text_VerifyAccountName'))
def FullName = GlobalVariable.contactFirstName +' '+ GlobalVariable.contactLastName
WebUI.verifyMatch(AccountName, FullName, false)
String url = GlobalVariable.urlFront + 'account#/'
WebUI.verifyEqual(WebUI.getUrl(), url)


//LOG OUT
WebUI.click(findTestObject('1 UI-B2B ST/Home page elements/Log out/a_AccountDropDownMenu'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Log out/ISignOut'))
WebUI.click(findTestObject('1 UI-B2B ST/Home page elements/Log out/ISignOut'))
WebUI.waitForPageLoad(10)
WebUI.verifyElementNotPresent(findTestObject('1 UI-B2B ST/Registration/text_VerifyAccountName'), 2)





//LOGIN
WebUI.click(findTestObject('1 UI-B2B ST/Login page/Log In/input_UserName'))
WebUI.setText(findTestObject('1 UI-B2B ST/Login page/Log In/input_UserName'), GlobalVariable.userName)
WebUI.click(findTestObject('1 UI-B2B ST/Login page/Log In/input_Password'))
WebUI.setText(findTestObject('1 UI-B2B ST/Login page/Log In/input_Password'), GlobalVariable.userPassword)
WebUI.click(findTestObject('1 UI-B2B ST/Login page/Log In/button_Login'))




//HEADERS
//check header 1st - CHECK FIRST LINE AS verifyElementText AND NOT verifyElementPresent
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Header/1st header/a_MyAccount'))
WebUI.verifyElementText(findTestObject('1 UI-B2B ST/Home page elements/Header/1st header/a_MyAccount'), 'My Account')
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Header/1st header/a_OrderHistory'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Home page elements/Header/1st header/a_OrderHistory'), 4)
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Header/1st header/a_Lists'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Home page elements/Header/1st header/a_Lists'), 4)
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Header/1st header/a_Account'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Home page elements/Header/1st header/a_Account'), 4)

//check header 2nd
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!CAN NOT VERIFY AN IMAGE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Header/1st header/a_MyAccount'))
//WebUI.verifyImagePresent(findTestObject('1 UI-B2B ST/Home page elements/Header/2nd header/img_Logo'), 4)
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Header/2nd header/div_OrganizationName'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Home page elements/Header/2nd header/div_OrganizationName'), 4)
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Header/2nd header/a_GeneralCatalogue'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Home page elements/Header/2nd header/a_GeneralCatalogue'), 4)
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Header/2nd header/a_FindBranch'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Home page elements/Header/2nd header/a_FindBranch'), 4)
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Header/2nd header/a_ContactUs'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Home page elements/Header/2nd header/a_ContactUs'), 4)

//check header 3d
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Header/3rd header/a_AllProducts'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Home page elements/Header/3rd header/a_AllProducts'), 4)
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Header/3rd header/input_SearchTab'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Home page elements/Header/3rd header/input_SearchTab'), 4)
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!CAN NOT VERIFY A BUTTON!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Header/3rd header/button_Search'))
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Home page elements/Header/3rd header/button_Search'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Header/3rd header/a_BulkOrderPad'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Home page elements/Header/3rd header/a_BulkOrderPad'), 4)
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Header/3rd header/a_CartLInk'))
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Home page elements/Header/3rd header/a_CartLInk'))




//FOOTER
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Footer/div_CompanyInformation'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Home page elements/Footer/div_CompanyInformation'), 4)
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Footer/div_CustomerSupport'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Home page elements/Footer/div_CustomerSupport'), 4)
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Footer/div_OnlineResources'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Home page elements/Footer/div_OnlineResources'), 4)
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Footer/div_OrderSupport'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Home page elements/Footer/div_OrderSupport'), 4)



//SEARCH
//searh full name
WebUI.setText(findTestObject('1 UI-B2B ST/Home page elements/Header/3rd header/input_SearchTab'), GlobalVariable.searchFullName)
WebUI.click(findTestObject('1 UI-B2B ST/Home page elements/Header/3rd header/button_Search'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Search/h2_SearchResultFullName'))
def search1 = WebUI.getText(findTestObject('1 UI-B2B ST/Home page elements/Search/h2_SearchResultFullName'))
WebUI.verifyMatch(search1, 'YOUR SEARCH FOR "LASER" REVEALED THE FOLLOWING:', false)

//searh part name
WebUI.setText(findTestObject('1 UI-B2B ST/Home page elements/Header/3rd header/input_SearchTab'), GlobalVariable.searchPartName)
WebUI.click(findTestObject('1 UI-B2B ST/Home page elements/Header/3rd header/button_Search'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Search/h2_SearchResultPartName'))
def search2 = WebUI.getText(findTestObject('1 UI-B2B ST/Home page elements/Search/h2_SearchResultPartName'))
WebUI.verifyMatch(search2, 'YOUR SEARCH FOR "PRIN" REVEALED THE FOLLOWING:', false)



//BULK ORDER
//add bulk pad item number correct
WebUI.click(findTestObject('1 UI-B2B ST/Home page elements/Bulk Order/a_OpenBulkOrderPad'))
WebUI.click(findTestObject('1 UI-B2B ST/Home page elements/Bulk Order/input_FillSku'))
WebUI.setText(findTestObject('1 UI-B2B ST/Home page elements/Bulk Order/input_FillSku'), GlobalVariable.skuCorrect)
WebUI.click(findTestObject('1 UI-B2B ST/Home page elements/Bulk Order/button_AddToCart'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Home page elements/Bulk Order/a_VerifyCartOpens'),4) 
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Bulk Order/div_CartProductList'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Home page elements/Bulk Order/span_VerifyItemCorrectSku'),4)
WebUI.verifyTextPresent(GlobalVariable.skuCorrect,false)

//add bulk pad item number not correct
WebUI.click(findTestObject('1 UI-B2B ST/Home page elements/Bulk Order/a_OpenBulkOrderPad'))
WebUI.click(findTestObject('1 UI-B2B ST/Home page elements/Bulk Order/input_FillSku'))
WebUI.setText(findTestObject('1 UI-B2B ST/Home page elements/Bulk Order/input_FillSku'), GlobalVariable.skuNotCorrect)
WebUI.click(findTestObject('1 UI-B2B ST/Home page elements/Bulk Order/button_AddToCart'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Home page elements/Bulk Order/dl_VeryfiAlertBlock'),4)




//CHECK CATEGORY PAGES
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_AllProductsCatalog'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_CarriageBolts'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/h1_CarriageBolts'))
WebUI.verifyTextPresent('Carriage Bolts', false)
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_AllProductsCatalog'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_FlangeBolts'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/h1_FlangeBolts'))
WebUI.verifyTextPresent('Flange Bolts', false)
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_AllProductsCatalog'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_InkjetPrinters'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/h1_InkjetPrinters'))
WebUI.verifyTextPresent('Inkjet Printers', false)
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_AllProductsCatalog'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_LaserPrinters'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/h1_LaserPrinters'))
WebUI.verifyTextPresent('Laser Printers', false)




//ADD PRODUCT
//add from catalog
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_AllProductsCatalog'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_CarriageBolts'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Add product/div_ProductBlock'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Add product/button_AddFromCatalog'))
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Catalog/Add product/div_PopUpProductAdded'))
def AddCartCatalog = WebUI.getText(findTestObject('1 UI-B2B ST/Catalog/Add product/h4_PopupTitle'))
WebUI.verifyMatch(AddCartCatalog, "1 ITEM WAS ADDED TO CART", false)

// PopUpButtonContinueShopping test-case
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Add product/button_PopUpButtonContinueShopping'))

//add from product page
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_AllProductsCatalog'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_InkjetPrinters'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Add product/div_ProductBlock'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Add product/a_OpenProduct'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Add product/button_AddFromProductPage'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Add product/div_PopUpProductAdded'))
def AddCartProductPage = WebUI.getText(findTestObject('1 UI-B2B ST/Catalog/Add product/h4_PopupTitle'))
WebUI.verifyMatch(AddCartProductPage, "1 ITEM WAS ADDED TO CART", false)

//PopUpButtonViewCart test-case
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Add product/button_PopUpButtonViewCart'))



//FILTERS
//filter 1
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_AllProductsCatalog')) 
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_CarriageBolts'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Filters/filter1/div_FilterPriceBlock'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Filters/filter1/a_FilterPrice10-20'))
WebUI.waitForPageLoad(5)
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Filters/div_Applied filtersBlock'))
WebUI.verifyElementText(findTestObject('1 UI-B2B ST/Catalog/Filters/filter1/li_10-20'), '10-20')
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Filters/filter1/div_FilterPriceBlock'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Filters/filter1/a_FilterPrice10-20'))
WebUI.waitForPageLoad(5)

//filter 2
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Filters/Filter2/div_FilterMaterialBlock'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Filters/Filter2/a_FilterMaterial5'))
WebUI.waitForPageLoad(5)
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Filters/div_Applied filtersBlock'))
WebUI.verifyElementText(findTestObject('1 UI-B2B ST/Catalog/Filters/Filter2/li_5'), '5')
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Filters/Filter2/div_FilterMaterialBlock'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Filters/Filter2/a_FilterMaterial5'))
WebUI.waitForPageLoad(5)



//SORTING 
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!HOW TO VERIFY?!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_AllProductsCatalog'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_InkjetPrinters'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Sorting/a_Featured'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Sorting/a_Price, high to low'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Sorting/a_Featured'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Sorting/a_Price, low to high'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Sorting/a_Featured'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Sorting/a_Alphabetically, A-Z'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Sorting/a_Featured'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Sorting/a_Alphabetically, Z-A'))



//PRODUCT VIEW
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_AllProductsCatalog'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_InkjetPrinters'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Add product/div_ProductBlock'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Catalog/Product/Product view/img_Image'), 4)
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Catalog/Product/Product view/div_CompareCheckBox'), 4)
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Catalog/Product/Product view/a_ProductTitle'), 4)
WebUI.verifyElementText(findTestObject('1 UI-B2B ST/Catalog/Product/Product view/span_ProductItem'), 'Item #')
WebUI.verifyElementText(findTestObject('1 UI-B2B ST/Catalog/Product/Product view/span_ProductModel'), 'Mfr. model #')
WebUI.verifyElementText(findTestObject('1 UI-B2B ST/Catalog/Product/Product view/span_TitleYour price'), 'Your price')
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Catalog/Product/Product view/span_TitleYour price'), 4)
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Catalog/Product/Product view/input_ProductAmountField'), 4)
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Catalog/Add product/button_AddFromCatalog'),4)




//COMPARE PRODUCTS
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_AllProductsCatalog'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_CarriageBolts'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Product/Compare product/div_ComparedProduct1'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Product/Product view/div_CompareCheckBox'))
WebUI.waitForPageLoad(5)
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Add product/div_ProductBlock'))
WebUI.scrollToElement(findTestObject('1 UI-B2B ST/Catalog/Add product/div_ProductBlock'),3)
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Product/Compare product/div_ComparedProduct2'))
WebUI.waitForPageLoad(5)
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Catalog/Product/Compare product/ul_Item 553390824'))
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Catalog/Product/Compare product/div_Object1'))
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Catalog/Product/Compare product/div_Object2'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Product/Compare product/button_CleanComparedProducts'))
WebUI.verifyElementNotPresent(findTestObject('1 UI-B2B ST/Catalog/Product/Compare product/ul_Item 553390824'),3)



//CHECK PRODUCT PAGE
//Check product with variations
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_AllProductsCatalog'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_CarriageBolts'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Add product/div_ProductBlock'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Add product/a_OpenProduct'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Catalog/Product/Variations/with variations/div_ProductVariationsBlock'), 4)

//Check product without variations
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_AllProductsCatalog'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_InkjetPrinters'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Add product/div_ProductBlock'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Add product/a_OpenProduct'))
WebUI.verifyElementNotPresent(findTestObject('1 UI-B2B ST/Catalog/Product/Variations/with variations/div_ProductVariationsBlock'), 4)





//LINKS ON PRODUCT PAGE
//1 - add to the wish list
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_AllProductsCatalog'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_InkjetPrinters'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Add product/div_ProductBlock'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Add product/a_OpenProduct'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Catalog/Product/Product links/AddToTheList/span_ChooseWishList'), 3)
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Product/Product links/AddToTheList/span_ChooseWishList'))
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Catalog/Product/Product links/AddToTheList/div_PopUpAddToList'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Product/Product links/AddToTheList/label_AddToWishList'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Product/Product links/AddToTheList/button_AddToList'))
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Catalog/Product/Product links/AddToTheList/div_PopUpItemAddedToList'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Product/Product links/AddToTheList/button_ViewListPage'))
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Catalog/Product/Product links/AddToTheList/div_CheckYourListPage'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Product/Product links/AddToTheList/button_RemoveItemFromWishList'))
WebUI.verifyElementNotPresent(findTestObject('1 UI-B2B ST/Catalog/Product/Product links/AddToTheList/div_CheckYourListPage'), 4)


//2 - send mail
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_AllProductsCatalog'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_InkjetPrinters'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Add product/div_ProductBlock'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Add product/a_OpenProduct'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Catalog/Product/Product links/Mail/a_Email'), 3)
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Product/Product links/Mail/a_Email'))
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Catalog/Product/Product links/Mail/div_PopUpSendMail'))
WebUI.setText(findTestObject('1 UI-B2B ST/Catalog/Product/Product links/Mail/input_MailField'), GlobalVariable.mailSendProduct)
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Product/Product links/Mail/button_SendMail'))


//3 - print 
//doesnt work!!!/!!!!!!!!!!!!!!!!!!!!!!!!!! CHECK THE TEST CASE!!!!!!!!!!!!!!!!!!!!!!!!





//CHECK OUT
//add product 1 with variables
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_AllProductsCatalog'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_CarriageBolts'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Add product/div_ProductBlock'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Add product/a_OpenProduct'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Add to the card/div_CustomizeOrderBlock'))
WebUI.setText(findTestObject('1 UI-B2B ST/Check Out/Create order/Add to the card/input_QuantityForProductWithVariables'), '1')
def productName1 = WebUI.getText(findTestObject('1 UI-B2B ST/Check Out/Create order/Add to the card/h1_ProductTitle1'))
WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Add to the card/button_AddToCart'))
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Catalog/Add product/div_PopUpProductAdded'))

//PopUpButtonContinueShopping test-case
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Add product/button_PopUpButtonContinueShopping'))


//add product 2 without variation
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_AllProductsCatalog'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/CategoryPages/a_InkjetPrinters'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Add product/div_ProductBlock'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Add product/a_OpenProduct'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Add to the card/h1_ProductTitle2'))
def productName2 = WebUI.getText(findTestObject('1 UI-B2B ST/Check Out/Create order/Add to the card/h1_ProductTitle2'))
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Add product/button_AddFromProductPage'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Catalog/Add product/div_PopUpProductAdded'))

//PopUpButtonViewCart test-case
WebUI.click(findTestObject('1 UI-B2B ST/Catalog/Add product/button_PopUpButtonViewCart'))

//VERIFY CART Page 1
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Check Out/Create order/MainElementsForCheckOut/div_MyCartPage1Opens'))
productName1 == WebUI.getText(findTestObject('1 UI-B2B ST/Check Out/Create order/MainElementsForCheckOut/div_MyCartPage1Opens'))
productName2 == WebUI.getText(findTestObject('1 UI-B2B ST/Check Out/Create order/MainElementsForCheckOut/div_MyCartPage1Opens'))
//go to checkout page 2
//WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/MainElementsForCheckOut/button_ProceedCheckoutPage1'))






//ADD CODES
//purchase code
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Purchased code/div_PurchaseCode'))
if (WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Purchased code/button_RemovePurchasedCode'),10,FailureHandling.OPTIONAL) == true) 
	{
	WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Purchased code/button_RemovePurchasedCode'))
	WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Purchased code/input_FieldPurchaseCode'))
	WebUI.setText(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Purchased code/input_FieldPurchaseCode'), '1275675634')
	}
else 
	//if (WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Purchased code/button_RemovePurchasedCode'),10) == false)
	{
	WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Purchased code/input_FieldPurchaseCode'))
	WebUI.setText(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Purchased code/input_FieldPurchaseCode'), '1275675634')
	}		
WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Purchased code/button_SubmitPurchaseCode'))
WebUI.waitForPageLoad(5)
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Purchased code/Message'),)
//WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Purchased code/Message'))
//def messagePurchasedCode = WebUI.getText(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Purchased code/Message'))
//WebUI.verifyMatch(messagePurchasedCode, '× Purchase order number has successfully changed', false)
WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Promo code/button_CloseMessage2'))


//promo code
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Promo code/div_PromotionCode'))
if (WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Promo code/button_RemovePromoCode'),10,FailureHandling.OPTIONAL) == true)
	{
	WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Promo code/button_RemovePromoCode'))
	WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Promo code/input_FieldPromotionCode'))
	WebUI.setText(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Promo code/input_FieldPromotionCode'), GlobalVariable.promoCode)
	}
else
	{
	WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Promo code/input_FieldPromotionCode'))
	WebUI.setText(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Promo code/input_FieldPromotionCode'), GlobalVariable.promoCode)
	}		
WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Promo code/button_SubmitPromotionCode'))
WebUI.waitForPageLoad(5)
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Promo code/Message2'),)
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Promo code/Message2'))
def messagePromoCode = WebUI.getText(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Promo code/Message2'))
WebUI.verifyMatch(messagePromoCode, 'Your promocode was successfully applied', false)
WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Promo code/button_CloseMessage2'))
//delete the code
//WebUI.click findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Promo code/button_RemovePromoCode')
//WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Purchased code/Message'),)
//WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Codes/Promo code/button_CloseMessage2'))


//Proceed to checkout page
WebUI.click(findTestObject('Object Repository/1 UI-B2B ST/Check Out/Create order/MainElementsForCheckOut/button_ProceedCheckoutPage1'))

//VERIFY CART Page 2 - SHIPPING DELIVERY
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Check Out/Create order/MainElementsForCheckOut/div_CartPage2Presented'))
WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Shipping delivery/label_ChooseDeliveryMethodAsShipping'))

//choose shipping method
//WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Shipping delivery/Shipping method/div_Shipping MethodBlock'))
WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Shipping delivery/Shipping method/a_openPopUpWindowWirhShippingMethod'))
WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Shipping delivery/Shipping method/a_ChooseFixedRateGround'))
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Check Out/Create order/Shipping delivery/Shipping method/span_ActiveFixedRateGround'))
WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Shipping delivery/Shipping method/button_OkShippingMethod'))

//choose payment method
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Shipping delivery/Payment method/div_PaymentMethodBlock'))
WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Shipping delivery/Payment method/a_openPopUpWindowWirhPaymentMethod'))
WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Shipping delivery/Payment method/a_ChoosePaymentMethodInvoice'))
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Check Out/Create order/Shipping delivery/Payment method/span_ActivePaymentMethodInvoice'))
WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Shipping delivery/Payment method/button_SavePaymentMethodInvoice'))
WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/MainElementsForCheckOut/button_SubmitOrderPage2'))





//VERIFY CART Page 3 - ORDER DETAILS PAGE
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/div_BlockOrderSummary'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_OrderSummary'))
def testText1 = WebUI.getText(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_OrderSummary'))
WebUI.verifyMatch(testText1, 'ORDER SUMMARY', false)
//WebUI.verifyTextPresent(testText,'ORDER SUMMARY', false)
//WebUI.verifyElementText(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_OrderSummary'), 'ORDER SUMMARY')
//def testText = WebUI.getAttribute(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_OrderSummary'), 'value')
//WebUI.verifyMatch(testText, 'ORDER SUMMARY', false)
//String parentObjectPath = ".//div[1]/div/div/ng-view/div[4]/div/div[7]/div/div[2]/div"
//String childObjectPath = "//div[text()='textYouLookFor']"
//TestObject to = new TestObject().addProperty("xpath", ConditionType.EQUALS, parentObjectPath + childObjectPath)
//WebUI.verifyElementVisible(to)

WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/div_BlockShippingAddress'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_ShippingAddress'))
def testText2 = WebUI.getText(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_ShippingAddress'))
WebUI.verifyMatch(testText2, 'SHIPPING ADDRESS', false)

WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/div_BlockPaymentMethod'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_PaymentMethod'))
def testText3 = WebUI.getText(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_PaymentMethod'))
WebUI.verifyMatch(testText3, 'PAYMENT METHOD', false)

WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/div_BlockMyPurchasedProducts'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_MyPurchasedProducts'))
def testText4 = WebUI.getText(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_MyPurchasedProducts'))
WebUI.verifyMatch(testText4, 'MY PURCHASED PRODUCTS', false)





/*
//VERIFY CART Page 2 - PICKUP DELIVERY
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Check Out/Create order/MainElementsForCheckOut/div_CartPage2Presented'))
WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/PickUpDelivery/label_ChooseDeliveryMethodAsPickUp'))

//choose pick up address 
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/PickUpDelivery/PickUp Address/div_PickUpAddress'))
WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/PickUpDelivery/PickUp Address/a_openPopUpWindowWirhAddress'))
WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/PickUpDelivery/PickUp Address/a_SelectAddress'))
WebUI.verifyElementPresent(findTestObject('1 UI-B2B ST/Check Out/Create order/PickUpDelivery/PickUp Address/div_CheckSelectedAddress'),3)

//choose payment method
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Shipping delivery/Payment method/div_PaymentMethodBlock'))
WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Shipping delivery/Payment method/a_openPopUpWindowWirhPaymentMethod'))
WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Shipping delivery/Payment method/a_ChoosePaymentMethodInvoice'))
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Check Out/Create order/Shipping delivery/Payment method/span_ActivePaymentMethodInvoice'))
WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Shipping delivery/Payment method/button_SavePaymentMethodInvoice'))

//submit order page 2
WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/MainElementsForCheckOut/button_SubmitOrderPage2'))

//VERIFY CART Page 3 - ORDER DETAILS PAGE
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/div_BlockOrderSummary'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_OrderSummary'))
def OrderPage1 = WebUI.getText(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_OrderSummary'))
WebUI.verifyMatch(OrderPage1, 'ORDER SUMMARY', false)

WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/div_BlockShippingAddress'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_PickUpAddress'))
def OrderPage2 = WebUI.getText(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_PickUpAddress'))
WebUI.verifyMatch(OrderPage2, 'PICKUP ADDRESS', false)

WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/div_BlockPaymentMethod'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_PaymentMethod'))
def OrderPage3 = WebUI.getText(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_PaymentMethod'))
WebUI.verifyMatch(OrderPage3, 'PAYMENT METHOD', false)

WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/div_BlockMyPurchasedProducts'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_MyPurchasedProducts'))
def OrderPage4 = WebUI.getText(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Order details/h5_MyPurchasedProducts'))
WebUI.verifyMatch(OrderPage4, 'MY PURCHASED PRODUCTS', false)
*/



//
//notification block
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Notification/div_OrderNotificationBlock'))
WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Notification/p_OrderNotificationText'))

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!links order details page CAN NOT BE CHECKED!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//link - print - CAN NOT verify page opens
//WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Notification/button_PrintOrderNotificationBlock'))

//link - send mail CAN NOT CLICK ON CHECKBOX
//WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Links/a_EmailButton'))
//WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Links/div_EmailPopUp'))
//WebUI.mouseOver(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Links/CheckBoxInputBlock'))
//WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Links/checkboxEmail'))
//WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Notification/button_EmailSend'))
//WebUI.verifyElementVisible(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Notification/div_EmailNotificationSent'))
//WebUI.click(findTestObject('1 UI-B2B ST/Check Out/Create order/Order details page/Notification/span_EmailNotificationClose'))



//LOG OUT
WebUI.click(findTestObject('1 UI-B2B ST/Home page elements/Log out/a_AccountDropDownMenu'))
WebUI.mouseOver(findTestObject('1 UI-B2B ST/Home page elements/Log out/ISignOut'))
WebUI.click(findTestObject('1 UI-B2B ST/Home page elements/Log out/ISignOut'))
WebUI.waitForPageLoad(10)
WebUI.verifyElementNotPresent(findTestObject('1 UI-B2B ST/Registration/text_VerifyAccountName'), 2)



//close browser	
WebUI.closeBrowser()


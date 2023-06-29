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


WebUI.comment('TEST CASE : PRICES ADD DELETE BULK')


'CREATE MULTIPLE PRODUCTS AND COLLECT PRODUCT IDs TO THE LIST'
def productIdList = []
for (int i = 1; i < 3; i++) {
	GlobalVariable.productName = GlobalVariable.productName+i
	GlobalVariable.sku = GlobalVariable.sku + i
	WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/productCreate'),
		null)
	productIdList.add(GlobalVariable.productId)
	}
GlobalVariable.productId = productIdList
println GlobalVariable.productId



'ADD PRODUCTS TO THE PRICELIST USING PRODUCT IDs FROM THE LIST (one id per loop iteration)'
//loop overwrites GV.productId list, so need to set it back after the loop is done
priceIdList = []
for(int j;j<productIdList.size();j++) {
	GlobalVariable.productId = productIdList[j]
	WS.callTestCase(findTestCase('API Coverage/ModulePricing/pricelistProductsAdd'),
		null)
}


'SET GV.productId BACKTO LIST OF CREATED PRODUCT IDs TO BULK DELETE THEM' 
GlobalVariable.productId = productIdList


'DELETE THE CREATED PRODUCTS USING IDs FROM THE LIST (one per loop iteration)'
//loop overwrites GV.productId list, so need to set it back after the loop is done

for(int n;n<productIdList.size();n++) {
	GlobalVariable.productId = productIdList[n]
deleteProducts = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModuleCatalog/productsDelete'),
	null)
}


'SET GV.productId BACKTO LIST OF CREATED PRODUCT IDs  to verify it was deleted'
GlobalVariable.productId = productIdList


'VERIFY PRODUCTS HAVE BEEN DELETED'
verifyCreated = WS.callTestCase(findTestCase('Test Cases/API Coverage/ModulePricing/priceSearchGet'),
	null) 
assert (WS.containsString(verifyCreated,GlobalVariable.productId[1],false,FailureHandling.OPTIONAL)) == false
assert (WS.containsString(verifyCreated,GlobalVariable.productId[0],false,FailureHandling.OPTIONAL)) == false


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

//Create a new User using GlobalVariable.memberId with random email

Random rnd = new Random()

// DEBUG CODE | Create random usernames
//GlobalVariable.userName = GlobalVariable.userName+rnd.nextInt(20)
//println("USER : " + GlobalVariable.userName)

WS.sendRequestAndVerify(findTestObject('API/backWebServices/AccountCreateUser', [('email') : rnd.nextInt(100)+'@email.com', ('userName') : GlobalVariable.userName, ('storeId') : GlobalVariable.storeId, ('contactId') : GlobalVariable.contactId]))
//WS.sendRequestAndVerify(findTestObject('API/backWebServices/AccountCreateUser', [('email') : rnd.next(100)+'@email.com', ('userName') : GlobalVariable.userName]))
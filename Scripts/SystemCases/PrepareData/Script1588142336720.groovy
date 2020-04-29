import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

def DataFromFile = ['FirstName': '', 'LastName': '', 'Email': '', 'Company': '', 'Address':'', 'Apt': '', 'City': '', 'CorrectSearchRequest': '', 'IncorrectSearchRequest': '', 'Zip':'', 'Login':'', 'Password':'']
def data = TestDataFactory.findTestData ("Data Files/TestData")
DataFromFile.FirstName = data.getValue(1, 1)
DataFromFile.LastName = data.getValue(2, 1)
DataFromFile.Email = data.getValue(3, 1)
DataFromFile.Company = data.getValue(4, 1)
DataFromFile.Address = data.getValue(5, 1)
DataFromFile.Apt = data.getValue(6, 1)
DataFromFile.City = data.getValue(7, 1)
DataFromFile.CorrectSearchRequest = data.getValue(8, 1)
DataFromFile.IncorrectSearchRequest = data.getValue(9, 1)
DataFromFile.Zip = data.getValue(10, 1)
DataFromFile.Login = data.getValue(11, 1)
DataFromFile.Password = data.getValue(12, 1)
return DataFromFile

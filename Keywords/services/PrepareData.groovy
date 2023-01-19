package services

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

import internal.GlobalVariable

public class PrepareData {

	@Keyword
	def userDateReturn(){

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
	}
}

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

import groovy.json.JsonSlurper

response = WS.sendRequestAndVerify(findTestObject('API/backWebServices/DRAFT/DRAFT.searchFFC'))
//
//JsonSlurper responseJson = new JsonSlurper()
//def parsedResult = responseJson.parseText(response.getResponseBodyContent())
//def localMemberId = parsedResult.'results'
//def memberId = localMemberId[0].'id'


def orderList = new JsonSlurper().parseText(response.getResponseBodyContent())

ArrayList ordersArray = orderList.get('results')
println ("NAME : " + ordersArray.name)
String namex = "Los Angeles Branch"
if (ordersArray.name == namex ) {
	//Save orderID to Global variable
	println ("FFC ID : " + ordersArray.get('id'))
	//GlobalVariable.ffcId = ordersArray[0].id
//println ("ORDER ID : " + GlobalVariable.orderId)
//println ("orderNumber : " + GlobalVariable.orderNumber)

}




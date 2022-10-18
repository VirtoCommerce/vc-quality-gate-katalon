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

import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.FormDataBodyParameter
import groovy.json.JsonSlurper as JsonSlurper

import com.kms.katalon.core.testobject.ConditionType as ConditionType
//import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.testobject.UrlEncodedBodyParameter
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

def request = findTestObject('API/backWebServices/VirtoCommerce.Content/DRAFT.ContentFileNew')
//
//List<FormDataBodyParameter> body = new ArrayList()
//body.add(new FormDataBodyParameter('qwetest.md', '', 'blob'))
//request.setBodyContent(new FormDataBodyParameter(body))
//response = WS.sendRequestAndVerify(request)
//println("REQUEST IS : " + request)



def builder = new RestRequestObjectBuilder()

'Create a new POST object using builder'
def requestObject = builder
  .withRestRequestMethod("POST")
  .withRestUrl(request)
  .withHttpHeaders([
      new TestObjectProperty("Content-Type", ConditionType.EQUALS, "multipart/form-data")
  ])
  .withMultipartFormDataBodyContent([
      new withMultipartFormDataBodyContent("qwetest.md", "", "blob"),
  ])
  .build()
   
def response = WS.sendRequest(requestObject)

assert response.getStatusCode() == 200
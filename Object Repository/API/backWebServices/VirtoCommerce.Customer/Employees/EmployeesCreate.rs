<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>EmployeesCreate</name>
   <tag></tag>
   <elementGuidId>c0a52ad4-1979-46af-babf-f0d457955d3f</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;fullName\&quot;: \&quot;${contactName}\&quot;,\n  \&quot;firstName\&quot;: \&quot;${firstName}\&quot;,\n  \&quot;lastName\&quot;: \&quot;${lastName}\&quot;, \n  \&quot;isActive\&quot;:true,\n  \&quot;middleName\&quot;:\&quot;Middle\&quot;,\n  \&quot;timeZone\&quot;:\&quot;Europe/Moscow\&quot;,\n  \&quot;defaultLanguage\&quot;:\&quot;Test lang\&quot;,\n  \&quot;photoUrl\&quot;:\&quot;test.test\&quot;,\n  \&quot;birthDate\&quot;:\&quot;2020-09-02T21:00:00.000Z\&quot;,\n  \&quot;organizations\&quot;: [\n  ],\n  \&quot;memberType\&quot;: \&quot;Employee\&quot;,\n  \&quot;addresses\&quot;: [\n    {\n        \&quot;addressType\&quot;: \&quot;Billing\&quot;,\n\t    \&quot;firstName\&quot;: \&quot;JohnFirst\&quot;,\n\t\t\&quot;lastName\&quot;: \&quot;DoeLast\&quot;,\n        \&quot;name\&quot;: \&quot;Qwest\&quot;,\n        \&quot;line1\&quot;: \&quot;Test adress line 1\&quot;,\n        \&quot;line2\&quot;: \&quot;Test adress line 2\&quot;,\n        \&quot;postalCode\&quot;: \&quot;X34656703\&quot;,\n        \&quot;city\&quot;: \&quot;Test city\&quot;,\n        \&quot;region\&quot;: \&quot;test region\&quot;,\n        \&quot;countryName\&quot;: \&quot;United States\&quot;,\n        \&quot;countryCode\&quot;: \&quot;USA\&quot;\n    }\n  ],\n  \&quot;phones\&quot;: [\n    \&quot;+132456987\&quot;\n  ],\n  \&quot;emails\&quot;: [\n    \&quot;emp@qwe.com\&quot;\n  ]\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>api_key</name>
      <type>Main</type>
      <value>${GlobalVariable.api_key}</value>
   </httpHeaderProperties>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/employees</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>''</defaultValue>
      <description>data to create an em[ployee</description>
      <id>e390bbf9-6904-4f47-a24c-221a58d57b94</id>
      <masked>false</masked>
      <name>contactName</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description>data to create an em[ployee</description>
      <id>d8863bcb-a904-4614-af79-04a1fe9bf1a2</id>
      <masked>false</masked>
      <name>firstName</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description>data to create an em[ployee</description>
      <id>401c9164-b473-4cc7-8ee6-657c2d96d4ce</id>
      <masked>false</masked>
      <name>LastName</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonOutput
import com.kms.katalon.core.util.KeywordUtil


ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
def prettyJson = JsonOutput.prettyPrint(response.getResponseBodyContent())
KeywordUtil.logInfo(prettyJson)
WS.verifyResponseStatusCode(response, 200)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

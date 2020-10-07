<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>EmployeesCreate</name>
   <tag></tag>
   <elementGuidId>c0a52ad4-1979-46af-babf-f0d457955d3f</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;fullName\&quot;: \&quot;${GlobalVariable.contactName}\&quot;,\n  \&quot;firstName\&quot;: \&quot;${GlobalVariable.firstName}\&quot;,\n  \&quot;lastName\&quot;: \&quot;${GlobalVariable.lastName}\&quot;,  \n  \&quot;organizations\&quot;: [\n    \&quot;037f0630-bde0-4a3c-a991-ad0e5cbfe61e\&quot;\n  ],\n  \&quot;employeeType\&quot;: \&quot;string\&quot;,\n  \&quot;isActive\&quot;: true,\n  \&quot;memberType\&quot;: \&quot;Employee\&quot;,\n  \&quot;addresses\&quot;: [\n    {\n        \&quot;addressType\&quot;: \&quot;Billing\&quot;,\n\t    \&quot;firstName\&quot;: \&quot;JohnFirst\&quot;,\n\t\t\&quot;lastName\&quot;: \&quot;DoeLast\&quot;,\n        \&quot;name\&quot;: \&quot;Qwest\&quot;,\n        \&quot;line1\&quot;: \&quot;Test adress line 1\&quot;,\n        \&quot;line2\&quot;: \&quot;Test adress line 2\&quot;,\n        \&quot;postalCode\&quot;: \&quot;X34656703\&quot;,\n        \&quot;city\&quot;: \&quot;Test city\&quot;,\n        \&quot;region\&quot;: \&quot;test region\&quot;,\n        \&quot;countryName\&quot;: \&quot;United States\&quot;,\n        \&quot;countryCode\&quot;: \&quot;USA\&quot;\n    }\n  ],\n  \&quot;phones\&quot;: [\n    \&quot;+132456987\&quot;\n  ],\n  \&quot;emails\&quot;: [\n    \&quot;emp@qwe.com\&quot;\n  ],\n    \&quot;groups\&quot;: [\n        \&quot;TEST UG1\&quot;,\n        \&quot;TEST UG2\&quot;\n    ],\n  //\&quot;id\&quot;: \&quot;string\&quot;\n}&quot;,
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
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/employees</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
KeywordUtil.logInfo(response.responseBodyContent)
WS.verifyResponseStatusCode(response, 200)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

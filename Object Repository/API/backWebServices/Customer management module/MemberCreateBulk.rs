<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>MemberCreateBulk</name>
   <tag></tag>
   <elementGuidId>6fe8548c-947b-422a-bce1-9bf82deb3496</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[\n  {\n    \&quot;name\&quot;: \&quot;Qwe Contact1\&quot;,\n    \&quot;firstName\&quot;: \&quot;JohnFirst\&quot;,\n    \&quot;lastName\&quot;: \&quot;DoeLast\&quot;,\n    \&quot;fullName\&quot;: \&quot;Qwe Contact1\&quot;,\n    \&quot;memberType\&quot;: \&quot;${GlobalVariable.memberType[1]}\&quot;,\n    \&quot;id\&quot;: \&quot;89b7b0cc-378c-4d07-a883-6812c648057f\&quot;,\n    \&quot;addresses\&quot;: [\n      {\n        \&quot;addressType\&quot;: \&quot;Billing\&quot;,\n        \&quot;firstName\&quot;: \&quot;JohnFirst\&quot;,\n        \&quot;lastName\&quot;: \&quot;DoeLast\&quot;,\n        \&quot;countryCode\&quot;: \&quot;USA\&quot;,\n        \&quot;countryName\&quot;: \&quot;United States\&quot;,\n        \&quot;regionName\&quot;: \&quot;test region\&quot;,\n        \&quot;city\&quot;: \&quot;Test city\&quot;,\n        \&quot;line1\&quot;: \&quot;Test adress line 1\&quot;,\n        \&quot;line2\&quot;: \&quot;Test adress line 2\&quot;,\n        \&quot;postalCode\&quot;: \&quot;X34656703\&quot;,\n        \&quot;name\&quot;: \&quot;Qwest\&quot;\n      }\n    ],\n    \&quot;groups\&quot;: [\n      \&quot;TEST UG1\&quot;,\n      \&quot;TEST UG2\&quot;\n    ],\n    \&quot;phones\&quot;: [\n      \&quot;0123456789\&quot;\n    ],\n    \&quot;emails\&quot;: [\n      \&quot;test@test.com\&quot;\n    ]\n  },\n  {\n    \&quot;name\&quot;: \&quot;Qwe Contact2\&quot;,\n    \&quot;firstName\&quot;: \&quot;JohnFirst\&quot;,\n    \&quot;lastName\&quot;: \&quot;DoeLast\&quot;,\n    \&quot;fullName\&quot;: \&quot;Qwe Contact2\&quot;,\n    \&quot;memberType\&quot;: \&quot;${GlobalVariable.memberType[1]}\&quot;,\n    \&quot;id\&quot;: \&quot;5370ae29-0edc-42e5-8b46-cfb5da1fd29e\&quot;,\n    \&quot;addresses\&quot;: [\n      {\n        \&quot;addressType\&quot;: \&quot;Shipping\&quot;,\n        \&quot;firstName\&quot;: \&quot;JohnFirst\&quot;,\n        \&quot;lastName\&quot;: \&quot;DoeLast\&quot;,\n        \&quot;countryCode\&quot;: \&quot;USA\&quot;,\n        \&quot;countryName\&quot;: \&quot;United States\&quot;,\n        \&quot;regionName\&quot;: \&quot;test region\&quot;,\n        \&quot;city\&quot;: \&quot;Test city\&quot;,\n        \&quot;line1\&quot;: \&quot;Test adress line 1\&quot;,\n        \&quot;line2\&quot;: \&quot;Test adress line 2\&quot;,\n        \&quot;postalCode\&quot;: \&quot;X34656703\&quot;,\n        \&quot;name\&quot;: \&quot;Qwest\&quot;\n      }\n    ],\n    \&quot;groups\&quot;: [\n      \&quot;TEST UG1\&quot;,\n      \&quot;TEST UG2\&quot;\n    ],\n    \&quot;phones\&quot;: [\n      \&quot;0123456789\&quot;\n    ],\n    \&quot;emails\&quot;: [\n      \&quot;test@test.com\&quot;\n    ],\n  }\n]&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/members/bulk</restUrl>
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
      <description></description>
      <id>318c8c1f-f653-4e73-8daf-06f9ece33245</id>
      <masked>false</masked>
      <name>memberType</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>e00d32a8-6b75-4e8c-a13a-f093335c2f40</id>
      <masked>false</masked>
      <name>variable</name>
   </variables>
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

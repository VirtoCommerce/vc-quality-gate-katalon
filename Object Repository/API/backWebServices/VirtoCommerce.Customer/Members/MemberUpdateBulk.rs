<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>MemberUpdateBulk</name>
   <tag></tag>
   <elementGuidId>d73f648b-a3a2-4c0e-853b-57b094296f69</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[\n  {\n    \&quot;id\&quot;: \&quot;${id1}\&quot;,\n    \n    \&quot;name\&quot;: \&quot;${name1}\&quot;,\n    \&quot;firstName\&quot;: \&quot;JohnFirst X\&quot;,\n    \&quot;lastName\&quot;: \&quot;DoeLast Y\&quot;,\n    \&quot;fullName\&quot;: \&quot;Qwe BulkContact\&quot;,\n    \&quot;memberType\&quot;: \&quot;${memberType}\&quot;,\n    \&quot;addresses\&quot;: [\n      {\n        \&quot;addressType\&quot;: \&quot;Billing\&quot;,\n        \&quot;firstName\&quot;: \&quot;JohnFirst\&quot;,\n        \&quot;lastName\&quot;: \&quot;DoeLast\&quot;,\n        \&quot;countryCode\&quot;: \&quot;USA\&quot;,\n        \&quot;countryName\&quot;: \&quot;United States\&quot;,\n        \&quot;regionName\&quot;: \&quot;Upd region\&quot;,\n        \&quot;city\&quot;: \&quot;Upd city\&quot;,\n        \&quot;line1\&quot;: \&quot;Upd adress line 1\&quot;,\n        \&quot;line2\&quot;: \&quot;Upd adress line 2\&quot;,\n        \&quot;postalCode\&quot;: \&quot;001122\&quot;,\n        \&quot;name\&quot;: \&quot;Qwesttttt\&quot;\n      }\n    ],\n    \&quot;groups\&quot;: [\n      \&quot;TEST UG0\&quot;,\n      \&quot;TEST UG10\&quot;\n    ],\n    \&quot;phones\&quot;: [\n      \&quot;000000001\&quot;\n    ],\n    \&quot;emails\&quot;: [\n      \&quot;test1@test.com\&quot;\n    ]\n  },\n   {\n    \&quot;id\&quot;: \&quot;${id2}\&quot;,\n    \n    \&quot;name\&quot;: \&quot;${name2}\&quot;,\n    \&quot;firstName\&quot;: \&quot;JohnFirst X\&quot;,\n    \&quot;lastName\&quot;: \&quot;DoeLast Y\&quot;,\n    \&quot;fullName\&quot;: \&quot;Qwe BulkContact\&quot;,\n    \&quot;memberType\&quot;: \&quot;${memberType}\&quot;,\n    \&quot;addresses\&quot;: [\n      {\n        \&quot;addressType\&quot;: \&quot;Billing\&quot;,\n        \&quot;firstName\&quot;: \&quot;JohnFirst\&quot;,\n        \&quot;lastName\&quot;: \&quot;DoeLast\&quot;,\n        \&quot;countryCode\&quot;: \&quot;USA\&quot;,\n        \&quot;countryName\&quot;: \&quot;United States\&quot;,\n        \&quot;regionName\&quot;: \&quot;Upd region\&quot;,\n        \&quot;city\&quot;: \&quot;Upd city\&quot;,\n        \&quot;line1\&quot;: \&quot;Upd adress line 1\&quot;,\n        \&quot;line2\&quot;: \&quot;Upd adress line 2\&quot;,\n        \&quot;postalCode\&quot;: \&quot;001122\&quot;,\n        \&quot;name\&quot;: \&quot;Qwesttttt\&quot;\n      }\n    ],\n    \&quot;groups\&quot;: [\n      \&quot;TEST UG0\&quot;,\n      \&quot;TEST UG10\&quot;\n    ],\n    \&quot;phones\&quot;: [\n      \&quot;000000001\&quot;\n    ],\n    \&quot;emails\&quot;: [\n      \&quot;test1@test.com\&quot;\n    ]\n  }\n]&quot;,
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
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>PUT</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/members/bulk</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'1ed0907a-e3b1-423f-a053-f642522143b0'</defaultValue>
      <description></description>
      <id>f781838f-54f8-4ccc-8bd6-083922537a71</id>
      <masked>false</masked>
      <name>id1</name>
   </variables>
   <variables>
      <defaultValue>'QWEUPDATED'</defaultValue>
      <description></description>
      <id>af6afeca-cd85-4f09-99de-ad143027db4b</id>
      <masked>false</masked>
      <name>name1</name>
   </variables>
   <variables>
      <defaultValue>'Organization'</defaultValue>
      <description>GV.memberType[0]</description>
      <id>9f18ed43-b566-44a1-9b24-bf59e2e0c5ab</id>
      <masked>false</masked>
      <name>memberType</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>c2662680-ca72-487d-ba7f-adf2f0f1a6ad</id>
      <masked>false</masked>
      <name>id2</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>9673eecd-6a9e-47a2-94c2-47e2f1cb7650</id>
      <masked>false</masked>
      <name>name2</name>
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
WS.verifyResponseStatusCode(response, 204)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

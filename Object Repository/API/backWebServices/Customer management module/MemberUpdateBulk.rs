<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>MemberUpdateBulk</name>
   <tag></tag>
   <elementGuidId>d73f648b-a3a2-4c0e-853b-57b094296f69</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[\n  {\n    \&quot;name\&quot;: \&quot;Qwe BulkUpd1\&quot;,\n    \&quot;firstName\&quot;: \&quot;JohnFirst X\&quot;,\n    \&quot;lastName\&quot;: \&quot;DoeLast Y\&quot;,\n    \&quot;fullName\&quot;: \&quot;Qwe BulkUpd\&quot;,\n    //\&quot;memberType\&quot;: \&quot;${memberType}\&quot;,\n    \&quot;id\&quot;: \&quot;${id1}\&quot;,\n    \&quot;addresses\&quot;: [\n      {\n        \&quot;addressType\&quot;: \&quot;Billing\&quot;,\n        \&quot;firstName\&quot;: \&quot;JohnFirst\&quot;,\n        \&quot;lastName\&quot;: \&quot;DoeLast\&quot;,\n        \&quot;countryCode\&quot;: \&quot;USA\&quot;,\n        \&quot;countryName\&quot;: \&quot;United States\&quot;,\n        \&quot;regionName\&quot;: \&quot;Upd region\&quot;,\n        \&quot;city\&quot;: \&quot;Upd city\&quot;,\n        \&quot;line1\&quot;: \&quot;Upd adress line 1\&quot;,\n        \&quot;line2\&quot;: \&quot;Upd adress line 2\&quot;,\n        \&quot;postalCode\&quot;: \&quot;001122\&quot;,\n        \&quot;name\&quot;: \&quot;Qwesttttt\&quot;\n      }\n    ],\n    \&quot;groups\&quot;: [\n      \&quot;TEST UG0\&quot;,\n      \&quot;TEST UG10\&quot;\n    ],\n    \&quot;phones\&quot;: [\n      \&quot;000000001\&quot;\n    ],\n    \&quot;emails\&quot;: [\n      \&quot;test1@test.com\&quot;\n    ]\n  },\n  {\n    \&quot;name\&quot;: \&quot;Qwe BulkUpd2\&quot;,\n    \&quot;firstName\&quot;: \&quot;JohnFirst X\&quot;,\n    \&quot;lastName\&quot;: \&quot;DoeLast Y\&quot;,\n    \&quot;fullName\&quot;: \&quot;Qwe BulkUpd\&quot;,\n    //\&quot;memberType\&quot;: \&quot;${memberType}\&quot;,\n    \&quot;id\&quot;: \&quot;${id2}\&quot;,\n    \&quot;addresses\&quot;: [\n      {\n        \&quot;addressType\&quot;: \&quot;Billing\&quot;,\n        \&quot;firstName\&quot;: \&quot;JohnFirst\&quot;,\n        \&quot;lastName\&quot;: \&quot;DoeLast\&quot;,\n        \&quot;countryCode\&quot;: \&quot;USA\&quot;,\n        \&quot;countryName\&quot;: \&quot;United States\&quot;,\n        \&quot;regionName\&quot;: \&quot;Upd region\&quot;,\n        \&quot;city\&quot;: \&quot;Upd city\&quot;,\n        \&quot;line1\&quot;: \&quot;Upd adress line 1\&quot;,\n        \&quot;line2\&quot;: \&quot;Upd adress line 2\&quot;,\n        \&quot;postalCode\&quot;: \&quot;001122\&quot;,\n        \&quot;name\&quot;: \&quot;Qwesssst\&quot;\n      }\n    ],\n    \&quot;groups\&quot;: [\n      \&quot;TEST UG0\&quot;,\n      \&quot;TEST UG20\&quot;\n    ],\n    \&quot;phones\&quot;: [\n      \&quot;000000002\&quot;\n    ],\n    \&quot;emails\&quot;: [\n      \&quot;test2@test.com\&quot;\n    ]\n  }\n]&quot;,
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
   <restRequestMethod>PUT</restRequestMethod>
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
      <id>a2b03e0e-3b87-4d4e-901b-56472e21d7c6</id>
      <masked>false</masked>
      <name>id1</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>08c2ac0d-50e2-4441-be3d-5666965d61a2</id>
      <masked>false</masked>
      <name>id2</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>1f85b36b-39fa-42c8-ac25-64f29bc0518e</id>
      <masked>false</masked>
      <name>memberType</name>
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

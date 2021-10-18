<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ContactsCreate</name>
   <tag></tag>
   <elementGuidId>f44fa7f2-cd46-4bdb-9769-aa1ed5dcb810</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;fullName\&quot;: \&quot;${fullName}\&quot;,\n  \&quot;firstName\&quot;: \&quot;${firstName}\&quot;,\n  \&quot;lastName\&quot;: \&quot;${lastName}\&quot;,  \n  \&quot;organizations\&quot;: [\n    //\&quot;${orgId}\&quot;\n  ],\n  \&quot;memberType\&quot;: \&quot;Contact\&quot;,\n  \&quot;addresses\&quot;: [\n    {\n        \&quot;addressType\&quot;: \&quot;Billing\&quot;,\n\t    \&quot;firstName\&quot;: \&quot;JohnFirst\&quot;,\n\t\t\&quot;lastName\&quot;: \&quot;DoeLast\&quot;,\n        \&quot;name\&quot;: \&quot;Qwest\&quot;,\n        \&quot;email\&quot;: \&quot;qwest@qwest.com\&quot;,\n        \&quot;line1\&quot;: \&quot;Test adress line 1\&quot;,\n        \&quot;line2\&quot;: \&quot;Test adress line 2\&quot;,\n        \&quot;postalCode\&quot;: \&quot;X34656703\&quot;,\n        \&quot;city\&quot;: \&quot;Test city\&quot;,\n        \&quot;regionName\&quot;: \&quot;Alaska\&quot;,\n        \&quot;countryName\&quot;: \&quot;United States\&quot;,\n        \&quot;countryCode\&quot;: \&quot;USA\&quot;\n    }\n  ],\n  \&quot;phones\&quot;: [\n    \&quot;+132456987\&quot;\n  ],\n  \&quot;emails\&quot;: [\n    \&quot;emp@qwe.com\&quot;\n  ],\n    \&quot;groups\&quot;: [\n        \&quot;TEST UG1\&quot;,\n        \&quot;TEST UG2\&quot;\n    ]\n  //\&quot;id\&quot;: \&quot;string\&quot;\n}&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/contacts</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'0'</defaultValue>
      <description>id of the related organization</description>
      <id>bba2cc07-95ed-4181-a0ba-be9026e91801</id>
      <masked>false</masked>
      <name>orgId</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description>GlobalVariable.contactName</description>
      <id>3c102e49-f10d-44b8-8de7-0a01257bbbe5</id>
      <masked>false</masked>
      <name>fullName</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description>GlobalVariable.firstName</description>
      <id>711485a5-152a-40d9-8014-83574d0f37ac</id>
      <masked>false</masked>
      <name>firstName</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description>GlobalVariable.lastName</description>
      <id>fdd12ab4-2b68-484f-87a1-fad06006ad78</id>
      <masked>false</masked>
      <name>lastName</name>
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

<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>MemberCreateInOrg</name>
   <tag></tag>
   <elementGuidId>9385be9b-a97c-4f9b-a556-a22066bd32eb</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;name\&quot;: \&quot;${GlobalVariable.firstName}\&quot;,\n  \&quot;firstName\&quot;: \&quot;${GlobalVariable.firstName}\&quot;,\n  \&quot;middleName\&quot;: \&quot;Middle\&quot;,\n  \&quot;lastName\&quot;: \&quot;${GlobalVariable.lastName}\&quot;,\n  \&quot;fullName\&quot;: \&quot;${GlobalVariable.contactName}\&quot;,\n  \&quot;memberType\&quot;: \&quot;${memberType}\&quot;,\n  \&quot;organizations\&quot;: [ \n    \&quot;${orgId}\&quot;\n  ],\n  \&quot;isActive\&quot;: true,\n  \&quot;birthDate\&quot;: \&quot;2020-02-02T22:00:00.000Z\&quot;,\n  \&quot;timeZone\&quot;: \&quot;Europe/Moscow\&quot;,\n  \&quot;defaultLanguage\&quot;: \&quot;test lang\&quot;,\n  \&quot;photoUrl\&quot;: \&quot;qwe.test\&quot;,\n  \&quot;addresses\&quot;: [\n    {\n    \t\&quot;addressType\&quot;: \&quot;Billing\&quot;,\n\t    \&quot;firstName\&quot;: \&quot;JohnFirst\&quot;,\n\t\t\&quot;lastName\&quot;: \&quot;DoeLast\&quot;,\n        \&quot;countryCode\&quot;: \&quot;USA\&quot;,    \n        \&quot;countryName\&quot;: \&quot;United States\&quot;,\n        \&quot;regionName\&quot;: \&quot;test region\&quot;,\n        \&quot;city\&quot;: \&quot;Test city\&quot;,\n        \&quot;line1\&quot;: \&quot;Test adress line 1\&quot;,\n        \&quot;line2\&quot;: \&quot;Test adress line 2\&quot;,\n        \&quot;postalCode\&quot;: \&quot;X34656703\&quot;,\n        \&quot;name\&quot;: \&quot;Qwest\&quot;\n    }\n  ],\n  \&quot;businessCategory\&quot;: \&quot;businessCategory\&quot;,\n  \&quot;description\&quot;: \&quot;Lorem ipsum\&quot;,\n  \&quot;groups\&quot;: [\n    \&quot;TEST UG1\&quot;,\n    \&quot;TEST UG2\&quot;\n  ],\n  \&quot;phones\&quot;: [\n    \&quot;0123456789\&quot;\n  ],\n  \&quot;emails\&quot;: [\n    \&quot;test@test.com\&quot;\n  ]\n}&quot;,
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
      <webElementGuid>e95f963e-1bdf-4acd-aed9-9f798097968a</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>api_key</name>
      <type>Main</type>
      <value>${GlobalVariable.api_key}</value>
      <webElementGuid>491886f2-c08b-46a1-b96b-6e57ff7d5a37</webElementGuid>
   </httpHeaderProperties>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/members</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'Contact'</defaultValue>
      <description></description>
      <id>0ebcd8b2-e2ac-436f-9253-1ecbe7053e6e</id>
      <masked>false</masked>
      <name>memberType</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>03106a42-2b9b-44f5-aa3c-bf789e48c67d</id>
      <masked>false</masked>
      <name>orgId</name>
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

<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ContactsUpdate</name>
   <tag></tag>
   <elementGuidId>322aeda6-db1e-41d0-b87d-054a41472e3d</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  //\&quot;name\&quot;: \&quot;Qwe2updated\&quot;,\n  \&quot;firstName\&quot;: \&quot;JohnFirst X\&quot;,\n  \&quot;lastName\&quot;: \&quot;DoeLast Y\&quot;,\n  \&quot;fullName\&quot;: \&quot;${fullName}\&quot;,\n  \&quot;id\&quot;: \&quot;${contactId}\&quot;,\n  \&quot;addresses\&quot;: [\n    {\n    \t\&quot;addressType\&quot;: \&quot;Billing\&quot;,\n\t    \&quot;firstName\&quot;: \&quot;JohnFirst\&quot;,\n\t\t\&quot;lastName\&quot;: \&quot;DoeLast\&quot;,\n        \&quot;countryCode\&quot;: \&quot;USA\&quot;,    \n        \&quot;countryName\&quot;: \&quot;United States\&quot;,\n        \&quot;regionName\&quot;: \&quot;test region\&quot;,\n        \&quot;city\&quot;: \&quot;Test city\&quot;,\n        \&quot;line1\&quot;: \&quot;Test adress line 1\&quot;,\n        \&quot;line2\&quot;: \&quot;Test adress line 2\&quot;,\n        \&quot;postalCode\&quot;: \&quot;X34656703\&quot;,\n        \&quot;name\&quot;: \&quot;Qwest\&quot;\n    }\n  ],\n  \&quot;groups\&quot;: [\n    \&quot;TEST UG1\&quot;,\n    \&quot;TEST UG2\&quot;\n  ],\n  \&quot;phones\&quot;: [\n    \&quot;00000000\&quot;\n  ],\n  \&quot;emails\&quot;: [\n    \&quot;test@test.com\&quot;\n  ],\n}&quot;,
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
      <defaultValue>''</defaultValue>
      <description></description>
      <id>23ab5a83-6249-4640-ad2c-563d8e063e6e</id>
      <masked>false</masked>
      <name>contactId</name>
   </variables>
   <variables>
      <defaultValue>'Qwe ContactUpdated'</defaultValue>
      <description></description>
      <id>8ae29fe1-e2c2-43da-aeac-26580e6fee9b</id>
      <masked>false</masked>
      <name>fullName</name>
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
WS.verifyResponseStatusCode(response, 204)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

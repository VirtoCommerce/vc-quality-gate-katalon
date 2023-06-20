<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ContactsCreateBulk</name>
   <tag></tag>
   <elementGuidId>142c396c-8150-4eff-ac3c-0a51a61ac95d</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[\n  {\n    \&quot;fullName\&quot;: \&quot;${fullName1}\&quot;,\n    \&quot;firstName\&quot;: \&quot;Qwe1\&quot;,\n    \&quot;lastName\&quot;: \&quot;Rty1\&quot;,\n    \&quot;organizations\&quot;: [\n    ],\n    \&quot;isActive\&quot;: true,\n    \&quot;addresses\&quot;: [\n      {\n        \&quot;addressType\&quot;: \&quot;Billing\&quot;,\n        \&quot;firstName\&quot;: \&quot;JohnFirst1\&quot;,\n        \&quot;lastName\&quot;: \&quot;DoeLast1\&quot;,\n        \&quot;name\&quot;: \&quot;Qwest1\&quot;,\n        \&quot;line1\&quot;: \&quot;Test adress line 1\&quot;,\n        \&quot;line2\&quot;: \&quot;Test adress line 2\&quot;,\n        \&quot;postalCode\&quot;: \&quot;X34656703\&quot;,\n        \&quot;city\&quot;: \&quot;Test city\&quot;,\n        \&quot;region\&quot;: \&quot;test region\&quot;,\n        \&quot;countryName\&quot;: \&quot;United States\&quot;,\n        \&quot;countryCode\&quot;: \&quot;USA\&quot;\n      }\n    ],\n    \&quot;phones\&quot;: [\n      \&quot;+1324569870\&quot;\n    ],\n    \&quot;emails\&quot;: [\n      \&quot;emp1@qwe.com\&quot;\n    ],\n    \&quot;groups\&quot;: [\n      \&quot;TEST UG1\&quot;,\n      \&quot;TEST UG2\&quot;\n    ]\n \n  }, \n  {\n    \&quot;fullName\&quot;: \&quot;${fullName2}\&quot;,\n    \&quot;firstName\&quot;: \&quot;Qwe2\&quot;,\n    \&quot;lastName\&quot;: \&quot;Rty2\&quot;,\n    \&quot;organizations\&quot;: [\n      \n    ],\n    \&quot;isActive\&quot;: true,\n    \&quot;addresses\&quot;: [\n      {\n        \&quot;addressType\&quot;: \&quot;Billing\&quot;,\n        \&quot;firstName\&quot;: \&quot;JohnFirst2\&quot;,\n        \&quot;lastName\&quot;: \&quot;DoeLast2\&quot;,\n        \&quot;name\&quot;: \&quot;Qwest2\&quot;,\n        \&quot;line1\&quot;: \&quot;Test adress line 1\&quot;,\n        \&quot;line2\&quot;: \&quot;Test adress line 2\&quot;,\n        \&quot;postalCode\&quot;: \&quot;X34656703\&quot;,\n        \&quot;city\&quot;: \&quot;Test city\&quot;,\n        \&quot;region\&quot;: \&quot;test region\&quot;,\n        \&quot;countryName\&quot;: \&quot;United States\&quot;,\n        \&quot;countryCode\&quot;: \&quot;USA\&quot;\n      }\n    ],\n    \&quot;phones\&quot;: [\n      \&quot;+1324569871\&quot;\n    ],\n    \&quot;emails\&quot;: [\n      \&quot;emp2@qwe.com\&quot;\n    ],\n    \&quot;groups\&quot;: [\n      \&quot;TEST UG1\&quot;,\n      \&quot;TEST UG2\&quot;\n    ]\n  }\n]&quot;,
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
      <webElementGuid>ff0d3e35-7854-46ed-ac30-1f5215a52a5b</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>api_key</name>
      <type>Main</type>
      <value>${GlobalVariable.api_key}</value>
      <webElementGuid>f21e7e8c-9d99-4a73-8a8e-8377c9c5b5c1</webElementGuid>
   </httpHeaderProperties>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/contacts/bulk</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'qweBulk'</defaultValue>
      <description>created contact name</description>
      <id>87fcfd4a-0141-47dd-9b5c-327d38c6fc5e</id>
      <masked>false</masked>
      <name>fullName1</name>
   </variables>
   <variables>
      <defaultValue>'qweBulk'</defaultValue>
      <description>created contact name</description>
      <id>d6487aa3-73b1-4597-bd89-731b4ce0a8d5</id>
      <masked>false</masked>
      <name>fullName2</name>
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

<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>AddressesUpdate</name>
   <tag></tag>
   <elementGuidId>c52c2657-75e8-4cbe-a419-b88cd2d5e4c3</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[\n  {\n    \&quot;addressType\&quot;: \&quot;Billing\&quot;,\n    \&quot;firstName\&quot;: \&quot;JohnFirst 12\&quot;,\n    \&quot;lastName\&quot;: \&quot;DoeLast 12\&quot;,\n    \&quot;name\&quot;: \&quot;${name}\&quot;,\n    \&quot;line1\&quot;: \&quot;Test adress line 1\&quot;,\n    \&quot;line2\&quot;: \&quot;Test adress line 2\&quot;,\n    \&quot;postalCode\&quot;: \&quot;4656703\&quot;,\n    \&quot;city\&quot;: \&quot;Updated city\&quot;,\n    \&quot;regionName\&quot;: \&quot;Updated region\&quot;,\n    \&quot;countryName\&quot;: \&quot;United States\&quot;,\n    \&quot;countryCode\&quot;: \&quot;USA\&quot;,\n    \&quot;phone\&quot;: \&quot;000111222333\&quot;,\n    \&quot;email\&quot;: \&quot;update@update.com\&quot;\n  }\n]&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/addresses?memberId=${contactId}</restUrl>
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
      <id>4b2f0af2-4558-4924-bb67-8c202239b39d</id>
      <masked>false</masked>
      <name>contactId</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>9d8a88ff-406d-4f69-b32f-621e291d852f</id>
      <masked>false</masked>
      <name>name</name>
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

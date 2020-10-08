<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>AddressesUpdate_</name>
   <tag></tag>
   <elementGuidId>c52c2657-75e8-4cbe-a419-b88cd2d5e4c3</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[\n  {\n    \&quot;addressType\&quot;: \&quot;Billing\&quot;,\n    \&quot;key\&quot;: \&quot;string\&quot;,\n    \&quot;name\&quot;: \&quot;string\&quot;,\n    \&quot;organization\&quot;: \&quot;string\&quot;,\n    \&quot;countryCode\&quot;: \&quot;string\&quot;,\n    \&quot;countryName\&quot;: \&quot;string\&quot;,\n    \&quot;city\&quot;: \&quot;string\&quot;,\n    \&quot;postalCode\&quot;: \&quot;string\&quot;,\n    \&quot;zip\&quot;: \&quot;string\&quot;,\n    \&quot;line1\&quot;: \&quot;string\&quot;,\n    \&quot;line2\&quot;: \&quot;string\&quot;,\n    \&quot;regionId\&quot;: \&quot;string\&quot;,\n    \&quot;regionName\&quot;: \&quot;string\&quot;,\n    \&quot;firstName\&quot;: \&quot;string\&quot;,\n    \&quot;middleName\&quot;: \&quot;string\&quot;,\n    \&quot;lastName\&quot;: \&quot;string\&quot;,\n    \&quot;phone\&quot;: \&quot;string\&quot;,\n    \&quot;email\&quot;: \&quot;string\&quot;\n  }\n]&quot;,
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
   <restRequestMethod>PUT</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/addresses?memberId=</restUrl>
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

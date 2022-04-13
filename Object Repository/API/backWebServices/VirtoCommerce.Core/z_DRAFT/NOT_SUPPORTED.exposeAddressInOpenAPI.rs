<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>NOT_SUPPORTED.exposeAddressInOpenAPI</name>
   <tag></tag>
   <elementGuidId>78b61989-b500-44bb-a1fd-90691d1a1991</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;addressType\&quot;: \&quot;Billing\&quot;,\n  \&quot;key\&quot;: \&quot;string\&quot;,\n  \&quot;name\&quot;: \&quot;string\&quot;,\n  \&quot;organization\&quot;: \&quot;string\&quot;,\n  \&quot;countryCode\&quot;: \&quot;string\&quot;,\n  \&quot;countryName\&quot;: \&quot;string\&quot;,\n  \&quot;city\&quot;: \&quot;string\&quot;,\n  \&quot;postalCode\&quot;: \&quot;string\&quot;,\n  \&quot;zip\&quot;: \&quot;string\&quot;,\n  \&quot;line1\&quot;: \&quot;string\&quot;,\n  \&quot;line2\&quot;: \&quot;string\&quot;,\n  \&quot;regionId\&quot;: \&quot;string\&quot;,\n  \&quot;regionName\&quot;: \&quot;string\&quot;,\n  \&quot;firstName\&quot;: \&quot;string\&quot;,\n  \&quot;middleName\&quot;: \&quot;string\&quot;,\n  \&quot;lastName\&quot;: \&quot;string\&quot;,\n  \&quot;phone\&quot;: \&quot;string\&quot;,\n  \&quot;email\&quot;: \&quot;string\&quot;,\n  \&quot;outerId\&quot;: \&quot;string\&quot;,\n  \&quot;isDefault\&quot;: true\n}&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'QWE'</defaultValue>
      <description>code of the created currencie</description>
      <id>6d8812e4-fce4-4dbd-88b7-cf4c31d763e4</id>
      <masked>false</masked>
      <name>currencyCode</name>
   </variables>
   <variables>
      <defaultValue>'qweCurrencie'</defaultValue>
      <description>name of the created currencie</description>
      <id>caf01b4b-39e4-46da-b0d4-81e321215120</id>
      <masked>false</masked>
      <name>currencyName</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonOutput
import com.kms.katalon.core.util.KeywordUtil


ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
def prettyJson = JsonOutput.prettyPrint(response.getResponseBodyContent())
KeywordUtil.logInfo(prettyJson)
WS.verifyResponseStatusCode(response, 204)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

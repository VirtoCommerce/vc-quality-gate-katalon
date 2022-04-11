<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>seoInfosBatchUpdate(not used)</name>
   <tag></tag>
   <elementGuidId>988d387a-b249-4a42-b903-8d78c302fb79</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[\n  {\n    \&quot;name\&quot;: \&quot;string\&quot;,\n    \&quot;semanticUrl\&quot;: \&quot;string\&quot;,\n    \&quot;pageTitle\&quot;: \&quot;string\&quot;,\n    \&quot;metaDescription\&quot;: \&quot;string\&quot;,\n    \&quot;imageAltDescription\&quot;: \&quot;string\&quot;,\n    \&quot;metaKeywords\&quot;: \&quot;string\&quot;,\n    \&quot;storeId\&quot;: \&quot;string\&quot;,\n    \&quot;objectId\&quot;: \&quot;string\&quot;,\n    \&quot;objectType\&quot;: \&quot;string\&quot;,\n    \&quot;isActive\&quot;: true,\n    \&quot;languageCode\&quot;: \&quot;string\&quot;,\n    \&quot;createdDate\&quot;: \&quot;2022-04-08T12:29:43.999Z\&quot;,\n    \&quot;modifiedDate\&quot;: \&quot;2022-04-08T12:29:43.999Z\&quot;,\n    \&quot;createdBy\&quot;: \&quot;string\&quot;,\n    \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n    \&quot;id\&quot;: \&quot;string\&quot;\n  }\n]&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/seoinfos/batchupdate</restUrl>
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
      <description>updated currencie code</description>
      <id>d6a1d979-0d09-4266-bcc0-84673fd590b6</id>
      <masked>false</masked>
      <name>currencyCode</name>
   </variables>
   <variables>
      <defaultValue>'qweCurUPD'</defaultValue>
      <description>updated currencie name</description>
      <id>b39c76e1-fcc2-4e06-8c4d-7337171d2312</id>
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

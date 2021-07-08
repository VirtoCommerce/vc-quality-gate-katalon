<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ContentMove</name>
   <tag></tag>
   <elementGuidId>4c2eb935-a167-424c-b06a-118f2d880a85</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;&quot;,
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
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/content/${contentType}/${storeId}/move?newUrl=${newUrl}&amp;oldUrl=${oldUrl}</restUrl>
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
      <id>acbc18e1-ce8e-4411-a5da-3588b1e3760d</id>
      <masked>false</masked>
      <name>newUrl</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>2eb59dbe-0c16-4826-bee8-fd89363639c0</id>
      <masked>false</masked>
      <name>oldUrl</name>
   </variables>
   <variables>
      <defaultValue>'themes'</defaultValue>
      <description></description>
      <id>337190d0-797f-45f1-8439-531219eda15a</id>
      <masked>false</masked>
      <name>contentType</name>
   </variables>
   <variables>
      <defaultValue>'Electronics'</defaultValue>
      <description></description>
      <id>993f833a-4503-4769-83b9-40a1dc2c48cb</id>
      <masked>false</masked>
      <name>storeId</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil


ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

def listJsonOutput = JsonOutput.prettyPrint(response.getResponseBodyContent())
KeywordUtil.logInfo(listJsonOutput)
WS.verifyResponseStatusCode(response, 204)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

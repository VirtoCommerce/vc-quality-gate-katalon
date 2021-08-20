<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ContentGet</name>
   <tag></tag>
   <elementGuidId>20192eb4-d1a7-43ec-a073-572b730e3bb5</elementGuidId>
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
   <restUrl>${GlobalVariable.urlBack}/api/content/${contentType}/${storeId}?relativeUrl=${relativeUrl}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'/theme_test_x/theme_test.html'</defaultValue>
      <description></description>
      <id>c87a4da2-a306-4cc8-8386-dd6494061e20</id>
      <masked>false</masked>
      <name>relativeUrl</name>
   </variables>
   <variables>
      <defaultValue>'themes'</defaultValue>
      <description></description>
      <id>dc32d5cf-109b-4461-ba58-f25799c77889</id>
      <masked>false</masked>
      <name>contentType</name>
   </variables>
   <variables>
      <defaultValue>'Electronics'</defaultValue>
      <description></description>
      <id>6e4a9af1-fb65-4c56-aa62-583099edeb9b</id>
      <masked>false</masked>
      <name>storeId</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonOutput
import com.kms.katalon.core.util.KeywordUtil


//No need to parse and return JSON. 
//Because somtimes returned content is in HTML format and this will cause an error.
ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
KeywordUtil.logInfo(response.responseBodyContent)
WS.verifyResponseStatusCode(response, 200)
  </verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>CreateNewClient</name>
   <tag></tag>
   <elementGuidId>4486445c-cfae-44c0-bd84-008ca8b438f9</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;clientId\&quot;:\&quot;${clientId}\&quot;,\n  \&quot;clientSecret\&quot;:\&quot;${clientSecret}\&quot;,\n  \&quot;displayName\&quot;:\&quot;TestOauth\&quot;,\n  \&quot;permissions\&quot;:\t\t  [\&quot;ept:authorization\&quot;,\n                           \&quot;ept:token\&quot;,\n                           \&quot;gt:authorization_code\&quot;,\n                           \&quot;gt:client_credentials\&quot;],\n  \&quot;postLogoutRedirectUris\&quot;:[],\n  \&quot;redirectUris\&quot;:[],\n  \&quot;type\&quot;:\&quot;confidential\&quot;\n}&quot;,
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
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/platform/oauthapps</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>GlobalVariable.ClientId</defaultValue>
      <description></description>
      <id>7f1a7b63-82a7-4032-9bb7-fe9ec79c79be</id>
      <masked>false</masked>
      <name>clientId</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.ClientSecret</defaultValue>
      <description></description>
      <id>c6ff57aa-b6c8-4e7e-b7b4-60ee2e43dad7</id>
      <masked>false</masked>
      <name>clientSecret</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonOutput
import com.kms.katalon.core.util.KeywordUtil


RequestObject request = WSResponseManager.getInstance().getCurrentRequest()
ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
WS.verifyResponseStatusCode(response, 200)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

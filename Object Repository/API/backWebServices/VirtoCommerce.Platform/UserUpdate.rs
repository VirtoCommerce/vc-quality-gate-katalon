<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>UserUpdate</name>
   <tag></tag>
   <elementGuidId>78222d87-32c1-4273-99f5-d3d4d3de7ac6</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n   \&quot;userName\&quot;: \&quot;${userName}\&quot;,\n   \&quot;email\&quot;: \&quot;${userEmail}\&quot;,\n   \&quot;id\&quot;: \&quot;${GlobalVariable.userID}\&quot;,\n   \&quot;userType\&quot;:\&quot;${userType}\&quot;,\n   \&quot;emailConfirmed\&quot;: \&quot;${emailConfirmed}\&quot;\n}&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/platform/security/users</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.UserName</defaultValue>
      <description></description>
      <id>2238c78b-7ee9-4d39-b624-b206365c9320</id>
      <masked>false</masked>
      <name>userName</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Email</defaultValue>
      <description></description>
      <id>73dd08ad-e5c2-4242-84fa-fe21a969cbc1</id>
      <masked>false</masked>
      <name>userEmail</name>
   </variables>
   <variables>
      <defaultValue>'Manager'</defaultValue>
      <description></description>
      <id>852b8fa8-c9a3-4b89-bad8-c8115364e1d4</id>
      <masked>false</masked>
      <name>userType</name>
   </variables>
   <variables>
      <defaultValue>'true'</defaultValue>
      <description></description>
      <id>24f7e443-af4a-4483-862a-e8e15c22f77c</id>
      <masked>false</masked>
      <name>emailConfirmed</name>
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
WS.verifyResponseStatusCode(response, 200)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

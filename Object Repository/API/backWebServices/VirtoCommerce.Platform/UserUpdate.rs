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
  &quot;text&quot;: &quot;{\n  \&quot;userName\&quot;: \&quot;${userName}\&quot;,\n  \&quot;userType\&quot;:\&quot;${userType}\&quot;, \n  \&quot;email\&quot;: \&quot;${email}\&quot;,\n  \&quot;id\&quot;: \&quot;${userId}\&quot;,\n  \&quot;emailConfirmed\&quot;: \&quot;${emailConfirmed}\&quot;,\n  \&quot;roles\&quot;: [ ${roles} ],\n  \&quot;isAdministrator\&quot;: \&quot;${isAdministrator}\&quot;,\n  \&quot;lockoutEnabled\&quot;: true,\n  \&quot;status\&quot; : \&quot;New\&quot;\n}&quot;,
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
      <webElementGuid>cc9dc758-0458-4125-a043-1c0c8d0d77e5</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>api_key</name>
      <type>Main</type>
      <value>${GlobalVariable.api_key}</value>
      <webElementGuid>d13ec565-503e-4717-bc77-e999c17c99a9</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${GlobalVariable.token}</value>
      <webElementGuid>ce15cdc6-0621-49c8-93c9-ddb57c8c7cff</webElementGuid>
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
      <defaultValue>''</defaultValue>
      <description></description>
      <id>2238c78b-7ee9-4d39-b624-b206365c9320</id>
      <masked>false</masked>
      <name>userName</name>
   </variables>
   <variables>
      <defaultValue>'Manager'</defaultValue>
      <description></description>
      <id>852b8fa8-c9a3-4b89-bad8-c8115364e1d4</id>
      <masked>false</masked>
      <name>userType</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>73dd08ad-e5c2-4242-84fa-fe21a969cbc1</id>
      <masked>false</masked>
      <name>email</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>c69bffe4-66b9-423f-acf2-b036c7f8d1d9</id>
      <masked>false</masked>
      <name>userId</name>
   </variables>
   <variables>
      <defaultValue>'false'</defaultValue>
      <description></description>
      <id>24f7e443-af4a-4483-862a-e8e15c22f77c</id>
      <masked>false</masked>
      <name>emailConfirmed</name>
   </variables>
   <variables>
      <defaultValue>'6c3de7a1-ccbe-4a64-8b6d-258dcd92f0f8'</defaultValue>
      <description></description>
      <id>2479e8f0-def0-4b75-bece-f992747d7735</id>
      <masked>false</masked>
      <name>roleId</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>3b6ec929-ea75-4622-99a5-8b20bad848a2</id>
      <masked>false</masked>
      <name>roles</name>
   </variables>
   <variables>
      <defaultValue>'false'</defaultValue>
      <description></description>
      <id>adf5d808-56d9-4ebb-865a-90c11b2b3dc4</id>
      <masked>false</masked>
      <name>isAdministrator</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>a706e52f-473c-4b35-b8c4-b28a8cfb9956</id>
      <masked>false</masked>
      <name>userLockEnabled</name>
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
WS.verifyResponseStatusCode(response, 200)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

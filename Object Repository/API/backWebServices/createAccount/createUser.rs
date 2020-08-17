<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>createUser</name>
   <tag></tag>
   <elementGuidId>02ded382-2731-4c2a-878c-e4bb6aac9738</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;userType\&quot;: \&quot;${userType}\&quot;,\n    \&quot;storeId\&quot;: \&quot;${GlobalVariable.storeId}\&quot;,\n    \&quot;memberId\&quot;: \&quot;${GlobalVariable.contactId}\&quot;,\n    \&quot;userName\&quot;: \&quot;${GlobalVariable.userName}\&quot;,\n    \&quot;email\&quot;: \&quot;${email}\&quot;,\n    \&quot;password\&quot;: \&quot;${GlobalVariable.userPassword}\&quot;\n}&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/platform/security/users/create</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'Customer'</defaultValue>
      <description></description>
      <id>7f1a7b63-82a7-4032-9bb7-fe9ec79c79be</id>
      <masked>false</masked>
      <name>userType</name>
   </variables>
   <variables>
      <defaultValue>'qwer@qwer.qwe'</defaultValue>
      <description></description>
      <id>a3d703c1-361c-43e3-b208-a6256af06bdf</id>
      <masked>false</masked>
      <name>email</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
KeywordUtil.logInfo(response.responseBodyContent)
WS.verifyResponseStatusCode(response, 200)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

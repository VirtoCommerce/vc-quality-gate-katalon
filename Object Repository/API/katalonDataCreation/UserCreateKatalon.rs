<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>UserCreateKatalon</name>
   <tag></tag>
   <elementGuidId>ec5d42e0-054b-4c40-b440-7c3dea251017</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;userType\&quot;: \&quot;${userType}\&quot;,\n  \&quot;userName\&quot;: \&quot;${userName}\&quot;,\n  \&quot;password\&quot;: \&quot;${password}\&quot;,\n  \&quot;memberId\&quot;: \&quot;${contactId}\&quot;,\n  \&quot;storeId\&quot;: \&quot;${storeId}\&quot;,\n  \&quot;status\&quot;: \&quot;${status}\&quot;,\n  \&quot;email\&quot;: \&quot;${email}\&quot;,\n  \&quot;roles\&quot;: [],\n  \&quot;emailConfirmed\&quot;: \&quot;${emailConfirmed}\&quot;//,\n  //\&quot;lockoutEnabled\&quot;:true\n}&quot;,
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
      <webElementGuid>33183432-f66f-48b0-aff4-96d511d8b681</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${GlobalVariable.token}</value>
      <webElementGuid>73edfc50-9563-4a57-b819-73e975273961</webElementGuid>
   </httpHeaderProperties>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/platform/security/users/create</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'Customer'</defaultValue>
      <description></description>
      <id>7f1a7b63-82a7-4032-9bb7-fe9ec79c79be</id>
      <masked>false</masked>
      <name>userType</name>
   </variables>
   <variables>
      <defaultValue>'AutoUser'</defaultValue>
      <description></description>
      <id>83cc8a71-dedb-422c-91bf-4fe75d94a932</id>
      <masked>false</masked>
      <name>userName</name>
   </variables>
   <variables>
      <defaultValue>'Password1!'</defaultValue>
      <description></description>
      <id>c6ff57aa-b6c8-4e7e-b7b4-60ee2e43dad7</id>
      <masked>false</masked>
      <name>password</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>c0974235-1eef-4f16-a598-bc5505a4e1e3</id>
      <masked>false</masked>
      <name>contactId</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>4ae1a995-80e2-4d39-a6f1-38336b971569</id>
      <masked>false</masked>
      <name>storeId</name>
   </variables>
   <variables>
      <defaultValue>'New'</defaultValue>
      <description></description>
      <id>c71f8657-f07c-45d7-b7d9-929efc31fb35</id>
      <masked>false</masked>
      <name>status</name>
   </variables>
   <variables>
      <defaultValue>'qwer@qwer.qwe'</defaultValue>
      <description></description>
      <id>a3d703c1-361c-43e3-b208-a6256af06bdf</id>
      <masked>false</masked>
      <name>email</name>
   </variables>
   <variables>
      <defaultValue>'true'</defaultValue>
      <description></description>
      <id>faad9627-b0ef-47de-954f-64a623baf305</id>
      <masked>false</masked>
      <name>emailConfirmed</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonOutput
import com.kms.katalon.core.util.KeywordUtil


ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
def memberJsonOutput = JsonOutput.prettyPrint(response.getResponseBodyContent())
KeywordUtil.logInfo(memberJsonOutput)
WS.verifyResponseStatusCode(response, 200)


</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

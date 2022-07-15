<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>PasswordChangeCurrentUser</name>
   <tag></tag>
   <elementGuidId>39228bc1-b3a6-40d0-8615-d13f1761aa26</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;userName\&quot;: \&quot;${userName}\&quot;,\n  \&quot;oldPassword\&quot;: \&quot;${oldPassword}\&quot;,\n  \&quot;newPassword\&quot;: \&quot;${newPassword}\&quot;\n}&quot;,
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
      <name>Authorization</name>
      <type>Main</type>
      <value>${GlobalVariable.token}</value>
   </httpHeaderProperties>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/platform/security/currentuser/changepassword</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'Password1!'</defaultValue>
      <description></description>
      <id>e42f9b27-872e-41b7-9dcd-ed89527ab54c</id>
      <masked>false</masked>
      <name>newPassword</name>
   </variables>
   <variables>
      <defaultValue>'Password2!'</defaultValue>
      <description></description>
      <id>deafc15d-2f02-4346-bcf6-5380678db2fd</id>
      <masked>false</masked>
      <name>oldPassword</name>
   </variables>
   <variables>
      <defaultValue>'QweUser'</defaultValue>
      <description></description>
      <id>f904d9c9-7e67-4317-b676-436bdd1c2ea6</id>
      <masked>false</masked>
      <name>userName</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonOutput
import com.kms.katalon.core.util.KeywordUtil


ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
def prettyJson = JsonOutput.prettyPrint(response.getResponseBodyContent())
KeywordUtil.logInfo(prettyJson)
WS.verifyResponseStatusCode(response, 200)
WS.verifyElementPropertyValue(response, 'succeeded', true)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

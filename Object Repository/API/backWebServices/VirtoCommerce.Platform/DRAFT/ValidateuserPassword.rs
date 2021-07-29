<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ValidateUserPassword</name>
   <tag></tag>
   <elementGuidId>61a289c8-3291-4723-9b4c-dab7453fe251</elementGuidId>
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
      <name>api_key</name>
      <type>Main</type>
      <value>${GlobalVariable.api_key}</value>
   </httpHeaderProperties>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/platform/security/validateuserpassword</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'1!Password'</defaultValue>
      <description></description>
      <id>e42f9b27-872e-41b7-9dcd-ed89527ab54c</id>
      <masked>false</masked>
      <name>newPassword</name>
   </variables>
   <variables>
      <defaultValue>'123456qQ'</defaultValue>
      <description></description>
      <id>deafc15d-2f02-4346-bcf6-5380678db2fd</id>
      <masked>false</masked>
      <name>oldPassword</name>
   </variables>
   <variables>
      <defaultValue>'autotestvolha'</defaultValue>
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

import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil


RequestObject request = WSResponseManager.getInstance().getCurrentRequest()
ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
def memberJsonOutput = JsonOutput.prettyPrint(response.getResponseBodyContent())
KeywordUtil.logInfo(memberJsonOutput)
WS.verifyResponseStatusCode(response, 200)
WS.verifyElementPropertyValue(response, 'succeeded', true)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

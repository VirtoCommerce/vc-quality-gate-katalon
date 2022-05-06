<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ApiKeySetToUser</name>
   <tag></tag>
   <elementGuidId>3962bd96-f428-4d83-a499-8b2305f978fe</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\t\n  \&quot;apiKey\&quot;: \&quot;${api_key}\&quot;,  \n  \&quot;userName\&quot;: \&quot;${userName}\&quot;,\n  \&quot;userId\&quot;: \&quot;${userId}\&quot;,\n  \&quot;isActive\&quot;: \&quot;${apiKeyStatus}\&quot; ,\n  \&quot;id\&quot;: \&quot;${apiKeyId}\&quot;\n}&quot;,
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
      <value>${GlobalVariable.api_key}</value>
   </httpHeaderProperties>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/platform/security/users/apikeys</restUrl>
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
      <id>4ae41095-bb05-48c7-9d43-e2921770be35</id>
      <masked>false</masked>
      <name>api_key</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>7d4f5e5c-c077-4339-9348-5eaf78f6a0d3</id>
      <masked>false</masked>
      <name>userId</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>ad3f5597-5972-4c0a-b9a2-0bd25d559bc9</id>
      <masked>false</masked>
      <name>userName</name>
   </variables>
   <variables>
      <defaultValue>'true'</defaultValue>
      <description>apiKey isActive flag</description>
      <id>5641c927-9c2f-4e8d-8f46-965cfba5077b</id>
      <masked>false</masked>
      <name>apiKeyStatus</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description>id of the apikey to update</description>
      <id>26ab075c-be79-4169-87c2-18c7bbb352ab</id>
      <masked>false</masked>
      <name>apiKeyId</name>
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
WS.verifyResponseStatusCode(response, 200)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

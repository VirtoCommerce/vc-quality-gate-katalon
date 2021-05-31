<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>SettingsUpdateBoolean</name>
   <tag></tag>
   <elementGuidId>17d09a46-266a-4689-be22-0af0ae19f466</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[\n {\n      \&quot;moduleId\&quot;: \&quot;${moduleId}\&quot;,\n      \&quot;value\&quot;:\&quot;${value}\&quot;,\n      \&quot;groupName\&quot;: \&quot;${groupName}\&quot;,\n      \&quot;name\&quot;: \&quot;${name}\&quot;,\n      \&quot;valueType\&quot;:\&quot;Boolean\&quot;,\n      \&quot;defaultValue\&quot;:true,\n      \&quot;values\&quot;:[\n         {\n            \&quot;id\&quot;:true,\n            \&quot;value\&quot;:false\n         }\n      ]\n   }\n]&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/platform/settings</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'VirtoCommerce.Platform.Security.EnablePruneExpiredTokensJob'</defaultValue>
      <description>example of bool name</description>
      <id>175194f2-1316-4d9d-8573-e13a363603a3</id>
      <masked>false</masked>
      <name>name</name>
   </variables>
   <variables>
      <defaultValue>'true'</defaultValue>
      <description>example of bool value</description>
      <id>bf794ba6-0fac-413e-8057-0bfcf8c4c25a</id>
      <masked>false</masked>
      <name>value</name>
   </variables>
   <variables>
      <defaultValue>'Security'</defaultValue>
      <description>example of name f groub</description>
      <id>2e6758ab-51d4-4883-badd-cc86bf8241ad</id>
      <masked>false</masked>
      <name>groupName</name>
   </variables>
   <variables>
      <defaultValue>'Platform'</defaultValue>
      <description></description>
      <id>50c7c268-d36c-4014-bfd7-3d36bb9cbd27</id>
      <masked>false</masked>
      <name>moduleId</name>
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
WS.verifyResponseStatusCode(response, 204)

</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

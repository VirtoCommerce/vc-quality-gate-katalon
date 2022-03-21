<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>settingsDictionaryTagAddUpdate</name>
   <tag></tag>
   <elementGuidId>1561f710-7eea-469a-ba71-19935cf4ae1d</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[\n\t{\n\t\t\&quot;itHasValues\&quot;: true,\n\t\t\&quot;restartRequired\&quot;: false,\n\t\t\&quot;moduleId\&quot;: \&quot;VirtoCommerce.Customer\&quot;,\n\t\t\&quot;groupName\&quot;: \&quot;Customer|General\&quot;,\n\t\t\&quot;name\&quot;: \&quot;Customer.MemberGroups\&quot;,\n\t\t\&quot;isHidden\&quot;: false,\n\t\t\&quot;valueType\&quot;: \&quot;ShortText\&quot;,\n\t\t\&quot;allowedValues\&quot;: [\n\t\t\t\&quot;${tag}\&quot;,\n\t\t\t\&quot;VIP\&quot;,\n\t\t\t\&quot;Wholesaler\&quot;\n\t\t],\n\t\t\&quot;defaultValue\&quot;: \&quot;New\&quot;,\n\t\t\&quot;isDictionary\&quot;: true\n\t}\n]&quot;,
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
      <defaultValue>''</defaultValue>
      <description>tag to add to the dictionary</description>
      <id>4bb74c52-c3b4-433c-bab9-b4459004a280</id>
      <masked>false</masked>
      <name>tag</name>
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
WS.verifyResponseStatusCode(response, 204)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

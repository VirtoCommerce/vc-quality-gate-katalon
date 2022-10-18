<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>tagPutUnassign</name>
   <tag></tag>
   <elementGuidId>d63a5b11-2bfb-4210-ad8d-cf6c4b0afc5d</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\t\&quot;entityType\&quot;: \&quot;${entityType}\&quot;,\n\t\&quot;entityId\&quot;: \&quot;${entityId}\&quot;,\n\t\&quot;tags\&quot;: [],\n\t\&quot;inheritedTags\&quot;: [],\n\t\&quot;label\&quot;: \&quot;${label}\&quot;,\n  \t\&quot;id\&quot;: \&quot;${assignmetId}\&quot;\n}&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/personalization/taggeditem</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'Product'</defaultValue>
      <description>type of the entity</description>
      <id>4bb74c52-c3b4-433c-bab9-b4459004a280</id>
      <masked>false</masked>
      <name>entityType</name>
   </variables>
   <variables>
      <defaultValue>'d154d30d76d548fb8505f5124d18c1f3'</defaultValue>
      <description>id of the entity</description>
      <id>7d09f5f0-c51d-4005-a0da-9ffd2e1b81d0</id>
      <masked>false</masked>
      <name>entityId</name>
   </variables>
   <variables>
      <defaultValue>'qweTag'</defaultValue>
      <description>tag to assign</description>
      <id>0d694286-050b-4ce5-a86c-ef59daea0a75</id>
      <masked>false</masked>
      <name>tag</name>
   </variables>
   <variables>
      <defaultValue>'BLU Win HD LTE X150Q 8GB'</defaultValue>
      <description>enity title</description>
      <id>5e108b73-b1ac-48f4-93b4-164ac1aa3f56</id>
      <masked>false</masked>
      <name>label</name>
   </variables>
   <variables>
      <defaultValue>'f00beb14-2845-48d3-9c76-b53b6b509b62'</defaultValue>
      <description></description>
      <id>4443f856-27cc-4326-aec0-ec85c64ddddf</id>
      <masked>false</masked>
      <name>assignmetId</name>
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

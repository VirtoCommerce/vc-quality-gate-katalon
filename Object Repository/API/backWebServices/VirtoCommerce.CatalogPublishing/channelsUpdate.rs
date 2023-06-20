<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>channelsUpdate</name>
   <tag></tag>
   <elementGuidId>7e660c75-e07e-4bcd-8479-3ed464f8931e</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;\&quot;$body\&quot;&quot;,
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
      <webElementGuid>47326525-6f87-4928-810b-e0283c158136</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>api_key</name>
      <type>Main</type>
      <value>${GlobalVariable.api_key}</value>
      <webElementGuid>549a6393-e813-4f47-bbe4-c76b54685768</webElementGuid>
   </httpHeaderProperties>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>PUT</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/completeness/channels</restUrl>
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
      <defaultValue>'f0ddac0d-f987-4ca9-b6cb-da250bd279c7'</defaultValue>
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
      <defaultValue>'QweProduct'</defaultValue>
      <description>enity title</description>
      <id>5e108b73-b1ac-48f4-93b4-164ac1aa3f56</id>
      <masked>false</masked>
      <name>label</name>
   </variables>
   <variables>
      <defaultValue>'f00beb14-2845-48d3-9c76-b53b6b509b62'</defaultValue>
      <description>id of the tag assignment</description>
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

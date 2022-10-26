<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>DynamicPropertyDictionaryItemAddNew</name>
   <tag></tag>
   <elementGuidId>f72d7a3f-b98f-4240-8d48-d855dacd38a2</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[{\n    \n    \&quot;name\&quot;: \&quot;${name}\&quot;\n}]&quot;,
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
      <webElementGuid>adfa742a-ea59-4f9e-9e23-a90fffb3376b</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>api_key</name>
      <type>Main</type>
      <value>${GlobalVariable.api_key}</value>
      <webElementGuid>978f7469-0f3c-4639-acb8-0864ff5c2d03</webElementGuid>
   </httpHeaderProperties>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/platform/dynamic/types/${propertyType}/properties/${propertyId}/dictionaryitems</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'VirtoCommerce.CustomerModule.Core.Model.Contact'</defaultValue>
      <description></description>
      <id>c180e3f8-d87d-4130-b72a-4fca14ccd5a2</id>
      <masked>false</masked>
      <name>propertyType</name>
   </variables>
   <variables>
      <defaultValue>'88884a93-f165-424b-8a7c-159744e55fbf'</defaultValue>
      <description></description>
      <id>dca3cb61-d931-4692-863e-86b7458d5eb1</id>
      <masked>false</masked>
      <name>propertyId</name>
   </variables>
   <variables>
      <defaultValue>'3333'</defaultValue>
      <description></description>
      <id>b6bb283b-a8e2-4959-9092-6333dbd4aff2</id>
      <masked>false</masked>
      <name>name</name>
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

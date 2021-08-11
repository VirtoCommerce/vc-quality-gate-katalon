<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>CategoriesCreateUpdate</name>
   <tag></tag>
   <elementGuidId>6e39dbc7-cbbb-41d7-a458-46c2c85c654e</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n   \&quot;catalogId\&quot;:\&quot;${catalogId}\&quot;,\n   \&quot;code\&quot;:\&quot;${code}\&quot;,\n   \&quot;isVirtual\&quot;:false,\n   \&quot;level\&quot;:0,\n   \&quot;priority\&quot;:0,\n   \&quot;isActive\&quot;:true,\n   \&quot;seoObjectType\&quot;:\&quot;Category\&quot;,\n   \&quot;seoInfos\&quot;:[\n      \n   ],\n   \&quot;isInherited\&quot;:false,\n   \&quot;createdDate\&quot;:\&quot;0001-01-01T00:00:00Z\&quot;,\n   \&quot;name\&quot;:\&quot;${name}\&quot;\n}&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/catalog/categories</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'4974648a41df4e6ea67ef2ad76d7bbd4'</defaultValue>
      <description></description>
      <id>901cc077-5d05-41dc-98e8-afede1d1e9ac</id>
      <masked>false</masked>
      <name>catalogId</name>
   </variables>
   <variables>
      <defaultValue>'796b8'</defaultValue>
      <description></description>
      <id>79f8e3de-1f98-426a-a462-06eb2ba5724e</id>
      <masked>false</masked>
      <name>code</name>
   </variables>
   <variables>
      <defaultValue>'qweCategory'</defaultValue>
      <description></description>
      <id>87dfc3c0-46d1-4fa7-ae85-97a9ea469b99</id>
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
WS.verifyResponseStatusCode(response, 200)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

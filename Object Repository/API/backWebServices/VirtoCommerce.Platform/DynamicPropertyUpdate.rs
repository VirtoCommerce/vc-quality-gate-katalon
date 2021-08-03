<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>DynamicPropertyUpdate</name>
   <tag></tag>
   <elementGuidId>4a50e80e-8321-4cf9-9093-cbb7fd847b65</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  //\&quot;id\&quot;: \&quot;${id}\&quot;,\n  \&quot;name\&quot;: \&quot;${name}\&quot;,\n  \&quot;description\&quot;: \&quot;${description}\&quot;,\n  \&quot;objectType\&quot;: \&quot;${propertyType}\&quot;,\n  \&quot;valueType\&quot;: \&quot;${valueType}\&quot;,\n  \&quot;displayNames\&quot;: [\n    {\n      \&quot;locale\&quot;: \&quot;de-DE\&quot;\n    },\n    {\n      \&quot;locale\&quot;: \&quot;en-US\&quot;\n    },\n    {\n      \&quot;locale\&quot;: \&quot;fr-FR\&quot;\n    }\n  ]\n}&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/platform/dynamic/types/${propertyType}/properties/${propertyId}</restUrl>
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
      <id>0e6ce4e9-1582-4a3b-ba4d-8be17e105388</id>
      <masked>false</masked>
      <name>propertyId</name>
   </variables>
   <variables>
      <defaultValue>'UPD new'</defaultValue>
      <description></description>
      <id>7d4fc892-d213-4ec8-80fd-ffe13d5adc3f</id>
      <masked>false</masked>
      <name>name</name>
   </variables>
   <variables>
      <defaultValue>'VirtoCommerce.StoreModule.Core.Model.Store'</defaultValue>
      <description></description>
      <id>76a79459-5404-45e3-8f34-48b9d02845a2</id>
      <masked>false</masked>
      <name>propertyType</name>
   </variables>
   <variables>
      <defaultValue>'description'</defaultValue>
      <description></description>
      <id>17d52c5f-55d3-4682-a817-89331c5823d2</id>
      <masked>false</masked>
      <name>description</name>
   </variables>
   <variables>
      <defaultValue>'ShortText'</defaultValue>
      <description></description>
      <id>c4342782-9c7d-46eb-b1e4-f9e037992c36</id>
      <masked>false</masked>
      <name>valueType</name>
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

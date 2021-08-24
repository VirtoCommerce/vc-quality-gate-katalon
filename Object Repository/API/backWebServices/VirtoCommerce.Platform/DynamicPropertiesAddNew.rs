<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>DynamicPropertiesAddNew</name>
   <tag></tag>
   <elementGuidId>52ff30a4-b594-4000-aeae-cec3854a9ec1</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;name\&quot;: \&quot;${name}\&quot;,\n  \&quot;valueType\&quot;: \&quot;${valueType}\&quot;,\n  \&quot;isRequired\&quot;: false,\n  \&quot;isArray\&quot;: \&quot;${isArray}\&quot;,\n  \&quot;isMultilingual\&quot;: \&quot;${isMultilingual}\&quot;,\n  \&quot;isDictionary\&quot;: \&quot;${isDictionary}\&quot;,\n  \&quot;displayNames\&quot;: [\n    {\n      \&quot;locale\&quot;: \&quot;de-DE\&quot;\n    },\n    {\n      \&quot;locale\&quot;: \&quot;en-US\&quot;\n    },\n    {\n      \&quot;locale\&quot;: \&quot;fr-FR\&quot;\n    }\n  ]\n}&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/platform/dynamic/types/${propertyType}/properties</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'VirtoCommerce.StoreModule.Core.Model.Store'</defaultValue>
      <description></description>
      <id>dca3cb61-d931-4692-863e-86b7458d5eb1</id>
      <masked>false</masked>
      <name>propertyType</name>
   </variables>
   <variables>
      <defaultValue>'TEST'</defaultValue>
      <description></description>
      <id>b6bb283b-a8e2-4959-9092-6333dbd4aff2</id>
      <masked>false</masked>
      <name>name</name>
   </variables>
   <variables>
      <defaultValue>'ShortText'</defaultValue>
      <description></description>
      <id>67f4a20f-ad0d-4895-9da2-da2439d5c2b1</id>
      <masked>false</masked>
      <name>valueType</name>
   </variables>
   <variables>
      <defaultValue>false</defaultValue>
      <description></description>
      <id>d592ede4-8c90-41c2-b641-8d4132c363c3</id>
      <masked>false</masked>
      <name>isArray</name>
   </variables>
   <variables>
      <defaultValue>false</defaultValue>
      <description></description>
      <id>a8791166-8992-4868-ac8b-ea0862579f7c</id>
      <masked>false</masked>
      <name>isMultilingual</name>
   </variables>
   <variables>
      <defaultValue>false</defaultValue>
      <description></description>
      <id>03fae3ca-6a24-4a5f-b099-3a05ec26ec34</id>
      <masked>false</masked>
      <name>isDictionary</name>
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
WS.verifyResponseStatusCode(response, 200)



</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

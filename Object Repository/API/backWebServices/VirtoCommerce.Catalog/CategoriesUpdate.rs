<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>CategoriesUpdate</name>
   <tag></tag>
   <elementGuidId>47df64da-aa33-4bce-962c-6824fcb7a819</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n   \&quot;catalogId\&quot;:\&quot;${catalogId}\&quot;,\n   \&quot;code\&quot;:\&quot;${code}\&quot;,\n   \&quot;name\&quot;:\&quot;${name}\&quot;,\n   \&quot;outline\&quot;:\&quot;${categoryId}\&quot;,\n   \&quot;path\&quot;:\&quot;${name}\&quot;,\n   \&quot;isVirtual\&quot;:false,\n   \&quot;level\&quot;:0,\n   \&quot;priority\&quot;:0,\n   \&quot;isActive\&quot;:true,\n   \&quot;properties\&quot;:[\n      {\n         \&quot;isReadOnly\&quot;:true,\n         \&quot;isManageable\&quot;:true,\n         \&quot;isNew\&quot;:false,\n         \&quot;catalogId\&quot;:\&quot;${catalogId}\&quot;,\n         \&quot;name\&quot;:\&quot;Brand\&quot;,\n         \&quot;required\&quot;:true,\n         \&quot;dictionary\&quot;:true,\n         \&quot;multivalue\&quot;:false,\n         \&quot;multilanguage\&quot;:false,\n         \&quot;hidden\&quot;:false,\n         \&quot;valueType\&quot;:\&quot;ShortText\&quot;,\n         \&quot;type\&quot;:\&quot;Product\&quot;,\n         \&quot;values\&quot;:[\n            \n         ],\n         \&quot;attributes\&quot;:[\n            \n         ],\n         \&quot;displayNames\&quot;:[\n            {\n               \&quot;name\&quot;:\&quot;Marke\&quot;,\n               \&quot;languageCode\&quot;:\&quot;de-DE\&quot;\n            },\n            {\n               \&quot;name\&quot;:\&quot;Brand\&quot;,\n               \&quot;languageCode\&quot;:\&quot;en-US\&quot;\n            }\n         ],\n         \&quot;validationRules\&quot;:[\n            \n         ],\n         \&quot;isInherited\&quot;:true,\n\n      }\n   ],\n   \&quot;links\&quot;:[\n      \n   ],\n   \&quot;seoObjectType\&quot;:\&quot;Category\&quot;,\n   \&quot;seoInfos\&quot;:[\n      {\n         \&quot;semanticUrl\&quot;:\&quot;test\&quot;,\n         \&quot;objectId\&quot;:\&quot;${categoryId}\&quot;,\n         \&quot;objectType\&quot;:\&quot;Category\&quot;,\n         \&quot;isActive\&quot;:true,\n         \&quot;languageCode\&quot;:\&quot;en-US\&quot;,\n\n      }\n   ],\n   \&quot;images\&quot;:[\n      \n   ],\n   \&quot;outlines\&quot;:[\n      {\n         \&quot;items\&quot;:[\n            {\n               \&quot;id\&quot;:\&quot;${catalogId}\&quot;,\n               \&quot;seoObjectType\&quot;:\&quot;Catalog\&quot;,\n               \&quot;name\&quot;:\&quot;Electronics\&quot;,\n               \&quot;hasVirtualParent\&quot;:false\n            },\n            {\n               \&quot;id\&quot;:\&quot;${categoryId}\&quot;,\n               \&quot;seoObjectType\&quot;:\&quot;Category\&quot;,\n               \&quot;seoInfos\&quot;:[\n                  {\n                     \&quot;semanticUrl\&quot;:\&quot;${name}\&quot;,\n                     \&quot;objectId\&quot;:\&quot;${categoryId}\&quot;,\n                     \&quot;objectType\&quot;:\&quot;Category\&quot;,\n                     \&quot;isActive\&quot;:true,\n                     \&quot;languageCode\&quot;:\&quot;en-US\&quot;,\n                     \n                  }\n               ],\n               \&quot;name\&quot;:\&quot;${name}\&quot;,\n               \&quot;hasVirtualParent\&quot;:false\n            }\n         ]\n      }\n   ],\n   \&quot;isInherited\&quot;:false,\n   \&quot;createdDate\&quot;:\&quot;2021-08-11T14:41:50.5921398Z\&quot;,\n   \&quot;modifiedDate\&quot;:\&quot;2021-08-11T14:41:50.5921398Z\&quot;,\n   \&quot;createdBy\&quot;:\&quot;admin\&quot;,\n   \&quot;modifiedBy\&quot;:\&quot;admin\&quot;,\n   \&quot;id\&quot;:\&quot;${categoryId}\&quot;\n}&quot;,
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
      <description>'Electronics' catalog id</description>
      <id>901cc077-5d05-41dc-98e8-afede1d1e9ac</id>
      <masked>false</masked>
      <name>catalogId</name>
   </variables>
   <variables>
      <defaultValue>'5c331'</defaultValue>
      <description>updated category code</description>
      <id>79f8e3de-1f98-426a-a462-06eb2ba5724e</id>
      <masked>false</masked>
      <name>code</name>
   </variables>
   <variables>
      <defaultValue>'UPDATED'</defaultValue>
      <description>updated category name</description>
      <id>87dfc3c0-46d1-4fa7-ae85-97a9ea469b99</id>
      <masked>false</masked>
      <name>name</name>
   </variables>
   <variables>
      <defaultValue>'categoryId'</defaultValue>
      <description>updated category id</description>
      <id>e636a4a4-753c-4b75-b6a9-5582288ae288</id>
      <masked>false</masked>
      <name>categoryId</name>
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

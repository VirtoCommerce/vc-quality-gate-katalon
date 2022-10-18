<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ProductAssociationsUpdate</name>
   <tag></tag>
   <elementGuidId>a4854c79-085d-43f7-a2a6-a3bee8a3b370</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[\n  {\n    \&quot;type\&quot;: \&quot;string\&quot;,\n    \&quot;priority\&quot;: 0,\n    \&quot;quantity\&quot;: 0,\n    \&quot;itemId\&quot;: \&quot;string\&quot;,\n    \&quot;associatedObjectId\&quot;: \&quot;string\&quot;,\n    \&quot;associatedObjectType\&quot;: \&quot;string\&quot;,\n    \&quot;outerId\&quot;: \&quot;string\&quot;,\n    \&quot;tags\&quot;: [\n      \&quot;string\&quot;\n    ],\n    \&quot;images\&quot;: [\n      {\n        \&quot;binaryData\&quot;: \&quot;string\&quot;,\n        \&quot;altText\&quot;: \&quot;string\&quot;,\n        \&quot;relativeUrl\&quot;: \&quot;string\&quot;,\n        \&quot;url\&quot;: \&quot;string\&quot;,\n        \&quot;description\&quot;: \&quot;string\&quot;,\n        \&quot;sortOrder\&quot;: 0,\n        \&quot;typeId\&quot;: \&quot;string\&quot;,\n        \&quot;group\&quot;: \&quot;string\&quot;,\n        \&quot;name\&quot;: \&quot;string\&quot;,\n        \&quot;outerId\&quot;: \&quot;string\&quot;,\n        \&quot;languageCode\&quot;: \&quot;string\&quot;,\n        \&quot;seoInfos\&quot;: [\n          {\n            \&quot;name\&quot;: \&quot;string\&quot;,\n            \&quot;semanticUrl\&quot;: \&quot;string\&quot;,\n            \&quot;pageTitle\&quot;: \&quot;string\&quot;,\n            \&quot;metaDescription\&quot;: \&quot;string\&quot;,\n            \&quot;imageAltDescription\&quot;: \&quot;string\&quot;,\n            \&quot;metaKeywords\&quot;: \&quot;string\&quot;,\n            \&quot;storeId\&quot;: \&quot;string\&quot;,\n            \&quot;objectId\&quot;: \&quot;string\&quot;,\n            \&quot;objectType\&quot;: \&quot;string\&quot;,\n            \&quot;isActive\&quot;: true,\n            \&quot;languageCode\&quot;: \&quot;string\&quot;,\n            \&quot;createdDate\&quot;: \&quot;2021-07-30T16:43:56.522Z\&quot;,\n            \&quot;modifiedDate\&quot;: \&quot;2021-07-30T16:43:56.522Z\&quot;,\n            \&quot;createdBy\&quot;: \&quot;string\&quot;,\n            \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n            \&quot;id\&quot;: \&quot;string\&quot;\n          }\n        ],\n        \&quot;createdDate\&quot;: \&quot;2021-07-30T16:43:56.522Z\&quot;,\n        \&quot;modifiedDate\&quot;: \&quot;2021-07-30T16:43:56.522Z\&quot;,\n        \&quot;createdBy\&quot;: \&quot;string\&quot;,\n        \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n        \&quot;id\&quot;: \&quot;string\&quot;\n      }\n    ],\n    \&quot;id\&quot;: \&quot;string\&quot;\n  }\n]\n&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/catalog/products/associations</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
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

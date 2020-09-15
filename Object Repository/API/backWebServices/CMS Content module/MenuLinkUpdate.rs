<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>MenuLinkUpdate</name>
   <tag></tag>
   <elementGuidId>5b0d8e7d-dda1-46c3-a5e7-c1f0103f5f1e</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;name\&quot;: \&quot;string\&quot;,\n  \&quot;storeId\&quot;: \&quot;string\&quot;,\n  \&quot;language\&quot;: \&quot;string\&quot;,\n  \&quot;menuLinks\&quot;: [\n    {\n      \&quot;title\&quot;: \&quot;string\&quot;,\n      \&quot;url\&quot;: \&quot;string\&quot;,\n      \&quot;priority\&quot;: 0,\n      \&quot;menuLinkListId\&quot;: \&quot;string\&quot;,\n      \&quot;associatedObjectId\&quot;: \&quot;string\&quot;,\n      \&quot;associatedObjectName\&quot;: \&quot;string\&quot;,\n      \&quot;associatedObjectType\&quot;: \&quot;string\&quot;,\n      \&quot;securityScopes\&quot;: [\n        \&quot;string\&quot;\n      ],\n      \&quot;outerId\&quot;: \&quot;string\&quot;,\n      \&quot;createdDate\&quot;: \&quot;2020-09-15T19:47:27.910Z\&quot;,\n      \&quot;modifiedDate\&quot;: \&quot;2020-09-15T19:47:27.910Z\&quot;,\n      \&quot;createdBy\&quot;: \&quot;string\&quot;,\n      \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n      \&quot;id\&quot;: \&quot;string\&quot;\n    }\n  ],\n  \&quot;securityScopes\&quot;: [\n    \&quot;string\&quot;\n  ],\n  \&quot;outerId\&quot;: \&quot;string\&quot;,\n  \&quot;createdDate\&quot;: \&quot;2020-09-15T19:47:27.910Z\&quot;,\n  \&quot;modifiedDate\&quot;: \&quot;2020-09-15T19:47:27.910Z\&quot;,\n  \&quot;createdBy\&quot;: \&quot;string\&quot;,\n  \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n  \&quot;id\&quot;: \&quot;string\&quot;\n}&quot;,
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
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/cms/${GlobalVariable.storeId}/menu</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import com.kms.katalon.core.util.KeywordUtil

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
KeywordUtil.logInfo(response.responseBodyContent)
WS.verifyResponseStatusCode(response, 200)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

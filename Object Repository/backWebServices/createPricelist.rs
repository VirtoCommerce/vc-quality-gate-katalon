<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>createPricelist</name>
   <tag></tag>
   <elementGuidId>f44fa7f2-cd46-4bdb-9769-aa1ed5dcb810</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;name\&quot;: \&quot;string\&quot;,\n  \&quot;description\&quot;: \&quot;string\&quot;,\n  \&quot;currency\&quot;: \&quot;string\&quot;,\n  \&quot;outerId\&quot;: \&quot;string\&quot;,\n  \&quot;prices\&quot;: [\n    {\n      \&quot;pricelistId\&quot;: \&quot;string\&quot;,\n      \&quot;currency\&quot;: \&quot;string\&quot;,\n      \&quot;productId\&quot;: \&quot;string\&quot;,\n      \&quot;sale\&quot;: 0,\n      \&quot;list\&quot;: 0,\n      \&quot;minQuantity\&quot;: 0,\n      \&quot;startDate\&quot;: \&quot;2020-07-21T02:29:37.654Z\&quot;,\n      \&quot;endDate\&quot;: \&quot;2020-07-21T02:29:37.654Z\&quot;,\n      \&quot;outerId\&quot;: \&quot;string\&quot;,\n      \&quot;createdDate\&quot;: \&quot;2020-07-21T02:29:37.654Z\&quot;,\n      \&quot;modifiedDate\&quot;: \&quot;2020-07-21T02:29:37.654Z\&quot;,\n      \&quot;createdBy\&quot;: \&quot;string\&quot;,\n      \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n      \&quot;id\&quot;: \&quot;string\&quot;\n    }\n  ],\n  \&quot;assignments\&quot;: [\n    {\n      \&quot;catalogId\&quot;: \&quot;string\&quot;,\n      \&quot;pricelistId\&quot;: \&quot;string\&quot;,\n      \&quot;name\&quot;: \&quot;string\&quot;,\n      \&quot;description\&quot;: \&quot;string\&quot;,\n      \&quot;priority\&quot;: 0,\n      \&quot;startDate\&quot;: \&quot;2020-07-21T02:29:37.654Z\&quot;,\n      \&quot;endDate\&quot;: \&quot;2020-07-21T02:29:37.654Z\&quot;,\n      \&quot;dynamicExpression\&quot;: {\n        \&quot;all\&quot;: true,\n        \&quot;not\&quot;: true,\n        \&quot;availableChildren\&quot;: [\n          {}\n        ],\n        \&quot;children\&quot;: [\n          {}\n        ]\n      },\n      \&quot;outerId\&quot;: \&quot;string\&quot;,\n      \&quot;createdDate\&quot;: \&quot;2020-07-21T02:29:37.654Z\&quot;,\n      \&quot;modifiedDate\&quot;: \&quot;2020-07-21T02:29:37.654Z\&quot;,\n      \&quot;createdBy\&quot;: \&quot;string\&quot;,\n      \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n      \&quot;id\&quot;: \&quot;string\&quot;\n    }\n  ],\n  \&quot;createdDate\&quot;: \&quot;2020-07-21T02:29:37.654Z\&quot;,\n  \&quot;modifiedDate\&quot;: \&quot;2020-07-21T02:29:37.654Z\&quot;,\n  \&quot;createdBy\&quot;: \&quot;string\&quot;,\n  \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n  \&quot;id\&quot;: \&quot;string\&quot;\n}&quot;,
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
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/pricing/pricelists</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
KeywordUtil.logInfo(response.responseBodyContent)
WS.verifyResponseStatusCode(response, 200)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

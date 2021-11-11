<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>PricelistAssignmentsUpdate</name>
   <tag></tag>
   <elementGuidId>66d8a7c0-631f-4642-9e47-62bb85f0c28f</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;catalogId\&quot;: \&quot;string\&quot;,\n  \&quot;pricelistId\&quot;: \&quot;string\&quot;,\n  \&quot;pricelist\&quot;: {\n    \&quot;name\&quot;: \&quot;string\&quot;,\n    \&quot;description\&quot;: \&quot;string\&quot;,\n    \&quot;currency\&quot;: \&quot;string\&quot;,\n    \&quot;outerId\&quot;: \&quot;string\&quot;,\n    \&quot;prices\&quot;: [\n      {\n        \&quot;pricelistId\&quot;: \&quot;string\&quot;,\n        \&quot;currency\&quot;: \&quot;string\&quot;,\n        \&quot;productId\&quot;: \&quot;string\&quot;,\n        \&quot;sale\&quot;: 0,\n        \&quot;list\&quot;: 0,\n        \&quot;minQuantity\&quot;: 0,\n        \&quot;startDate\&quot;: \&quot;2021-11-11T17:28:01.530Z\&quot;,\n        \&quot;endDate\&quot;: \&quot;2021-11-11T17:28:01.530Z\&quot;,\n        \&quot;outerId\&quot;: \&quot;string\&quot;,\n        \&quot;createdDate\&quot;: \&quot;2021-11-11T17:28:01.530Z\&quot;,\n        \&quot;modifiedDate\&quot;: \&quot;2021-11-11T17:28:01.530Z\&quot;,\n        \&quot;createdBy\&quot;: \&quot;string\&quot;,\n        \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n        \&quot;id\&quot;: \&quot;string\&quot;\n      }\n    ],\n    \&quot;assignments\&quot;: [\n      null\n    ],\n    \&quot;createdDate\&quot;: \&quot;2021-11-11T17:28:01.530Z\&quot;,\n    \&quot;modifiedDate\&quot;: \&quot;2021-11-11T17:28:01.530Z\&quot;,\n    \&quot;createdBy\&quot;: \&quot;string\&quot;,\n    \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n    \&quot;id\&quot;: \&quot;string\&quot;\n  },\n  \&quot;name\&quot;: \&quot;string\&quot;,\n  \&quot;description\&quot;: \&quot;string\&quot;,\n  \&quot;priority\&quot;: 0,\n  \&quot;startDate\&quot;: \&quot;2021-11-11T17:28:01.530Z\&quot;,\n  \&quot;endDate\&quot;: \&quot;2021-11-11T17:28:01.530Z\&quot;,\n  \&quot;dynamicExpression\&quot;: {\n    \&quot;all\&quot;: true,\n    \&quot;not\&quot;: true,\n    \&quot;availableChildren\&quot;: [\n      {}\n    ],\n    \&quot;children\&quot;: [\n      {}\n    ]\n  },\n  \&quot;outerId\&quot;: \&quot;string\&quot;,\n  \&quot;createdDate\&quot;: \&quot;2021-11-11T17:28:01.530Z\&quot;,\n  \&quot;modifiedDate\&quot;: \&quot;2021-11-11T17:28:01.530Z\&quot;,\n  \&quot;createdBy\&quot;: \&quot;string\&quot;,\n  \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n  \&quot;id\&quot;: \&quot;string\&quot;\n}&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/pricing/assignments</restUrl>
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
WS.verifyResponseStatusCode(response, 200)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

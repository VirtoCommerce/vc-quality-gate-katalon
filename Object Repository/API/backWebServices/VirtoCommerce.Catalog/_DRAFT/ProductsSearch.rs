<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ProductsSearch</name>
   <tag></tag>
   <elementGuidId>ae0fbed5-c871-4eae-ab7d-5fe01cf1f8fb</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;objectType\&quot;: \&quot;string\&quot;,\n  \&quot;productType\&quot;: \&quot;string\&quot;,\n  \&quot;currency\&quot;: \&quot;string\&quot;,\n  \&quot;pricelists\&quot;: [\n    \&quot;string\&quot;\n  ],\n  \&quot;priceRange\&quot;: {\n    \&quot;lower\&quot;: 0,\n    \&quot;upper\&quot;: 0,\n    \&quot;includeLower\&quot;: true,\n    \&quot;includeUpper\&quot;: true\n  },\n  \&quot;classTypes\&quot;: [\n    \&quot;string\&quot;\n  ],\n  \&quot;withHidden\&quot;: true,\n  \&quot;searchInVariations\&quot;: true,\n  \&quot;startDate\&quot;: \&quot;2021-08-02T09:03:20.820Z\&quot;,\n  \&quot;startDateFrom\&quot;: \&quot;2021-08-02T09:03:20.820Z\&quot;,\n  \&quot;endDate\&quot;: \&quot;2021-08-02T09:03:20.820Z\&quot;,\n  \&quot;includeAggregations\&quot;: [\n    \&quot;string\&quot;\n  ],\n  \&quot;excludeAggregations\&quot;: [\n    \&quot;string\&quot;\n  ],\n  \&quot;geoDistanceFilter\&quot;: {\n    \&quot;fieldName\&quot;: \&quot;string\&quot;,\n    \&quot;location\&quot;: {\n      \&quot;latitude\&quot;: 0,\n      \&quot;longitude\&quot;: 0\n    },\n    \&quot;distance\&quot;: 0\n  },\n  \&quot;storeId\&quot;: \&quot;string\&quot;,\n  \&quot;catalogId\&quot;: \&quot;string\&quot;,\n  \&quot;outline\&quot;: \&quot;string\&quot;,\n  \&quot;outlines\&quot;: [\n    \&quot;string\&quot;\n  ],\n  \&quot;terms\&quot;: [\n    \&quot;string\&quot;\n  ],\n  \&quot;userGroups\&quot;: [\n    \&quot;string\&quot;\n  ],\n  \&quot;isFuzzySearch\&quot;: true,\n  \&quot;rawQuery\&quot;: \&quot;string\&quot;,\n  \&quot;includeFields\&quot;: [\n    \&quot;string\&quot;\n  ],\n  \&quot;searchPhrase\&quot;: \&quot;string\&quot;,\n  \&quot;keyword\&quot;: \&quot;string\&quot;,\n  \&quot;responseGroup\&quot;: \&quot;string\&quot;,\n  \&quot;objectTypes\&quot;: [\n    \&quot;string\&quot;\n  ],\n  \&quot;objectIds\&quot;: [\n    \&quot;string\&quot;\n  ],\n  \&quot;languageCode\&quot;: \&quot;string\&quot;,\n  \&quot;sort\&quot;: \&quot;string\&quot;,\n  \&quot;skip\&quot;: 0,\n  \&quot;take\&quot;: 0\n}&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/catalog/search/products</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
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

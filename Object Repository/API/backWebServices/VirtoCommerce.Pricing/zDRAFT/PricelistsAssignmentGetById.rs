<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>PricelistsAssignmentGetById</name>
   <tag></tag>
   <elementGuidId>17fd50a8-2b87-4037-ab84-52c35309ac81</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;storeId\&quot;: \&quot;string\&quot;,\n  \&quot;catalogId\&quot;: \&quot;string\&quot;,\n  \&quot;productIds\&quot;: [\n    \&quot;string\&quot;\n  ],\n  \&quot;pricelistIds\&quot;: [\n    \&quot;string\&quot;\n  ],\n  \&quot;returnAllMatchedPrices\&quot;: true,\n  \&quot;quantity\&quot;: 0,\n  \&quot;customerId\&quot;: \&quot;string\&quot;,\n  \&quot;organizationId\&quot;: \&quot;string\&quot;,\n  \&quot;certainDate\&quot;: \&quot;2021-11-11T16:21:30.065Z\&quot;,\n  \&quot;currency\&quot;: \&quot;string\&quot;,\n  \&quot;contextObject\&quot;: {},\n  \&quot;geoCity\&quot;: \&quot;string\&quot;,\n  \&quot;geoState\&quot;: \&quot;string\&quot;,\n  \&quot;geoCountry\&quot;: \&quot;string\&quot;,\n  \&quot;geoContinent\&quot;: \&quot;string\&quot;,\n  \&quot;geoZipCode\&quot;: \&quot;string\&quot;,\n  \&quot;geoConnectionType\&quot;: \&quot;string\&quot;,\n  \&quot;geoTimeZone\&quot;: \&quot;string\&quot;,\n  \&quot;geoIpRoutingType\&quot;: \&quot;string\&quot;,\n  \&quot;geoIspSecondLevel\&quot;: \&quot;string\&quot;,\n  \&quot;geoIspTopLevel\&quot;: \&quot;string\&quot;,\n  \&quot;shopperAge\&quot;: 0,\n  \&quot;shopperGender\&quot;: \&quot;string\&quot;,\n  \&quot;language\&quot;: \&quot;string\&quot;,\n  \&quot;userGroups\&quot;: [\n    \&quot;string\&quot;\n  ],\n  \&quot;shopperSearchedPhraseInStore\&quot;: \&quot;string\&quot;,\n  \&quot;shopperSearchedPhraseOnInternet\&quot;: \&quot;string\&quot;,\n  \&quot;currentUrl\&quot;: \&quot;string\&quot;,\n  \&quot;referredUrl\&quot;: \&quot;string\&quot;\n}&quot;,
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
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/pricing/assignments/{id}</restUrl>
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

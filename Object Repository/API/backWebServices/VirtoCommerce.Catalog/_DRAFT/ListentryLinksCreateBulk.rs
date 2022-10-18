<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Bulk create links to categories and items</description>
   <name>ListentryLinksCreateBulk</name>
   <tag></tag>
   <elementGuidId>07819558-d534-49b4-874c-42078a3ddfce</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;searchCriteria\&quot;: {\n    \&quot;code\&quot;: \&quot;string\&quot;,\n    \&quot;vendorId\&quot;: \&quot;string\&quot;,\n    \&quot;vendorIds\&quot;: [\n      \&quot;string\&quot;\n    ],\n    \&quot;productType\&quot;: \&quot;string\&quot;,\n    \&quot;productTypes\&quot;: [\n      \&quot;string\&quot;\n    ],\n    \&quot;excludeProductType\&quot;: \&quot;string\&quot;,\n    \&quot;excludeProductTypes\&quot;: [\n      \&quot;string\&quot;\n    ],\n    \&quot;withHidden\&quot;: true,\n    \&quot;hideDirectLinkedCategories\&quot;: true,\n    \&quot;mainProductId\&quot;: \&quot;string\&quot;,\n    \&quot;searchInChildren\&quot;: true,\n    \&quot;searchInVariations\&quot;: true,\n    \&quot;onlyBuyable\&quot;: true,\n    \&quot;onlyWithTrackingInventory\&quot;: true,\n    \&quot;catalogId\&quot;: \&quot;string\&quot;,\n    \&quot;catalogIds\&quot;: [\n      \&quot;string\&quot;\n    ],\n    \&quot;categoryId\&quot;: \&quot;string\&quot;,\n    \&quot;categoryIds\&quot;: [\n      \&quot;string\&quot;\n    ],\n    \&quot;responseGroup\&quot;: \&quot;string\&quot;,\n    \&quot;objectType\&quot;: \&quot;string\&quot;,\n    \&quot;objectTypes\&quot;: [\n      \&quot;string\&quot;\n    ],\n    \&quot;objectIds\&quot;: [\n      \&quot;string\&quot;\n    ],\n    \&quot;keyword\&quot;: \&quot;string\&quot;,\n    \&quot;searchPhrase\&quot;: \&quot;string\&quot;,\n    \&quot;languageCode\&quot;: \&quot;string\&quot;,\n    \&quot;sort\&quot;: \&quot;string\&quot;,\n    \&quot;skip\&quot;: 0,\n    \&quot;take\&quot;: 0\n  },\n  \&quot;categoryId\&quot;: \&quot;string\&quot;,\n  \&quot;catalogId\&quot;: \&quot;string\&quot;\n}\n&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/catalog/listentrylinks/bulkcreate</restUrl>
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
WS.verifyResponseStatusCode(response, 200)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

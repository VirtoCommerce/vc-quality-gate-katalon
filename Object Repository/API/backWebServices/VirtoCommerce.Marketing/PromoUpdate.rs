<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>PromoUpdate</name>
   <tag></tag>
   <elementGuidId>320f5f11-dc87-4211-834f-dbd0db56944c</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\t\&quot;isAllowCombiningWithSelf\&quot;: false,\n\t\&quot;storeIds\&quot;: [],\n\t\&quot;name\&quot;: \&quot;${promoName}\&quot;,\n\t\&quot;type\&quot;: \&quot;DynamicPromotion\&quot;,\n\t\&quot;isActive\&quot;: true,\n\t\&quot;priority\&quot;: 1,\n\t\&quot;isExclusive\&quot;: false,\n\t\&quot;hasCoupons\&quot;: false,\n\t\&quot;maxUsageCount\&quot;: 0,\n\t\&quot;maxUsageOnOrder\&quot;: 0,\n\t\&quot;maxPersonalUsageCount\&quot;: 0,\n\t\&quot;startDate\&quot;: \&quot;2020-01-03T09:31:26.961Z\&quot;,\n\t\&quot;endDate\&quot;: \&quot;2045-07-03T09:31:26.961Z\&quot;,\n\t\&quot;createdBy\&quot;: \&quot;admin\&quot;,\n\t\&quot;modifiedBy\&quot;: \&quot;admin\&quot;,\n\t\&quot;id\&quot;: \&quot;${promoId}\&quot;,\n\t\&quot;coupons\&quot;: []\n}&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/marketing/promotions</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'qweTest'</defaultValue>
      <description>updated promo name</description>
      <id>e01223e6-8437-4a3d-8e6f-d8198d9ef6d8</id>
      <masked>false</masked>
      <name>promoName</name>
   </variables>
   <variables>
      <defaultValue>'AutoTestId'</defaultValue>
      <description>promo id</description>
      <id>faa42c59-e113-451f-94a1-cd28077eea63</id>
      <masked>false</masked>
      <name>promoId</name>
   </variables>
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
WS.verifyResponseStatusCode(response, 204)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

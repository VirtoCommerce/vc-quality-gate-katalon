<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>DRAFT.createProductInventory</name>
   <tag></tag>
   <elementGuidId>15e2a6ec-37e7-4c71-bf3c-403ec9ed604a</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;fulfillmentCenterId\&quot;: \&quot;7c441d89-5bbf-40ae-ad3b-2f63917d77e1\&quot;,\n  //\&quot;fulfillmentCenterName\&quot;: \&quot;string\&quot;,\n  \&quot;productId\&quot;: \&quot;b6fdced5-58cc-4527-9453-5b0712b105fb\&quot;,\n  \&quot;inStockQuantity\&quot;: 90,\n  \&quot;allowBackorder\&quot;: false,\n  \&quot;allowPreorder\&quot;: false,\n  \&quot;status\&quot;: \&quot;Disabled\&quot;\n}&quot;,
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
   <restRequestMethod>PUT</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/inventory/products/b6fdced5-58cc-4527-9453-5b0712b105fb</restUrl>
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

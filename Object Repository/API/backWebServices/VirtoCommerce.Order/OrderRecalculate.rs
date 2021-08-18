<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Relculate order totals after changes</description>
   <name>OrderRecalculate</name>
   <tag></tag>
   <elementGuidId>c05cafb4-0402-4625-bc3d-4dc4da0c6422</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;customerId\&quot;: \&quot;8f20288b-da0a-45d7-8ade-bce2adbadcfe\&quot;,\n  \&quot;customerName\&quot;: \&quot;${userName}\&quot;,\n  \&quot;storeId\&quot;: \&quot;${storeId}\&quot;,\n  \&quot;items\&quot;: [\n    {\n      \&quot;currency\&quot;: \&quot;USD\&quot;,\n      \&quot;price\&quot;: 995.99,\n      \&quot;extendedPrice\&quot;: 995.99,\n      \&quot;extendedPriceWithTax\&quot;: 995.99,\n      \&quot;quantity\&quot;: \&quot;${quantity}\&quot;,\n      \&quot;productId\&quot;: \&quot;9cbd8f316e254a679ba34a900fccb076\&quot;,\n      \&quot;sku\&quot;: \&quot;3DRSOLO\&quot;,\n      \&quot;productType\&quot;: \&quot;Physical\&quot;,\n      \&quot;catalogId\&quot;: \&quot;4974648a41df4e6ea67ef2ad76d7bbd4\&quot;,\n      \&quot;categoryId\&quot;: \&quot;e51b5f9eea094a44939c11d4d4fa3bb1\&quot;,\n      \&quot;name\&quot;: \&quot;3DR Solo Quadcopter (No Gimbal)\&quot;,\n      \&quot;isGift\&quot;: false\n    }\n  ],\n  \&quot;Status\&quot;: \&quot;Paid\&quot;,\n  \&quot;number\&quot;: \&quot;CO123456-00000\&quot;,\n  \&quot;currency\&quot;: \&quot;USD\&quot;,\n  \&quot;id\&quot;: \&quot;${orderId}\&quot;\n}&quot;,
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
   <katalonVersion>8.0.5</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>PUT</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/order/customerOrders/recalculate</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'fc898c4e-d2ee-42a1-bac6-9df64dd1fcce'</defaultValue>
      <description></description>
      <id>85d5eae8-29e9-4548-b8dd-867f8404ae68</id>
      <masked>false</masked>
      <name>orderId</name>
   </variables>
   <variables>
      <defaultValue>'2'</defaultValue>
      <description></description>
      <id>3bc016b2-5e81-40e9-ae55-71a9e9d54e03</id>
      <masked>false</masked>
      <name>quantity</name>
   </variables>
   <variables>
      <defaultValue>'QweUser'</defaultValue>
      <description></description>
      <id>48120f77-daab-432f-a61f-caf335fd820a</id>
      <masked>false</masked>
      <name>userName</name>
   </variables>
   <variables>
      <defaultValue>'Electronics'</defaultValue>
      <description></description>
      <id>ca9218f2-3f5d-40ab-84c2-45d15b3a8fe0</id>
      <masked>false</masked>
      <name>storeId</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil


ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

def listJsonOutput = JsonOutput.prettyPrint(response.getResponseBodyContent())
KeywordUtil.logInfo(listJsonOutput)
WS.verifyResponseStatusCode(response, 200)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

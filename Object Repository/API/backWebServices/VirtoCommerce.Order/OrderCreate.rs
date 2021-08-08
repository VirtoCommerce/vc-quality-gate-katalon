<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>create order by cart id
(requires id from storefront)</description>
   <name>OrderCreate</name>
   <tag></tag>
   <elementGuidId>a3300cae-74f7-4386-8064-90f2f9b347c5</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;customerId\&quot;: \&quot;8f20288b-da0a-45d7-8ade-bce2adbadcfe\&quot;,\n  \&quot;customerName\&quot;: \&quot;${userName}\&quot;,\n  \&quot;storeId\&quot;: \&quot;${storeId}\&quot;,\n  \&quot;items\&quot;: [\n    {\n      \&quot;currency\&quot;: \&quot;USD\&quot;,\n      \&quot;price\&quot;: 995.99,\n      \&quot;quantity\&quot;: \&quot;${quantity}\&quot;,\n      \&quot;productId\&quot;: \&quot;9cbd8f316e254a679ba34a900fccb076\&quot;,\n      \&quot;sku\&quot;: \&quot;3DRSOLO\&quot;,\n      \&quot;catalogId\&quot;: \&quot;4974648a41df4e6ea67ef2ad76d7bbd4\&quot;,\n      \&quot;categoryId\&quot;: \&quot;e51b5f9eea094a44939c11d4d4fa3bb1\&quot;,\n      \&quot;name\&quot;: \&quot;3DR Solo Quadcopter (No Gimbal)\&quot;,\n      \&quot;isGift\&quot;: false\n    }\n  ],\n  \&quot;Status\&quot;: \&quot;Paid\&quot;,\n  \&quot;number\&quot;: \&quot;CO123456-12345\&quot;,\n  \&quot;currency\&quot;: \&quot;USD\&quot;,\n  \&quot;id\&quot;: \&quot;${orderId}\&quot;\n}&quot;,
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
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/order/customerOrders</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'8383028c-4d80-46bc-887e-282d0707a070'</defaultValue>
      <description></description>
      <id>b4011f0c-270d-49ed-bbe4-fe1e21fc6e0c</id>
      <masked>false</masked>
      <name>orderId</name>
   </variables>
   <variables>
      <defaultValue>'1'</defaultValue>
      <description></description>
      <id>706fdfb2-03e9-4fc9-8cbc-845f68c9bb6c</id>
      <masked>false</masked>
      <name>quantity</name>
   </variables>
   <variables>
      <defaultValue>'QweUser'</defaultValue>
      <description></description>
      <id>e25f5dae-1123-463e-8a5e-c9c1c11214f7</id>
      <masked>false</masked>
      <name>userName</name>
   </variables>
   <variables>
      <defaultValue>'Electronics'</defaultValue>
      <description></description>
      <id>bab93e5c-8236-4186-b6a2-120b4773c5c3</id>
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

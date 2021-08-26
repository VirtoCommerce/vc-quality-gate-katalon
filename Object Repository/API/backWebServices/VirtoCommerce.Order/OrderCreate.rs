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
  &quot;text&quot;: &quot;{\n  \&quot;customerId\&quot;: \&quot;bc0682a3-1050-4637-95e3-d2499f5b3d08\&quot;,\n  \&quot;customerName\&quot;: \&quot;${userName}\&quot;,\n  \&quot;storeId\&quot;: \&quot;${storeId}\&quot;,\n  \&quot;shoppingCartId\&quot;: \&quot;fb30406f-7c43-4445-af16-fe26cdba2c5d\&quot;,\n  \&quot;isPrototype\&quot;: false,\n  \&quot;objectType\&quot;: \&quot;VirtoCommerce.OrdersModule.Core.Model.CustomerOrder\&quot;,\n  \&quot;addresses\&quot;: [],\n  \&quot;inPayments\&quot;: [],\n  \&quot;items\&quot;: [\n    {\n      \&quot;currency\&quot;: \&quot;USD\&quot;,\n      \&quot;price\&quot;: \&quot;995.99\&quot;,\n      \&quot;quantity\&quot;: \&quot;${quantity}\&quot;,\n      \&quot;productId\&quot;: \&quot;9cbd8f316e254a679ba34a900fccb076\&quot;,\n      \&quot;sku\&quot;: \&quot;3DRSOLO\&quot;,\n      \&quot;productType\&quot;: \&quot;Physical\&quot;,\n      \&quot;catalogId\&quot;: \&quot;4974648a41df4e6ea67ef2ad76d7bbd4\&quot;,\n      \&quot;name\&quot;: \&quot;3DR Solo Quadcopter (No Gimbal)\&quot;,\n      \&quot;isGift\&quot;: false,\n      \&quot;isCancelled\&quot;: false,\n      \&quot;objectType\&quot;: \&quot;VirtoCommerce.OrdersModule.Core.Model.LineItem\&quot;,\n      \&quot;createdBy\&quot;: \&quot;admin\&quot;,\n      \&quot;modifiedBy\&quot;: \&quot;admin\&quot;,\n      \&quot;id\&quot;: \&quot;c5d5394b-b2e5-49f5-80c8-179e94c9b37e\&quot;\n    }\n  ],\n  \&quot;shipments\&quot;: [],\n  \&quot;discounts\&quot;: [],\n  \&quot;number\&quot;: \&quot;${orderNumber}\&quot;,\n  \&quot;status\&quot;: \&quot;Paid\&quot;,\n  \&quot;currency\&quot;: \&quot;USD\&quot;,\n  \&quot;childrenOperations\&quot;: [],\n  \&quot;isCancelled\&quot;: false,\n  \&quot;dynamicProperties\&quot;: [],\n  \&quot;createdBy\&quot;: \&quot;${userName}\&quot;,\n  \&quot;modifiedBy\&quot;: null,\n  \&quot;id\&quot;: \&quot;${orderId}\&quot;\n}&quot;,
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
      <description>id of the created order</description>
      <id>b4011f0c-270d-49ed-bbe4-fe1e21fc6e0c</id>
      <masked>false</masked>
      <name>orderId</name>
   </variables>
   <variables>
      <defaultValue>'1'</defaultValue>
      <description>sku quantity</description>
      <id>706fdfb2-03e9-4fc9-8cbc-845f68c9bb6c</id>
      <masked>false</masked>
      <name>quantity</name>
   </variables>
   <variables>
      <defaultValue>'QweUser'</defaultValue>
      <description>required username</description>
      <id>e25f5dae-1123-463e-8a5e-c9c1c11214f7</id>
      <masked>false</masked>
      <name>userName</name>
   </variables>
   <variables>
      <defaultValue>'Electronics'</defaultValue>
      <description>id of the store</description>
      <id>bab93e5c-8236-4186-b6a2-120b4773c5c3</id>
      <masked>false</masked>
      <name>storeId</name>
   </variables>
   <variables>
      <defaultValue>'CO123456-00000'</defaultValue>
      <description>id of the created order</description>
      <id>a190af35-2e33-4ce1-9359-403925e6a725</id>
      <masked>false</masked>
      <name>orderNumber</name>
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
WS.verifyResponseStatusCode(response, 200)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

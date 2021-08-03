<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>create order by cart id
(requires id from storefront)</description>
   <name>DRAFT.OrderCreate</name>
   <tag></tag>
   <elementGuidId>09827226-6ccd-44f6-9826-6a0fd9871c5f</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{  \n\&quot;customerId\&quot;: \&quot;${userId}\&quot;,\n  \&quot;customerName\&quot;: \&quot;${userName}\&quot;,\n  \&quot;storeId\&quot;: \&quot;${storeId}\&quot;,\n  \&quot;shoppingCartId\&quot;: \&quot;4cbaf9bf-834d-4306-bde6-af66af08054d\&quot;,\n  \&quot;isPrototype\&quot;: false,\n  \&quot;objectType\&quot;: \&quot;VirtoCommerce.OrdersModule.Core.Model.CustomerOrder\&quot;,\n  \&quot;addresses\&quot;: [\n  ],\n  \&quot;inPayments\&quot;: [],\n  \&quot;items\&quot;: [\n    {\n      \&quot;currency\&quot;: \&quot;USD\&quot;,\n      \&quot;price\&quot;: 995.99,\n      \&quot;priceWithTax\&quot;: 995.99,\n      \&quot;placedPrice\&quot;: 995.99,\n      \&quot;placedPriceWithTax\&quot;: 995.99,\n      \&quot;extendedPrice\&quot;: 995.99,\n      \&quot;extendedPriceWithTax\&quot;: 995.99,\n      \&quot;discountAmount\&quot;: 0,\n      \&quot;discountAmountWithTax\&quot;: 0,\n      \&quot;discountTotal\&quot;: 0,\n      \&quot;discountTotalWithTax\&quot;: 0,\n      \&quot;fee\&quot;: 0,\n      \&quot;feeWithTax\&quot;: 0,\n      \&quot;taxTotal\&quot;: 0,\n      \&quot;taxPercentRate\&quot;: 0,\n      \&quot;reserveQuantity\&quot;: 0,\n      \&quot;quantity\&quot;: 1,\n      \&quot;productId\&quot;: \&quot;9cbd8f316e254a679ba34a900fccb076\&quot;,\n      \&quot;sku\&quot;: \&quot;3DRSOLO\&quot;,\n      \&quot;productType\&quot;: \&quot;Physical\&quot;,\n      \&quot;catalogId\&quot;: \&quot;4974648a41df4e6ea67ef2ad76d7bbd4\&quot;,\n      \&quot;categoryId\&quot;: \&quot;e51b5f9eea094a44939c11d4d4fa3bb1\&quot;,\n      \&quot;name\&quot;: \&quot;3DR Solo Quadcopter (No Gimbal)\&quot;,\n      \&quot;imageUrl\&quot;: \&quot;//localhost:9112/assets/catalog/3DRSOLO/1428965138000_1133723.jpg\&quot;,\n      \&quot;isGift\&quot;: false,\n      \&quot;isCancelled\&quot;: false,\n      \&quot;objectType\&quot;: \&quot;VirtoCommerce.OrdersModule.Core.Model.LineItem\&quot;,\n      \&quot;dynamicProperties\&quot;: [],\n      \&quot;discounts\&quot;: [],\n      \&quot;taxDetails\&quot;: [],\n      \&quot;createdDate\&quot;: \&quot;${currentDate}\&quot;,\n      \&quot;modifiedDate\&quot;: \&quot;${currentDate}\&quot;,\n      \&quot;createdBy\&quot;: \&quot;${userName}\&quot;,\n      \&quot;modifiedBy\&quot;: \&quot;${userName}\&quot;,\n      \&quot;id\&quot;: \&quot;9e30a534-6f21-4b40-9341-e4d872138455\&quot;\n    }\n  ],\n  \&quot;shipments\&quot;: [],\n  \&quot;discounts\&quot;: [],\n  \&quot;discountAmount\&quot;: 0,\n  \&quot;taxDetails\&quot;: [],\n  \&quot;total\&quot;: 995.99,\n  \&quot;subTotal\&quot;: 995.99,\n  \&quot;subTotalWithTax\&quot;: 995.99,\n  \&quot;subTotalDiscount\&quot;: 0,\n  \&quot;subTotalDiscountWithTax\&quot;: 0,\n  \&quot;subTotalTaxTotal\&quot;: 0,\n  \&quot;shippingTotal\&quot;: 0,\n  \&quot;shippingTotalWithTax\&quot;: 0,\n  \&quot;shippingSubTotal\&quot;: 0,\n  \&quot;shippingSubTotalWithTax\&quot;: 0,\n  \&quot;shippingDiscountTotal\&quot;: 0,\n  \&quot;shippingDiscountTotalWithTax\&quot;: 0,\n  \&quot;shippingTaxTotal\&quot;: 0,\n  \&quot;paymentTotal\&quot;: 0,\n  \&quot;paymentTotalWithTax\&quot;: 0,\n  \&quot;paymentSubTotal\&quot;: 0,\n  \&quot;paymentSubTotalWithTax\&quot;: 0,\n  \&quot;paymentDiscountTotal\&quot;: 0,\n  \&quot;paymentDiscountTotalWithTax\&quot;: 0,\n  \&quot;paymentTaxTotal\&quot;: 0,\n  \&quot;discountTotal\&quot;: 0,\n  \&quot;discountTotalWithTax\&quot;: 0,\n  \&quot;fee\&quot;: 0,\n  \&quot;feeWithTax\&quot;: 0,\n  \&quot;feeTotal\&quot;: 0,\n  \&quot;feeTotalWithTax\&quot;: 0,\n  \&quot;taxTotal\&quot;: 0,\n  \&quot;taxPercentRate\&quot;: 0,\n  \&quot;languageCode\&quot;: \&quot;en-US\&quot;,\n  \&quot;operationType\&quot;: \&quot;CustomerOrder\&quot;,\n  \&quot;number\&quot;: \&quot;CO210803-00001\&quot;,\n  \&quot;isApproved\&quot;: false,\n  \&quot;status\&quot;: \&quot;Paid\&quot;,\n  \&quot;currency\&quot;: \&quot;USD\&quot;,\n  \&quot;sum\&quot;: 995.99,\n  \&quot;childrenOperations\&quot;: [],\n  \&quot;isCancelled\&quot;: false,\n  \&quot;dynamicProperties\&quot;: [],\n  \&quot;createdDate\&quot;: \&quot;${currentDate}\&quot;,\n  \&quot;modifiedDate\&quot;: \&quot;${currentDate}\&quot;,\n  \&quot;createdBy\&quot;: \&quot;${userName}\&quot;,\n  \&quot;modifiedBy\&quot;: \&quot;${userName}\&quot;,\n  \&quot;id\&quot;: \&quot;${orderId}\&quot;\n}&quot;,
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
      <defaultValue>''</defaultValue>
      <description></description>
      <id>46f665e4-a31b-4d1a-ad19-965613d0ae34</id>
      <masked>false</masked>
      <name>storeId</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>eb960bed-f872-4d25-9d59-f2595f12bfba</id>
      <masked>false</masked>
      <name>userName</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>13d619e1-645d-466e-9ba6-bf3e84268f64</id>
      <masked>false</masked>
      <name>userId</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>dd337eaf-436b-40b0-8a49-e0d2f51d076d</id>
      <masked>false</masked>
      <name>currentDate</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>3a8b9669-c044-4bb4-8257-31def1ef72d2</id>
      <masked>false</masked>
      <name>orderId</name>
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

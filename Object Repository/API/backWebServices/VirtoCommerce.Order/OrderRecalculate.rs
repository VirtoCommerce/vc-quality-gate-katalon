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
  &quot;text&quot;: &quot;{\n\t\&quot;customerId\&quot;: \&quot;88c0ce58-49c9-4ff5-af0d-10f19d0e38bc\&quot;,\n\t\&quot;customerName\&quot;: \&quot;alex@mail.com\&quot;,\n\t\&quot;storeId\&quot;: \&quot;Electronics\&quot;,\n\t\&quot;isPrototype\&quot;: false,\n\t\&quot;subscriptionNumber\&quot;: \&quot;SU170116-00100\&quot;,\n\t\&quot;subscriptionId\&quot;: \&quot;d52055595dbe43c181f00c192bcfcb5e\&quot;,\n\t\&quot;objectType\&quot;: \&quot;VirtoCommerce.OrdersModule.Core.Model.CustomerOrder\&quot;,\n\t\&quot;items\&quot;: [\n\t\t{\n\t\t\t\n\t\t\t\&quot;quantity\&quot;: 1,\n\t\t\t\&quot;productId\&quot;: \&quot;cbd8eab4f76b4e34b779d9c59dbc13fe\&quot;,\n\t\t\t\&quot;sku\&quot;: \&quot;ONHTS3700\&quot;,\n\t\t\t\&quot;productType\&quot;: \&quot;Physical\&quot;,\n\t\t\t\&quot;catalogId\&quot;: \&quot;4974648a41df4e6ea67ef2ad76d7bbd4\&quot;,\n\t\t\t\&quot;id\&quot;: \&quot;2c5bf494-3d6e-4e6e-a71e-fbd85e563359\&quot;\n\t\t}\n\t],\n\t\&quot;discounts\&quot;: [],\n\t\&quot;discountAmount\&quot;: 0,\n\t\&quot;taxDetails\&quot;: [],\n\t\&quot;total\&quot;: 484.8,\n\t\&quot;subTotal\&quot;: 399,\n\t\&quot;subTotalWithTax\&quot;: 478.8,\n\t\&quot;subTotalDiscount\&quot;: 0,\n\t\&quot;subTotalDiscountWithTax\&quot;: 0,\n\t\&quot;subTotalTaxTotal\&quot;: 79.8,\n\t\&quot;shippingTotal\&quot;: 5,\n\t\&quot;shippingTotalWithTax\&quot;: 5,\n\t\&quot;shippingSubTotal\&quot;: 5,\n\t\&quot;shippingSubTotalWithTax\&quot;: 6,\n\t\&quot;shippingDiscountTotal\&quot;: 0,\n\t\&quot;shippingDiscountTotalWithTax\&quot;: 0,\n\t\&quot;shippingTaxTotal\&quot;: 0,\n\t\&quot;paymentTotal\&quot;: 0,\n\t\&quot;paymentTotalWithTax\&quot;: 0,\n\t\&quot;paymentSubTotal\&quot;: 0,\n\t\&quot;paymentSubTotalWithTax\&quot;: 0,\n\t\&quot;paymentDiscountTotal\&quot;: 0,\n\t\&quot;paymentDiscountTotalWithTax\&quot;: 0,\n\t\&quot;paymentTaxTotal\&quot;: 0,\n\t\&quot;discountTotal\&quot;: 0,\n\t\&quot;discountTotalWithTax\&quot;: 0,\n\t\&quot;fee\&quot;: 0,\n\t\&quot;feeWithTax\&quot;: 0,\n\t\&quot;feeTotal\&quot;: 0,\n\t\&quot;feeTotalWithTax\&quot;: 0,\n\t\&quot;taxTotal\&quot;: 80.8,\n\t\&quot;taxPercentRate\&quot;: 0,\n\t\&quot;languageCode\&quot;: \&quot;en-US\&quot;,\n\t\&quot;operationType\&quot;: \&quot;CustomerOrder\&quot;,\n\t\&quot;number\&quot;: \&quot;CO210722-00002\&quot;,\n\t\&quot;isApproved\&quot;: false,\n\t\&quot;status\&quot;: \&quot;New\&quot;,\n\t\&quot;currency\&quot;: \&quot;USD\&quot;,\n\t\&quot;sum\&quot;: 484.8,\n\t\&quot;childrenOperations\&quot;: [],\n\t\&quot;isCancelled\&quot;: false,\n\t\&quot;dynamicProperties\&quot;: [],\n\t\&quot;createdDate\&quot;: \&quot;2021-07-22T09:00:10.8166664Z\&quot;,\n\t\&quot;modifiedDate\&quot;: \&quot;2021-07-22T09:00:10.8166664Z\&quot;,\n\t\&quot;createdBy\&quot;: \&quot;unknown\&quot;,\n\t\&quot;modifiedBy\&quot;: \&quot;unknown\&quot;,\n\t\&quot;id\&quot;: \&quot;20205d0c-1cfa-47a7-9669-87d120227eb4\&quot;\n}&quot;,
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
      <defaultValue>'20205d0c-1cfa-47a7-9669-87d120227eb4'</defaultValue>
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
WS.verifyResponseStatusCode(response, 204)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>PricesAddUpdateByProductId</name>
   <tag></tag>
   <elementGuidId>8f7b9dca-db8f-4a05-9d2a-477c5f2b916c</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\t\&quot;productId\&quot;: \&quot;${productId}\&quot;,\n\t\&quot;product\&quot;: {\n\t\t\&quot;code\&quot;: \&quot;QWESKU03\&quot;,\n\t\t\&quot;name\&quot;: \&quot;${productName}\&quot;,\n\t\t\&quot;catalogId\&quot;: \&quot;${catalogId}\&quot;,\n\t\t\&quot;path\&quot;: \&quot;Cell phones\&quot;,\n\t\t\&quot;isBuyable\&quot;: true,\n\t\t\&quot;isActive\&quot;: true,\n\t\t\&quot;id\&quot;: \&quot;${productId}\&quot;\n\t},\n\t\&quot;prices\&quot;: [\n\t\t{\n\t\t\t\&quot;pricelistId\&quot;: \&quot;${pricelistId}\&quot;,\n\t\t\t\&quot;currency\&quot;: \&quot;USD\&quot;,\n\t\t\t\&quot;productId\&quot;: \&quot;${productId}\&quot;,\n\t\t\t\&quot;sale\&quot;: 111,\n\t\t\t\&quot;list\&quot;: \&quot;${listPrice}\&quot;,\n\t\t\t\&quot;minQuantity\&quot;: 1,\n\t\t\t\&quot;id\&quot;: \&quot;${priceId}\&quot;\n\t\t}\n\t]\n}&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/products/${productId}/prices</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'edb3a60d-f1c6-4f41-a88b-a4dc6ccc3bf3'</defaultValue>
      <description>id of the product to update price</description>
      <id>c87e843b-cc32-41fb-989a-9646bf8c29ce</id>
      <masked>false</masked>
      <name>productId</name>
   </variables>
   <variables>
      <defaultValue>'QweProduct'</defaultValue>
      <description>name of the updated product</description>
      <id>a8fc0ab5-2113-4df0-9e7b-8d4293010240</id>
      <masked>false</masked>
      <name>productName</name>
   </variables>
   <variables>
      <defaultValue>'4974648a41df4e6ea67ef2ad76d7bbd4'</defaultValue>
      <description>id of the related catalog</description>
      <id>e9204163-1652-45ed-9f73-f6bd940e9a68</id>
      <masked>false</masked>
      <name>catalogId</name>
   </variables>
   <variables>
      <defaultValue>'ee5ec795-5f75-46df-95eb-94e378ada532'</defaultValue>
      <description>id of the related pricelist</description>
      <id>4e8271ec-1ba0-4d90-9704-ad48d1e4f3ec</id>
      <masked>false</masked>
      <name>pricelistId</name>
   </variables>
   <variables>
      <defaultValue>'4a0f48bc-4662-4668-95b5-e599275f6fcf'</defaultValue>
      <description>id of the price to update</description>
      <id>a37d9657-2064-4094-bec7-447b755c6d42</id>
      <masked>false</masked>
      <name>priceId</name>
   </variables>
   <variables>
      <defaultValue>'777'</defaultValue>
      <description>updated list price</description>
      <id>7aae55dc-63fe-40c1-b14c-dbd6a18defad</id>
      <masked>false</masked>
      <name>listPrice</name>
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
WS.verifyResponseStatusCode(response, 204)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

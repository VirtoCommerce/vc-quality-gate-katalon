<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ListentriesMove</name>
   <tag></tag>
   <elementGuidId>95f6f25f-fa7f-45db-830a-be2112a33bf4</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n   \&quot;catalog\&quot;:\&quot;${catalogId}\&quot;,\n   \&quot;listEntries\&quot;:[\n      {\n         \&quot;type\&quot;:\&quot;product\&quot;,\n         \&quot;isActive\&quot;:true,\n         \&quot;code\&quot;:\&quot;${code}\&quot;,\n         \&quot;name\&quot;:\&quot;${name}\&quot;,\n         \&quot;links\&quot;:[\n            \n         ],\n         \&quot;outline\&quot;:[\n            \&quot;${catalogId}\&quot;,\n            \&quot;${categoryIdFrom}\&quot;,\n            \&quot;${productId}\&quot;\n         ],\n         \&quot;path\&quot;:[\n            \&quot;${catalogName}\&quot;,\n            \&quot;${categoryNameFrom}\&quot;,\n            \&quot;${name}\&quot;\n         ],\n         \&quot;catalogId\&quot;:\&quot;${catalogId}\&quot;,\n         \&quot;seoObjectType\&quot;:\&quot;CatalogProduct\&quot;,\n         \&quot;seoInfos\&quot;:[\n            \n         ],\n         \&quot;createdDate\&quot;:\&quot;2021-08-23T15:26:22.4347115Z\&quot;,\n         \&quot;modifiedDate\&quot;:\&quot;2021-08-24T07:08:38.3515897Z\&quot;,\n         \&quot;createdBy\&quot;:\&quot;operator@mail.com\&quot;,\n         \&quot;modifiedBy\&quot;:\&quot;operator@mail.com\&quot;,\n         \&quot;id\&quot;:\&quot;${productId}\&quot;,\n         \&quot;$path\&quot;:\&quot;${catalogName} \\\\ ${categoryNamefrom} \\\\ ${name}\&quot;\n      }\n   ]\n}&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/catalog/listentries/move</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'QweDrink'</defaultValue>
      <description>Name of product</description>
      <id>634e3cbd-bf59-489b-9196-794d1bad3851</id>
      <masked>false</masked>
      <name>name</name>
   </variables>
   <variables>
      <defaultValue>'sku'</defaultValue>
      <description>Sku</description>
      <id>672f198e-7765-46ad-a646-cccaa2f57fa4</id>
      <masked>false</masked>
      <name>code</name>
   </variables>
   <variables>
      <defaultValue>'catalogId'</defaultValue>
      <description>move TO this catId</description>
      <id>628db77e-1fc4-4cef-84b0-f2bcfa2d020b</id>
      <masked>false</masked>
      <name>catalogId</name>
   </variables>
   <variables>
      <defaultValue>'categoryId'</defaultValue>
      <description>move FROM this category</description>
      <id>12df0c44-f775-4ebd-a539-c9fded801c49</id>
      <masked>false</masked>
      <name>categoryIdFrom</name>
   </variables>
   <variables>
      <defaultValue>'productId'</defaultValue>
      <description>product ID</description>
      <id>ec461e2c-1f79-4356-85ee-88794d7146bf</id>
      <masked>false</masked>
      <name>productId</name>
   </variables>
   <variables>
      <defaultValue>'Electronics'</defaultValue>
      <description>move TO this catName</description>
      <id>005c83f7-0e10-41c4-a4ec-04d05c1ffece</id>
      <masked>false</masked>
      <name>catalogName</name>
   </variables>
   <variables>
      <defaultValue>'Cell phones'</defaultValue>
      <description>move FROM this category</description>
      <id>25cbd2e5-b24f-4905-a5a2-d953821a270f</id>
      <masked>false</masked>
      <name>categoryNameFrom</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

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

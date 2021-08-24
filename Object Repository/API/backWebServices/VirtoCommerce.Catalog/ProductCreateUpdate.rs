<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ProductCreateUpdate</name>
   <tag></tag>
   <elementGuidId>929eca15-9be8-4fb2-b095-d016a79f9a26</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;code\&quot;: \&quot;${code}\&quot;,\n  \&quot;name\&quot;: \&quot;${name}\&quot;,\n  \&quot;catalogId\&quot;: \&quot;${catalogId}\&quot;,\n  \&quot;categoryId\&quot;: \&quot;${categoryId}\&quot;,\n  \&quot;id\&quot;: \&quot;${id}\&quot;,\n  \&quot;weightUnit\&quot;:\&quot;${weightUnit}\&quot;,\n  \&quot;weight\&quot;:\&quot;${weight}\&quot;,\n  \&quot;height\&quot;:\&quot;${height}\&quot;,\n  \&quot;width\&quot;:\&quot;${width}\&quot;,\n  \&quot;length\&quot;:\&quot;${length}\&quot;,\n  \&quot;productType\&quot;:\&quot;Physical\&quot;,\n  \&quot;reviews\&quot;:[\n      {\n         \&quot;languageCode\&quot;:\&quot;en-US\&quot;,\n         \&quot;reviewType\&quot;:\&quot;QuickReview\&quot;,\n         \&quot;content\&quot;:\&quot;${content}\&quot;\n      }\n   ]\n}&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/catalog/products</restUrl>
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
      <id>4d31d96e-46bb-4000-badd-7d23496ac608</id>
      <masked>false</masked>
      <name>name</name>
   </variables>
   <variables>
      <defaultValue>'${GlobalVariable.sku}'</defaultValue>
      <description>Sku</description>
      <id>d3485287-a967-453e-b745-1910700a4d10</id>
      <masked>false</masked>
      <name>code</name>
   </variables>
   <variables>
      <defaultValue>'${GlobalVariable.catalogId}'</defaultValue>
      <description></description>
      <id>c82e8ed8-08f4-4fcb-9cf2-9a5eaee5fd74</id>
      <masked>false</masked>
      <name>catalogId</name>
   </variables>
   <variables>
      <defaultValue>'${GlobalVariable.categoryId}'</defaultValue>
      <description></description>
      <id>32e1c1a4-dd55-48ce-910b-d4b8593b2204</id>
      <masked>false</masked>
      <name>categoryId</name>
   </variables>
   <variables>
      <defaultValue>'${GlobalVariable.productId}'</defaultValue>
      <description>product ID</description>
      <id>5be61088-737c-495a-8a9d-02c5d4dcb767</id>
      <masked>false</masked>
      <name>id</name>
   </variables>
   <variables>
      <defaultValue>'description'</defaultValue>
      <description>Quick Review content</description>
      <id>71331444-febe-498f-a2d9-dd1d2bc8cec7</id>
      <masked>false</masked>
      <name>content</name>
   </variables>
   <variables>
      <defaultValue>'gram'</defaultValue>
      <description></description>
      <id>4904b186-6abb-436c-8fb0-f2adb254509c</id>
      <masked>false</masked>
      <name>weightUnit</name>
   </variables>
   <variables>
      <defaultValue>'100'</defaultValue>
      <description></description>
      <id>8a901198-de36-4be8-9f95-e109051e10b6</id>
      <masked>false</masked>
      <name>weight</name>
   </variables>
   <variables>
      <defaultValue>'100'</defaultValue>
      <description></description>
      <id>b99cdbdb-ca26-4210-a883-bd550d801be7</id>
      <masked>false</masked>
      <name>height</name>
   </variables>
   <variables>
      <defaultValue>'100'</defaultValue>
      <description></description>
      <id>5a4cff44-0bdc-47b2-88cd-7f45217a15dc</id>
      <masked>false</masked>
      <name>width</name>
   </variables>
   <variables>
      <defaultValue>'100'</defaultValue>
      <description></description>
      <id>ca52b234-76fa-4bdd-bef4-44ed3cc1d552</id>
      <masked>false</masked>
      <name>length</name>
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

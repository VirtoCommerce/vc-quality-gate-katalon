<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>PricelistAddPrices</name>
   <tag></tag>
   <elementGuidId>db97a09c-045d-4e03-9004-b2bd565e56c1</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[\n\t{\n\t\t\&quot;prices\&quot;: [\n\t\t\t{\n\t\t\t\t\&quot;productId\&quot;: \&quot;${productId}\&quot;,\n\t\t\t\t\&quot;list\&quot;: \&quot;${listPrice}\&quot;,\n\t\t\t\t\&quot;sale\&quot;: \&quot;${salePrice}\&quot;,\n\t\t\t\t\&quot;minQuantity\&quot;: \&quot;1\&quot;,\n\t\t\t\t\&quot;currency\&quot;: \&quot;USD\&quot;,\n\t\t\t\t\&quot;priceListId\&quot;: \&quot;${pricelistId}\&quot;\n\t\t\t}\n\t\t]\n\t}\n]&quot;,
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
      <webElementGuid>34935f68-d678-414d-95bb-f2ac8d231156</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>api_key</name>
      <type>Main</type>
      <value>${GlobalVariable.api_key}</value>
      <webElementGuid>79ae8420-cd4d-46d4-b08b-47c886e70f8c</webElementGuid>
   </httpHeaderProperties>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>PUT</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/products/prices</restUrl>
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
      <description>id of the product to add </description>
      <id>fc5e02ab-5a83-4534-9115-2958ad527843</id>
      <masked>false</masked>
      <name>productId</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description>recepient pricelist id</description>
      <id>2b51af88-c906-49f4-8fff-aafe0d18e3a5</id>
      <masked>false</masked>
      <name>pricelistId</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description>product list price</description>
      <id>89b7771b-dc91-4f1f-b1a2-52a93748b50a</id>
      <masked>false</masked>
      <name>listPrice</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description>product sale price</description>
      <id>8e6e2f4f-6560-44bd-9296-37a0023a7378</id>
      <masked>false</masked>
      <name>salePrice</name>
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

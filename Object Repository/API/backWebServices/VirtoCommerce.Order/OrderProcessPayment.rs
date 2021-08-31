<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Register customer order payment in external payment system</description>
   <name>OrderProcessPayment</name>
   <tag></tag>
   <elementGuidId>aaa0cfa8-b5e9-48e4-954c-edd2876eca72</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;bankCardNumber\&quot;: \&quot;4111111111111111\&quot;,\n  \&quot;bankCardType\&quot;: \&quot;VISA\&quot;,\n  \&quot;bankCardMonth\&quot;: 12,\n  \&quot;bankCardYear\&quot;: 2029,\n  \&quot;bankCardCVV2\&quot;: \&quot;123\&quot;,\n  \&quot;cardholderName\&quot;: \&quot;QWEUSER\&quot;\n}&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/order/customerOrders/${orderId}/processPayment/${paymentId}</restUrl>
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
      <description>related order id</description>
      <id>02036b8c-7c19-4e28-b4e0-ba744cc4b168</id>
      <masked>false</masked>
      <name>orderId</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description>used payment id</description>
      <id>85048ae5-edb0-4fc2-a6e3-7f059bf0586d</id>
      <masked>false</masked>
      <name>paymentId</name>
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
WS.verifyResponseStatusCode(response, 200)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>createOrder</name>
   <tag></tag>
   <elementGuidId>3f720ed8-ed44-4575-8b42-7334bed747d6</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;preferredDeliveryDate\&quot;: \&quot;${preferredDeliveryDate}\&quot;,\n  \&quot;purchaseOrderNumber\&quot;: \&quot;${purchaseOrderNumber}\&quot;,\n  \&quot;comment\&quot;: \&quot;${comment}\&quot;,\n  \&quot;paymentMethod\&quot;: \&quot;${GlobalVariable.paymentMethod}\&quot;,\n  \&quot;splitAlcoholicNonAlcoholicProducts\&quot;: \&quot;${splitAlcoholicNonAlcoholicProducts}\&quot;\n}&quot;,
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
      <name>Authorization</name>
      <type>Main</type>
      <value>${GlobalVariable.token}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Cookie</name>
      <type>Main</type>
      <value>${GlobalVariable.cookiesFfc}</value>
   </httpHeaderProperties>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.urlFront}/storefrontapi/hot/cart/order</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'2020-06-24T00:00:00.000Z'</defaultValue>
      <description></description>
      <id>3e73690a-bcba-45e3-92eb-374895592726</id>
      <masked>false</masked>
      <name>preferredDeliveryDate</name>
   </variables>
   <variables>
      <defaultValue>'Test purchase'</defaultValue>
      <description></description>
      <id>716a6703-8f6c-4b77-b05d-a5c90f2f6f77</id>
      <masked>false</masked>
      <name>purchaseOrderNumber</name>
   </variables>
   <variables>
      <defaultValue>'Test automation comment'</defaultValue>
      <description></description>
      <id>6ba9ef8b-78dc-44dd-8e78-94df7a20a64e</id>
      <masked>false</masked>
      <name>comment</name>
   </variables>
   <variables>
      <defaultValue>'Cash Payment'</defaultValue>
      <description></description>
      <id>360fe5ac-71b2-40f3-932e-90b236b21ed6</id>
      <masked>false</masked>
      <name>paymentMethod</name>
   </variables>
   <variables>
      <defaultValue>true</defaultValue>
      <description></description>
      <id>75a69b11-5d1d-4dcf-807e-ac79979d1194</id>
      <masked>false</masked>
      <name>splitAlcoholicNonAlcoholicProducts</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

JsonSlurper responseParser = new JsonSlurper()
HashMap&lt;String, String> responeMap = responseParser.parseText(response.getResponseBodyContent())
String isSuccesss = responeMap.get(&quot;succeeded&quot;)


if (isSuccesss.equals(&quot;true&quot;)){ 	
	String number = responeMap.get(&quot;order&quot;).get(&quot;number&quot;)
	KeywordUtil.logInfo(&quot;New order with number: &quot; + number +&quot; was created&quot;
		+ &quot;. Response status: &quot; + response.statusCode
		+ &quot;, Response body: &quot; + response.responseBodyContent)
} else {
	KeywordUtil.logInfo(&quot;Error: Can't create a new order&quot;
		+ &quot;. Response status: &quot; + response.statusCode
		+ &quot;, Response body: &quot; + response.responseBodyContent)
}
WS.verifyMatch(isSuccesss, &quot;true&quot;, false)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

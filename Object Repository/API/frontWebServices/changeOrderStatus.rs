<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Changing status via integration</description>
   <name>changeOrderStatus</name>
   <tag></tag>
   <elementGuidId>d5cd638f-9c97-4fe1-b712-672611fa8e6e</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;  {\n    \&quot;outerId\&quot;: \&quot;${outerId}\&quot;,\n    \&quot;outerStatus\&quot;: \&quot;${orderStatus}\&quot;,\n    \&quot;outerModifiedDate\&quot;: \&quot;${outerModifiedDate}\&quot;\n  }&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/hot/integration/orders/${GlobalVariable.orderId}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'0123'</defaultValue>
      <description></description>
      <id>9e271989-68de-463e-a1cd-a45e85c57013</id>
      <masked>false</masked>
      <name>outerId</name>
   </variables>
   <variables>
      <defaultValue>'Cancelled'</defaultValue>
      <description></description>
      <id>a9ce74bc-7b40-45dd-869a-114cd1375115</id>
      <masked>false</masked>
      <name>orderStatus</name>
   </variables>
   <variables>
      <defaultValue>'2020-07-06T12:22:38.057Z'</defaultValue>
      <description></description>
      <id>ad3c3a92-a720-432b-ab3e-cce11d5173bb</id>
      <masked>false</masked>
      <name>outerModifiedDate</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import com.kms.katalon.core.util.KeywordUtil

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
if (response.statusCode == 200){
	KeywordUtil.logInfo(&quot;Order status changed with integration API&quot;
		+ &quot;. Response status: &quot; + response.statusCode
		+ &quot;, Response body: &quot; + response.responseBodyContent)
}
else{
	KeywordUtil.logInfo(&quot;Error: can't change order status with integration API&quot;
		+ &quot;. Response status: &quot; + response.statusCode
		+ &quot;, Response body: &quot; + response.responseBodyContent)
}
	
WS.verifyResponseStatusCode(response, 200)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

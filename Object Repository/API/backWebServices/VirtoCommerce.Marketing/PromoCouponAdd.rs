<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>PromoCouponAdd</name>
   <tag></tag>
   <elementGuidId>d6c21488-1697-4f03-b90a-5f69a3f33506</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[\n\t{\n\t\t\&quot;promotionId\&quot;: \&quot;${promoId}\&quot;,\n\t\t\&quot;isNew\&quot;: true,\n\t\t\&quot;code\&quot;: \&quot;${couponName}\&quot;,\n\t\t\&quot;maxUsesNumber\&quot;: \&quot;${maxUsesNumber}\&quot;,\n\t\t\&quot;maxUsesPerUser\&quot;: \&quot;${maxUsesPerUser}\&quot;,\n\t\t\n\t}\n]&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/marketing/promotions/coupons/add</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'AutoTestId'</defaultValue>
      <description>id of the promo to add coupon to</description>
      <id>ef12b70f-ec80-4618-9ee2-0fafe76b8497</id>
      <masked>false</masked>
      <name>promoId</name>
   </variables>
   <variables>
      <defaultValue>'true'</defaultValue>
      <description>create new or update the existing promo</description>
      <id>763fe0ac-cd6d-437c-b3d1-444fc03d9df3</id>
      <masked>false</masked>
      <name>isNew</name>
   </variables>
   <variables>
      <defaultValue>'qweCoupon'</defaultValue>
      <description>)</description>
      <id>94499db4-0eea-426d-a881-9523e1c832c8</id>
      <masked>false</masked>
      <name>couponName</name>
   </variables>
   <variables>
      <defaultValue>'3'</defaultValue>
      <description>max uses number value</description>
      <id>34e8bc1e-feba-4111-b6ce-d1a298368e20</id>
      <masked>false</masked>
      <name>maxUsesNumber</name>
   </variables>
   <variables>
      <defaultValue>'2'</defaultValue>
      <description>max uses per user value</description>
      <id>038d02cb-6eb4-45ee-a4a9-7c140429bb42</id>
      <masked>false</masked>
      <name>maxUsesPerUser</name>
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
WS.verifyResponseStatusCode(response, 204)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

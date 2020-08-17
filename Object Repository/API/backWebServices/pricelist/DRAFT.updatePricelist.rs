<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>DRAFT.updatePricelist</name>
   <tag></tag>
   <elementGuidId>7f634854-3dd5-4ef4-9d2b-74a0613650fa</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  //\&quot;name\&quot;: \&quot;QwePricelist\&quot;,\n  \&quot;prices\&quot;: [\n    {\n      \&quot;pricelistId\&quot;: \&quot;9a978b1e-ab9f-4522-9b1b-8249725ba6f7\&quot;,\n      \&quot;productId\&quot;: \&quot;3f5dfb4e-eae7-43ae-a0e2-7750e884953b\&quot;,\n      \&quot;sale\&quot;: 555,\n      \&quot;list\&quot;: 999,\n      \&quot;startDate\&quot;: \&quot;2020-08-10T09:59:39.979Z\&quot;\n    }\n  ]\n}&quot;,
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
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>PUT</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/pricing/pricelists</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
KeywordUtil.logInfo(response.responseBodyContent)
WS.verifyResponseStatusCode(response, 200)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

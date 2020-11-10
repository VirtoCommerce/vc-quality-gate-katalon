<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>OrganizationsGetId</name>
   <tag></tag>
   <elementGuidId>b7f9b1f9-3aae-4c86-90c2-c88924702027</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;isActive\&quot;: true,\n  \&quot;outerId\&quot;: \&quot;12345\&quot;,\n  \&quot;storeId\&quot;: \&quot;${GlobalVariable.distributorId}\&quot;,\n  \&quot;name\&quot;: \&quot;ZXC Outlet\&quot;,\n  \&quot;id\&quot;:\&quot;402ebe1a-d50a-464b-91a5-c9b2ec90eeb2\&quot;,\n  \&quot;memberType\&quot;: \&quot;HotOutlet\&quot;,\n  \&quot;parentId\&quot;: \&quot;${GlobalVariable.organizationId}\&quot;,\n  \&quot;address\&quot;: {\n    \t\&quot;addressType\&quot;: \&quot;Billing\&quot;,\n\t    \&quot;firstName\&quot;: \&quot;JohnFirst\&quot;,\n\t\t\&quot;lastName\&quot;: \&quot;DoeLast\&quot;,\n        \&quot;name\&quot;: \&quot;Qwest\&quot;,\n        \&quot;line1\&quot;: \&quot;Test adress line 1\&quot;,\n        \&quot;line2\&quot;: \&quot;Test adress line 2\&quot;,\n        \&quot;postalCode\&quot;: \&quot;X34656703\&quot;,\n        \&quot;city\&quot;: \&quot;Test city\&quot;,\n        \&quot;region\&quot;: \&quot;test region\&quot;,\n        \&quot;countryName\&quot;: \&quot;United States\&quot;,\n        \&quot;countryCode\&quot;: \&quot;USA\&quot;\n    },\n    \&quot;groups\&quot;: [\n        \&quot;TEST UG1\&quot;,\n        \&quot;TEST UG2\&quot;\n    ],\n    \&quot;salesRepresentative\&quot;: {\n        \&quot;firstName\&quot;: \&quot;Far\&quot;,\n        \&quot;lastName\&quot;: \&quot;Dar\&quot;,\n        \&quot;phone\&quot;: \&quot;12313246789\&quot;,\n        \&quot;email\&quot;: \&quot;testemail345@test.com\&quot;\n    }\n}&quot;,
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
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/organizations/${orgId}</restUrl>
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
      <description></description>
      <id>ac3046d1-8d54-4ebc-86da-90ab8074c724</id>
      <masked>false</masked>
      <name>orgaId</name>
   </variables>
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

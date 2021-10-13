<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>OrganizationsCreateBulk</name>
   <tag></tag>
   <elementGuidId>5962674f-9e63-41b3-a50c-2d05cd06e293</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[\n  {\n    \&quot;name\&quot;: \&quot;${name1}\&quot;,\n    \&quot;description\&quot;: \&quot;New Org\&quot;,\n    \&quot;groups\&quot;: [\n      \&quot;TEST UG1\&quot;\n    ],\n    \&quot;phones\&quot;: [\n      \&quot;0000000\&quot;\n    ],\n    \&quot;emails\&quot;: [\n      \&quot;test1@test.com\&quot;\n    ]\n  },\n  {\n    \&quot;name\&quot;: \&quot;${name2}\&quot;,\n    \&quot;groups\&quot;: [\n      \&quot;TEST UG2\&quot;\n    ],\n    \&quot;phones\&quot;: [\n      \&quot;111111\&quot;\n    ]\n  }\n]&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/organizations/bulk</restUrl>
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
      <description>created organization name</description>
      <id>9498493e-20b4-42e2-9993-c9e8e5e03509</id>
      <masked>false</masked>
      <name>name1</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description>created organization name</description>
      <id>03c1d17f-0014-4f74-9cb1-d281cd516c6e</id>
      <masked>false</masked>
      <name>name2</name>
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
WS.verifyResponseStatusCode(response, 204)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

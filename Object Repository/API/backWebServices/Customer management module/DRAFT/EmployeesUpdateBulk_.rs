<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>EmployeesUpdateBulk_</name>
   <tag></tag>
   <elementGuidId>9ff8937a-9ff0-44e6-bb76-50b2aa1459c0</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[\n{\n  \&quot;fullName\&quot;: \&quot;Qwe JohnUpd\&quot;,\n  \&quot;firstName\&quot;: \&quot;${GlobalVariable.firstName}\&quot;,\n  \&quot;lastName\&quot;: \&quot;${GlobalVariable.lastName}\&quot;,  \n  \&quot;memberType\&quot;: \&quot;Employee\&quot;,\n  \&quot;id\&quot;: \&quot;${id}\&quot;,\n  \&quot;addresses\&quot;: [\n    {\n        \&quot;addressType\&quot;: \&quot;Billing\&quot;,\n\t    \&quot;firstName\&quot;: \&quot;JohnFirst\&quot;,\n\t\t\&quot;lastName\&quot;: \&quot;DoeLast\&quot;,\n        \&quot;name\&quot;: \&quot;Qwest\&quot;,\n        \&quot;line1\&quot;: \&quot;Updated adress line 1\&quot;,\n        \&quot;line2\&quot;: \&quot;Updated adress line 2\&quot;,\n        \&quot;postalCode\&quot;: \&quot;000656703\&quot;,\n        \&quot;city\&quot;: \&quot;Updated city\&quot;,\n        \&quot;region\&quot;: \&quot;Updated region\&quot;,\n        \&quot;countryName\&quot;: \&quot;United States\&quot;,\n        \&quot;countryCode\&quot;: \&quot;USA\&quot;\n    }\n  ],\n  \&quot;phones\&quot;: [\n    \&quot;00132456987\&quot;\n  ],\n  \&quot;emails\&quot;: [\n    \&quot;emp1@qwe.com\&quot;\n  ],\n    \&quot;groups\&quot;: [\n        \&quot;TEST UG1\&quot;,\n        \&quot;TEST UG2\&quot;\n    ]\n}\n]&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/employees/bulk</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'f493e39d-370e-45a7-88d6-273cb9843898'</defaultValue>
      <description></description>
      <id>ac6127bc-d83e-4eb2-b550-e18756cd943b</id>
      <masked>false</masked>
      <name>id</name>
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

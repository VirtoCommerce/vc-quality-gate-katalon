<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>GetEnvironmentInfo</name>
   <tag></tag>
   <elementGuidId>d3804d3a-c883-4956-a54f-68f8f517b5e2</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
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
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${GlobalVariable.urlFront}/storefrontapi/hot/debug/environment-info</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
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
WS.verifyResponseStatusCode(response, 200)
KeywordUtil.logInfo(response.responseBodyContent)
      </verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

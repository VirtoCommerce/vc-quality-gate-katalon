<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ResetCache</name>
   <tag></tag>
   <elementGuidId>6743c697-a7bb-4363-aa3f-ff4400307119</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;&quot;,
  &quot;contentType&quot;: &quot;text/plain&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
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
   <restUrl>${GlobalVariable.urlFront}/storefrontapi/hot/debug/reset-cache</restUrl>
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
   
ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
   if (response.statusCode == 200){
	   KeywordUtil.logInfo(&quot;Cache dropped&quot;
		   + &quot; Response status: &quot; + response.statusCode)
   }
   else {
	   KeywordUtil.logInfo(&quot;Error: Problem with dropping cache&quot;
		   + &quot; Response status: &quot; + response.statusCode
		   + &quot;, Response body: &quot; + response.responseBodyContent)
   }
WS.verifyResponseStatusCode(response, 200)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

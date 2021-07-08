<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ContentStatsStoreGet</name>
   <tag></tag>
   <elementGuidId>a077b638-49b1-4f9a-9e7d-8510b455c4c1</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/content/${storeId}/stats</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'1'</defaultValue>
      <description></description>
      <id>db587bef-a069-492f-9ac7-ed4234bafd56</id>
      <masked>false</masked>
      <name>themesCount</name>
   </variables>
   <variables>
      <defaultValue>'6'</defaultValue>
      <description></description>
      <id>aa0691e7-7324-42c9-aaed-7aba38523ef4</id>
      <masked>false</masked>
      <name>pagesCount</name>
   </variables>
   <variables>
      <defaultValue>'1'</defaultValue>
      <description></description>
      <id>0419d93b-26f0-452c-bd50-67b28e679b1c</id>
      <masked>false</masked>
      <name>blogsCount</name>
   </variables>
   <variables>
      <defaultValue>'Electronics'</defaultValue>
      <description></description>
      <id>e17b526f-cf70-4790-b4c1-02125946f70a</id>
      <masked>false</masked>
      <name>storeId</name>
   </variables>
   <variables>
      <defaultValue>'themes'</defaultValue>
      <description></description>
      <id>e04eba79-5817-4b48-9489-be93c7daf5ea</id>
      <masked>false</masked>
      <name>contentType</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager
import internal.GlobalVariable as GlobalVariable

import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

//RequestObject request = WSResponseManager.getInstance().getCurrentRequest()
//def variables = request.getVariables()
//def bCount = variables.get(&quot;blogsCount&quot;)
//println(&quot;VARS : &quot; + bCount)

def listJsonOutput = JsonOutput.prettyPrint(response.getResponseBodyContent())
KeywordUtil.logInfo(listJsonOutput)
WS.verifyResponseStatusCode(response, 200)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

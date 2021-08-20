<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>CatalogsUpdate</name>
   <tag></tag>
   <elementGuidId>8316b926-5246-48ee-b98b-09407479edd3</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n   \&quot;name\&quot;:\&quot;${name}\&quot;,\n   \&quot;isVirtual\&quot;:false,\n   \&quot;defaultLanguage\&quot;:{\n      \&quot;isDefault\&quot;:true,\n      \&quot;languageCode\&quot;:\&quot;en-US\&quot;\n   },\n   \&quot;languages\&quot;:[\n      {\n         \&quot;isDefault\&quot;:true,\n         \&quot;languageCode\&quot;:\&quot;en-US\&quot;\n      }\n   ],\n   \&quot;properties\&quot;:[\n     \n   ],\n   \&quot;createdDate\&quot;:\&quot;0001-01-01T00:00:00Z\&quot;,\n   \&quot;id\&quot;:\&quot;${id}\&quot;\n}&quot;,
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
   <restRequestMethod>PUT</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/catalog/catalogs</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'AutoTestCatalog'</defaultValue>
      <description></description>
      <id>2238c78b-7ee9-4d39-b624-b206365c9320</id>
      <masked>false</masked>
      <name>name</name>
   </variables>
   <variables>
      <defaultValue>'6431751a-91fa-4f70-8720-69e2edf5f2db'</defaultValue>
      <description></description>
      <id>0a2768bd-b95c-4fec-8deb-1c70f9b44e94</id>
      <masked>false</masked>
      <name>id</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonOutput
import com.kms.katalon.core.util.KeywordUtil


RequestObject request = WSResponseManager.getInstance().getCurrentRequest()
ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
def prettyJson = JsonOutput.prettyPrint(response.getResponseBodyContent())
KeywordUtil.logInfo(prettyJson)
WS.verifyResponseStatusCode(response, 200)

</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

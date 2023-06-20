<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ContentPublicationsAdd</name>
   <tag></tag>
   <elementGuidId>e50572cd-e3bd-4abc-a2d8-5be5293947aa</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\t\&quot;name\&quot;: \&quot;${publicationName}\&quot;,\n\t\&quot;storeId\&quot;: \&quot;${storeId}\&quot;,\n  \t\&quot;contentItems\&quot;: [\&quot;${contentItems}\&quot;],\n  \t\&quot;contentPlaces\&quot;: [\&quot;${contentPlaces}\&quot;],\n  \t\&quot;description\&quot;: \&quot;${description}\&quot;,\n    \&quot;isActive\&quot;: \&quot;${status}\&quot;\n}&quot;,
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
      <webElementGuid>3f623bf2-97ca-4625-97a0-aed4d13b806e</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>api_key</name>
      <type>Main</type>
      <value>${GlobalVariable.api_key}</value>
      <webElementGuid>24ffafee-d087-49ae-ac00-61caaadf00e8</webElementGuid>
   </httpHeaderProperties>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/marketing/contentpublications</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'qwe'</defaultValue>
      <description>name of the publication to add</description>
      <id>03f7967d-31e9-44aa-8200-4b4153f06a27</id>
      <masked>false</masked>
      <name>publicationName</name>
   </variables>
   <variables>
      <defaultValue>'Electronics'</defaultValue>
      <description></description>
      <id>1d4c00f1-ab6f-479e-8538-8dff188d1043</id>
      <masked>false</masked>
      <name>storeId</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description>added related contentItems</description>
      <id>1277929e-526e-4fa2-bfc3-f717114290fd</id>
      <masked>false</masked>
      <name>contentItems</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description>added related contentPlaces</description>
      <id>2973550f-54fa-4ae6-82d5-52c1e254b1ff</id>
      <masked>false</masked>
      <name>contentPlaces</name>
   </variables>
   <variables>
      <defaultValue>'qwe'</defaultValue>
      <description></description>
      <id>5ad3a9d5-fc5a-4b98-bfe9-7e17436c45d5</id>
      <masked>false</masked>
      <name>description</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>fa37f5d4-96a0-4e47-992e-ec52c9f36b3d</id>
      <masked>false</masked>
      <name>status</name>
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
WS.verifyResponseStatusCode(response, 200)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

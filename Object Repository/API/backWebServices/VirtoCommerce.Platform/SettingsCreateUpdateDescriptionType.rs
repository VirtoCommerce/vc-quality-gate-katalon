<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>SettingsCreateUpdateDescriptionType</name>
   <tag></tag>
   <elementGuidId>57dc81db-b947-423c-92e1-bfb6d22af10c</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;${body}&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/platform/settings</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'[{&quot;itHasValues&quot;:true,&quot;restartRequired&quot;:false,&quot;moduleId&quot;:&quot;VirtoCommerce.Catalog&quot;,&quot;groupName&quot;:&quot;Catalog|General&quot;,&quot;name&quot;:&quot;Catalog.EditorialReviewTypes&quot;,&quot;isHidden&quot;:false,&quot;valueType&quot;:&quot;ShortText&quot;,&quot;allowedValues&quot;:[&quot;FullReview&quot;,&quot;TEST&quot;],&quot;defaultValue&quot;:&quot;QuickReview&quot;,&quot;isDictionary&quot;:true}]'</defaultValue>
      <description></description>
      <id>61c8f0db-72b4-48f6-860d-7e8b75af2480</id>
      <masked>false</masked>
      <name>body</name>
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
WS.verifyResponseStatusCode(response, 204)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

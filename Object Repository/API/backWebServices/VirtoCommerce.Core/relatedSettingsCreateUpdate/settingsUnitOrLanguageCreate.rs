<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>settingsUnitOrLanguageCreate</name>
   <tag></tag>
   <elementGuidId>cbe737be-ce29-4ad1-bc78-8b4df4e842e0</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[ \n  //NOTE: script view is used for the actual settings update\n  //this JSON purpose is to illustrate the scheme\n  {\n    \&quot;itHasValues\&quot;: true,\n    \&quot;restartRequired\&quot;: false,\n    \&quot;moduleId\&quot;: \&quot;VirtoCommerce.Core\&quot;,\n    \&quot;groupName\&quot;: \&quot;Core|General\&quot;,\n    \&quot;name\&quot;: \&quot;VirtoCommerce.Core.General.WeightUnits\&quot;,\n    \&quot;isHidden\&quot;: false,\n    \&quot;valueType\&quot;: \&quot;ShortText\&quot;,\n    \&quot;allowedValues\&quot;: [\n      \&quot;pound\&quot;,\n      \&quot;ounce\&quot;,\n      \&quot;gram\&quot;,\n      \&quot;${unitName}\&quot;\n    ],\n    \&quot;defaultValue\&quot;: \&quot;gram\&quot;,\n    \&quot;isDictionary\&quot;: true\n  }\n]&quot;,
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
      <defaultValue>'qweUnit'</defaultValue>
      <description>name of the unit to add</description>
      <id>2afe6acb-8780-4ab4-bddc-100b8d2387bd</id>
      <masked>false</masked>
      <name>unitName</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonOutput
import com.kms.katalon.core.util.KeywordUtil


ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
def prettyJson = JsonOutput.prettyPrint(response.getResponseBodyContent())
KeywordUtil.logInfo(prettyJson)
WS.verifyResponseStatusCode(response, 204)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

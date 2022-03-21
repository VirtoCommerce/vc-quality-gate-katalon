<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>reverts tags values to the initial state</description>
   <name>settingsPropagationChange</name>
   <tag></tag>
   <elementGuidId>b101fd05-1c6b-483e-9ca2-e346b7e9f1a9</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[\n\t{\n\t\t\&quot;itHasValues\&quot;: true,\n\t\t\&quot;value\&quot;: \&quot;${value}\&quot;,\n\t\t\&quot;restartRequired\&quot;: false,\n\t\t\&quot;moduleId\&quot;: \&quot;VirtoCommerce.CatalogPersonalization\&quot;,\n\t\t\&quot;groupName\&quot;: \&quot;General\&quot;,\n\t\t\&quot;name\&quot;: \&quot;CatalogPersonalization.TagsInheritancePolicy\&quot;,\n\t\t\&quot;isHidden\&quot;: false,\n\t\t\&quot;valueType\&quot;: \&quot;ShortText\&quot;,\n\t\t\&quot;allowedValues\&quot;: [\n\t\t\t{\n\t\t\t\t\&quot;value\&quot;: \&quot;DownTree\&quot;\n\t\t\t},\n\t\t\t{\n\t\t\t\t\&quot;value\&quot;: \&quot;UpTree\&quot;\n\t\t\t}\n\t\t],\n\t\t\&quot;defaultValue\&quot;: \&quot;DownTree\&quot;,\n\t\t\&quot;isDictionary\&quot;: false,\n\t\t\&quot;translatedName\&quot;: \&quot;Selected policy for tags propagation\&quot;,\n\t\t\&quot;values\&quot;: [\n\t\t\t{\n\t\t\t\t\&quot;value\&quot;: \&quot;${value}\&quot;\n\t\t\t}\n\t\t]\n\t},\n\t{\n\t\t\&quot;itHasValues\&quot;: true,\n\t\t\&quot;value\&quot;: \&quot;0/15 * * * *\&quot;,\n\t\t\&quot;restartRequired\&quot;: false,\n\t\t\&quot;moduleId\&quot;: \&quot;VirtoCommerce.CatalogPersonalization\&quot;,\n\t\t\&quot;groupName\&quot;: \&quot;General\&quot;,\n\t\t\&quot;name\&quot;: \&quot;CatalogPersonalization.CronExpression\&quot;,\n\t\t\&quot;isHidden\&quot;: false,\n\t\t\&quot;valueType\&quot;: \&quot;ShortText\&quot;,\n\t\t\&quot;defaultValue\&quot;: \&quot;0/15 * * * *\&quot;,\n\t\t\&quot;isDictionary\&quot;: false,\n\t\t\&quot;translatedName\&quot;: \&quot;Job cron expression for synchronize the outlines of tagged entities. Valid only when the UpTree propagation policy is selected.\&quot;,\n\t\t\&quot;values\&quot;: [\n\t\t\t{\n\t\t\t\t\&quot;id\&quot;: \&quot;0/15 * * * *\&quot;,\n\t\t\t\t\&quot;value\&quot;: \&quot;0/15 * * * *\&quot;\n\t\t\t}\n\t\t]\n\t}\n]&quot;,
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
      <defaultValue>'UpTree'</defaultValue>
      <description>tag to add to the dictionary</description>
      <id>4bb74c52-c3b4-433c-bab9-b4459004a280</id>
      <masked>false</masked>
      <name>value</name>
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

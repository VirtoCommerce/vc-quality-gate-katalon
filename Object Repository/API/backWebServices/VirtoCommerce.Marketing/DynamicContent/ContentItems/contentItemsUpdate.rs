<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>contentItemsUpdate</name>
   <tag></tag>
   <elementGuidId>5202e4cf-860d-4378-9b06-29469119a7ca</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\t\&quot;contentType\&quot;: \&quot;Html\&quot;,\n\t\&quot;outline\&quot;: \&quot;ContentItem\&quot;,\n\t\&quot;path\&quot;: \&quot;ContentItem\&quot;,\n\t\&quot;folderId\&quot;: \&quot;ContentItem\&quot;,\n\t\&quot;folder\&quot;: {\n\t\t\&quot;path\&quot;: \&quot;ContentItem\&quot;,\n\t\t\&quot;outline\&quot;: \&quot;ContentItem\&quot;,\n\t\t\&quot;objectType\&quot;: \&quot;DynamicContentFolder\&quot;,\n\t\t\&quot;name\&quot;: \&quot;ContentItem\&quot;,\n\t\t\&quot;createdDate\&quot;: \&quot;2022-02-07T19:40:22.5482536Z\&quot;,\n\t\t\&quot;modifiedDate\&quot;: \&quot;2022-02-07T19:40:22.5482536Z\&quot;,\n\t\t\&quot;createdBy\&quot;: \&quot;unknown\&quot;,\n\t\t\&quot;modifiedBy\&quot;: \&quot;unknown\&quot;,\n\t\t\&quot;id\&quot;: \&quot;ContentItem\&quot;\n\t},\n\t\&quot;objectType\&quot;: \&quot;VirtoCommerce.MarketingModule.Core.Model.DynamicContentItem\&quot;,\n\t\&quot;dynamicProperties\&quot;: [],\n\t\&quot;name\&quot;: \&quot;${itemName}\&quot;,\n\t\&quot;description\&quot;: \&quot;${description}\&quot;,\n\t\&quot;id\&quot;: \&quot;${contentItemId}\&quot;\n}&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/marketing/contentitems</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'qweUPD'</defaultValue>
      <description>updated item name</description>
      <id>714822ad-20df-436e-8e22-2aa0209e82bb</id>
      <masked>false</masked>
      <name>itemName</name>
   </variables>
   <variables>
      <defaultValue>'308b2f92-4dda-4c5b-bfc9-9291c5914f44'</defaultValue>
      <description>id of an item to update</description>
      <id>273ac79b-a324-4434-bf67-b1c17dd7d4ff</id>
      <masked>false</masked>
      <name>contentItemId</name>
   </variables>
   <variables>
      <defaultValue>'qwe desc'</defaultValue>
      <description>updated item description</description>
      <id>911ad6c4-2bd3-4311-9828-04989b278ab8</id>
      <masked>false</masked>
      <name>description</name>
   </variables>
   <variables>
      <defaultValue>'{}'</defaultValue>
      <description></description>
      <id>ce42149c-fbd4-43d1-85f4-0c2d1d55eff5</id>
      <masked>false</masked>
      <name>dynamicProperties</name>
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
WS.verifyResponseStatusCode(response, 204)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>StoreCreate</name>
   <tag></tag>
   <elementGuidId>bb66e6be-60d6-4618-87f0-41b91b0baa81</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;id\&quot;:\&quot;${storeId}\&quot;,\n  \&quot;name\&quot;:\&quot;${name}\&quot;,\n  \&quot;catalog\&quot;:\&quot;${catalogId}\&quot;,\n  \&quot;defaultLanguage\&quot;:\&quot;${defaultLanguage}\&quot;,\n  \&quot;defaultCurrency\&quot;:\&quot;${defaultCurrency}\&quot;,\n  \&quot;storeState\&quot;:\&quot;${storeState}\&quot;,\n  \&quot;languages\&quot;:[\&quot;${languages}\&quot;],\n  \&quot;currencies\&quot;:[\&quot;${currencies}\&quot;]\n}&quot;,
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
   <katalonVersion>8.0.5</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/stores</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'qwestore'</defaultValue>
      <description></description>
      <id>c6a3191c-58e0-4223-a17e-caa47b4f9949</id>
      <masked>false</masked>
      <name>storeId</name>
   </variables>
   <variables>
      <defaultValue>'qwestore'</defaultValue>
      <description></description>
      <id>2fdaedf6-0dd1-4378-890a-aac94febb695</id>
      <masked>false</masked>
      <name>name</name>
   </variables>
   <variables>
      <defaultValue>'4974648a41df4e6ea67ef2ad76d7bbd4'</defaultValue>
      <description></description>
      <id>49d6278e-eca8-4e89-b193-3ed572263759</id>
      <masked>false</masked>
      <name>catalogId</name>
   </variables>
   <variables>
      <defaultValue>'en-US'</defaultValue>
      <description></description>
      <id>e36ea218-4ffb-4389-8ca8-2d60b4c3b619</id>
      <masked>false</masked>
      <name>defaultLanguage</name>
   </variables>
   <variables>
      <defaultValue>'USD'</defaultValue>
      <description></description>
      <id>cfc93afa-fbbf-4c11-afd3-6bd7502de817</id>
      <masked>false</masked>
      <name>defaultCurrency</name>
   </variables>
   <variables>
      <defaultValue>'Open'</defaultValue>
      <description></description>
      <id>6d84ca50-ec89-4587-8e36-0b10939042e7</id>
      <masked>false</masked>
      <name>storeState</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>d9ec862a-e079-4da4-8dc1-ba2690251e97</id>
      <masked>false</masked>
      <name>languages</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>fdd6107b-d1ff-48df-8d4b-5945aeaab8ec</id>
      <masked>false</masked>
      <name>currencies</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil


ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

def listJsonOutput = JsonOutput.prettyPrint(response.getResponseBodyContent())
KeywordUtil.logInfo(listJsonOutput)
WS.verifyResponseStatusCode(response, 200)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

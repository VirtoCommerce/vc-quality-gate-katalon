<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>StoreUpdate</name>
   <tag></tag>
   <elementGuidId>1cbc83bd-3074-4d4f-b41c-a17336cafe66</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;id\&quot;:\&quot;${storeId}\&quot;,\n  \&quot;name\&quot;:\&quot;${name}\&quot;,\n  \&quot;catalog\&quot;:\&quot;${catalogId}\&quot;,\n  \&quot;defaultLanguage\&quot;:\&quot;${defaultLanguage}\&quot;,\n  \&quot;defaultCurrency\&quot;:\&quot;${defaultCurrency}\&quot;,\n  \&quot;storeState\&quot;:\&quot;${storeState}\&quot;,\n  \&quot;languages\&quot;:[\&quot;${languages}\&quot;],\n  \&quot;currencies\&quot;:[\&quot;${currencies}\&quot;],\n  \&quot;url\&quot;: \&quot;${storeUrl}\&quot;\n}&quot;,
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
   <restRequestMethod>PUT</restRequestMethod>
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
      <defaultValue>'Updated'</defaultValue>
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
      <id>fcae1cac-992b-4cbb-b627-ee5b77d12fb8</id>
      <masked>false</masked>
      <name>defaultLanguage</name>
   </variables>
   <variables>
      <defaultValue>'USD'</defaultValue>
      <description></description>
      <id>0ac0618e-5ce8-4a22-bb48-11584269111a</id>
      <masked>false</masked>
      <name>defaultCurrency</name>
   </variables>
   <variables>
      <defaultValue>'Open'</defaultValue>
      <description></description>
      <id>c92f1141-9194-4598-b8f9-18ae4ea2a132</id>
      <masked>false</masked>
      <name>storeState</name>
   </variables>
   <variables>
      <defaultValue>'en-US'</defaultValue>
      <description></description>
      <id>d9ec862a-e079-4da4-8dc1-ba2690251e97</id>
      <masked>false</masked>
      <name>languages</name>
   </variables>
   <variables>
      <defaultValue>'USD'</defaultValue>
      <description></description>
      <id>fdd6107b-d1ff-48df-8d4b-5945aeaab8ec</id>
      <masked>false</masked>
      <name>currencies</name>
   </variables>
   <variables>
      <defaultValue>'321'</defaultValue>
      <description></description>
      <id>63b2003f-40d9-4675-91d2-944f534d065c</id>
      <masked>false</masked>
      <name>storeUrl</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import com.kms.katalon.core.util.KeywordUtil

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
KeywordUtil.logInfo(response.responseBodyContent)
WS.verifyResponseStatusCode(response, 204)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

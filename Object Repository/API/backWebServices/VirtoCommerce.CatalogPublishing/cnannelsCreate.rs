<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>cnannelsCreate</name>
   <tag></tag>
   <elementGuidId>7978566f-b3fc-4bba-9082-484b0b10c4de</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\t\&quot;name\&quot;: \&quot;${channelName}\&quot;,\n\t\&quot;languages\&quot;: [\n\t\t\&quot;en-US\&quot;\n\t],\n\t\&quot;currencies\&quot;: [\n\t\t\&quot;USD\&quot;\n\t],\n\t\&quot;catalogId\&quot;: \&quot;${catalogId}\&quot;,\n\t\&quot;evaluatorType\&quot;: \&quot;DefaultCompletenessEvaluator\&quot;,\n\t\&quot;catalogName\&quot;: \&quot;${catalogName}\&quot;\n}&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/completeness/channels</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'qweChan2'</defaultValue>
      <description>name of the created channel</description>
      <id>618d77a7-2540-43bb-8d74-2c99fccd0a07</id>
      <masked>false</masked>
      <name>channelName</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description>name of the related catalog</description>
      <id>d886d283-6fb5-4098-b94d-3baa434658b7</id>
      <masked>false</masked>
      <name>catalogName</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description>id of the related catalog</description>
      <id>a8e7d165-b79a-4460-9c22-8642e2bde5ee</id>
      <masked>false</masked>
      <name>catalogId</name>
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
WS.verifyResponseStatusCode(response, 200)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

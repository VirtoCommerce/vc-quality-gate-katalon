<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>PricelistAssignmentsUpdate</name>
   <tag></tag>
   <elementGuidId>66d8a7c0-631f-4642-9e47-62bb85f0c28f</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\t\&quot;catalogId\&quot;: \&quot;${catalogId}\&quot;,\n\t\&quot;pricelistId\&quot;: \&quot;${pricelistId}\&quot;,\n\t\&quot;pricelist\&quot;: {\n\t\t\&quot;name\&quot;: \&quot;${pricelistName}\&quot;,\n\t\t\&quot;description\&quot;: \&quot;Pricelist created by Katalon test\&quot;,\n\t\t\&quot;currency\&quot;: \&quot;USD\&quot;,\n\t\t\&quot;createdDate\&quot;: \&quot;0001-01-01T00:00:00Z\&quot;,\n\t\t\&quot;id\&quot;: \&quot;${pricelistId}\&quot;\n\t},\n\t\&quot;name\&quot;: \&quot;${assignmentName}\&quot;,\n\t\&quot;priority\&quot;: 0,\n\t\&quot;dynamicExpression\&quot;: {\n\t\t\&quot;all\&quot;: true,\n\t\t\&quot;not\&quot;: false,\n\t\t\&quot;id\&quot;: \&quot;PriceConditionTree\&quot;,\n\t\t\&quot;children\&quot;: [\n\t\t\t{\n\t\t\t\t\&quot;all\&quot;: false,\n\t\t\t\t\&quot;not\&quot;: false,\n\t\t\t\t\&quot;id\&quot;: \&quot;BlockPricingCondition\&quot;,\n\t\t\t\t\&quot;children\&quot;: [\n\t\t\t\t\t{\n\t\t\t\t\t\t\&quot;matchCondition\&quot;: \&quot;Contains\&quot;,\n\t\t\t\t\t\t\&quot;id\&quot;: \&quot;ConditionStoreSearchedPhrase\&quot;,\n\t\t\t\t\t\t\&quot;children\&quot;: [],\n\t\t\t\t\t\t\&quot;value\&quot;: \&quot;${condition}\&quot;\n\t\t\t\t\t}\n\t\t\t\t]\n\t\t\t}\n\t\t]\n\t},\n\t\&quot;createdDate\&quot;: \&quot;2021-11-17T11:02:30.4569008Z\&quot;,\n\t\&quot;modifiedDate\&quot;: \&quot;2021-11-17T11:02:30.4569008Z\&quot;,\n\t\&quot;createdBy\&quot;: \&quot;admin\&quot;,\n\t\&quot;modifiedBy\&quot;: \&quot;admin\&quot;,\n\t\&quot;id\&quot;: \&quot;${assignmentId}\&quot;\n}&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/pricing/assignments</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>''</defaultValue>
      <description>catalog id used in the assignment</description>
      <id>212559c7-f595-4f11-bf99-d46d8b63b640</id>
      <masked>false</masked>
      <name>catalogId</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description>assigned pricelist id</description>
      <id>6665f5cd-9197-4505-8270-318741e3f14a</id>
      <masked>false</masked>
      <name>pricelistId</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description>assigned pricelist name</description>
      <id>80f38f0c-faf3-449d-ad01-06c6f3a82686</id>
      <masked>false</masked>
      <name>pricelistName</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description>name of the updated assignment</description>
      <id>94063534-006f-448c-b858-150b4309fbcb</id>
      <masked>false</masked>
      <name>assignmentName</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description>id of the updated assignment</description>
      <id>7f9ceed0-4b9a-44ae-99d1-357fdfaf2fb6</id>
      <masked>false</masked>
      <name>assignmentId</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description>conditional phrase for eligible shoppers section</description>
      <id>7c102634-4b69-4638-a2c6-5afb1e5dede0</id>
      <masked>false</masked>
      <name>condition</name>
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

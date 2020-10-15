<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>MemberSearch</name>
   <tag></tag>
   <elementGuidId>14c00c3b-b9c0-432b-8ba6-f7e0b0353adb</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;responseGroup\&quot;: \&quot;None\&quot;,\n  //\&quot;memberId\&quot;: \&quot;${memberId}\&quot;,\n  //\&quot;searchPhrase\&quot;: \&quot;Bulk\&quot;,\n  \&quot;searchPhrase\&quot;: \&quot;${GlobalVariable.firstName}\&quot;,\n  \&quot;deepSearch\&quot;: true,\n  \&quot;sort\&quot;: \&quot;memberType:asc;name:asc\&quot;,\n  \&quot;skip\&quot;: 0,\n  \&quot;take\&quot;: 20\n}&quot;,
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
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/members/search</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'d35854a1-114d-4b42-8017-524985237773'</defaultValue>
      <description></description>
      <id>72dbce37-d3d2-4134-a142-f5dd7be43f8c</id>
      <masked>false</masked>
      <name>memberId</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import com.kms.katalon.core.util.KeywordUtil

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()
ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

def variables = request.getVariables()
def variable = variables.get('memberId')

KeywordUtil.logInfo(response.responseBodyContent)
WS.verifyResponseStatusCode(response, 200)

</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

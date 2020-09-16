<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ContentFolderCreate</name>
   <tag></tag>
   <elementGuidId>b0ec81a5-32d9-411d-a2e4-8adfac2b49bb</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;name\&quot;: \&quot;qwefolder1\&quot;,\n  \&quot;type\&quot;: \&quot;QweType\&quot;\n  //\&quot;url\&quot;: \&quot;string\&quot;,\n  //\&quot;relativeUrl\&quot;: \&quot;string\&quot;,\n  //\&quot;parentUrl\&quot;: \&quot;string\&quot;,\n  //\&quot;modifiedDate\&quot;: \&quot;2020-09-15T19:47:10.460Z\&quot;,\n  //\&quot;createdDate\&quot;: \&quot;2020-09-15T19:47:10.460Z\&quot;\n}&quot;,
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
<<<<<<< HEAD
   <restUrl>${GlobalVariable.urlBack}/api/content/${GlobalVariable.contentType}/${GlobalVariable.storeId}/folder</restUrl>
=======
   <restUrl>${GlobalVariable.urlBack}/api/content/{contentType}/${GlobalVariable.storeId}/folder</restUrl>
>>>>>>> origin/dev
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import com.kms.katalon.core.util.KeywordUtil

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
KeywordUtil.logInfo(response.responseBodyContent)
WS.verifyResponseStatusCode(response, 200)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

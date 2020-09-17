<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>MenuLinkUpdate</name>
   <tag></tag>
   <elementGuidId>5b0d8e7d-dda1-46c3-a5e7-c1f0103f5f1e</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[\n  {\n    \&quot;name\&quot;:\&quot;footer\&quot;,\n    \&quot;storeId\&quot;:\&quot;Electronics\&quot;,\n    \&quot;language\&quot;:\&quot;fr-FR\&quot;,\n    \&quot;menuLinks\&quot;:[\n      {\n        \&quot;title\&quot;:\&quot;À propos de nous\&quot;,\n        \&quot;url\&quot;:\&quot;~/pages/about_us\&quot;,\n        \&quot;priority\&quot;:10,\n        \&quot;menuLinkListId\&quot;:\&quot;375fb2474fa745daa8174139f537014c\&quot;,\n        \&quot;createdDate\&quot;:\&quot;0001-01-01T00:00:00Z\&quot;,\n        \&quot;id\&quot;:\&quot;8874a5a4a6bb47ac9256d750e868307b\&quot;\n      },\n      {\n        \&quot;title\&quot;:\&quot;termes et conditions\&quot;,\n        \&quot;url\&quot;:\&quot;#\&quot;,\n        \&quot;priority\&quot;:0,\n        \&quot;menuLinkListId\&quot;:\&quot;375fb2474fa745daa8174139f537014c\&quot;,\n        \&quot;createdDate\&quot;:\&quot;0001-01-01T00:00:00Z\&quot;,\n        \&quot;id\&quot;:\&quot;9baae3f3cfd343d3b6e6b6a25720c7ee\&quot;\n      }],\n    \&quot;createdDate\&quot;:\&quot;0001-01-01T00:00:00Z\&quot;,\n    \&quot;id\&quot;:\&quot;375fb2474fa745daa8174139f537014c\&quot;\n  }\n]\n&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/cms/${GlobalVariable.storeId}/menu</restUrl>
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

<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Creates links for categories or items to parent categories and catalogs.</description>
   <name>ListentryLinksCreate</name>
   <tag></tag>
   <elementGuidId>fff29298-c500-4fa8-98a9-7107b3e48203</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[\n  {\n    \&quot;listEntryId\&quot;: \&quot;string\&quot;,\n    \&quot;listEntryType\&quot;: \&quot;string\&quot;,\n    \&quot;priority\&quot;: 0,\n    \&quot;catalogId\&quot;: \&quot;string\&quot;,\n    \&quot;categoryId\&quot;: \&quot;string\&quot;,\n    \&quot;category\&quot;: {\n      \&quot;catalogId\&quot;: \&quot;string\&quot;,\n      \&quot;parentId\&quot;: \&quot;string\&quot;,\n      \&quot;code\&quot;: \&quot;string\&quot;,\n      \&quot;name\&quot;: \&quot;string\&quot;,\n      \&quot;path\&quot;: \&quot;string\&quot;,\n      \&quot;isVirtual\&quot;: true,\n      \&quot;level\&quot;: 0,\n      \&quot;packageType\&quot;: \&quot;string\&quot;,\n      \&quot;priority\&quot;: 0,\n      \&quot;isActive\&quot;: true,\n      \&quot;outerId\&quot;: \&quot;string\&quot;,\n      \&quot;properties\&quot;: [\n        {\n          \&quot;isReadOnly\&quot;: true,\n          \&quot;isNew\&quot;: true,\n          \&quot;catalogId\&quot;: \&quot;string\&quot;,\n          \&quot;categoryId\&quot;: \&quot;string\&quot;,\n          \&quot;name\&quot;: \&quot;string\&quot;,\n          \&quot;required\&quot;: true,\n          \&quot;dictionary\&quot;: true,\n          \&quot;multivalue\&quot;: true,\n          \&quot;multilanguage\&quot;: true,\n          \&quot;hidden\&quot;: true,\n          \&quot;valueType\&quot;: \&quot;ShortText\&quot;,\n          \&quot;type\&quot;: \&quot;Product\&quot;,\n          \&quot;outerId\&quot;: \&quot;string\&quot;,\n          \&quot;ownerName\&quot;: \&quot;string\&quot;,\n          \&quot;values\&quot;: [\n            {\n              \&quot;propertyName\&quot;: \&quot;string\&quot;,\n              \&quot;propertyId\&quot;: \&quot;string\&quot;,\n              \&quot;languageCode\&quot;: \&quot;string\&quot;,\n              \&quot;alias\&quot;: \&quot;string\&quot;,\n              \&quot;valueType\&quot;: \&quot;ShortText\&quot;,\n              \&quot;valueId\&quot;: \&quot;string\&quot;,\n              \&quot;value\&quot;: {},\n              \&quot;outerId\&quot;: \&quot;string\&quot;,\n              \&quot;isInherited\&quot;: true,\n              \&quot;createdDate\&quot;: \&quot;2021-08-02T09:19:29.031Z\&quot;,\n              \&quot;modifiedDate\&quot;: \&quot;2021-08-02T09:19:29.031Z\&quot;,\n              \&quot;createdBy\&quot;: \&quot;string\&quot;,\n              \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n              \&quot;id\&quot;: \&quot;string\&quot;\n            }\n          ],\n          \&quot;attributes\&quot;: [\n            {\n              \&quot;propertyId\&quot;: \&quot;string\&quot;,\n              \&quot;value\&quot;: \&quot;string\&quot;,\n              \&quot;name\&quot;: \&quot;string\&quot;,\n              \&quot;createdDate\&quot;: \&quot;2021-08-02T09:19:29.031Z\&quot;,\n              \&quot;modifiedDate\&quot;: \&quot;2021-08-02T09:19:29.031Z\&quot;,\n              \&quot;createdBy\&quot;: \&quot;string\&quot;,\n              \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n              \&quot;id\&quot;: \&quot;string\&quot;\n            }\n          ],\n          \&quot;displayNames\&quot;: [\n            {\n              \&quot;name\&quot;: \&quot;string\&quot;,\n              \&quot;languageCode\&quot;: \&quot;string\&quot;\n            }\n          ],\n          \&quot;validationRules\&quot;: [\n            {\n              \&quot;isUnique\&quot;: true,\n              \&quot;charCountMin\&quot;: 0,\n              \&quot;charCountMax\&quot;: 0,\n              \&quot;regExp\&quot;: \&quot;string\&quot;,\n              \&quot;propertyId\&quot;: \&quot;string\&quot;,\n              \&quot;id\&quot;: \&quot;string\&quot;\n            }\n          ],\n          \&quot;validationRule\&quot;: {\n            \&quot;isUnique\&quot;: true,\n            \&quot;charCountMin\&quot;: 0,\n            \&quot;charCountMax\&quot;: 0,\n            \&quot;regExp\&quot;: \&quot;string\&quot;,\n            \&quot;propertyId\&quot;: \&quot;string\&quot;,\n            \&quot;id\&quot;: \&quot;string\&quot;\n          },\n          \&quot;isInherited\&quot;: true,\n          \&quot;createdDate\&quot;: \&quot;2021-08-02T09:19:29.031Z\&quot;,\n          \&quot;modifiedDate\&quot;: \&quot;2021-08-02T09:19:29.031Z\&quot;,\n          \&quot;createdBy\&quot;: \&quot;string\&quot;,\n          \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n          \&quot;id\&quot;: \&quot;string\&quot;\n        }\n      ],\n      \&quot;excludedProperties\&quot;: [\n        {\n          \&quot;name\&quot;: \&quot;string\&quot;,\n          \&quot;isInherited\&quot;: true\n        }\n      ],\n      \&quot;links\&quot;: [\n        null\n      ],\n      \&quot;taxType\&quot;: \&quot;string\&quot;,\n      \&quot;seoInfos\&quot;: [\n        {\n          \&quot;name\&quot;: \&quot;string\&quot;,\n          \&quot;semanticUrl\&quot;: \&quot;string\&quot;,\n          \&quot;pageTitle\&quot;: \&quot;string\&quot;,\n          \&quot;metaDescription\&quot;: \&quot;string\&quot;,\n          \&quot;imageAltDescription\&quot;: \&quot;string\&quot;,\n          \&quot;metaKeywords\&quot;: \&quot;string\&quot;,\n          \&quot;storeId\&quot;: \&quot;string\&quot;,\n          \&quot;objectId\&quot;: \&quot;string\&quot;,\n          \&quot;objectType\&quot;: \&quot;string\&quot;,\n          \&quot;isActive\&quot;: true,\n          \&quot;languageCode\&quot;: \&quot;string\&quot;,\n          \&quot;createdDate\&quot;: \&quot;2021-08-02T09:19:29.031Z\&quot;,\n          \&quot;modifiedDate\&quot;: \&quot;2021-08-02T09:19:29.031Z\&quot;,\n          \&quot;createdBy\&quot;: \&quot;string\&quot;,\n          \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n          \&quot;id\&quot;: \&quot;string\&quot;\n        }\n      ],\n      \&quot;images\&quot;: [\n        {\n          \&quot;binaryData\&quot;: \&quot;string\&quot;,\n          \&quot;altText\&quot;: \&quot;string\&quot;,\n          \&quot;relativeUrl\&quot;: \&quot;string\&quot;,\n          \&quot;url\&quot;: \&quot;string\&quot;,\n          \&quot;description\&quot;: \&quot;string\&quot;,\n          \&quot;sortOrder\&quot;: 0,\n          \&quot;typeId\&quot;: \&quot;string\&quot;,\n          \&quot;group\&quot;: \&quot;string\&quot;,\n          \&quot;name\&quot;: \&quot;string\&quot;,\n          \&quot;outerId\&quot;: \&quot;string\&quot;,\n          \&quot;languageCode\&quot;: \&quot;string\&quot;,\n          \&quot;seoInfos\&quot;: [\n            {\n              \&quot;name\&quot;: \&quot;string\&quot;,\n              \&quot;semanticUrl\&quot;: \&quot;string\&quot;,\n              \&quot;pageTitle\&quot;: \&quot;string\&quot;,\n              \&quot;metaDescription\&quot;: \&quot;string\&quot;,\n              \&quot;imageAltDescription\&quot;: \&quot;string\&quot;,\n              \&quot;metaKeywords\&quot;: \&quot;string\&quot;,\n              \&quot;storeId\&quot;: \&quot;string\&quot;,\n              \&quot;objectId\&quot;: \&quot;string\&quot;,\n              \&quot;objectType\&quot;: \&quot;string\&quot;,\n              \&quot;isActive\&quot;: true,\n              \&quot;languageCode\&quot;: \&quot;string\&quot;,\n              \&quot;createdDate\&quot;: \&quot;2021-08-02T09:19:29.031Z\&quot;,\n              \&quot;modifiedDate\&quot;: \&quot;2021-08-02T09:19:29.031Z\&quot;,\n              \&quot;createdBy\&quot;: \&quot;string\&quot;,\n              \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n              \&quot;id\&quot;: \&quot;string\&quot;\n            }\n          ],\n          \&quot;createdDate\&quot;: \&quot;2021-08-02T09:19:29.031Z\&quot;,\n          \&quot;modifiedDate\&quot;: \&quot;2021-08-02T09:19:29.031Z\&quot;,\n          \&quot;createdBy\&quot;: \&quot;string\&quot;,\n          \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n          \&quot;id\&quot;: \&quot;string\&quot;\n        }\n      ],\n      \&quot;outlines\&quot;: [\n        {\n          \&quot;items\&quot;: [\n            {\n              \&quot;id\&quot;: \&quot;string\&quot;,\n              \&quot;seoObjectType\&quot;: \&quot;string\&quot;,\n              \&quot;seoInfos\&quot;: [\n                {\n                  \&quot;name\&quot;: \&quot;string\&quot;,\n                  \&quot;semanticUrl\&quot;: \&quot;string\&quot;,\n                  \&quot;pageTitle\&quot;: \&quot;string\&quot;,\n                  \&quot;metaDescription\&quot;: \&quot;string\&quot;,\n                  \&quot;imageAltDescription\&quot;: \&quot;string\&quot;,\n                  \&quot;metaKeywords\&quot;: \&quot;string\&quot;,\n                  \&quot;storeId\&quot;: \&quot;string\&quot;,\n                  \&quot;objectId\&quot;: \&quot;string\&quot;,\n                  \&quot;objectType\&quot;: \&quot;string\&quot;,\n                  \&quot;isActive\&quot;: true,\n                  \&quot;languageCode\&quot;: \&quot;string\&quot;,\n                  \&quot;createdDate\&quot;: \&quot;2021-08-02T09:19:29.031Z\&quot;,\n                  \&quot;modifiedDate\&quot;: \&quot;2021-08-02T09:19:29.031Z\&quot;,\n                  \&quot;createdBy\&quot;: \&quot;string\&quot;,\n                  \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n                  \&quot;id\&quot;: \&quot;string\&quot;\n                }\n              ],\n              \&quot;name\&quot;: \&quot;string\&quot;,\n              \&quot;hasVirtualParent\&quot;: true\n            }\n          ]\n        }\n      ],\n      \&quot;createdDate\&quot;: \&quot;2021-08-02T09:19:29.031Z\&quot;,\n      \&quot;modifiedDate\&quot;: \&quot;2021-08-02T09:19:29.031Z\&quot;,\n      \&quot;createdBy\&quot;: \&quot;string\&quot;,\n      \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n      \&quot;id\&quot;: \&quot;string\&quot;\n    }\n  }\n]&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/catalog/listentrylinks</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonOutput
import com.kms.katalon.core.util.KeywordUtil


ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
def memberJsonOutput = JsonOutput.prettyPrint(response.getResponseBodyContent())
KeywordUtil.logInfo(memberJsonOutput)
WS.verifyResponseStatusCode(response, 200)


</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

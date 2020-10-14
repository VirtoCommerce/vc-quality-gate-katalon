<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>EmployeesGet</name>
   <tag></tag>
   <elementGuidId>76681817-5b8d-4cdd-b81a-35c2941f19b8</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;salutation\&quot;: \&quot;string\&quot;,\n  \&quot;fullName\&quot;: \&quot;string\&quot;,\n  \&quot;firstName\&quot;: \&quot;string\&quot;,\n  \&quot;middleName\&quot;: \&quot;string\&quot;,\n  \&quot;lastName\&quot;: \&quot;string\&quot;,\n  \&quot;birthDate\&quot;: \&quot;2020-09-27T00:54:07.095Z\&quot;,\n  \&quot;defaultLanguage\&quot;: \&quot;string\&quot;,\n  \&quot;timeZone\&quot;: \&quot;string\&quot;,\n  \&quot;organizations\&quot;: [\n    \&quot;string\&quot;\n  ],\n  \&quot;employeeType\&quot;: \&quot;string\&quot;,\n  \&quot;isActive\&quot;: true,\n  \&quot;photoUrl\&quot;: \&quot;string\&quot;,\n  \&quot;securityAccounts\&quot;: [\n    {\n      \&quot;storeId\&quot;: \&quot;string\&quot;,\n      \&quot;memberId\&quot;: \&quot;string\&quot;,\n      \&quot;isAdministrator\&quot;: true,\n      \&quot;photoUrl\&quot;: \&quot;string\&quot;,\n      \&quot;userType\&quot;: \&quot;string\&quot;,\n      \&quot;password\&quot;: \&quot;string\&quot;,\n      \&quot;createdDate\&quot;: \&quot;2020-09-27T00:54:07.095Z\&quot;,\n      \&quot;modifiedDate\&quot;: \&quot;2020-09-27T00:54:07.095Z\&quot;,\n      \&quot;createdBy\&quot;: \&quot;string\&quot;,\n      \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n      \&quot;roles\&quot;: [\n        {\n          \&quot;description\&quot;: \&quot;string\&quot;,\n          \&quot;permissions\&quot;: [\n            {\n              \&quot;name\&quot;: \&quot;string\&quot;,\n              \&quot;moduleId\&quot;: \&quot;string\&quot;,\n              \&quot;groupName\&quot;: \&quot;string\&quot;,\n              \&quot;assignedScopes\&quot;: [\n                {\n                  \&quot;type\&quot;: \&quot;string\&quot;,\n                  \&quot;label\&quot;: \&quot;string\&quot;,\n                  \&quot;scope\&quot;: \&quot;string\&quot;\n                }\n              ]\n            }\n          ],\n          \&quot;id\&quot;: \&quot;string\&quot;,\n          \&quot;name\&quot;: \&quot;string\&quot;,\n          \&quot;normalizedName\&quot;: \&quot;string\&quot;,\n          \&quot;concurrencyStamp\&quot;: \&quot;string\&quot;\n        }\n      ],\n      \&quot;userState\&quot;: \&quot;PendingApproval\&quot;,\n      \&quot;logins\&quot;: [\n        {\n          \&quot;loginProvider\&quot;: \&quot;string\&quot;,\n          \&quot;providerKey\&quot;: \&quot;string\&quot;\n        }\n      ],\n      \&quot;passwordExpired\&quot;: true,\n      \&quot;id\&quot;: \&quot;string\&quot;,\n      \&quot;userName\&quot;: \&quot;string\&quot;,\n      \&quot;normalizedUserName\&quot;: \&quot;string\&quot;,\n      \&quot;email\&quot;: \&quot;string\&quot;,\n      \&quot;normalizedEmail\&quot;: \&quot;string\&quot;,\n      \&quot;emailConfirmed\&quot;: true,\n      \&quot;passwordHash\&quot;: \&quot;string\&quot;,\n      \&quot;securityStamp\&quot;: \&quot;string\&quot;,\n      \&quot;concurrencyStamp\&quot;: \&quot;string\&quot;,\n      \&quot;phoneNumber\&quot;: \&quot;string\&quot;,\n      \&quot;phoneNumberConfirmed\&quot;: true,\n      \&quot;twoFactorEnabled\&quot;: true,\n      \&quot;lockoutEnd\&quot;: \&quot;2020-09-27T00:54:07.095Z\&quot;,\n      \&quot;lockoutEnabled\&quot;: true,\n      \&quot;accessFailedCount\&quot;: 0\n    }\n  ],\n  \&quot;name\&quot;: \&quot;string\&quot;,\n  \&quot;memberType\&quot;: \&quot;string\&quot;,\n  \&quot;outerId\&quot;: \&quot;string\&quot;,\n  \&quot;addresses\&quot;: [\n    {\n      \&quot;addressType\&quot;: \&quot;Billing\&quot;,\n      \&quot;key\&quot;: \&quot;string\&quot;,\n      \&quot;name\&quot;: \&quot;string\&quot;,\n      \&quot;organization\&quot;: \&quot;string\&quot;,\n      \&quot;countryCode\&quot;: \&quot;string\&quot;,\n      \&quot;countryName\&quot;: \&quot;string\&quot;,\n      \&quot;city\&quot;: \&quot;string\&quot;,\n      \&quot;postalCode\&quot;: \&quot;string\&quot;,\n      \&quot;zip\&quot;: \&quot;string\&quot;,\n      \&quot;line1\&quot;: \&quot;string\&quot;,\n      \&quot;line2\&quot;: \&quot;string\&quot;,\n      \&quot;regionId\&quot;: \&quot;string\&quot;,\n      \&quot;regionName\&quot;: \&quot;string\&quot;,\n      \&quot;firstName\&quot;: \&quot;string\&quot;,\n      \&quot;middleName\&quot;: \&quot;string\&quot;,\n      \&quot;lastName\&quot;: \&quot;string\&quot;,\n      \&quot;phone\&quot;: \&quot;string\&quot;,\n      \&quot;email\&quot;: \&quot;string\&quot;\n    }\n  ],\n  \&quot;phones\&quot;: [\n    \&quot;string\&quot;\n  ],\n  \&quot;emails\&quot;: [\n    \&quot;string\&quot;\n  ],\n  \&quot;notes\&quot;: [\n    {\n      \&quot;title\&quot;: \&quot;string\&quot;,\n      \&quot;body\&quot;: \&quot;string\&quot;,\n      \&quot;outerId\&quot;: \&quot;string\&quot;,\n      \&quot;createdDate\&quot;: \&quot;2020-09-27T00:54:07.095Z\&quot;,\n      \&quot;modifiedDate\&quot;: \&quot;2020-09-27T00:54:07.095Z\&quot;,\n      \&quot;createdBy\&quot;: \&quot;string\&quot;,\n      \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n      \&quot;id\&quot;: \&quot;string\&quot;\n    }\n  ],\n  \&quot;groups\&quot;: [\n    \&quot;string\&quot;\n  ],\n  \&quot;dynamicProperties\&quot;: [\n    {\n      \&quot;objectId\&quot;: \&quot;string\&quot;,\n      \&quot;values\&quot;: [\n        {\n          \&quot;objectType\&quot;: \&quot;string\&quot;,\n          \&quot;objectId\&quot;: \&quot;string\&quot;,\n          \&quot;locale\&quot;: \&quot;string\&quot;,\n          \&quot;value\&quot;: {},\n          \&quot;valueId\&quot;: \&quot;string\&quot;,\n          \&quot;valueType\&quot;: \&quot;Undefined\&quot;,\n          \&quot;propertyId\&quot;: \&quot;string\&quot;,\n          \&quot;propertyName\&quot;: \&quot;string\&quot;\n        }\n      ],\n      \&quot;name\&quot;: \&quot;string\&quot;,\n      \&quot;description\&quot;: \&quot;string\&quot;,\n      \&quot;objectType\&quot;: \&quot;string\&quot;,\n      \&quot;isArray\&quot;: true,\n      \&quot;isDictionary\&quot;: true,\n      \&quot;isMultilingual\&quot;: true,\n      \&quot;isRequired\&quot;: true,\n      \&quot;displayOrder\&quot;: 0,\n      \&quot;valueType\&quot;: \&quot;Undefined\&quot;,\n      \&quot;displayNames\&quot;: [\n        {\n          \&quot;locale\&quot;: \&quot;string\&quot;,\n          \&quot;name\&quot;: \&quot;string\&quot;\n        }\n      ],\n      \&quot;createdDate\&quot;: \&quot;2020-09-27T00:54:07.095Z\&quot;,\n      \&quot;modifiedDate\&quot;: \&quot;2020-09-27T00:54:07.095Z\&quot;,\n      \&quot;createdBy\&quot;: \&quot;string\&quot;,\n      \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n      \&quot;id\&quot;: \&quot;string\&quot;\n    }\n  ],\n  \&quot;seoInfos\&quot;: [\n    {\n      \&quot;name\&quot;: \&quot;string\&quot;,\n      \&quot;semanticUrl\&quot;: \&quot;string\&quot;,\n      \&quot;pageTitle\&quot;: \&quot;string\&quot;,\n      \&quot;metaDescription\&quot;: \&quot;string\&quot;,\n      \&quot;imageAltDescription\&quot;: \&quot;string\&quot;,\n      \&quot;metaKeywords\&quot;: \&quot;string\&quot;,\n      \&quot;storeId\&quot;: \&quot;string\&quot;,\n      \&quot;objectId\&quot;: \&quot;string\&quot;,\n      \&quot;objectType\&quot;: \&quot;string\&quot;,\n      \&quot;isActive\&quot;: true,\n      \&quot;languageCode\&quot;: \&quot;string\&quot;,\n      \&quot;createdDate\&quot;: \&quot;2020-09-27T00:54:07.095Z\&quot;,\n      \&quot;modifiedDate\&quot;: \&quot;2020-09-27T00:54:07.095Z\&quot;,\n      \&quot;createdBy\&quot;: \&quot;string\&quot;,\n      \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n      \&quot;id\&quot;: \&quot;string\&quot;\n    }\n  ],\n  \&quot;createdDate\&quot;: \&quot;2020-09-27T00:54:07.095Z\&quot;,\n  \&quot;modifiedDate\&quot;: \&quot;2020-09-27T00:54:07.095Z\&quot;,\n  \&quot;createdBy\&quot;: \&quot;string\&quot;,\n  \&quot;modifiedBy\&quot;: \&quot;string\&quot;,\n  \&quot;id\&quot;: \&quot;string\&quot;\n}&quot;,
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
      <value>b482842a-22ab-4eac-b251-21e5fdcdf79c</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/employees?ids=3d73e824-8598-4517-a073-ba0990aa4343</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
KeywordUtil.logInfo(response.responseBodyContent)
WS.verifyResponseStatusCode(response, 200)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

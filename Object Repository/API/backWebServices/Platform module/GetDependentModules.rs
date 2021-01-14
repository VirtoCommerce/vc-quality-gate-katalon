<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>GetDependentModules</name>
   <tag></tag>
   <elementGuidId>f376c27c-802c-4208-93b9-0a88654793a2</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[\n {\n    \&quot;version\&quot;: \&quot;3.9.0-alpha.486\&quot;,\n    \&quot;platformVersion\&quot;: \&quot;3.13.0\&quot;,\n    \&quot;title\&quot;: \&quot;Store module\&quot;,\n    \&quot;description\&quot;: \&quot;Multi store management with individual store settings\&quot;,\n    \&quot;authors\&quot;: [\n      \&quot;Virto Commerce\&quot;\n    ],\n    \&quot;owners\&quot;: [\n      \&quot;Virto Commerce\&quot;\n    ],\n    \&quot;projectUrl\&quot;: \&quot;https://virtocommerce.com/apps/extensions/virto-store-module\&quot;,\n    \&quot;iconUrl\&quot;: \&quot;Modules/$(VirtoCommerce.Store)/Content/logo.png\&quot;,\n    \&quot;requireLicenseAcceptance\&quot;: false,\n    \&quot;releaseNotes\&quot;: \&quot;\&quot;,\n    \&quot;copyright\&quot;: \&quot;Copyright © 2011-2020 Virto Commerce. All rights reserved\&quot;,\n    \&quot;groups\&quot;: [\n      \&quot;commerce\&quot;\n    ],\n    \&quot;dependencies\&quot;: [\n      {\n        \&quot;id\&quot;: \&quot;VirtoCommerce.Core\&quot;,\n        \&quot;version\&quot;: {\n          \&quot;major\&quot;: 3,\n          \&quot;minor\&quot;: 0,\n          \&quot;patch\&quot;: 0,\n          \&quot;prerelease\&quot;: \&quot;\&quot;\n        }\n      },\n      {\n        \&quot;id\&quot;: \&quot;VirtoCommerce.Notifications\&quot;,\n        \&quot;version\&quot;: {\n          \&quot;major\&quot;: 3,\n          \&quot;minor\&quot;: 0,\n          \&quot;patch\&quot;: 0,\n          \&quot;prerelease\&quot;: \&quot;\&quot;\n        }\n      }\n    ],\n    \&quot;validationErrors\&quot;: [],\n    \&quot;isRemovable\&quot;: false,\n    \&quot;isInstalled\&quot;: true,\n    \&quot;id\&quot;: \&quot;VirtoCommerce.Store\&quot;\n  }\n]&quot;,
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
   <restUrl>${GlobalVariable.urlBack}/api/platform/modules/getdependents</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
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

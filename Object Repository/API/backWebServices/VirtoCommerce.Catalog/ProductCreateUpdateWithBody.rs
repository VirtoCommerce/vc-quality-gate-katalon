<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ProductCreateUpdateWithBody</name>
   <tag></tag>
   <elementGuidId>cbc09d3a-4560-4112-8427-1bfb62b71ea7</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;\&quot;${body}\&quot;&quot;,
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
      <webElementGuid>ef9e7dd2-1c6a-46a9-af4f-06ee3ae6a8f8</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>api_key</name>
      <type>Main</type>
      <value>${GlobalVariable.api_key}</value>
      <webElementGuid>578d8c6c-c0dd-4a44-b02d-599c92d1089c</webElementGuid>
   </httpHeaderProperties>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.urlBack}/api/catalog/products</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'{\r\n   &quot;code&quot;:&quot;YJD-78514689&quot;,\r\n   &quot;name&quot;:&quot;QweDrink&quot;,\r\n   &quot;catalogId&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n   &quot;categoryId&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n   &quot;outline&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n   &quot;path&quot;:&quot;Cell phones&quot;,\r\n   &quot;isBuyable&quot;:true,\r\n   &quot;isActive&quot;:true,\r\n   &quot;trackInventory&quot;:true,\r\n   &quot;maxQuantity&quot;:0,\r\n   &quot;minQuantity&quot;:0,\r\n   &quot;startDate&quot;:&quot;2021-08-19T13:35:18.8492013Z&quot;,\r\n   &quot;priority&quot;:0,\r\n   &quot;properties&quot;:[\r\n      {\r\n         &quot;isReadOnly&quot;:false,\r\n         &quot;isManageable&quot;:true,\r\n         &quot;isNew&quot;:false,\r\n         &quot;catalogId&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n         &quot;name&quot;:&quot;Brand&quot;,\r\n         &quot;required&quot;:true,\r\n         &quot;dictionary&quot;:true,\r\n         &quot;multivalue&quot;:false,\r\n         &quot;multilanguage&quot;:false,\r\n         &quot;hidden&quot;:false,\r\n         &quot;valueType&quot;:&quot;ShortText&quot;,\r\n         &quot;type&quot;:&quot;Product&quot;,\r\n         &quot;values&quot;:[\r\n            \r\n         ],\r\n         &quot;attributes&quot;:[\r\n            \r\n         ],\r\n         &quot;displayNames&quot;:[\r\n            {\r\n               &quot;name&quot;:&quot;Marke&quot;,\r\n               &quot;languageCode&quot;:&quot;de-DE&quot;\r\n            },\r\n            {\r\n               &quot;name&quot;:&quot;Brand&quot;,\r\n               &quot;languageCode&quot;:&quot;en-US&quot;\r\n            }\r\n         ],\r\n         &quot;validationRules&quot;:[\r\n            \r\n         ],\r\n         &quot;isInherited&quot;:true,\r\n         &quot;id&quot;:&quot;43d14478-d142-4a65-956f-0a308d0c4ee8&quot;\r\n      },\r\n      {\r\n         &quot;isReadOnly&quot;:false,\r\n         &quot;isManageable&quot;:true,\r\n         &quot;isNew&quot;:false,\r\n         &quot;catalogId&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n         &quot;categoryId&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n         &quot;name&quot;:&quot;Color&quot;,\r\n         &quot;required&quot;:false,\r\n         &quot;dictionary&quot;:true,\r\n         &quot;multivalue&quot;:true,\r\n         &quot;multilanguage&quot;:true,\r\n         &quot;hidden&quot;:false,\r\n         &quot;valueType&quot;:&quot;ShortText&quot;,\r\n         &quot;type&quot;:&quot;Variation&quot;,\r\n         &quot;values&quot;:[\r\n            \r\n         ],\r\n         &quot;attributes&quot;:[\r\n            \r\n         ],\r\n         &quot;displayNames&quot;:[\r\n            {\r\n               &quot;name&quot;:&quot;Farber&quot;,\r\n               &quot;languageCode&quot;:&quot;de-DE&quot;\r\n            },\r\n            {\r\n               &quot;name&quot;:&quot;Color&quot;,\r\n               &quot;languageCode&quot;:&quot;en-US&quot;\r\n            }\r\n         ],\r\n         &quot;validationRules&quot;:[\r\n            \r\n         ],\r\n         &quot;isInherited&quot;:true,\r\n         &quot;id&quot;:&quot;87fd1cec-79c2-4652-83b4-36e241ede571&quot;\r\n      },\r\n      {\r\n         &quot;isReadOnly&quot;:false,\r\n         &quot;isManageable&quot;:true,\r\n         &quot;isNew&quot;:false,\r\n         &quot;catalogId&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n         &quot;categoryId&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n         &quot;name&quot;:&quot;Deep&quot;,\r\n         &quot;required&quot;:false,\r\n         &quot;dictionary&quot;:false,\r\n         &quot;multivalue&quot;:false,\r\n         &quot;multilanguage&quot;:false,\r\n         &quot;hidden&quot;:false,\r\n         &quot;valueType&quot;:&quot;Number&quot;,\r\n         &quot;type&quot;:&quot;Product&quot;,\r\n         &quot;values&quot;:[\r\n            \r\n         ],\r\n         &quot;attributes&quot;:[\r\n            \r\n         ],\r\n         &quot;displayNames&quot;:[\r\n            {\r\n               &quot;languageCode&quot;:&quot;de-DE&quot;\r\n            },\r\n            {\r\n               &quot;name&quot;:&quot;Deep&quot;,\r\n               &quot;languageCode&quot;:&quot;en-US&quot;\r\n            }\r\n         ],\r\n         &quot;validationRules&quot;:[\r\n            \r\n         ],\r\n         &quot;isInherited&quot;:true,\r\n         &quot;id&quot;:&quot;a5e64e80-2484-496a-aff5-c8df9c75fbbe&quot;\r\n      },\r\n      {\r\n         &quot;isReadOnly&quot;:false,\r\n         &quot;isManageable&quot;:true,\r\n         &quot;isNew&quot;:false,\r\n         &quot;catalogId&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n         &quot;categoryId&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n         &quot;name&quot;:&quot;Display_size&quot;,\r\n         &quot;required&quot;:false,\r\n         &quot;dictionary&quot;:false,\r\n         &quot;multivalue&quot;:false,\r\n         &quot;multilanguage&quot;:false,\r\n         &quot;hidden&quot;:false,\r\n         &quot;valueType&quot;:&quot;Number&quot;,\r\n         &quot;type&quot;:&quot;Product&quot;,\r\n         &quot;values&quot;:[\r\n            \r\n         ],\r\n         &quot;attributes&quot;:[\r\n            \r\n         ],\r\n         &quot;displayNames&quot;:[\r\n            {\r\n               &quot;name&quot;:&quot;Bildschirmgröße&quot;,\r\n               &quot;languageCode&quot;:&quot;de-DE&quot;\r\n            },\r\n            {\r\n               &quot;name&quot;:&quot;Display size&quot;,\r\n               &quot;languageCode&quot;:&quot;en-US&quot;\r\n            }\r\n         ],\r\n         &quot;validationRules&quot;:[\r\n            \r\n         ],\r\n         &quot;isInherited&quot;:true,\r\n         &quot;id&quot;:&quot;fa4a86b5-d85b-464b-b27c-00f316a979e7&quot;\r\n      },\r\n      {\r\n         &quot;isReadOnly&quot;:false,\r\n         &quot;isManageable&quot;:true,\r\n         &quot;isNew&quot;:false,\r\n         &quot;catalogId&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n         &quot;categoryId&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n         &quot;name&quot;:&quot;Front_camera_MP&quot;,\r\n         &quot;required&quot;:false,\r\n         &quot;dictionary&quot;:false,\r\n         &quot;multivalue&quot;:false,\r\n         &quot;multilanguage&quot;:false,\r\n         &quot;hidden&quot;:false,\r\n         &quot;valueType&quot;:&quot;Number&quot;,\r\n         &quot;type&quot;:&quot;Product&quot;,\r\n         &quot;values&quot;:[\r\n            \r\n         ],\r\n         &quot;attributes&quot;:[\r\n            \r\n         ],\r\n         &quot;displayNames&quot;:[\r\n            {\r\n               &quot;languageCode&quot;:&quot;de-DE&quot;\r\n            },\r\n            {\r\n               &quot;languageCode&quot;:&quot;en-US&quot;\r\n            }\r\n         ],\r\n         &quot;validationRules&quot;:[\r\n            \r\n         ],\r\n         &quot;isInherited&quot;:true,\r\n         &quot;id&quot;:&quot;7ae290e2-b198-42b0-ae63-26537281d53b&quot;\r\n      },\r\n      {\r\n         &quot;isReadOnly&quot;:false,\r\n         &quot;isManageable&quot;:true,\r\n         &quot;isNew&quot;:false,\r\n         &quot;catalogId&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n         &quot;categoryId&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n         &quot;name&quot;:&quot;Internal_Storage_GB&quot;,\r\n         &quot;required&quot;:false,\r\n         &quot;dictionary&quot;:false,\r\n         &quot;multivalue&quot;:false,\r\n         &quot;multilanguage&quot;:false,\r\n         &quot;hidden&quot;:false,\r\n         &quot;valueType&quot;:&quot;Number&quot;,\r\n         &quot;type&quot;:&quot;Variation&quot;,\r\n         &quot;values&quot;:[\r\n            \r\n         ],\r\n         &quot;attributes&quot;:[\r\n            \r\n         ],\r\n         &quot;displayNames&quot;:[\r\n            {\r\n               &quot;languageCode&quot;:&quot;en-US&quot;\r\n            },\r\n            {\r\n               &quot;languageCode&quot;:&quot;de-DE&quot;\r\n            }\r\n         ],\r\n         &quot;validationRules&quot;:[\r\n            \r\n         ],\r\n         &quot;isInherited&quot;:true,\r\n         &quot;id&quot;:&quot;1e94acae-f338-44a3-8216-194c01260628&quot;\r\n      },\r\n      {\r\n         &quot;isReadOnly&quot;:false,\r\n         &quot;isManageable&quot;:true,\r\n         &quot;isNew&quot;:false,\r\n         &quot;catalogId&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n         &quot;categoryId&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n         &quot;name&quot;:&quot;Memory_Card_Slot&quot;,\r\n         &quot;required&quot;:false,\r\n         &quot;dictionary&quot;:false,\r\n         &quot;multivalue&quot;:false,\r\n         &quot;multilanguage&quot;:false,\r\n         &quot;hidden&quot;:false,\r\n         &quot;valueType&quot;:&quot;Boolean&quot;,\r\n         &quot;type&quot;:&quot;Variation&quot;,\r\n         &quot;values&quot;:[\r\n            \r\n         ],\r\n         &quot;attributes&quot;:[\r\n            \r\n         ],\r\n         &quot;displayNames&quot;:[\r\n            {\r\n               &quot;languageCode&quot;:&quot;en-US&quot;\r\n            },\r\n            {\r\n               &quot;languageCode&quot;:&quot;de-DE&quot;\r\n            }\r\n         ],\r\n         &quot;validationRules&quot;:[\r\n            \r\n         ],\r\n         &quot;isInherited&quot;:true,\r\n         &quot;id&quot;:&quot;3309e819-a77a-437c-915d-28450d55bab6&quot;\r\n      },\r\n      {\r\n         &quot;isReadOnly&quot;:false,\r\n         &quot;isManageable&quot;:true,\r\n         &quot;isNew&quot;:false,\r\n         &quot;catalogId&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n         &quot;categoryId&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n         &quot;name&quot;:&quot;NFC&quot;,\r\n         &quot;required&quot;:false,\r\n         &quot;dictionary&quot;:false,\r\n         &quot;multivalue&quot;:false,\r\n         &quot;multilanguage&quot;:false,\r\n         &quot;hidden&quot;:false,\r\n         &quot;valueType&quot;:&quot;Boolean&quot;,\r\n         &quot;type&quot;:&quot;Product&quot;,\r\n         &quot;values&quot;:[\r\n            \r\n         ],\r\n         &quot;attributes&quot;:[\r\n            \r\n         ],\r\n         &quot;displayNames&quot;:[\r\n            {\r\n               &quot;languageCode&quot;:&quot;en-US&quot;\r\n            },\r\n            {\r\n               &quot;languageCode&quot;:&quot;de-DE&quot;\r\n            }\r\n         ],\r\n         &quot;validationRules&quot;:[\r\n            \r\n         ],\r\n         &quot;isInherited&quot;:true,\r\n         &quot;id&quot;:&quot;29007dd4-2f23-417b-902c-8d6565615eea&quot;\r\n      },\r\n      {\r\n         &quot;isReadOnly&quot;:false,\r\n         &quot;isManageable&quot;:true,\r\n         &quot;isNew&quot;:false,\r\n         &quot;catalogId&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n         &quot;categoryId&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n         &quot;name&quot;:&quot;Operating_system&quot;,\r\n         &quot;required&quot;:true,\r\n         &quot;dictionary&quot;:true,\r\n         &quot;multivalue&quot;:false,\r\n         &quot;multilanguage&quot;:false,\r\n         &quot;hidden&quot;:false,\r\n         &quot;valueType&quot;:&quot;ShortText&quot;,\r\n         &quot;type&quot;:&quot;Product&quot;,\r\n         &quot;values&quot;:[\r\n            \r\n         ],\r\n         &quot;attributes&quot;:[\r\n            \r\n         ],\r\n         &quot;displayNames&quot;:[\r\n            {\r\n               &quot;languageCode&quot;:&quot;de-DE&quot;\r\n            },\r\n            {\r\n               &quot;languageCode&quot;:&quot;en-US&quot;\r\n            }\r\n         ],\r\n         &quot;validationRules&quot;:[\r\n            \r\n         ],\r\n         &quot;isInherited&quot;:true,\r\n         &quot;id&quot;:&quot;f5ac5fae-b80b-4f88-8042-e7f89c998eff&quot;\r\n      },\r\n      {\r\n         &quot;isReadOnly&quot;:false,\r\n         &quot;isManageable&quot;:true,\r\n         &quot;isNew&quot;:false,\r\n         &quot;catalogId&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n         &quot;categoryId&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n         &quot;name&quot;:&quot;Pixels_Per_Inch_ppi&quot;,\r\n         &quot;required&quot;:false,\r\n         &quot;dictionary&quot;:false,\r\n         &quot;multivalue&quot;:false,\r\n         &quot;multilanguage&quot;:false,\r\n         &quot;hidden&quot;:false,\r\n         &quot;valueType&quot;:&quot;Number&quot;,\r\n         &quot;type&quot;:&quot;Product&quot;,\r\n         &quot;values&quot;:[\r\n            \r\n         ],\r\n         &quot;attributes&quot;:[\r\n            \r\n         ],\r\n         &quot;displayNames&quot;:[\r\n            {\r\n               &quot;languageCode&quot;:&quot;en-US&quot;\r\n            },\r\n            {\r\n               &quot;languageCode&quot;:&quot;de-DE&quot;\r\n            }\r\n         ],\r\n         &quot;validationRules&quot;:[\r\n            \r\n         ],\r\n         &quot;isInherited&quot;:true,\r\n         &quot;id&quot;:&quot;0e3029bd-dc69-4617-9163-78ac53ee8a6e&quot;\r\n      },\r\n      {\r\n         &quot;isReadOnly&quot;:false,\r\n         &quot;isManageable&quot;:true,\r\n         &quot;isNew&quot;:false,\r\n         &quot;catalogId&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n         &quot;categoryId&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n         &quot;name&quot;:&quot;Processor_Core_GHz&quot;,\r\n         &quot;required&quot;:false,\r\n         &quot;dictionary&quot;:false,\r\n         &quot;multivalue&quot;:false,\r\n         &quot;multilanguage&quot;:false,\r\n         &quot;hidden&quot;:false,\r\n         &quot;valueType&quot;:&quot;ShortText&quot;,\r\n         &quot;type&quot;:&quot;Variation&quot;,\r\n         &quot;values&quot;:[\r\n            \r\n         ],\r\n         &quot;attributes&quot;:[\r\n            \r\n         ],\r\n         &quot;displayNames&quot;:[\r\n            {\r\n               &quot;languageCode&quot;:&quot;en-US&quot;\r\n            },\r\n            {\r\n               &quot;languageCode&quot;:&quot;de-DE&quot;\r\n            }\r\n         ],\r\n         &quot;validationRules&quot;:[\r\n            \r\n         ],\r\n         &quot;isInherited&quot;:true,\r\n         &quot;id&quot;:&quot;85daf769-12c7-4135-9e8a-a0bcf74db4c3&quot;\r\n      },\r\n      {\r\n         &quot;isReadOnly&quot;:false,\r\n         &quot;isManageable&quot;:true,\r\n         &quot;isNew&quot;:false,\r\n         &quot;catalogId&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n         &quot;categoryId&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n         &quot;name&quot;:&quot;RAM_Memory_GB&quot;,\r\n         &quot;required&quot;:false,\r\n         &quot;dictionary&quot;:false,\r\n         &quot;multivalue&quot;:false,\r\n         &quot;multilanguage&quot;:false,\r\n         &quot;hidden&quot;:false,\r\n         &quot;valueType&quot;:&quot;Number&quot;,\r\n         &quot;type&quot;:&quot;Variation&quot;,\r\n         &quot;values&quot;:[\r\n            \r\n         ],\r\n         &quot;attributes&quot;:[\r\n            \r\n         ],\r\n         &quot;displayNames&quot;:[\r\n            {\r\n               &quot;languageCode&quot;:&quot;en-US&quot;\r\n            },\r\n            {\r\n               &quot;languageCode&quot;:&quot;de-DE&quot;\r\n            }\r\n         ],\r\n         &quot;validationRules&quot;:[\r\n            \r\n         ],\r\n         &quot;isInherited&quot;:true,\r\n         &quot;id&quot;:&quot;f06daf73-efd3-4b6d-9143-bf08a0715991&quot;\r\n      },\r\n      {\r\n         &quot;isReadOnly&quot;:false,\r\n         &quot;isManageable&quot;:true,\r\n         &quot;isNew&quot;:false,\r\n         &quot;catalogId&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n         &quot;categoryId&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n         &quot;name&quot;:&quot;Rear_camera_MP&quot;,\r\n         &quot;required&quot;:false,\r\n         &quot;dictionary&quot;:false,\r\n         &quot;multivalue&quot;:false,\r\n         &quot;multilanguage&quot;:false,\r\n         &quot;hidden&quot;:false,\r\n         &quot;valueType&quot;:&quot;Number&quot;,\r\n         &quot;type&quot;:&quot;Product&quot;,\r\n         &quot;values&quot;:[\r\n            \r\n         ],\r\n         &quot;attributes&quot;:[\r\n            \r\n         ],\r\n         &quot;displayNames&quot;:[\r\n            {\r\n               &quot;languageCode&quot;:&quot;en-US&quot;\r\n            },\r\n            {\r\n               &quot;languageCode&quot;:&quot;de-DE&quot;\r\n            }\r\n         ],\r\n         &quot;validationRules&quot;:[\r\n            \r\n         ],\r\n         &quot;isInherited&quot;:true,\r\n         &quot;id&quot;:&quot;ee496813-1a59-4707-9816-85e639c55534&quot;\r\n      },\r\n      {\r\n         &quot;isReadOnly&quot;:false,\r\n         &quot;isManageable&quot;:true,\r\n         &quot;isNew&quot;:false,\r\n         &quot;catalogId&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n         &quot;categoryId&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n         &quot;name&quot;:&quot;SIM_Card_Slots&quot;,\r\n         &quot;required&quot;:false,\r\n         &quot;dictionary&quot;:true,\r\n         &quot;multivalue&quot;:false,\r\n         &quot;multilanguage&quot;:false,\r\n         &quot;hidden&quot;:false,\r\n         &quot;valueType&quot;:&quot;ShortText&quot;,\r\n         &quot;type&quot;:&quot;Product&quot;,\r\n         &quot;values&quot;:[\r\n            \r\n         ],\r\n         &quot;attributes&quot;:[\r\n            \r\n         ],\r\n         &quot;displayNames&quot;:[\r\n            {\r\n               &quot;languageCode&quot;:&quot;en-US&quot;\r\n            },\r\n            {\r\n               &quot;languageCode&quot;:&quot;de-DE&quot;\r\n            }\r\n         ],\r\n         &quot;validationRules&quot;:[\r\n            \r\n         ],\r\n         &quot;isInherited&quot;:true,\r\n         &quot;id&quot;:&quot;552a29f0-fb63-4ea2-ba12-293cd8c9410c&quot;\r\n      },\r\n      {\r\n         &quot;isReadOnly&quot;:false,\r\n         &quot;isManageable&quot;:true,\r\n         &quot;isNew&quot;:false,\r\n         &quot;catalogId&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n         &quot;categoryId&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n         &quot;name&quot;:&quot;Two_SIM_cards&quot;,\r\n         &quot;required&quot;:false,\r\n         &quot;dictionary&quot;:false,\r\n         &quot;multivalue&quot;:false,\r\n         &quot;multilanguage&quot;:false,\r\n         &quot;hidden&quot;:false,\r\n         &quot;valueType&quot;:&quot;Boolean&quot;,\r\n         &quot;type&quot;:&quot;Variation&quot;,\r\n         &quot;values&quot;:[\r\n            \r\n         ],\r\n         &quot;attributes&quot;:[\r\n            \r\n         ],\r\n         &quot;displayNames&quot;:[\r\n            {\r\n               &quot;languageCode&quot;:&quot;de-DE&quot;\r\n            },\r\n            {\r\n               &quot;languageCode&quot;:&quot;en-US&quot;\r\n            }\r\n         ],\r\n         &quot;validationRules&quot;:[\r\n            \r\n         ],\r\n         &quot;isInherited&quot;:true,\r\n         &quot;id&quot;:&quot;b2e01868-4545-4159-8936-5f21a338cc2d&quot;\r\n      },\r\n      {\r\n         &quot;isReadOnly&quot;:false,\r\n         &quot;isManageable&quot;:true,\r\n         &quot;isNew&quot;:false,\r\n         &quot;catalogId&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n         &quot;categoryId&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n         &quot;name&quot;:&quot;Video_Recording&quot;,\r\n         &quot;required&quot;:false,\r\n         &quot;dictionary&quot;:true,\r\n         &quot;multivalue&quot;:false,\r\n         &quot;multilanguage&quot;:false,\r\n         &quot;hidden&quot;:false,\r\n         &quot;valueType&quot;:&quot;ShortText&quot;,\r\n         &quot;type&quot;:&quot;Product&quot;,\r\n         &quot;values&quot;:[\r\n            \r\n         ],\r\n         &quot;attributes&quot;:[\r\n            \r\n         ],\r\n         &quot;displayNames&quot;:[\r\n            {\r\n               &quot;languageCode&quot;:&quot;en-US&quot;\r\n            },\r\n            {\r\n               &quot;languageCode&quot;:&quot;de-DE&quot;\r\n            }\r\n         ],\r\n         &quot;validationRules&quot;:[\r\n            \r\n         ],\r\n         &quot;isInherited&quot;:true,\r\n         &quot;id&quot;:&quot;2d8f8a03-9c7d-464f-96b8-959e60e91214&quot;\r\n      },\r\n      {\r\n         &quot;isReadOnly&quot;:false,\r\n         &quot;isManageable&quot;:true,\r\n         &quot;isNew&quot;:false,\r\n         &quot;catalogId&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n         &quot;categoryId&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n         &quot;name&quot;:&quot;Waterproof&quot;,\r\n         &quot;required&quot;:false,\r\n         &quot;dictionary&quot;:false,\r\n         &quot;multivalue&quot;:false,\r\n         &quot;multilanguage&quot;:false,\r\n         &quot;hidden&quot;:false,\r\n         &quot;valueType&quot;:&quot;Boolean&quot;,\r\n         &quot;type&quot;:&quot;Product&quot;,\r\n         &quot;values&quot;:[\r\n            \r\n         ],\r\n         &quot;attributes&quot;:[\r\n            \r\n         ],\r\n         &quot;displayNames&quot;:[\r\n            {\r\n               &quot;languageCode&quot;:&quot;de-DE&quot;\r\n            },\r\n            {\r\n               &quot;languageCode&quot;:&quot;en-US&quot;\r\n            }\r\n         ],\r\n         &quot;validationRules&quot;:[\r\n            \r\n         ],\r\n         &quot;isInherited&quot;:true,\r\n         &quot;id&quot;:&quot;a897f2bd-bbbf-4efb-9a8e-000d1568bd96&quot;\r\n      },\r\n      {\r\n         &quot;isReadOnly&quot;:false,\r\n         &quot;isManageable&quot;:true,\r\n         &quot;isNew&quot;:false,\r\n         &quot;catalogId&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n         &quot;categoryId&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n         &quot;name&quot;:&quot;Weight_oz&quot;,\r\n         &quot;required&quot;:false,\r\n         &quot;dictionary&quot;:false,\r\n         &quot;multivalue&quot;:false,\r\n         &quot;multilanguage&quot;:false,\r\n         &quot;hidden&quot;:false,\r\n         &quot;valueType&quot;:&quot;Number&quot;,\r\n         &quot;type&quot;:&quot;Product&quot;,\r\n         &quot;values&quot;:[\r\n            \r\n         ],\r\n         &quot;attributes&quot;:[\r\n            \r\n         ],\r\n         &quot;displayNames&quot;:[\r\n            {\r\n               &quot;languageCode&quot;:&quot;de-DE&quot;\r\n            },\r\n            {\r\n               &quot;languageCode&quot;:&quot;en-US&quot;\r\n            }\r\n         ],\r\n         &quot;validationRules&quot;:[\r\n            \r\n         ],\r\n         &quot;isInherited&quot;:true,\r\n         &quot;id&quot;:&quot;13e822a6-9a07-4889-88df-52a3e7eef488&quot;\r\n      },\r\n      {\r\n         &quot;isReadOnly&quot;:false,\r\n         &quot;isManageable&quot;:true,\r\n         &quot;isNew&quot;:false,\r\n         &quot;catalogId&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n         &quot;categoryId&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n         &quot;name&quot;:&quot;Year_Released&quot;,\r\n         &quot;required&quot;:false,\r\n         &quot;dictionary&quot;:false,\r\n         &quot;multivalue&quot;:false,\r\n         &quot;multilanguage&quot;:false,\r\n         &quot;hidden&quot;:false,\r\n         &quot;valueType&quot;:&quot;Number&quot;,\r\n         &quot;type&quot;:&quot;Product&quot;,\r\n         &quot;values&quot;:[\r\n            \r\n         ],\r\n         &quot;attributes&quot;:[\r\n            \r\n         ],\r\n         &quot;displayNames&quot;:[\r\n            {\r\n               &quot;languageCode&quot;:&quot;de-DE&quot;\r\n            },\r\n            {\r\n               &quot;languageCode&quot;:&quot;en-US&quot;\r\n            }\r\n         ],\r\n         &quot;validationRules&quot;:[\r\n            \r\n         ],\r\n         &quot;isInherited&quot;:true,\r\n         &quot;id&quot;:&quot;6283167f-5f8f-4210-9612-790d9b2eefa0&quot;\r\n      }\r\n   ],\r\n   &quot;images&quot;:[\r\n      \r\n   ],\r\n   &quot;assets&quot;:[\r\n      \r\n   ],\r\n   &quot;links&quot;:[\r\n      \r\n   ],\r\n   &quot;variations&quot;:[\r\n      \r\n   ],\r\n   &quot;seoObjectType&quot;:&quot;CatalogProduct&quot;,\r\n   &quot;seoInfos&quot;:[\r\n      \r\n   ],\r\n   &quot;reviews&quot;:[\r\n      {\r\n         &quot;content&quot;:&quot;Updated quick description&quot;,\r\n         &quot;reviewType&quot;:&quot;QuickReview&quot;,\r\n         &quot;languageCode&quot;:&quot;en-US&quot;,\r\n         &quot;isInherited&quot;:false\r\n      }\r\n   ],\r\n   &quot;associations&quot;:[\r\n      \r\n   ],\r\n   &quot;referencedAssociations&quot;:[\r\n      \r\n   ],\r\n   &quot;outlines&quot;:[\r\n      {\r\n         &quot;items&quot;:[\r\n            {\r\n               &quot;id&quot;:&quot;4974648a41df4e6ea67ef2ad76d7bbd4&quot;,\r\n               &quot;seoObjectType&quot;:&quot;Catalog&quot;,\r\n               &quot;name&quot;:&quot;Electronics&quot;,\r\n               &quot;hasVirtualParent&quot;:false\r\n            },\r\n            {\r\n               &quot;id&quot;:&quot;0d4ad9bab9184d69a6e586effdf9c2ea&quot;,\r\n               &quot;seoObjectType&quot;:&quot;Category&quot;,\r\n               &quot;seoInfos&quot;:[\r\n                  \r\n               ],\r\n               &quot;name&quot;:&quot;Cell phones&quot;,\r\n               &quot;hasVirtualParent&quot;:false\r\n            },\r\n            {\r\n               &quot;id&quot;:&quot;3df8a98b-db6d-42d9-aa42-eb1d5099ce0c&quot;,\r\n               &quot;seoObjectType&quot;:&quot;CatalogProduct&quot;,\r\n               &quot;seoInfos&quot;:[\r\n                  \r\n               ],\r\n               &quot;name&quot;:&quot;QweDrink&quot;,\r\n               &quot;hasVirtualParent&quot;:false\r\n            }\r\n         ]\r\n      }\r\n   ],\r\n   &quot;isInherited&quot;:false,\r\n   &quot;createdDate&quot;:&quot;2021-08-19T13:35:15.3416684Z&quot;,\r\n   &quot;modifiedDate&quot;:&quot;2021-08-19T13:35:18.8500894Z&quot;,\r\n   &quot;createdBy&quot;:&quot;operator@mail.com&quot;,\r\n   &quot;modifiedBy&quot;:&quot;operator@mail.com&quot;\r\n}'</defaultValue>
      <description>the whole information about product</description>
      <id>4a85ce51-7e49-4b76-9f97-a25e9f4dff7a</id>
      <masked>false</masked>
      <name>body</name>
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
WS.verifyResponseStatusCode(response, 200)

</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

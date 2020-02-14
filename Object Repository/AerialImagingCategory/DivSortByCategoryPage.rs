<?xml version="1.0" encoding="UTF-8"?>
<WebElementEntity>
   <description></description>
   <name>DivSortByCategoryPage</name>
   <tag></tag>
   <elementGuidId>f797278c-b83f-44b7-921f-4eb91714f464</elementGuidId>
   <selectorCollection>
      <entry>
         <key>XPATH</key>
         <value>//body[@id='aerial-imaging-drones']/main/div/div/header/div</value>
      </entry>
   </selectorCollection>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>tag</name>
      <type>Main</type>
      <value>div</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>class</name>
      <type>Main</type>
      <value>section-header--right</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>
                
  Sort by
  
    Featured
    
    Alphabetically, A-Z
    Alphabetically, Z-A
    Price, low to high
    Price, high to low
    Date, new to old
    Date, old to new
  



  Shopify.queryParams = {};
  if (location.search.length) {
    for (var aKeyValue, i = 0, aCouples = location.search.substr(1).split('&amp;'); i &lt; aCouples.length; i++) {
      aKeyValue = aCouples[i].split('=');
      if (aKeyValue.length > 1) {
        Shopify.queryParams[decodeURIComponent(aKeyValue[0])] = decodeURIComponent(aKeyValue[1]);
      }
    }
  }

  $(function() {
    $('#sortBy')
      // select the current sort order
      .val('priority-descending;name-ascending')
      .bind('change', function() {
        Shopify.queryParams.sort_by = jQuery(this).val();
        location.search = jQuery.param(Shopify.queryParams).replace(/\+/g, '%20');
      }
    );
  });


                


  
    
  
  
    
  



  function replaceUrlParam(url, paramName, paramValue) {
    var pattern = new RegExp('('+paramName+'=).*?(&amp;|$)'),
        newUrl = url.replace(pattern,'$1' + paramValue + '$2');
    if ( newUrl == url ) {
      newUrl = newUrl + (newUrl.indexOf('?')>0 ? '&amp;' : '?') + paramName + '=' + paramValue;
    }
    return newUrl;
  }

  $(function() {
    $('.change-view').on('click', function() {
      if ($(this).hasClass('collection-view--active')) {
        return;
      }
      var view = $(this).data('view'),
          url = document.URL,
          hasParams = url.indexOf('?') > -1;

      if (hasParams) {
        window.location = replaceUrlParam(url, 'view', view);
      } else {
        window.location = url + '?view=' + view;
      }
    });
  });


                Filters

            </value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath</name>
      <type>Main</type>
      <value>id(&quot;aerial-imaging-drones&quot;)/main[@class=&quot;wrapper main-content&quot;]/div[@class=&quot;grid grid-border&quot;]/div[@class=&quot;grid-item large--four-fifths grid-border--left&quot;]/header[@class=&quot;section-header&quot;]/div[@class=&quot;section-header--right&quot;]</value>
   </webElementProperties>
   <webElementXpaths>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:idRelative</name>
      <type>Main</type>
      <value>//body[@id='aerial-imaging-drones']/main/div/div/header/div</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:neighbor</name>
      <type>Main</type>
      <value>(.//*[normalize-space(text()) and normalize-space(.)='Aerial Imaging &amp; Drones'])[2]/following::div[1]</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:position</name>
      <type>Main</type>
      <value>//div/header/div</value>
   </webElementXpaths>
</WebElementEntity>

<?xml version="1.0" encoding="UTF-8"?>
<WebElementEntity>
   <description></description>
   <name>SortByInside</name>
   <tag></tag>
   <elementGuidId>75c74a83-eef1-411a-9109-c248027e5db0</elementGuidId>
   <selectorCollection>
      <entry>
         <key>XPATH</key>
         <value>//body[@id='aerial-imaging-drones']/main/div/div[2]</value>
      </entry>
      <entry>
         <key>BASIC</key>
         <value>id(&quot;aerial-imaging-drones&quot;)/main[@class=&quot;wrapper main-content&quot;]/div[@class=&quot;grid grid-border&quot;]/div[@class=&quot;grid-item large--four-fifths grid-border--left&quot;][count(. | //*[@class = 'grid-item large--four-fifths grid-border--left']) = count(//*[@class = 'grid-item large--four-fifths grid-border--left'])]</value>
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
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>class</name>
      <type>Main</type>
      <value>grid-item large--four-fifths grid-border--left</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>

    
      Aerial Imaging &amp; Drones
      

        
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


      
    

     

      
         

           
    














    
        
            
                



                
                    
                

            
            
                3DR Solo Quadcopter (No Gimbal)
                
                    
                        
                    
                
                
            
            
                 
    
        
        
            
            




$995.99

        
    
    
    
     

            
        
    


        
         

           













    
        
            
                



                
                    
                

            
            
                3DR X8-M Octocopter for Visual-Spectrum Aerial Maps (915 MHz)
                
                    
                        
                    
                
                
            
            
                 
    
        
        
            
            




$5,400.00

        
    
    
    
     

            
        
    


        
         

           













    
        
            
                



                
                    
                

            
            
                DJI Phantom 3 Professional Quadcopter with 4K Camera and 3-Axis Gimbal
                
                    
                        
                    
                
                
            
            
                 
    
        
        
            
            




$1,259.00

        
    
    
    
     

            
        
    


        
         

           













    
        
            
                



                
                    
                

            
            
                DJI Spreading Wings S1000+ Professional Octocopter
                
                    
                        
                    
                
                
            
            
                 
    
        
        
            
            




$1,900.00

        
    
    
    
     

            
        
    


        
         

           













    
        
            
                



                
                    
                

            
            
                E-flite Carbon-Z Cub BNF Basic
                
                    
                        
                    
                
                
            
            
                 
    
        
        
            
            




$399.99

        
    
    
    
     

            
        
    


        
         

           













    
        
            
                



                
                    
                

            
            
                Parrot Jumping Sumo MiniDrone
                
                    
                        
                    
                
                
            
            
                 
    
        
        
            
            




$124.79

        
    
    
    
     

            
        
    


        
         

           













    
        
            
                



                
                    
                

            
            
                Walkera TALI H500 Hexacopter
                
                    
                        
                    
                
                
            
            
                 
    
        
        
            
            




$1,399.00

        
    
    
    
     

            
        
    


        
         

           













    
        
            
                



                
                    
                        
                    
                

            
            
                testproduct
                
                    
                        
                    
                
                
            
            
                 
    
        
        
            
            




$100.00

        
    
    
    
     

            
        
    


        
         

           













    
        
            
                



                
                    
                

            
            
                xFold CINEMA X12 RTF U7
                
                    
                        
                    
                
                
            
            
                 
    
        
        
            
            




$23,638.00

        
    
    
    
     

            
        
    


        
         
               

    

  </value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath</name>
      <type>Main</type>
      <value>id(&quot;aerial-imaging-drones&quot;)/main[@class=&quot;wrapper main-content&quot;]/div[@class=&quot;grid grid-border&quot;]/div[@class=&quot;grid-item large--four-fifths grid-border--left&quot;]</value>
   </webElementProperties>
   <webElementXpaths>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:idRelative</name>
      <type>Main</type>
      <value>//body[@id='aerial-imaging-drones']/main/div/div[2]</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:position</name>
      <type>Main</type>
      <value>//main/div/div[2]</value>
   </webElementXpaths>
</WebElementEntity>

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as Globals

WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Search/indexWithoutDeleting'))

// Delay to prevent getting 404 from SearchModule

WebUI.comment('Waiting for build index 10 sec')
WS.delay(10)

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as Globals

WS.sendRequestAndVerify(findTestObject('Object Repository/API/backWebServices/indexWithoutDeleting'))

WebUI.comment('Waiting for drop index 3 sec')

WS.delay(Globals.indexDelay)

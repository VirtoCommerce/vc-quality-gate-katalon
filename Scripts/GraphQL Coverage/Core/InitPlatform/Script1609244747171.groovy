import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Build index
WebUI.callTestCase(findTestCase('API Coverage/backend/BuildIndex'), [ : ], FailureHandling.STOP_ON_FAILURE)

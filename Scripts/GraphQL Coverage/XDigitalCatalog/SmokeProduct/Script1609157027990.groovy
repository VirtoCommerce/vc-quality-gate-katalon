import internal.GlobalVariable as Globals
import services.GQL as GQL
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

GQL gql = new GQL()
def query = "{\"query\":\"{ product(id: \\\"${Globals.productId}\\\", storeId: \\\"${Globals.storeId}\\\", cultureName: \\\"${Globals.gql_cultureName}\\\", currencyCode: \\\"${Globals.gql_currencyCode}\\\") { id }}\"}"
gql.sendRequest(query)

// Get payload 
def payload = gql.verifyPayloadContainsData()

// Extraction path
def jsonFieldName = "data.product.id"

get = { field, json -> field.tokenize(".").inject(json) { map, f -> map[f] }}

id = get jsonFieldName, payload

// Check if payload contains information about requested product
assert id == "${Globals.productId}"

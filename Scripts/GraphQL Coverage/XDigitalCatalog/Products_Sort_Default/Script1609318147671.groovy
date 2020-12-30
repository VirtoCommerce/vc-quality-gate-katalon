import internal.GlobalVariable as Globals
import services.GQL as GQL
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Arrange
def after = "0"
def first = 10
def storeId = Globals.storeId
def currencyCode = Globals.gql_currencyCode
def queryString = "Octocopter"

// Todo: move to QueryBuilder
def queryHeader = "after: \\\"${after}\\\", first: ${first}, storeId: \\\"${storeId}\\\", currencyCode: \\\"${currencyCode}\\\", query: \\\"${queryString}\\\""
def includedFields = "items { code id name } totalCount"
def query = "{\"query\":\"{ products(${queryHeader}) { ${includedFields} }}\"}"

// Act
GQL gql = new GQL()
gql.sendRequest(query)

// Assert
// Get payload 
def payload = gql.verifyPayloadContainsData()

// Extraction path
// Todo: move to response incapsulation
def jsonFieldName = "data.products.items"
get = { field, json -> field.tokenize(".").inject(json) { map, f -> map[f] }} 
itemName = get jsonFieldName, payload

// Check if payload contains information about requested product
assert itemName[0].name == "3DR X8-M Octocopter for Visual-Spectrum Aerial Maps (915 MHz)"

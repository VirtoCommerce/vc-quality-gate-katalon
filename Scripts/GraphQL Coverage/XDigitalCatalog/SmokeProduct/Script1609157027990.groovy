import internal.GlobalVariable as Globals
import services.GQL as GQL

GQL gql = new GQL()
def query = "{\"query\":\"{ product(id: \\\"${Globals.productId}\\\", storeId: \\\"${Globals.storeId}\\\", cultureName: \\\"${Globals.gql_cultureName}\\\", currencyCode: \\\"${Globals.gql_currencyCode}\\\") { id }}\"}"
def response = gql.sendRequest(query)
gql.verifyPayloadContainsData()
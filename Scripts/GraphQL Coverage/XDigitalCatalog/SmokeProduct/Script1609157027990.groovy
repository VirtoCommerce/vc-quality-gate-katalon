import internal.GlobalVariable as GlobalVariable
import services.GQL as GQL

GQL gql = new GQL(GlovalVariable.urlBack)
def response = gql.sendRequest("{\"query\":{product(id: \"${GlobalVariable.productId}\", storeId: \"${GlobalVariable.storeId}\", cultureName: \"${GlobalVariable.gql_cultureName}\", currencyCode: \"${GlobalVariable.gql_currencyCode}\"){id}}")
gql.verifyPayloadContainsData()
import groovy.json.JsonSlurper
import services.GQL as GQL

// Arrange
def includedFields = "__schema { __typename }"
def query = "{\"query\":\"{ ${includedFields} }\"}"

// Act
GQL gql = new GQL()
gql.sendRequest(query)

// Assert
gql.verifyStatusCode(200)
def response = gql.getResponse()

// Check if errors not defined in payload
def responseText = response.body().string()
def payload = (new JsonSlurper()).parseText(responseText)
assert payload.errors == null

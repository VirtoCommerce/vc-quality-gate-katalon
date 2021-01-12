package services
import com.kms.katalon.core.annotation.Keyword
import groovy.json.JsonSlurper
import internal.GlobalVariable as Globals
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response

/**
 * GraphQL entry point for all requests to GraphQL server.
 * Contains logic to send requests and verify responses.
 */
public class GQL {
	public String url
	Response response

	/**
	 * Default constructor.
	 */
	public GQL(){
		def platformUrl = Globals.urlBack
		this.url = platformUrl.substring(0, platformUrl.length() - (platformUrl.endsWith("/") ? 1 : 0)) + '/graphql'
	}

	/**
	 * Send request to GraphQl server.
	 */
	@Keyword
	def sendRequest(String query){
		OkHttpClient client = new OkHttpClient()
		MediaType mediaType = MediaType.parse("application/json")
		RequestBody body = RequestBody.create(mediaType, query)

		println(query)

		Request request = new Request.Builder()
				.url(this.url)
				.post(body)
				.build()
		response = client.newCall(request).execute()
	}

	/**
	 * Check if status code exactly the same of response of GraphQL request.
	 * Use after sending request.
	 */
	@Keyword
	def verifyStatusCode(int statusCode){
		assert response.code == statusCode
	}

	/**
	 * Check if JSON response of GraphQL request contains proper structure.
	 * Use after sending request. !!Caution - do not verify twice on the same request. 
	 */
	@Keyword
	def verifyPayloadContainsData(){
		def responseText = response.body().string()
		JsonSlurper parser = new JsonSlurper()
		def payload = parser.parseText(responseText)
		assert payload.data != null
		return payload
	}
}
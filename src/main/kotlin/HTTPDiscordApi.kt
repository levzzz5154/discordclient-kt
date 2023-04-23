import com.google.gson.Gson
import com.google.gson.JsonObject
import requests.GetGateway
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class HTTPDiscordApi(val dcClient: DiscordClient) {
    private val httpClient: HttpClient = HttpClient.newHttpClient()
    private val gson = Gson()

    fun getGateway(): GetGateway {
        val request = HttpRequest.newBuilder(URI("${dcClient.baseEndpoint}/gateway"))
            .GET()
            .build()
        val jsonResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString())
        return gson.fromJson(jsonResponse.body(), GetGateway::class.java)
    }

    fun createMessage(channelId: String, content: String): String {
        val json = JsonObject()
        json.addProperty("content", content)

        val request = HttpRequest.newBuilder(URI("${dcClient.baseEndpoint}/channels/${channelId}/messages"))
            .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(json)))
            .header("Content-Type", "application/json")
            .header("Authorization", dcClient.token)
            .header("User-Agent", "DiscordBot (angles.tech, 9)")
            .build()
        val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())
        return response.body()
    }
}
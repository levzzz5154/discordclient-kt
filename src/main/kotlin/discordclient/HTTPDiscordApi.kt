package discordclient

import com.google.gson.Gson
import com.google.gson.JsonObject
import discordclient.requests.GetGatewayResponse
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class HTTPDiscordApi(val dcClient: DiscordClient) {
    private val httpClient: HttpClient = HttpClient.newHttpClient()
    private val gson = Gson()

    fun getGateway(): String {
        val request = HttpRequest.newBuilder(URI("${dcClient.baseEndpoint}/gateway"))
            .GET()
            .build()
        val jsonResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString())
        return gson.fromJson(jsonResponse.body(), GetGatewayResponse::class.java).url
    }

    fun createMessage(channelId: String, content: String): Message {
        val json = JsonObject()
        json.addProperty("content", content)

        val request = HttpRequest.newBuilder(URI("${dcClient.baseEndpoint}/channels/${channelId}/messages"))
            .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(json)))
            .header("Content-Type", "application/json")
            .header("Authorization", dcClient.token)
            .header("User-Agent", "DiscordBot (angles.tech, 9)")
            .build()
        val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())
        return gson.fromJson(response.body(), Message::class.java)
    }

    fun editMessage(channelId: String, messageId: String, content: String): Message {
        val json = JsonObject()
        json.addProperty("content", content)

        val request = HttpRequest.newBuilder(URI("${dcClient.baseEndpoint}/channels/$channelId/messages/$messageId"))
            .method("PATCH", HttpRequest.BodyPublishers.ofString(gson.toJson(json)))
            .header("Content-Type", "application/json")
            .header("Authorization", dcClient.token)
            .header("User-Agent", "DiscordBot (angles.tech, 9)")
            .build()
        val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())
        return gson.fromJson(response.body(), Message::class.java)
    }

    fun deleteMessage(channelId: String, messageId: String): Boolean {
        val request = HttpRequest.newBuilder(URI("${dcClient.baseEndpoint}/channels/$channelId/messages/$messageId"))
            .method("DELETE", HttpRequest.BodyPublishers.noBody())
            .header("Authorization", dcClient.token)
            .header("User-Agent", "DiscordBot (angles.tech, 9)")
            .build()
        val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())
        return response.statusCode() == 204
    }
}
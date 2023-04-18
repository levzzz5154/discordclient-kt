package requests

import java.net.URI
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class GetGateway : DiscordRequest<GetGateway>() {
    lateinit var url: String
    override fun run(baseURL: String): GetGateway {
        val request = HttpRequest.newBuilder(URI("$baseURL/gateway"))
            .GET()
            .build()
        val jsonResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString())
        return deserializeSelf(jsonResponse.body())
    }
}
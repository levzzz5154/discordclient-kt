package requests

import java.net.URI
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class GetGateway : DiscordRequest() {
    lateinit var url: String
}
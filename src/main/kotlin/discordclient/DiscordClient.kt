package discordclient

import com.google.gson.GsonBuilder
import jakarta.websocket.Session
import org.glassfish.tyrus.client.ClientManager
import discordclient.wsevents.client.ConnProperties
import discordclient.wsevents.client.IdData
import discordclient.wsevents.client.Identify
import discordclient.wsevents.server.Ready
import java.net.URI

class DiscordClient(val token: String, val eventHandler: EventHandler) {
    val apiVersion = "9"
    val baseEndpoint = "https://discord.com/api/v$apiVersion"
    var gatewayURL = ""

    private var session: Session? = null
    private var client: ClientManager? = null
    private var handler: WebSocketHandler = WebSocketHandler(this)
    var API: HTTPDiscordApi = HTTPDiscordApi(this)

    var readyState: Ready? = null

    init {
        gatewayURL = "${API.getGateway()}/?v=$apiVersion&encoding=json"

        println(gatewayURL)
        val client = ClientManager.createClient()
        val session = client.asyncConnectToServer(handler, URI(gatewayURL)).get()
        val gson = GsonBuilder().create()

        Thread.sleep(2000)
        val identifyEvent = Identify(
            IdData(
            token,
            ConnProperties("Windows", "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36", "Windows NT 10.0; Win64; x64"),
            null, null, null, null,
            131071
        ))
        session.basicRemote.sendText(gson.toJson(identifyEvent))

        while (session.isOpen) {
            Thread.sleep(1000)
        }
    }
}
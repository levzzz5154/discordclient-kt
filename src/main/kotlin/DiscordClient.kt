import com.google.gson.GsonBuilder
import jakarta.websocket.Session
import org.glassfish.tyrus.client.ClientManager
import requests.GetGateway
import wsevents.client.ConnProperties
import wsevents.client.Heartbeat
import wsevents.client.IdData
import wsevents.client.Identify
import java.net.URI

class DiscordClient(val token: String) {
    val apiVersion = "9"
    val baseEndpoint = "https://discord.com/api/v$apiVersion"
    var gatewayURL = ""

    private var session: Session? = null
    private var client: ClientManager? = null
    private var handler: WebSocketHandler? = null

    init {
        gatewayURL = "${GetGateway().run(baseEndpoint).url}/?v=$apiVersion&encoding=json"

        println(gatewayURL)
        val client = ClientManager.createClient()
        handler = WebSocketHandler(this)
        val session = client.asyncConnectToServer(handler, URI(gatewayURL)).get()
        val gson = GsonBuilder().create()

        Thread.sleep(2000)
        val identifyEvent = Identify(IdData(
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
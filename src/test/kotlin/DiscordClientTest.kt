import com.google.gson.Gson
import org.junit.jupiter.api.Test
import requests.GetGateway
import wsevents.client.ConnProperties
import wsevents.client.IdData
import wsevents.client.Identify
import wsevents.server.GuildCreate
import wsevents.server.MessageCreate
import wsevents.server.Ready

class DiscordClientTest {
    val apiVersion = "9"
    val baseEndpoint = "https://discord.com/api/v$apiVersion"
    @Test
    fun getGateway() {
        val gatewayURL = GetGateway().run(baseEndpoint).url
        println(gatewayURL)
    }

    @Test
    fun mainTest() {
        val token = "MTA5NzkxMzE4OTIxNzM1MzgwOA.Gj3IH3.shNt9hAqU42FoyL3fhsyAOj1Z3qrQ_I_wnGvqs"
        println("testink")
        val client = DiscordClient(token, object : EventHandler() {
            override fun onReady(event: Ready) {
                println("ready or something")
            }
            override fun onGuildCreate(event: GuildCreate) {
                println("some guild was created Lol")
            }
            override fun onMessageCreate(event: MessageCreate) {

            }
        })
    }

    @Test
    fun jsonTest() {
        val ident = Identify(IdData("my bot toekn",
            ConnProperties("insaneos", "chromium or something", "a pregnancy test"),
            null, null, null, null,
            50085))
        println(Gson().toJson(ident))
    }
}
import com.google.gson.Gson
import org.junit.jupiter.api.Test
import requests.GetGateway
import wsevents.client.ConnProperties
import wsevents.client.IdData
import wsevents.client.Identify
import wsevents.server.*

class DiscordClientTest {
    @Test
    fun mainTest() {
        //val token = "MTA5NzkxMzE4OTIxNzM1MzgwOA.Gj3IH3.shNt9hAqU42FoyL3fhsyAOj1Z3qrQ_I_wnGvqs" //bot
        val token = "MTA5ODU5MTA2ODIzNDE4NjgzMw.GQzxmS.OLA3R7HjaKDlv8bOx2AL2JbrG4hAR3Hj-89K00" // user
        println("testink")
        val client = DiscordClient(token, object : EventHandler() {
            override fun onReady(event: ReadyData, client: DiscordClient) {
                println("ready or something")
            }
            override fun onGuildCreate(event: GuildCreateData, client: DiscordClient) {
                println("some guild was created Lol")
            }
            override fun onMessageCreate(event: MessageCreateData, client: DiscordClient) {
                if (event.author.id == "1098591068234186833") {
                    return
                }
                client.API.createMessage(event.channel_id, "your msg: ${event.content}")
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
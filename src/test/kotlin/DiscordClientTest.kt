import com.google.gson.Gson
import discordclient.DiscordClient
import discordclient.EventHandler
import discordclient.Message
import org.junit.jupiter.api.Test
import discordclient.wsevents.client.ConnProperties
import discordclient.wsevents.client.IdData
import discordclient.wsevents.client.Identify

class DiscordClientTest {
    @Test
    fun mainTest() {
        //val token = "MTA5NzkxMzE4OTIxNzM1MzgwOA.Gj3IH3.shNt9hAqU42FoyL3fhsyAOj1Z3qrQ_I_wnGvqs" //bot
        val leMap = mutableMapOf<String, Message>()
        val token = "MTA5ODU5MTA2ODIzNDE4NjgzMw.GQzxmS.OLA3R7HjaKDlv8bOx2AL2JbrG4hAR3Hj-89K00" // user
        println("testink")
        val client = DiscordClient(token, EventHandler(
            onReady = { _, _ ->
                println("ready")
            },
            onGuildCreate = { event, client ->
                println("some guild was created Lol")
            },
            onMessageCreate = { event, client ->
                if (event.author.id == "1098591068234186833") {
                    return@EventHandler
                }
                val message = client.API.createMessage(event.channel_id, "your msg: ${event.content}")
                leMap[event.id] = message
                if (leMap.size > 5) leMap.clear()
            },
            onMessageUpdate = { event, client ->
                if (event.author.id == "1098591068234186833") {
                    return@EventHandler
                }
                if (leMap[event.id] != null) {
                    val message = client.API.editMessage(event.channel_id, leMap[event.id]!!.id,"you edited it to: ${event.content}")
                    return@EventHandler
                }
                val message = client.API.createMessage(event.channel_id, "you edited your message to: ${event.content}")
            },
        ))

    }

    @Test
    fun jsonTest() {
        val ident = Identify(
            IdData("my bot toekn",
            ConnProperties("insaneos", "chromium or something", "a pregnancy test"),
            null, null, null, null,
            50085)
        )
        println(Gson().toJson(ident))
    }
}
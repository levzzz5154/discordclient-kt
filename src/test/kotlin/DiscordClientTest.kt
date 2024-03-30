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
        val leMap = mutableMapOf<String, Message>()
        val token = "" // put yuor token here
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
                if (event.content.contains("react to this")) {
                    println("status code: ${client.API.createReaction(event.channel_id, event.id, "🍕")}")
                }
                val message = client.API.createMessage(event.channel_id, "your msg: ${event.content}")
                leMap[event.id] = message
                if (leMap.size > 10) leMap.clear()
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
            onMessageDelete = { event, client ->
                var replyString = "msg deleted, id: ${event.id}"
                if (leMap[event.id] != null) {
                    replyString += ", content: ${leMap[event.id]!!.content}"
                }
                client.API.createMessage(event.channel_id, replyString)
            }
        ))

    }

    @Test
    fun jsonTest() {
        val ident = Identify(
            IdData("my bot toekn",
            ConnProperties("insaneos", "chromium or something", "a microwave"),
            null, null, null, null,
            50085)
        )
        println(Gson().toJson(ident))
    }
}
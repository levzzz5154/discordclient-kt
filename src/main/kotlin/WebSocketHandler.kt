import com.google.gson.GsonBuilder
import jakarta.websocket.*
import wsevents.client.Heartbeat
import wsevents.server.*
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit
import kotlin.random.Random


@ClientEndpoint
class WebSocketHandler(val dcClient: DiscordClient) {
    var lastSequence: Int? = null
    var gson = GsonBuilder().serializeNulls().create()
    var scheduledExecutor = Executors.newSingleThreadScheduledExecutor()
    var heartbeatFuture: ScheduledFuture<*>? = null

    @OnOpen
    fun onOpen(clientSession: Session) {
        println("--- Connection Successful: " + clientSession.id)
    }

    @OnMessage
    fun onMessage(clientMessage: String, clientSession: Session?) {
        println("--- Received: $clientMessage")
        val leEvent = gson.fromJson(clientMessage, ServerEvent::class.java)

        when (leEvent.opcode) {
            10 -> {
                val wrapper = gson.fromJson(clientMessage, Hello::class.java)

                heartbeatFuture?.cancel(true)
                heartbeatFuture = scheduledExecutor.scheduleAtFixedRate({
                    if (!clientSession!!.isOpen) {
                        heartbeatFuture!!.cancel(true)
                        return@scheduleAtFixedRate
                    }
                    clientSession.basicRemote.sendText(gson.toJson(Heartbeat(lastSequence)))
                    println("sent heartbeat to dc, d = $lastSequence")
                }, Random.nextLong(1, 5000), wrapper.data.heartbeat_interval.toLong(), TimeUnit.MILLISECONDS)
            }
            0 -> {
                handleNamedEvent(leEvent, clientMessage)
            }
        }
        lastSequence = leEvent.sequenceNumber
    }

    fun handleNamedEvent(event: ServerEvent<*>, jsonEvent: String) {
        if (event.type == null) return
        when (event.type) {
            "READY" -> {
                val wrapper = gson.fromJson(jsonEvent, Ready::class.java)
                dcClient.readyState = wrapper
                dcClient.eventHandler.onReady(wrapper.data, dcClient)
            }
            "GUILD_CREATE" -> {
                val wrapper = gson.fromJson(jsonEvent, GuildCreate::class.java)
                dcClient.eventHandler.onGuildCreate(wrapper.data, dcClient)
            }
            "MESSAGE_CREATE" -> {
                val wrapper = gson.fromJson(jsonEvent, MessageCreate::class.java)
                dcClient.eventHandler.onMessageCreate(wrapper.data, dcClient)
            }
        }
    }

    @OnClose
    fun onClose(clientSession: Session, closeReason: CloseReason) {
        println("--- Session ID: " + clientSession.id)
        println("--- Closing Reason: $closeReason")
    }

    @OnError
    fun error(session: Session, t: Throwable?) {
        if (t != null) {
            println("Error on session: " + t.message)
        }
    }
}
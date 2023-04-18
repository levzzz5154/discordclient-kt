import com.google.gson.GsonBuilder
import jakarta.websocket.*
import wsevents.client.Heartbeat
import wsevents.server.Hello
import wsevents.server.ServerEvent
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit
import kotlin.random.Random


@ClientEndpoint
class WebSocketHandler(val dcClient: DiscordClient) {
    var lastPayload: Int? = null
    var gson = GsonBuilder().serializeNulls().create()
    var scheduledExecutor = Executors.newSingleThreadScheduledExecutor()
    var heartbeatFuture: ScheduledFuture<*>? = null
    @OnOpen
    fun onOpen(clientSession: Session) {
        println("--- Connection Successful " + clientSession.id)

    }

    @OnMessage
    fun onMessage(clientMessage: String, clientSession: Session?) {
        println("--- Message Received $clientMessage")
        val leEvent = gson.fromJson(clientMessage, ServerEvent::class.java)
        when (leEvent.op) {
            10 -> {
                val wrapper = gson.fromJson(clientMessage, Hello::class.java)

                heartbeatFuture?.cancel(true)
                heartbeatFuture = scheduledExecutor.scheduleAtFixedRate({
                    if (!clientSession!!.isOpen) {
                        heartbeatFuture!!.cancel(true)
                        return@scheduleAtFixedRate
                    }
                    clientSession.basicRemote.sendText(gson.toJson(Heartbeat(lastPayload)))
                    println("sent heartbeat to dc, d = $lastPayload")
                }, Random.nextLong(1, 5000), wrapper.d.heartbeat_interval.toLong(), TimeUnit.MILLISECONDS)
            }
        }
        lastPayload = leEvent.s
    }

    @OnClose
    fun onClose(clientSession: Session, closeReason: CloseReason) {
        println("--- Session ID: " + clientSession.id)
        println("--- Closing Reason: $closeReason")
    }

    @OnError
    fun error(session: Session, t: Throwable?) {
        println("Error on session " + session.id)
    }
}
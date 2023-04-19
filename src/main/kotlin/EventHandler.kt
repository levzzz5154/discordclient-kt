import wsevents.server.GuildCreate
import wsevents.server.MessageCreate
import wsevents.server.Ready

abstract class EventHandler {
    abstract fun onReady(event: Ready)
    abstract fun onGuildCreate(event: GuildCreate)

    abstract fun onMessageCreate(event: MessageCreate)
}
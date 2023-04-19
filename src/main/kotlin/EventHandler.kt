import wsevents.server.Ready

abstract class EventHandler {
    abstract fun onReady(event: Ready)
    /*abstract fun onMessageCreate(event: MessageCreate)
    abstract fun onGuildCreate(event: GuildCreate)*/
}
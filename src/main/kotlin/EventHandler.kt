import wsevents.server.*

abstract class EventHandler {
    abstract fun onReady(event: ReadyData, client: DiscordClient)
    abstract fun onGuildCreate(event: GuildCreateData, client: DiscordClient)
    abstract fun onMessageCreate(event: MessageCreateData, client: DiscordClient)
}
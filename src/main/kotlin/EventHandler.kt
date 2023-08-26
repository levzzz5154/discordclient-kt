import wsevents.server.GuildCreateData
import wsevents.server.MessageCreateData
import wsevents.server.MessageUpdateData
import wsevents.server.ReadyData

class EventHandler(
    val onReady: (ReadyData, DiscordClient) -> Unit = { _, _ -> },
    val onGuildCreate: (GuildCreateData, DiscordClient) -> Unit = { _, _ -> },
    val onMessageCreate: (MessageCreateData, DiscordClient) -> Unit = { _, _ -> },
    val onMessageUpdate: (MessageUpdateData, DiscordClient) -> Unit = { _, _ -> },
)
package discordclient

import discordclient.wsevents.server.GuildCreateData
import discordclient.wsevents.server.MessageCreateData
import discordclient.wsevents.server.MessageUpdateData
import discordclient.wsevents.server.ReadyData

class EventHandler(
    val onReady: (ReadyData, DiscordClient) -> Unit = { _, _ -> },
    val onGuildCreate: (GuildCreateData, DiscordClient) -> Unit = { _, _ -> },
    val onMessageCreate: (MessageCreateData, DiscordClient) -> Unit = { _, _ -> },
    val onMessageUpdate: (MessageUpdateData, DiscordClient) -> Unit = { _, _ -> },
)
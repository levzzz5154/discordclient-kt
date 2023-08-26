package discordclient

import discordclient.wsevents.server.*

class EventHandler(
    val onReady: (ReadyData, DiscordClient) -> Unit = { _, _ -> },
    val onGuildCreate: (GuildCreateData, DiscordClient) -> Unit = { _, _ -> },
    val onMessageCreate: (MessageCreateData, DiscordClient) -> Unit = { _, _ -> },
    val onMessageUpdate: (MessageUpdateData, DiscordClient) -> Unit = { _, _ -> },
    val onMessageDelete: (MessageDeleteData, DiscordClient) -> Unit = { _, _ -> },
)
package discordclient.wsevents.server

class MessageDelete(d: MessageDeleteData) : ServerEvent<MessageDeleteData>(10, d, null, "MESSAGE_DELETE") {
}

class MessageDeleteData(
    val id: String,
    val channel_id: String,
    val guild_id: String?
)
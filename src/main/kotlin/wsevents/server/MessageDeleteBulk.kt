package wsevents.server

class MessageDeleteBulk(d: MessageDeleteBulkData) : ServerEvent<MessageDeleteBulkData>(10, d, null, "MESSAGE_DELETE") {
}

class MessageDeleteBulkData(
    val id: String,
    val channel_id: String,
    val guild_id: String?
)
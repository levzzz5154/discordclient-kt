package wsevents.server

class GuildCreate(d: GuildCreateData) : ServerEvent<GuildCreateData>(0, d, null, "GUILD_CREATE") {
}

class GuildCreateData(
    val joined_at: String,
    val large: Boolean,
    val unavailable: Boolean,
    val member_count: Int,
    // todo: not yet fully implemented
)
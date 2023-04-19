package wsevents.server

import java.awt.Color

class Ready(d: ReadyData, s: Int?) : ServerEvent<ReadyData>(0, d, s, "READY") {
}

class ReadyData(
    val v: Int,
    val user: DiscordUser,
    val guilds: Array<PartialGuild>,
    val session_id: String,
    val resume_gateway_url: String,
    val shard: Array<Int>?,
    val application: PartialApplication
)
class DiscordUser(
    var id: Snowflake,
    val username: String,
    val discriminator: Discrim,
    val avatar: String?,
    val bot: Boolean?,
    val system: Boolean?,
    val mfa_enabled: Boolean?,
    val banner: String?,
    val accent_color: Int?,
    val locale: String?,
    val verified: Boolean?,
    val email: String?,
    val flags: Int?,
    val premium_type: Int?,
    val public_flags: Int?,
)
class PartialGuild(
    val id: Snowflake,
    val unavailable: Boolean,
)
class GuildPreview(
    val id: Snowflake,
    val name: String,
    val icon: String?,
    val splash: String?,
    val discovery_splash: String?,
    val emojis: Array<Emoji>,
    val features: Array<String>,
    val approximate_member_count: Int,
    val approximate_presence_count: Int,
    val description: String?,
    val stickers: Array<Sticker>,
)
class PartialApplication
class Emoji(
    val id: Snowflake?,
    val name: String?,
    /*val roles: */
)
class Role(
    val id: Snowflake,
    val name: String,
    val color: IntColor,
    val hoist: Boolean,
    val icon: String?,
    val unicode_emoji: String?,
    val position: Int,
    val permissions: String,
    val managed: Boolean,
    val mentionable: Boolean,
    val tags: RoleTags
)
class RoleTags(
    // TODO: implement this bs
)
@JvmInline
value class IntColor(val hexValue: Int) {
    fun toColor(): Color = Color(hexValue)
}
class Sticker(
    val id: Snowflake,
    val pack_id: Snowflake?,
    val name: String,
    val description: String?,
    val tags: String,
    val type: Int,
    val format_type: Int,
    val available: Boolean?,
    val guild_id: Snowflake?,
    val user: DiscordUser?,
    val sort_value: Int?
)

@JvmInline
value class Snowflake(val s: String)
@JvmInline
value class Discrim(val s: String)
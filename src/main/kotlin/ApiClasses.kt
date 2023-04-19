import java.awt.Color

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
class PartialMember(
    val nick: String?,
    val avatar: String?,
    val roles: Array<Snowflake>,
    val joined_at: String,
    val premium_since: String?,
    val deaf: Boolean,
    val mute: Boolean,
    val flags: Int,
    val pending: Boolean?,
    val communication_disabled_until: String?,
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
class PartialApplication(
    val id: Snowflake,
    val flags: Int?,
)
class Emoji(
    val id: Snowflake?,
    val name: String?,
    val roles: Array<Role>?,
    val user: DiscordUser?,
    val require_colons: Boolean?,
    val managed: Boolean?,
    val animated: Boolean?,
    val available: Boolean?
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
    val tags: RoleTags?
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

class Relationship(
    // todo: implement this bs
)

open class Message(
    val id: Snowflake,
    val channel_id: Snowflake,
    val author: DiscordUser,
    val content: String,
    val timestamp: String,
    val edited_timestamp: String?,
    val tts: Boolean,
    val mention_everyone: Boolean,
    val mentions: Array<DiscordUser>,
    val mention_roles: Array<Snowflake>,
    val mention_channels: Array<ChannelMention>,
    val attachments: Array<Attachment>?,
    val embeds: Array<Embed>?,
    val reactions: Array<Reaction>?,
    val nonce: String?,
    val pinned: Boolean?,
    val webhook_id: Snowflake?,
    val type: Int,
    val activity: MessageActivity?,
    val application: PartialApplication?,
    val application_id: Snowflake?,
    val message_reference: MessageReference?,
    val flags: Int,
    val referenced_message: Message?,
    val interaction: MessageInteraction?,
    //val thread: Channel?,
    //val components: Array<MessageComponent>,
    //val sticker_items: Array<PartialSticker>,
    val stickers: Array<Sticker>,
    val position: Int,
    //val role_subscription_data: RoleSubscriptionData?,
)

class MessageInteraction(
    val id: Snowflake,
    val type: Int,
    val name: String,
    val user: DiscordUser,
    //val member: PartialMember,
)
class MessageReference(
    val message_id: Snowflake?,
    val channel_id: Snowflake?,
    val guild_id: Snowflake?,
    val fail_if_not_exists: Boolean?
)

class MessageActivity(
    val type: Int,
    val party_id: String?
)

class Reaction(
    val count: Int,
    val me: Boolean,
    val emoji: Emoji
)

class Attachment(
    val id: Snowflake,
    val filename: String,
    val description: String?,
    val content_type: String?,
    val size: Int,
    val url: String,
    val proxy_url: String,
    val height: Int?,
    val width: Int?,
    val ephemeral: Boolean?
)
class ChannelMention(
    val id: Snowflake,
    val guild_id: Snowflake,
    val type: Int,
    val name: String
)

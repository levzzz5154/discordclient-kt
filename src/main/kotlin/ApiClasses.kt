import java.awt.Color

class DiscordUser(
    var id: String,
    val username: String,
    val discriminator: String,
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
    val roles: Array<String>,
    val joined_at: String,
    val premium_since: String?,
    val deaf: Boolean,
    val mute: Boolean,
    val flags: Int,
    val pending: Boolean?,
    val communication_disabled_until: String?,
)

class PartialGuild(
    val id: String,
    val unavailable: Boolean,
)
class GuildPreview(
    val id: String,
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
    val id: String,
    val flags: Int?,
)
class Emoji(
    val id: String?,
    val name: String?,
    val roles: Array<Role>?,
    val user: DiscordUser?,
    val require_colons: Boolean?,
    val managed: Boolean?,
    val animated: Boolean?,
    val available: Boolean?
)
class Role(
    val id: String,
    val name: String,
    val color: Int,
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
class Sticker(
    val id: String,
    val pack_id: String?,
    val name: String,
    val description: String?,
    val tags: String,
    val type: Int,
    val format_type: Int,
    val available: Boolean?,
    val guild_id: String?,
    val user: DiscordUser?,
    val sort_value: Int?
)

class Relationship(
    // todo: implement this bs
)

open class Message(
    val id: String,
    val channel_id: String,
    val author: DiscordUser,
    val content: String,
    val timestamp: String,
    val edited_timestamp: String?,
    val tts: Boolean,
    val mention_everyone: Boolean,
    val mentions: Array<DiscordUser>,
    val mention_roles: Array<String>,
    val mention_channels: Array<ChannelMention>,
    val attachments: Array<Attachment>?,
    val embeds: Array<Embed>?,
    val reactions: Array<Reaction>?,
    val nonce: String?,
    val pinned: Boolean?,
    val webhook_id: String?,
    val type: Int,
    val activity: MessageActivity?,
    val application: PartialApplication?,
    val application_id: String?,
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
    val id: String,
    val type: Int,
    val name: String,
    val user: DiscordUser,
    //val member: PartialMember,
)
class MessageReference(
    val message_id: String?,
    val channel_id: String?,
    val guild_id: String?,
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
    val id: String,
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
    val id: String,
    val guild_id: String,
    val type: Int,
    val name: String
)

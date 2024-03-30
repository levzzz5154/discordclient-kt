package discordclient

import discordclient.apiclasses.Activity
import com.google.gson.TypeAdapter
import com.google.gson.annotations.JsonAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.*


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

class GuildMember(
    val user: DiscordUser,
    val nick: String?,
    val avatar: String?,
    val roles: Array<String>,
    val joined_at: String,
    val premium_since: String?,
    val deaf: Boolean,
    val mute: Boolean,
    val flags: Int,
    val pending: Boolean?,
    val permissions: String?,
    val communication_disabled_until: String?,
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
) {
    fun getPremiumSince(): Date? {
        val tempAccessor = DateTimeFormatter.ISO_INSTANT.parse(premium_since)
        val instant = Instant.from(tempAccessor)
        return Date.from(instant)
    }
    fun getMutedUntil(): Date? {
        val tempAccessor = DateTimeFormatter.ISO_INSTANT.parse(communication_disabled_until)
        val instant = Instant.from(tempAccessor)
        return Date.from(instant)
    }
}
class VoiceState(
    val guild_id: String?,
    val channel_id: String?,
    val user_id: String,
    val member: GuildMember?,
    val session_id: String,
    val deaf: Boolean,
    val mute: Boolean,
    val self_deaf: Boolean,
    val self_mute: Boolean,
    val self_stream: Boolean?,
    val self_video: Boolean,
    val suppress: Boolean,
    val request_to_speak_timestamp: String?,
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

@JsonAdapter(VerificationAdapter::class)
enum class VerificationLevel {
    NONE,
    LOW,
    MEDIUM,
    HIGH,
    VERY_HIGH
}
class VerificationAdapter : TypeAdapter<VerificationLevel>() {
    override fun write(out: JsonWriter?, value: VerificationLevel?) {
        out!!.value(value!!.ordinal)
    }
    override fun read(`in`: JsonReader?): VerificationLevel {
        return VerificationLevel.values()[`in`!!.nextInt()]
    }
}

class Guild (
    val id: String,
    val name: String,
    val icon: String?,
    val icon_hash: String?,
    val splash: String?,
    val discovery_splash: String?,
    val owner: Boolean?,
    val owner_id: String,
    val permissions: String,
    val afk_channel_id: String?,
    val afk_timeout: Int,
    val widget_enabled: Boolean?,
    val widget_channel_id: String?,
    val verification_level: VerificationLevel,
    val default_message_notifications: Int,
    val explicit_content_filter: Int,
    val roles: Array<Role>,
    val emojis: Array<Emoji>,
    val features: Array<String>,
    val mfa_level: Int,
    val application_id: String?,
    val system_channel_id: String?,
    val system_channel_flags: Int,
    val rules_channel_id: String?,
    val max_presences: Int?,
    val vanity_url_code: String?,
    val description: String?,
    val banner: String?,
    val premium_tier: Int,
    val premium_subscription_count: Int?,
    val preferred_locale: String,
    val public_updates_channel_id: String?,
    val max_video_channel_users: Int?,
    val max_stage_video_channel_users: Int?,
    val approximate_member_count: Int?,
    val approximate_presence_count: Int?,
    val welcome_screen: WelcomeScreen?,
    val nsfw_level: Int,
    val stickers: Array<Sticker>,
    val premium_progress_bar_enabled: Boolean
)
class WelcomeScreen(
    val description: String?,
    val welcome_channels: Array<WelcomeScreenChannel>
)
class WelcomeScreenChannel(
    val channel_id: String,
    val description: String,
    val emoji_id: String?,
    val emoji_name: String?
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
) {
    constructor(leName: String) : this(null, leName, null, null, null, null, null, null)
}
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
    val bot_id: String?,
    val integration_id: String?,
    val premium_subscriber: Boolean?,
    val subscription_listing_id: String?,
    val available_for_purchase: Boolean?,
    val guild_connections: Boolean?,
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
class Channel(
    val id: String,
    val type: Int,
    val guild_id: String?,
    val position: Int?,
    val permission_overwrites: Array<Overwrite>,
    val name: String?,
    val topic: String?,
    val nsfw: Boolean?,
    val last_message_id: String?,
    val bitrate: Int?,
    val user_limit: Int?,
    val rate_limit_per_user: Int?,
    val recipients: Array<DiscordUser>?,
    val icon: String?,
    val owner_id: String?,
    val application_id: String?,
    val managed: Boolean?,
    val parent_id: String?,
    val last_pin_timestamp: String?,
    val rtc_region: String?,
    val video_quality_mode: Int?,
    val message_count: Int?,
    val member_count: Int?,
    val thread_metadata: ThreadMetadata?,
    val member: ThreadMember?,
    val default_auto_archive_duration: Int?,
    val permissions: String?,
    val flags: Int?,
    val total_message_sent: Int?,
    val available_tags: Array<ForumTag>?,
    val applied_tags: Array<String>?,
    val default_reaction_emoji: DefaultReaction?,
    val default_thread_rate_limit_per_user: Int?,
    val default_sort_order: Int?,
    val default_forum_layout: Int?,
)

class DefaultReaction(
    val emoji_id: String?,
    val emoji_name: String?,
)
class ForumTag(
    val id: String,
    val name: String,
    val moderated: Boolean,
    val emoji_id: String?,
    val emoji_name: String?,
)
class ThreadMetadata(
    val archived: Boolean,
    val auto_archive_duration: Int,
    val archive_timestamp: String,
    val locked: Boolean,
    val invitable: Boolean?,
    val create_timestamp: String?
)
class ThreadMember(
    val id: String?,
    val user_id: String?,
    val join_timestamp: String,
    val flags: Int,
    val member: GuildMember?
)

class Overwrite(
    val id: String,
    val type: Int,
    val allow: String,
    val deny: String
)

class PresenceUpdate(
    val user: DiscordUser,
    val guild_id: String,
    val status: String,
    val activities: Array<Activity>,
    val client_status: ClientStatus,
)
class ClientStatus(
    val desktop: String?,
    val mobile: String?,
    val web: String?
)
class StageInstance(
    val id: String,
    val guild_id: String,
    val channel_id: String,
    val topic: String,
    val privacy_level: Int,
    val guild_scheduled_event_id: String?
)
class GuildScheduledEvent(
    val id: String,
    val guild_id: String,
    val channel_id: String?,
    val creator_id: String?,
    val name: String,
    val description: String?,
    val scheduled_start_time: String,
    val scheduled_end_time: String?,
    val privacy_level: Int,
    val status: Int,
    val entity_type: Int,
    val entity_id: String?,
    val entity_metadata: GuildScheduledEventEntityMetadata?,
    val creator: DiscordUser?,
    val user_count: Int?,
    val image: String?,
)
class GuildScheduledEventEntityMetadata(
    val location: String?,
)
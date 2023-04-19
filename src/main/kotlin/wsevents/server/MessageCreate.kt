package wsevents.server

import Attachment
import ChannelMention
import DiscordUser
import Embed
import Message
import MessageActivity
import MessageInteraction
import MessageReference
import PartialApplication
import PartialMember
import Reaction
import Snowflake
import Sticker

class MessageCreate(d: MessageCreateData) : ServerEvent<MessageCreateData>(0, d, null, "MESSAGE_CREATE") {
}

class MessageCreateData(
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
    val guild_id: Snowflake?,
    val member: PartialMember?,
)
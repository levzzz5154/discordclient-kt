package wsevents.server

import Channel
import GuildMember
import GuildScheduledEvent
import PresenceUpdate
import StageInstance
import VoiceState
import wsevents.client.UpdatePresence

class GuildCreate(d: GuildCreateData) : ServerEvent<GuildCreateData>(0, d, null, "GUILD_CREATE") {
}

class GuildCreateData(
    val joined_at: String,
    val large: Boolean,
    val unavailable: Boolean?,
    val member_count: Int,
    val voice_states: Array<VoiceState>,
    val members: Array<GuildMember>,
    val channels: Array<Channel>,
    val threads: Array<Channel>,
    val presences: Array<PresenceUpdate>,
    val stage_instances: Array<StageInstance>,
    val guild_scheduled_events: Array<GuildScheduledEvent>,
)
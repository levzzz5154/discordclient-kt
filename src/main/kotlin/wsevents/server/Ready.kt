package wsevents.server

import DiscordUser
import PartialApplication
import PartialGuild

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
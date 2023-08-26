package discordclient.wsevents.server

import discordclient.DiscordUser
import discordclient.PartialApplication
import discordclient.PartialGuild
import discordclient.Relationship

class Ready(d: ReadyData, s: Int?) : ServerEvent<ReadyData>(0, d, s, "READY") {

}

class ReadyData(
    val v: Int,
    val user: DiscordUser,
    val guilds: Array<PartialGuild>,
    val session_id: String,
    val resume_gateway_url: String,
    val relationships: Array<Relationship>,
    val shard: Array<Int>?,
    val application: PartialApplication
)
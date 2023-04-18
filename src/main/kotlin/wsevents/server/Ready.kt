package wsevents.server

class Ready(d: ReadyData, s: Int?) : ServerEvent<ReadyData>(0, d, s, "READY") {
}

class ReadyData(
    val v: Int,
    val user: UserData,
    val guilds: Array<PartialGuild>,
    val session_id: String,
    val resume_gateway_url: String,
    val shard: Array<Int>?,
    val application: PartialApplication
)
class UserData(
    var id: Snowflake,
    val username: String,

)
class PartialGuild
class PartialApplication

@JvmInline
value class Snowflake(val s: String)
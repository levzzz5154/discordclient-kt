package wsevents.client

class Identify(d: IdData) : ClientEvent<IdData>(2, d) {

}

class IdData(
    val token: String,
    val properties: ConnProperties,
    val compress: Boolean?,
    val large_threshold: Int?,
    val shard: Array<Int>?,
    val presence: UpdatePresence?,
    val intents: Int
)
class ConnProperties(val os: String, val browser: String, val device: String)
class UpdatePresence(val since: Int?, val activities: Array<Activity>, val status: String, val afk: Boolean)
class Activity
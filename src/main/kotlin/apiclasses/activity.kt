package apiclasses

import Emoji

class Activity(
    val name: String,
    val type: Int,
    val url: String?,
    val created_at: Int,
    val timestamps: Timestamps?,
    val application_id: String?,
    val details: String?,
    val state: String?,
    val emoji: Emoji?,
    val party: ActivityParty?,
    val assets: ActivityAssets?,
    val secrets: ActivitySecrets?,
    val instance: Boolean?,
    val flags: Int?,
    val buttons: Array<ActivityButton>?,
)
class ActivityButton(val label: String, val url: String)
class ActivitySecrets(val join: String?, val spectate: String?, val match: String?)
class ActivityAssets(val large_image: String?, val large_text: String?, val small_image: String?, val small_text: String?)
class Timestamps(val start: Int?, val end: Int?)
class ActivityParty(val id: String?, val size: Array<Int>?)
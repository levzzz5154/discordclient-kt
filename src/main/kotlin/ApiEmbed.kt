class Embed(
    val title: String?,
    val type: String?,
    val description: String?,
    val url: String?,
    val timestamp: String?,
    val color: IntColor?,
    val footer: EmbedFooter?,
    val image: EmbedImage?,
    val thumbnail: EmbedThumbnail?,
    val video: EmbedVideo?,
    val provider: EmbedProvider?,
    val author: EmbedAuthor?,
    val fields: Array<EmbedField>?,
)
class EmbedFooter(
    val text: String,
    val icon_url: String?,
    val proxy_icon_url: String?
)
class EmbedImage(
    val url: String,
    val proxy_url: String?,
    val height: Int?,
    val width: Int?
)
class EmbedThumbnail(
    val url: String,
    val proxy_url: String?,
    val height: Int?,
    val width: Int?
)
class EmbedVideo(
    val url: String?,
    val proxy_url: String?,
    val height: Int?,
    val width: Int?
)
class EmbedProvider(
    val name: String?,
    val url: String?
)
class EmbedAuthor(
    val name: String,
    val url: String?,
    val icon_url: String?,
    val proxy_icon_url: String?
)
class EmbedField(
    val name: String,
    val value: String,
    val inline: Boolean?
)
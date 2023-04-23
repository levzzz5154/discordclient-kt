package wsevents.server

import com.google.gson.annotations.SerializedName

open class ServerEvent<T>(
    @SerializedName("op") val opcode: Int,
    @SerializedName("d") val data: T,
    @SerializedName("s") val sequenceNumber: Int?,
    @SerializedName("t") val type: String?
) {

}
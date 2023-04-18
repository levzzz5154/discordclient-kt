package requests

import com.google.gson.Gson
import java.net.http.HttpClient

abstract class DiscordRequest<T> {
    protected val httpClient = HttpClient.newHttpClient()
    protected val gson = Gson()

    abstract fun run(baseURL: String): T

    protected fun deserializeSelf(json: String): T {
        return gson.fromJson<T>(json, this::class.java) as T
    }
}
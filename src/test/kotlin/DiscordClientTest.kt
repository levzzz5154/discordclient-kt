import com.google.gson.Gson
import org.junit.jupiter.api.Test
import requests.GetGateway
import wsevents.client.ConnProperties
import wsevents.client.IdData
import wsevents.client.Identify

class DiscordClientTest {
    val apiVersion = "9"
    val baseEndpoint = "https://discord.com/api/v$apiVersion"
    @Test
    fun getGateway() {
        val gatewayURL = GetGateway().run(baseEndpoint).url
        println(gatewayURL)
    }

    @Test
    fun initTest() {
        val token = "MTA5NzkxMzE4OTIxNzM1MzgwOA.Gj3IH3.shNt9hAqU42FoyL3fhsyAOj1Z3qrQ_I_wnGvqs"
        println("testink")
        val client = DiscordClient(token)
    }

    @Test
    fun jsonTest() {
        val ident = Identify(IdData("my bot toekn",
            ConnProperties("insaneos", "chromium or something", "a pregnancy test"),
            null, null, null, null,
            50085))
        println(Gson().toJson(ident))
    }
}
package discordclient.wsevents.client

open class ClientEvent<T>(val op: Int, var d: T?) {

}
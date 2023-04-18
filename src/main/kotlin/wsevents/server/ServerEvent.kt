package wsevents.server

open class ServerEvent<T>(val op: Int, val d: T, val s: Int?, val t: String?) {

}
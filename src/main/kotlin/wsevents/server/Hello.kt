package wsevents.server

class Hello(d: HelloData) : ServerEvent<HelloData>(10, d, null, null) {

}
class HelloData(val heartbeat_interval: Int)
package wsevents.client

class Heartbeat(d: Int?) : ClientEvent<Int>(1, d) {
    constructor() : this(null) {
    }
}
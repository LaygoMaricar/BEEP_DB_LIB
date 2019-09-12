package com.afpayments.beejees.fe.database.upstreamObjects

import com.afpayments.beejees.fe.database.dataObjects.Heartbeat
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.RequestBody

@Serializable
class HeartbeatUpstream {
    var heartbeat : Heartbeat? = null

    constructor()

    constructor(heartbeat : Heartbeat){
        this.heartbeat = heartbeat
    }

    override fun toString() : String{
        return Json.stringify(serializer(),this)
    }

    fun toRequestBody() : RequestBody {
        return RequestBody.create(MediaType.parse("application/json"),this.toString())
    }
}
package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class Segment {
    var seq : Long? = null
    var start : Coordinate? = null
    var end : Coordinate? = null
    var len : Long? = null
    var dir : Long? = null

    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): Segment {
            return Json.parse(serializer(), jsonString)
        }
    }

}

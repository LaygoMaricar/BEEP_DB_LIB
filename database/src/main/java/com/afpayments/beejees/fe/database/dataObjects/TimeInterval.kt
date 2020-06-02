package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class TimeInterval {
    var on : String? = null
    var at : ArrayList<Boolean>? = null

    override fun toString(): String {
        return Json.nonstrict.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): TimeInterval {
            return Json.nonstrict.parse(serializer(), jsonString)
        }
    }
}

package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class Coordinate {
    var lat : String? = null
    var lon : String? = null

    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }

    companion object {
        fun fromString(jsonString: String): Coordinate {
            return Json.parse(serializer(), jsonString)
        }
    }
}

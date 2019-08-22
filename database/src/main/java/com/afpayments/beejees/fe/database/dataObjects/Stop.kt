package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class Stop {
    var id : Long? = null
    var shortName : String? = null
    var longName : String? = null
    var coordinate : Coordinate? = null
    var range : Long? = null
    var direction : String? = null
    var activeAt : ArrayList<TimeInterval>? = null

    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): Stop {
            return Json.parse(serializer(), jsonString)
        }
    }
}

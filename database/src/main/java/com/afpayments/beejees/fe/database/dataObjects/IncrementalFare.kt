package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class IncrementalFare {
    var distance : Long? = null
    var amount : Long? = null
    var startDistance : Long? = null

    override fun toString(): String {
        return Json.nonstrict.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): IncrementalFare {
            return Json.nonstrict.parse(serializer(), jsonString)
        }
    }
}

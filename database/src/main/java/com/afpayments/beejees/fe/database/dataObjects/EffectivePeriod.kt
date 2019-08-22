package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class EffectivePeriod {
    var from : String? = null
    var to : String? = null

    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): EffectivePeriod {
            return Json.parse(serializer(), jsonString)
        }
    }
}

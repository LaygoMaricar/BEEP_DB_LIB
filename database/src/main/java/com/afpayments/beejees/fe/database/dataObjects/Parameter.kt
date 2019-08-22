package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class Parameter {
    var name : String? = null
    var type : String? = null
    var value : String? = null
    var effective : EffectivePeriod? = null
    var activeAt : ArrayList<TimeInterval>? = null

    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): Parameter {
            return Json.parse(serializer(), jsonString)
        }
    }
}
package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class IdCards {
    var uid : String? = null
    var role : String? = null
    var effective : EffectivePeriod? = null

    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): IdCards {
            return Json.parse(serializer(), jsonString)
        }
    }
}

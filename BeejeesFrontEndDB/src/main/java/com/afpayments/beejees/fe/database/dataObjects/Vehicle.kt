package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class Vehicle {
    var id : Long? = null
    var shortIdentifier : String? = null
    var longIdentifier : String? = null
    var externalIds : ArrayList<ExternalId>? = null
    var idCards : ArrayList<IdCards>? = null
    var effective : EffectivePeriod? = null

    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): Vehicle {
            return Json.parse(serializer(), jsonString)
        }
    }
}
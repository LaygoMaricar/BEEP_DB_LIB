package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class ExternalId {
    var idType : String? = null
    var idValue : String? = null

    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): ExternalId {
            return Json.parse(serializer(), jsonString)
        }
    }
}

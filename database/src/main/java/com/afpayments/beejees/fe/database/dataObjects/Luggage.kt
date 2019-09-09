package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class Luggage {
    var count : Long? = null
    var amount : Long? = null
    var type : String? = null
    var weight : Long? = null

    override fun toString(): String {
        return Json.nonstrict.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): Luggage {
            return Json.nonstrict.parse(serializer(), jsonString)
        }
    }
}
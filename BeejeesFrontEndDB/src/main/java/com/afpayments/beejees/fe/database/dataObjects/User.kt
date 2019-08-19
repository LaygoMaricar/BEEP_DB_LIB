package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class User {
    var id : Long? = null
    var companyID : String? = null
    var shortName : String? = null
    var longName : String? = null
    var idCards : ArrayList<IdCards>? = null
    var effective : EffectivePeriod? = null

    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): User {
            return Json.parse(serializer(), jsonString)
        }
    }
}
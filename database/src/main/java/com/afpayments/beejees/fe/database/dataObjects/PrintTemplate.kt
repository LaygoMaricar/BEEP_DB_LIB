package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class PrintTemplate {

    var id : Long? = null
    var templateType : String? = null
    var templateName : String? = null
    var template : ArrayList<String>? = null
    var effective : EffectivePeriod? = null

    override fun toString(): String {
        return Json.nonstrict.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): PrintTemplate {
            return Json.nonstrict.parse(serializer(), jsonString)
        }
    }
}
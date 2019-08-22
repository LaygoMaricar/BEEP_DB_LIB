package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class IncrementalFee {
    var hours : Long? = null
    var amount : Long? = null
    var fromInitialPeriod : Long? = null

    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): IncrementalFee {
            return Json.parse(serializer(), jsonString)
        }
    }
}

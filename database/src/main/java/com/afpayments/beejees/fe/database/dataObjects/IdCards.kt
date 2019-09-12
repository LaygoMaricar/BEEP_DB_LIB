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
        const val DRIVER = "driver"
        const val DISPATCHER = "dispatcher"
        const val ADMIN = "admin"
        const val CASH_COLLECTOR = "cash-collector"
        const val SUPER = "super"

        fun fromString(jsonString: String): IdCards {
            return Json.parse(serializer(), jsonString)
        }
    }
}

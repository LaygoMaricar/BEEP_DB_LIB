package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class BeepFinancial {
    var purseTransactionCounter : Long? = null
    var purseBalance : Long? = null
    var CAN : Long? = null

    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }


    companion object {
        fun fromString(jsonString: String): BeepFinancial {
            return Json.parse(serializer(), jsonString)
        }
    }
}

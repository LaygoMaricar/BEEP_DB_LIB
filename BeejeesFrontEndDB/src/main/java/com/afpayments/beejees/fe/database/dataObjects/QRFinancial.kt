package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class QRFinancial {
    var authCode : String? = null

    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): QRFinancial {
            return Json.parse(serializer(), jsonString)
        }
    }
}

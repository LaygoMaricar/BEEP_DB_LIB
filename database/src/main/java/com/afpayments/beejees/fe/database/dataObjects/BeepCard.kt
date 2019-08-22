package com.afpayments.beejees.fe.database.dataObjects

import android.database.Cursor
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class BeepCard {
    var can : Long? = null
    var uid : String? = null
    var profileId : Long? = null

    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }

    companion object {
        fun fromString(jsonString: String): BeepCard {
            return Json.parse(serializer(), jsonString)
        }
    }
}

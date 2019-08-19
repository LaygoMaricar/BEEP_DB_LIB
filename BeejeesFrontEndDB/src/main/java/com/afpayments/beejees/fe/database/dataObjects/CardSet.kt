package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class CardSet {
    var profileIds : ArrayList<Long>? = null
    var accountRanges : ArrayList<AccountRange>? = null
    var vehicleTypes : ArrayList<Long>? = null

    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }

    companion object {
        fun fromString(jsonString: String): CardSet {
            return Json.parse(serializer(), jsonString)
        }
    }

    @Serializable
    class AccountRange{
        var start : Long? = null
        var end : Long? = null

        override fun toString(): String {
            return Json.stringify(serializer(),this)
        }


        companion object {
            fun fromString(jsonString: String): AccountRange {
                return Json.parse(serializer(), jsonString)
            }
        }
    }
}

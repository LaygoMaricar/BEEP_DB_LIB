package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class CardSet {
    var profileIds : Long? = null
    var accountRanges : ArrayList<AccountRange>? = null
    var vehicleTypes : ArrayList<Long>? = null

    override fun toString(): String {
        return Json.nonstrict.stringify(serializer(),this)
    }

    companion object {
        fun fromString(jsonString: String): CardSet {
            return Json.nonstrict.parse(serializer(), jsonString)
        }
    }

    @Serializable
    class AccountRange{
        var start : Long? = null
        var end : Long? = null

        override fun toString(): String {
            return Json.nonstrict.stringify(serializer(),this)
        }


        companion object {
            fun fromString(jsonString: String): AccountRange {
                return Json.nonstrict.parse(serializer(), jsonString)
            }
        }
    }
}

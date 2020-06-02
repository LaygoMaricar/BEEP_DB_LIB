package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class TimeBasedFeeTable {
    var id : Long? = null
    var appliesTo : ArrayList<CardSet>? = null
    var activeAt : ArrayList<TimeInterval>? = null
    var effective : EffectivePeriod? = null
    var initialFare : InitialFare? = null
    var succedding : ArrayList<IncrementalFee>? = null
    var accumulative : Boolean? = null
    var prorated : Boolean? = null

    override fun toString(): String {
        return Json.nonstrict.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): TimeBasedFeeTable {
            return Json.nonstrict.parse(serializer(), jsonString)
        }
    }

    @Serializable
    class InitialFare {
        var hours : Long? = null
        var amount : Long? = null

        override fun toString(): String {
            return Json.nonstrict.stringify(serializer(),this)
        }

        companion object{
            fun fromString(jsonString: String): InitialFare {
                return Json.nonstrict.parse(serializer(), jsonString)
            }
        }
    }
}
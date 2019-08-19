package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class DistanceBasedFareTable {
    companion object{
        fun fromString(jsonString: String): DistanceBasedFareTable {
            return Json.parse(serializer(), jsonString)
        }
    }
    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }


    var id : Long? = null
    var appliesTo : ArrayList<CardSet>? = null
    var activeAt : ArrayList<TimeInterval>? = null
    var effective : EffectivePeriod? = null
    var baseFare : EffectivePeriod? = null
    var incrementalFares : ArrayList<IncrementalFare>? = null
    var accumulative : Boolean? = null
    var prorated : Boolean? = null

    @Serializable
    class BaseFare {
        var distance : Long? = null
        var amount : Long? = null

        override fun toString(): String {
            return Json.stringify(serializer(),this)
        }
        companion object{
            fun fromString(jsonString: String): BaseFare {
                return Json.parse(serializer(), jsonString)
            }
        }
    }
}
package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class StopBasedFareTable {
    var id : Long? = null
    var appliesTo : ArrayList<CardSet>? = null
    var activeAt : ArrayList<TimeInterval>? = null
    var effective : EffectivePeriod? = null
    var fares : ArrayList<Fares>? = null
    var accumulative : Boolean? = null
    var prorated : Boolean? = null

    companion object{
        fun fromString(jsonString: String): StopBasedFareTable {
            return Json.parse(serializer(), jsonString)
        }
    }
    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }


    @Serializable
    class Fares {
        var list : ArrayList<Long>? = null

        override fun toString(): String {
            return Json.stringify(serializer(),this)
        }

        companion object{
            fun fromString(jsonString: String): Fares {
                return Json.parse(serializer(), jsonString)
            }
        }
    }
}
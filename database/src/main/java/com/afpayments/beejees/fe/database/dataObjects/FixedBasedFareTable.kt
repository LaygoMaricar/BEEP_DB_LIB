package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class FixedBasedFareTable {
    var id : Long? = null
    var appliesTo : ArrayList<CardSet>? = null
    var activeAt : ArrayList<TimeInterval>? = null
    var effective : EffectivePeriod? = null
    var amount : Long? = null
    var accumulative : Boolean? = null
    var prorated : Boolean? = null

    override fun toString(): String {
        return Json.nonstrict.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): FixedBasedFareTable {
            return Json.nonstrict.parse(serializer(), jsonString)
        }
    }
}
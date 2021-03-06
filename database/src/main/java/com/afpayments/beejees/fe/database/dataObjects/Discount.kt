package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class Discount {
    companion object{
        const val UP = "up"
        const val DOWN = "down"
        const val NEAREST = "nearest"
        const val EXACT = "exact"

        fun fromString(jsonString: String): Discount {
            return Json.nonstrict.parse(serializer(), jsonString)
        }

    }

    var id : Long? = null
    var discount : Long? = null
    var roundingMethod : String? = null
    var roundingAccuracy : Long? = null
    var activeAt : ArrayList<CardSet>? = null
    var effective : EffectivePeriod? = null
    var appliesTo : ArrayList<CardSet>? = null
    var accumulative : Boolean? = null
    var prorated : Boolean? = null
    
    override fun toString(): String {
        return Json.nonstrict.stringify(serializer(),this)
    }

}
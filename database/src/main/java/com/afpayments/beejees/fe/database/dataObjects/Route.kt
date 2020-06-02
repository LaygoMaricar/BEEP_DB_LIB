package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class Route {
    companion object{
        const val DEBIT_CREDIT = "debit_credit"
        const val DEBIT_DEBIT = "debit_debit"

        fun fromString(jsonString: String): Route {
            return Json.nonstrict.parse(serializer(), jsonString)
        }
    }
    override fun toString(): String {
        return Json.nonstrict.stringify(serializer(),this)
    }


    var id : Long? = null
    var shortName : String? = null
    var longName : String? = null
    var cellTowerSegments : ArrayList<CellTowerSegment>? = null
    var segments : ArrayList<Segment>? = null
    var stops : ArrayList<Stop>? = null
    var fareStrategy : String? = null
    var fareTables : FareTables? = null

    @Serializable
    class FareTables{

        companion object{
            fun fromString(jsonString: String): FareTables {
                return Json.nonstrict.parse(serializer(), jsonString)
            }
        }

        override fun toString(): String {
            return Json.nonstrict.stringify(serializer(),this)
        }

        var distanceBased : ArrayList<Long>? = null
        var stopBased : ArrayList<Long>? = null
        var discounts : ArrayList<Long>? = null
        var fixedBased : ArrayList<Long>? = null
    }
}
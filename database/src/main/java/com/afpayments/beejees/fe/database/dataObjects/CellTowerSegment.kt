package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class CellTowerSegment {
    var cellId : Long? = null
    var signal : Long? = null
    var start : Coordinate? = null
    var end : Coordinate? = null

    override fun toString(): String {
        return Json.nonstrict.stringify(serializer(),this)
    }

    companion object {
        fun fromString(jsonString: String): CellTowerSegment {
            return Json.nonstrict.parse(serializer(), jsonString)
        }
    }
}

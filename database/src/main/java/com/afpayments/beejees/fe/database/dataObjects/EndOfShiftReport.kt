package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class EndOfShiftReport {
    var terminalId : String? = null
    var uploadDateTime : String? = null
    var reportCreationDateTime : String? = null
    var participantId : Long? = null
    var vehicleId : Long? = null
    var loginId : Long? = null
    var logoutId : Long? = null
    var routeId : Long? = null
    var shiftStart : String? = null
    var shiftEnd : String? = null
    var startMTC : Long? = null
    var endMTC : Long? = null
    var sums : Sums? = null

    override fun toString(): String {
        return Json.nonstrict.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): EndOfShiftReport {
            return Json.nonstrict.parse(serializer(), jsonString)
        }
    }
}
package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class CashboxReport {
    var terminalId : String? = null
    var uploadDateTime : String? = null
    var reportCreationDateTime : String? = null
    var participantId : Long? = null
    var driverId : Long? = null
    var vehicleId : Long? = null
    var routeId : Long? = null
    var ticketPrice : Long? = null
    var sums : Sums? = null

    override fun toString(): String {
        return Json.nonstrict.stringify(serializer(),this)
    }

    companion object {
        fun fromString(jsonString: String): CashboxReport {
            return Json.nonstrict.parse(serializer(), jsonString)
        }
    }
}
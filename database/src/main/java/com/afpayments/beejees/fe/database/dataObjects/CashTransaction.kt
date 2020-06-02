package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class CashTransaction {
    var id : String? = null
    var time : String? = null
    var participantId : Long? = null
    var operatorId : Long? = null
    var terminalId : String? = null
    var vehicleId : Long? = null
    var tellerId : Long? = null
    var routeId : Long? = null
    var startStop : Long? = null
    var endStop : Long? = null
    var fareTable : Long? = null
    var passengers : ArrayList<Passenger>? = null
    var luggage : ArrayList<Luggage>? = null
    var productType : String? = null
    var paymentType : String? = null

    override fun toString(): String {
        return Json.nonstrict.stringify(serializer(),this)
    }

    companion object {
        fun fromString(jsonString: String): CashTransaction {
            return Json.nonstrict.parse(serializer(), jsonString)
        }
    }
}
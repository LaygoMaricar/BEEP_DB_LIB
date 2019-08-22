package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class Transaction {
    companion object{
        const val BEEP_TAP_IN = "beep_tap_in"
        const val BEEP_TAP_OUT = "beep_tap_out"
        const val CASH = "cash"
        const val DRIVER_SELECTED = "driver_selected"
        const val QR_TICKET_IN = "qr_ticket_in"
        const val QR_TICKET_OUT = "qr_ticket_out"
        const val TRANSIT_PASS = "transit_pass"
        const val DISCOUNT_PRODUCT = "discount_product"

        fun fromString(jsonString: String): Transaction {
            return Json.parse(serializer(), jsonString)
        }
    }

    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }

    var id : String? = null
    var type : String? = null
    var time : String? = null
    var card : BeepCard? = null
    var qrCode : QRCode? = null
    var participantId : Long? = null
    var terminalId : String? = null
    var vehicleId : Long? = null
    var vehicleName : String? = null
    var driverId : Long? = null
    var routeId : Long? = null
    var fareTable : Long? = null
    var discount : Long? = null
    var stop : Long? = null
    var rawPosition : Coordinate? = null
    var positionOnRoute : Coordinate? = null
}
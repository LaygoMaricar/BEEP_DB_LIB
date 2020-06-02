package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class FinancialTransaction {
    companion object{
        const val PRODUCT_TICKET = "TICKET"
        const val PRODUCT_QR_TICKET = "QR_TICKET"
        const val PAYMENT_CASH = "CASH"
        const val PAYMENT_BEEP = "BEEP"
        const val PAYMENT_GCASH = "GCASH"
        const val PAYMENT_PAYMAYA = "PAYMAYA"
        const val PAYMENT_BPI = "BPI"

        fun fromString(jsonString: String): FinancialTransaction {
            return Json.nonstrict.parse(serializer(), jsonString)
        }
    }

    override fun toString(): String {
        return Json.nonstrict.stringify(serializer(),this)
    }

    var id : String? = null
    var time : String? = null
    var participantId : Long? = null
    var operatorId : Long? = null
    var terminalId : String? = null
    var vehicleId : Long? = null
    var vehicleName : String? = null
    var tellerId : Long? = null
    var routeId : Long? = null
    var startStop : Long? = null
    var endStop : Long? = null
    var fareTable : Long? = null
    var passengers : ArrayList<Passenger>? = null
    var luggage : ArrayList<Luggage>? = null
    var productType : String? = null
    var paymentType : String? = null
    var beep : BeepFinancial? = null
    var qrCode : QRFinancial? = null
}
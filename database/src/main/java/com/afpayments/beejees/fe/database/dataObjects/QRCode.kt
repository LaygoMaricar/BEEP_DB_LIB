package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class QRCode {
    var ticketValidityPeriod : Long? = null
    var ticketVailidityDomain : Long? = null
    var transportOperatorId : Long? = null
    var ticketEffectiveTime : String? = null
    var refreshPeriod : Long? = null
    var accountIdentifier : String? = null
    var boardingStation : Long? = null
    var destinationStation : Long? = null
    var seatNumber : String? = null
    var seatClass : String? = null
    var maximumAuthorizedAmount : String? = null
    var signatureKeyIdentifier : String? = null
    var signature : String? = null
    var QRPayload : String? = null
    var proprietaryValidationData : String? = null
    var ticketIdentifier : Long? = null
    var timeTicketCreationTime : String? = null
    var slipNumber : Long? = null
    var issuerTerminalId : String? = null

    override fun toString(): String {
        return Json.nonstrict.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): QRCode {
            return Json.nonstrict.parse(serializer(), jsonString)
        }
    }
}

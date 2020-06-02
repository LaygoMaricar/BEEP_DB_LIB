package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class Item {
    companion object {
        const val BEEP = "beep"
        const val CASH = "cash"
        const val QR = "qr"

        fun fromString(jsonString: String): Item {
            return Json.nonstrict.parse(serializer(), jsonString)
        }
    }

    constructor()

    constructor(type : String, total : Total, subTotals : ArrayList<SubTotal>){
        this.total = total
        this.subTotals = subTotals
        this.type = type
    }

    override fun toString(): String {
        return Json.nonstrict.stringify(serializer(), this)
    }

    var type: String? = null
    var total: Total? = null
    var subTotals: ArrayList<SubTotal>? = null
}
package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class Sums {
    var total : Total? = null
    var subTotals : ArrayList<Item>? = null

    constructor()

    constructor(total : Total, items : ArrayList<Item>){
        this.total = total
        this.subTotals = items
    }

    override fun toString(): String {
        return Json.nonstrict.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): Sums {
            return Json.nonstrict.parse(serializer(), jsonString)
        }
    }






}
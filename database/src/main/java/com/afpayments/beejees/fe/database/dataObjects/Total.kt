package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class Total{
    var amount : Long? = null
    var count : Long? = null

    constructor()

    constructor(amount: Long, count: Long) {
        this.amount = amount
        this.count = count
    }

    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): Total {
            return Json.parse(serializer(), jsonString)
        }
    }
}
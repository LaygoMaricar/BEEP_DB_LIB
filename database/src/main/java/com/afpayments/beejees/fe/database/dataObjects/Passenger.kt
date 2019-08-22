package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class Passenger{
    companion object{
        const val STANDARD = "standard"
        const val SENIOR = "senior"
        const val STUDENT = "student"
        const val PWD = "pwd"
        const val MEDAL_FOR_VALOR = "medal_for_valor"

        fun fromString(jsonString: String): Passenger {
            return Json.parse(serializer(), jsonString)
        }
    }
    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }


    var count : Long? = null
    var amount : Long? = null
    var profile : String? = null
}
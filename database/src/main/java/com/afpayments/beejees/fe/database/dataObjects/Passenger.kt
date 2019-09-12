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
            return Json.nonstrict.parse(serializer(), jsonString)
        }
    }
    override fun toString(): String {
        return Json.nonstrict.stringify(serializer(),this)
    }

    constructor()

    constructor(count : Long, amount : Long, profile : String, profileId : Long){
        this.count = count
        this.amount = amount
        this.profile = profile
        this.profileId = profileId
    }


    var count : Long? = null
    var amount : Long? = null
    var profile : String? = null
    var profileId : Long? = null
}
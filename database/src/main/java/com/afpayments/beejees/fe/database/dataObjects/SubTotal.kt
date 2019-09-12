package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class SubTotal{
    companion object{
        const val PWD = "pwd"
        const val REGULAR = "regular"
        const val STUDENT = "student"
        const val SENIOR = "senior"

        fun fromString(jsonString: String): SubTotal {
            return Json.parse(serializer(), jsonString)
        }
    }

    constructor()

    constructor(typeId : Long, type : String){
        this.type = type
        this.typeId = typeId
    }

    fun addCount(count : Long){
        this.count = this.count?.plus(count)
    }

    fun addAmount(amount : Long){
        this.amount = this.amount?.plus(amount)
    }

    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }

    var type : String? = null
    var typeId : Long? = null
    var amount : Long? = 0L
    var count : Long? = 0L
}
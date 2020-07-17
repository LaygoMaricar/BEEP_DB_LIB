package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Operator(
        val id: Int? = null,
        val shortName: String? = null,
        val longName: String? = null,
        val routes: List<Long>? = null
) {
    override fun toString(): String {
        return Json.stringify(serializer(), this)
    }

    companion object {
        fun fromString(jsonString: String): Operator {
            return Json.nonstrict.parse(serializer(), jsonString)
        }
    }
}
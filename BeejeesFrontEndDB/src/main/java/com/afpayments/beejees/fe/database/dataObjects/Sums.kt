package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class Sums {
    var total : Total? = null
    var subTotals : ArrayList<SubTotalTransaction>? = null

    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): Sums {
            return Json.parse(serializer(), jsonString)
        }
    }

    @Serializable
    class Total{
        var amount : Long? = null
        var count : Long? = null

        override fun toString(): String {
            return Json.stringify(serializer(),this)
        }

        companion object{
            fun fromString(jsonString: String): Total {
                return Json.parse(serializer(), jsonString)
            }
        }
    }

    @Serializable
    class SubTotalTransaction{
        companion object{
            const val BEEP = "beep"
            const val CASH = "cash"
            const val QR = "qr"

            fun fromString(jsonString: String): SubTotalTransaction {
                return Json.parse(serializer(), jsonString)
            }
        }
        override fun toString(): String {
            return Json.stringify(serializer(),this)
        }

        var type : String? = null
        var total : Total? = null
        var subTotals : ArrayList<SubTotalProfile>? = null
    }

    @Serializable
    class SubTotalProfile{
        companion object{
            const val PWD = "pwd"
            const val REGULAR = "regular"
            const val STUDENT = "student"
            const val SENIOR = "senior"

            fun fromString(jsonString: String): SubTotalProfile {
                return Json.parse(serializer(), jsonString)
            }
        }

        override fun toString(): String {
            return Json.stringify(serializer(),this)
        }

        var type : String? = null
        var amount : Long? = null
        var count : Long? = null
    }
}
package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class Heartbeat {
    var terminalId : String? = null
    var uploadDateTime : String? = null
    var masterTransactionCounter : Long? = null
    var clientUploadIndex : Long? = null
    var lastDriverLoginDateTime : String? = null
    var lastDriverLogoutDateTime : String? = null
    var lastDispatcherLoginDateTime : String? = null
    var dispatcherId : Long? = null
    var driverId : Long? = null
    var routeId : Long? = null
    var vehicle : VehicleStatus? = null
    var opsCode : Long? = null
    var gpsCode : Long? = null
    var message : String? = null

    override fun toString(): String {
        return Json.nonstrict.stringify(serializer(),this)
    }

    companion object{
        fun fromString(jsonString: String): Heartbeat {
            return Json.nonstrict.parse(serializer(), jsonString)
        }
    }

    @Serializable
    class VehicleStatus{
        var id : Long? = null
        var position : Position? = null
        var speed : Long? = null
        var distance : Long? = null
        var direction : String? = null

        override fun toString(): String {
            return Json.nonstrict.stringify(serializer(),this)
        }

        companion object{
            fun fromString(jsonString: String): VehicleStatus {
                return Json.nonstrict.parse(serializer(), jsonString)
            }
        }

        @Serializable
        class Position{
            companion object{
                const val GPS = "gps"
                const val GPS_ROUTE = "gps_route"
                const val COARSE = "coarse"

                fun fromString(jsonString: String): Position {
                    return Json.nonstrict.parse(serializer(), jsonString)
                }
            }
            override fun toString(): String {
                return Json.nonstrict.stringify(serializer(),this)
            }
            var lat : String? = null
            var lon : String? = null
            var alt : Long? = null
            var time : String? = null
            var source : String? = null
        }
    }
}
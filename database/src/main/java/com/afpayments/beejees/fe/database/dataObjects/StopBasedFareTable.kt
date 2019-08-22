package com.afpayments.beejees.fe.database.dataObjects

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.json.JSONArray
import java.lang.StringBuilder

@Serializable
class StopBasedFareTable {
    var id : Long? = null
    var appliesTo : ArrayList<CardSet>? = null
    var activeAt : ArrayList<TimeInterval>? = null
    var effective : EffectivePeriod? = null
    var fareMatrix : String? = null
    var accumulative : Boolean? = null
    var prorated : Boolean? = null

    companion object{
        fun fromString(jsonString: String): StopBasedFareTable {
            return Json.parse(serializer(), jsonString)
        }
    }
    override fun toString(): String {
        return Json.stringify(serializer(),this)
    }


    class Fares {
        var list : ArrayList<ArrayList<Long>>? = null

        override fun toString(): String {
            var sb = StringBuilder()
            sb.append("[")

            for(subList in list!!){
                sb.append("[")
                for(id in subList){
                    sb.append("$id")
                    sb.append(",")
                }
                sb.append("]")
                sb.append(",")
            }
            sb.deleteCharAt(sb.length - 1)
            sb.append("]")
            return sb.toString()
        }

        companion object{
            fun fromString(jsonString: String): Fares {
                val array = JSONArray(jsonString)
                var fares = Fares()
                fares.list = ArrayList()
                for (x in 0..array.length()){
                    var subArray = array.getJSONArray(x)
                    var subList = ArrayList<Long>()
                    for(y in 0..subArray.length()){
                        subList.add(subArray.getLong(y))
                    }
                    fares.list!!.add(subList)
                }
                return fares
            }
        }
    }
}
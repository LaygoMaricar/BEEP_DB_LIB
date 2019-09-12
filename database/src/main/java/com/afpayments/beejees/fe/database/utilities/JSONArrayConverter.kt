package com.afpayments.beejees.fe.database.utilities

import com.afpayments.beejees.fe.database.dataObjects.*
import org.json.JSONArray

class JSONArrayConverter {
    companion object{
        fun toVehicles(array : JSONArray) : ArrayList<Vehicle> {
            var ret = ArrayList<Vehicle>()
            for(i in 0 until array.length()){
                ret.add(Vehicle.fromString(array.getJSONObject(i).toString()))
            }
            return ret
        }

        fun toUsers(array : JSONArray) : ArrayList<User> {
            var ret = ArrayList<User>()
            for(i in 0 until array.length()){
                ret.add(User.fromString(array.getJSONObject(i).toString()))
            }
            return ret
        }

        fun toParameters(array : JSONArray) : ArrayList<Parameter> {
            var ret = ArrayList<Parameter>()
            for(i in 0 until array.length()){
                ret.add(Parameter.fromString(array.getJSONObject(i).toString()))
            }
            return ret
        }

        fun toDiscounts(array : JSONArray) : ArrayList<Discount> {
            var ret = ArrayList<Discount>()
            for(i in 0 until array.length()){
                ret.add(Discount.fromString(array.getJSONObject(i).toString()))
            }
            return ret
        }

        fun toDistanceBasedFareTables(array : JSONArray) : ArrayList<DistanceBasedFareTable> {
            var ret = ArrayList<DistanceBasedFareTable>()
            for(i in 0 until array.length()){
                ret.add(DistanceBasedFareTable.fromString(array.getJSONObject(i).toString()))
            }
            return ret
        }

        fun toFixedBasedFareTables(array : JSONArray) : ArrayList<FixedBasedFareTable> {
            var ret = ArrayList<FixedBasedFareTable>()
            for(i in 0 until array.length()){
                ret.add(FixedBasedFareTable.fromString(array.getJSONObject(i).toString()))
            }
            return ret
        }

        fun toStopBasedFareTables(array : JSONArray) : ArrayList<StopBasedFareTable> {
            var ret = ArrayList<StopBasedFareTable>()
            for(i in 0 until array.length()){
                ret.add(StopBasedFareTable.fromString(array.getJSONObject(i).toString()))
            }
            return ret
        }

        fun toRoutes(array : JSONArray) : ArrayList<Route> {
            var ret = ArrayList<Route>()
            for(i in 0 until array.length()){
                ret.add(Route.fromString(array.getJSONObject(i).toString()))
            }
            return ret
        }

        fun toPrintTemplates(array : JSONArray) : ArrayList<PrintTemplate> {
            var ret = ArrayList<PrintTemplate>()
            for(i in 0 until array.length()){
                ret.add(PrintTemplate.fromString(array.getJSONObject(i).toString()))
            }
            return ret
        }

        fun toLuggages(array : JSONArray) : ArrayList<Luggage> {
            var ret = ArrayList<Luggage>()
            for(i in 0 until array.length()){
                ret.add(Luggage.fromString(array.getJSONObject(i).toString()))
            }
            return ret
        }

        fun toPassengers(array : JSONArray) : ArrayList<Passenger> {
            var ret = ArrayList<Passenger>()
            for(i in 0 until array.length()){
                ret.add(Passenger.fromString(array.getJSONObject(i).toString()))
            }
            return ret
        }

    }
}
package com.afpayments.beejees.fe.database.upstreamObjects

import com.afpayments.beejees.fe.database.dataObjects.Transaction
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.RequestBody

@Serializable
class TransactionsUpstream {
    var transactions : ArrayList<Transaction>? = null

    constructor(transactions: ArrayList<Transaction>){
        this.transactions = transactions
    }

    override fun toString() : String{
        return Json.stringify(serializer(),this)
    }

    fun toRequestBody() : RequestBody {
        return RequestBody.create(MediaType.parse("application/json"),this.toString())
    }
}
package com.afpayments.beejees.fe.database.upstreamObjects

import com.afpayments.beejees.fe.database.dataObjects.CashTransaction
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.RequestBody

@Serializable
class CashTransactionUpstream {
    var transactions : ArrayList<CashTransaction>? = null

    constructor(transactions: ArrayList<CashTransaction>){
        this.transactions = transactions
    }

    override fun toString() : String{
        return Json.stringify(serializer(),this)
    }

    fun toRequestBody() : RequestBody {
        return RequestBody.create(MediaType.parse("application/json"),this.toString())
    }
}
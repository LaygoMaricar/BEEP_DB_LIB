package com.afpayments.beejees.fe.database.upstreamObjects

import com.afpayments.beejees.fe.database.dataObjects.CashboxReport
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.RequestBody

@Serializable
class CashboxReportUpstream {
    var cashboxReport: CashboxReport? = null

    constructor()

    constructor(cashboxReport: CashboxReport) {
        this.cashboxReport = cashboxReport
    }

    override fun toString(): String {
        return Json.stringify(serializer(), this)
    }

    fun toRequestBody(): RequestBody {
        return RequestBody.create(MediaType.parse("application/json"), this.toString())
    }
}
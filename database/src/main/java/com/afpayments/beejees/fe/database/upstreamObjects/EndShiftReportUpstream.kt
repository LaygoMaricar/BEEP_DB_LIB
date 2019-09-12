package com.afpayments.beejees.fe.database.upstreamObjects

import com.afpayments.beejees.fe.database.dataObjects.EndOfShiftReport
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.RequestBody

@Serializable
class EndShiftReportUpstream {
    var reportRecords : EndOfShiftReport? = null

    constructor()

    constructor(reportRecords : EndOfShiftReport){
        this.reportRecords = reportRecords
    }

    override fun toString() : String{
        return Json.stringify(serializer(),this)
    }

    fun toRequestBody() : RequestBody {
        return RequestBody.create(MediaType.parse("application/json"),this.toString())
    }
}
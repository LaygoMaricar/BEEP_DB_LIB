package com.afpayments.beejees.fe.database

import com.afpayments.beejees.fe.database.dataObjects.*
import com.afpayments.beejees.fe.database.upstreamObjects.*
import org.junit.Assert
import org.junit.Test

class UpstreamSerializeTest {

    @Test
    fun cashboxUpstream(){

        var txns = CashboxReport()
        var upstream = CashboxReportUpstream(txns)

        Assert.assertTrue(upstream.toString().contains("cashboxReport"))
    }

    @Test
    fun cashTransaction(){

        var txns = ArrayList<CashTransaction>()
        var upstream = CashTransactionUpstream(txns)

        Assert.assertTrue(upstream.toString().contains("transactions"))
    }

    @Test
    fun transaction(){

        var txns = ArrayList<Transaction>()
        var upstream = TransactionsUpstream(txns)

        Assert.assertTrue(upstream.toString().contains("transactions"))
    }

    @Test
    fun endOfShift(){

        var txns = EndOfShiftReport()
        var upstream = EndShiftReportUpstream(txns)

        Assert.assertTrue(upstream.toString().contains("reportRecords"))
    }

    @Test
    fun heartbeat(){

        var txns = Heartbeat()
        var upstream = HeartbeatUpstream(txns)

        Assert.assertTrue(upstream.toString().contains("heartbeat"))
    }
}
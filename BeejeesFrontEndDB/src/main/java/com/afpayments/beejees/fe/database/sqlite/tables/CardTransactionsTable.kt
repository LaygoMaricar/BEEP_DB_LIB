package com.afpayments.beejees.fe.database.sqlite.tables

class CardTransactionsTable {
    companion object{
        const val TABLE_NAME = "CardTransactions"
        const val MTC = "mtc"
        const val TRANSACTION_DATA = "transactionData"
        const val DATE_INSERTED = "dateInserted"

        const val MTC_COL = 0
        const val TRANSACTION_DATA_COL = 1
        const val DATE_INSERTED_COL = 2
    }
}
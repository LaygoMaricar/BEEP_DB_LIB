package com.afpayments.beejees.fe.database.sqlite.tables

class TransactionsTable {
    companion object{
        const val TABLE_NAME = "Transactions"
        const val MTC = "mtc"
        const val TRANSACTION_TYPE = "transactionType"
        const val TRANSACTION_DATA = "transactionData"
        const val DATE_INSERTED = "dateInserted"

        const val MTC_COL = 0
        const val TRANSACTION_TYPE_COL = 1
        const val TRANSACTION_DATA_COL = 2
        const val DATE_INSERTED_COL = 3

    }
}
package com.afpayments.beejees.fe.database.sqlite.tables

class UserLogsTable {
    companion object{
        const val TABLE_NAME = "UserLogs"
        const val MTC = "mtc"
        const val REPORT_DATA = "reportData"
        const val DATE_INSERTED = "dateInserted"

        const val MTC_COL = 0
        const val REPORT_DATA_COL = 1
        const val DATE_INSERTED_COL = 2
    }
}
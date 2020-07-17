package com.afpayments.beejees.fe.database.sqlite.tables

class UsersTable {
    companion object {
        const val TABLE_NAME = "Users"
        const val ID = "id"
        const val COMPANY_ID = "companyId"
        const val SHORT_NAME = "shortName"
        const val LONG_NAME = "longName"
        const val UID = "uid"
        const val ROLE = "role"
        const val USER_EFFECTIVE = "userEffective"
        const val CARD_EFFECTIVE = "cardEffective"
        const val OPERATOR_ID = "operatorId"

        const val ID_COL = 0
        const val COMPANY_ID_COL = 1
        const val SHORT_NAME_COL = 2
        const val LONG_NAME_COL = 3
        const val UID_COL = 4
        const val ROLE_COL = 5
        const val USER_EFFECTIVE_COL = 6
        const val CARD_EFFECTIVE_COL = 7
        const val OPERATOR_ID_COL = 8
    }
}
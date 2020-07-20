package com.afpayments.beejees.fe.database.sqlite.queries

import com.afpayments.beejees.fe.database.sqlite.tables.UsersTable

object QueryAlter {
    const val USERS_TABLE =
        "ALTER TABLE `${UsersTable.TABLE_NAME}` " +
            "ADD COLUMN `${UsersTable.OPERATOR_ID}` INTEGER NULL"
}
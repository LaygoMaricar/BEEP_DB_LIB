package com.afpayments.beejees.fe.database.sqlite.queries

import com.afpayments.beejees.fe.database.sqlite.tables.*

class QueryCreate {
    companion object{
        const val CREATE_STATEMENT = "CREATE TABLE IF NOT EXISTS "

        const val BLACKLIST_TABLE = "CREATE TABLE IF NOT EXISTS `${BlacklistTable.TABLE_NAME}` ( `${BlacklistTable.BLACKLIST_DATA}` TEXT )"
        const val CARD_TRANSACTIONS_TABLE = "CREATE TABLE `${CardTransactionsTable.TABLE_NAME}` ( `${CardTransactionsTable.MTC}` INTEGER, `${CardTransactionsTable.TRANSACTION_DATA}` TEXT, `${CardTransactionsTable.DATE_INSERTED}` TEXT, PRIMARY KEY(`${CardTransactionsTable.MTC}`) )"
        const val TRANSACTIONS_TABLE = "CREATE TABLE `${TransactionsTable.TABLE_NAME}` ( `${TransactionsTable.MTC}` INTEGER, `${TransactionsTable.TRANSACTION_TYPE}` TEXT, `${TransactionsTable.TRANSACTION_DATA}` TEXT, `${TransactionsTable.DATE_INSERTED}` TEXT, PRIMARY KEY(`${TransactionsTable.MTC}`) )"
        const val USER_LOGS_TABLE = "CREATE TABLE IF NOT EXISTS  `${UserLogsTable.TABLE_NAME}` ( `${UserLogsTable.MTC}` INTEGER PRIMARY KEY AUTOINCREMENT, `${UserLogsTable.REPORT_DATA}` TEXT, `${UserLogsTable.DATE_INSERTED}` TEXT )"
        const val USERS_TABLE = "CREATE TABLE IF NOT EXISTS  `${UsersTable.TABLE_NAME}` ( `${UsersTable.ID}` INTEGER NOT NULL, `${UsersTable.COMPANY_ID}` TEXT, `${UsersTable.SHORT_NAME}` TEXT, `${UsersTable.LONG_NAME}` TEXT, `${UsersTable.UID}` TEXT NOT NULL, `${UsersTable.ROLE}` TEXT, `${UsersTable.USER_EFFECTIVE}` TEXT, `${UsersTable.CARD_EFFECTIVE}` TEXT, unique(`${UsersTable.ID}`,`${UsersTable.UID}`) )"
        const val VEHICLE_TABLE = "CREATE TABLE IF NOT EXISTS  `${VehicleTable.TABLE_NAME}` ( `${VehicleTable.DATA}` TEXT )"
        const val VERSIONS_TABLE = "CREATE TABLE IF NOT EXISTS  `${VersionsTable.TABLE_NAME}` ( `${VersionsTable.ID}` INTEGER, `${VersionsTable.TABLE_NAME_COL}` TEXT, `${VersionsTable.VERSION}` INTEGER, PRIMARY KEY(`${VersionsTable.ID}`) )"
        const val CELL_TOWER_SEGMENTS_TABLE = "CREATE TABLE IF NOT EXISTS  `${CellTowerSegmentsTable.TABLE_NAME}` ( `${CellTowerSegmentsTable.ID}` INTEGER NOT NULL, `${CellTowerSegmentsTable.ROUTE_ID}` INTEGER NOT NULL, `${CellTowerSegmentsTable.DATA}` TEXT, PRIMARY KEY(`${CellTowerSegmentsTable.ID}`),unique(`${CellTowerSegmentsTable.ID}`,`${CellTowerSegmentsTable.ROUTE_ID}`) )"
        const val DISCOUNT_TABLE = "CREATE TABLE IF NOT EXISTS  `${DiscountTable.TABLE_NAME}` ( `${DiscountTable.ID}` INTEGER NOT NULL UNIQUE, `${DiscountTable.DATA}` TEXT, PRIMARY KEY(`${DiscountTable.ID}`) )"
        const val DISTANCE_BASED_FARE_TABLE = "CREATE TABLE IF NOT EXISTS  `${DistanceBasedFaresTable.TABLE_NAME}` ( `${DistanceBasedFaresTable.ID}` INTEGER NOT NULL UNIQUE, `${DistanceBasedFaresTable.DATA}` TEXT, PRIMARY KEY(`${DistanceBasedFaresTable.ID}`) )"
        const val FIXED_BASED_FARE_TABLE = "CREATE TABLE IF NOT EXISTS  `${FixedBasedFaresTable.TABLE_NAME}` ( `${FixedBasedFaresTable.ID}` INTEGER NOT NULL UNIQUE, `${FixedBasedFaresTable.DATA}` TEXT, PRIMARY KEY(`${FixedBasedFaresTable.ID}`) )"
        const val PARAMETERS_TABLE = "CREATE TABLE IF NOT EXISTS  `${ParameterTable.TABLE_NAME}` ( `${ParameterTable.ID}` INTEGER NOT NULL, `${ParameterTable.DATA}` TEXT NOT NULL, `${ParameterTable.DATE_INSERTED}` TEXT NOT NULL, PRIMARY KEY(`${ParameterTable.ID}`) )"
        const val ROUTES_TABLE = "CREATE TABLE IF NOT EXISTS  `${RouteTable.TABLE_NAME}` ( `${RouteTable.ID}` INTEGER NOT NULL, `${RouteTable.DATA}` TEXT, PRIMARY KEY(`${RouteTable.ID}`) )"
        const val SEGMENTS_TABLE = "CREATE TABLE IF NOT EXISTS  `${SegmentsTable.TABLE_NAME}` ( `${SegmentsTable.ID}` INTEGER NOT NULL, `${SegmentsTable.ROUTE_ID}` INTEGER NOT NULL, `${SegmentsTable.DATA}` TEXT, PRIMARY KEY(`${SegmentsTable.ID}`),unique(`${SegmentsTable.ID}`,`${SegmentsTable.ROUTE_ID}`) )"
        const val STOP_BASED_FARE_TABLE = "CREATE TABLE IF NOT EXISTS  `${StopBasedFaresTable.TABLE_NAME}` ( `${StopBasedFaresTable.ID}` INTEGER NOT NULL UNIQUE, `${StopBasedFaresTable.DATA}` TEXT, PRIMARY KEY(`${StopBasedFaresTable.ID}`) )"
        const val STOPS_TABLE = "CREATE TABLE IF NOT EXISTS  `${StopTable.TABLE_NAME}` ( `${StopTable.ID}` INTEGER NOT NULL, `${StopTable.ROUTE_ID}` INTEGER NOT NULL, `${StopTable.DATA}` TEXT, PRIMARY KEY(`${StopTable.ID}`),unique(`${StopTable.ID}`,`${StopTable.ROUTE_ID}`) )"
        const val TIME_BASED_FARE_TABLE = "CREATE TABLE IF NOT EXISTS  `${TimeBasedFaresTable.TABLE_NAME}` ( `${TimeBasedFaresTable.ID}` INTEGER NOT NULL UNIQUE, `${TimeBasedFaresTable.DATA}` TEXT, PRIMARY KEY(`${TimeBasedFaresTable.ID}`) )"
        const val PRINT_TEMPLATE_TABLE = "CREATE TABLE `${PrintTemplatesTable.TABLE_NAME}` ( `${PrintTemplatesTable.ID}` INTEGER UNIQUE, `${PrintTemplatesTable.DATA}` TEXT, PRIMARY KEY(`${PrintTemplatesTable.ID}`) )"
    }
}
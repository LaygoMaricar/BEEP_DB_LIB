package com.afpayments.beejees.fe.database.sqlite.queries

import android.database.sqlite.SQLiteDatabase
import com.afpayments.beejees.fe.database.dataObjects.*
import com.afpayments.beejees.fe.database.sqlite.tables.*

class DBRead {
    companion object {
        fun blacklist(db: SQLiteDatabase): String? {

            var blacklist = ""
            val cursor = db.rawQuery(SQLQueryHelper.selectAll(BlacklistTable.TABLE_NAME), null)

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    blacklist = cursor.getString(BlacklistTable.BLACKLIST_DATA_COL)
                }
            }
            cursor?.close()
            return blacklist
        }

        fun parameter(db: SQLiteDatabase): ArrayList<Parameter>? {

            var parameter = ArrayList<Parameter>()
            val cursor = db.rawQuery(SQLQueryHelper.selectAll(ParameterTable.TABLE_NAME), null)

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    parameter.add(Parameter.fromString(cursor.getString(ParameterTable.DATA_COL)))
                }
            }

            cursor?.close()
            return parameter
        }

        fun cardTransactions(
            db: SQLiteDatabase,
            lastUpload: Long,
            limit: Long
        ): ArrayList<String>? {
            var transactions = ArrayList<String>()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhereLimit(
                    CardTransactionsTable.TABLE_NAME,
                    CardTransactionsTable.MTC,
                    ">",
                    lastUpload,
                    limit
                )
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    transactions.add(cursor.getString(CardTransactionsTable.TRANSACTION_DATA_COL))
                }
            }

            cursor?.close()
            return transactions
        }

        fun cardTransactions(db: SQLiteDatabase, lastUpload: Long): ArrayList<String>? {
            var transactions = ArrayList<String>()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(
                    CardTransactionsTable.TABLE_NAME, CardTransactionsTable.MTC, ">", lastUpload
                )
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    transactions.add(cursor.getString(CardTransactionsTable.TRANSACTION_DATA_COL))
                }
            }
            cursor?.close()
            return transactions
        }

        fun transactions(db: SQLiteDatabase, lastUpload: Long, limit: Long): ArrayList<String>? {
            var transactions = ArrayList<String>()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhereLimit(
                    TransactionsTable.TABLE_NAME, TransactionsTable.MTC, ">", lastUpload, limit
                )
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    transactions.add(cursor.getString(TransactionsTable.TRANSACTION_DATA_COL))
                }
            }
            cursor?.close()
            return transactions
        }

        fun transactions(db: SQLiteDatabase, lastUpload: Long): ArrayList<String>? {
            var transactions = ArrayList<String>()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(
                    TransactionsTable.TABLE_NAME, TransactionsTable.MTC, ">", lastUpload
                )
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    transactions.add(cursor.getString(TransactionsTable.TRANSACTION_DATA_COL))
                }
            }
            cursor?.close()
            return transactions
        }

        fun transactions(
            db: SQLiteDatabase,
            startShift: String,
            endShift: String
        ): ArrayList<String>? {
            var transactions = ArrayList<String>()
            val cursor = db.rawQuery(
                String.format(
                    "SELECT * FROM %s WHERE %s >= '%s' AND %s <= '%s'",
                    TransactionsTable.TABLE_NAME,
                    TransactionsTable.DATE_INSERTED,
                    startShift,
                    TransactionsTable.DATE_INSERTED,
                    endShift
                )
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    transactions.add(cursor.getString(TransactionsTable.TRANSACTION_DATA_COL))
                }
            }
            cursor?.close()
            return transactions
        }

        fun reports(db: SQLiteDatabase, lastUpload: Long, limit: Long): ArrayList<String>? {
            var reports = ArrayList<String>()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhereLimit(
                    UserLogsTable.TABLE_NAME, UserLogsTable.MTC, ">", lastUpload, limit
                )
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    reports.add(cursor.getString(UserLogsTable.REPORT_DATA_COL))
                }
                return reports
            }
            cursor?.close()
            return null
        }

        fun reports(db: SQLiteDatabase, lastUpload: Long): ArrayList<String>? {
            var reports = ArrayList<String>()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(
                    UserLogsTable.TABLE_NAME, UserLogsTable.MTC, ">", lastUpload
                )
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    reports.add(cursor.getString(UserLogsTable.REPORT_DATA_COL))
                }
            }
            cursor?.close()
            return reports
        }

        fun cellTowerSegments(db: SQLiteDatabase, routeId: Long): ArrayList<CellTowerSegment>? {
            var segments = ArrayList<CellTowerSegment>()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(
                    CellTowerSegmentsTable.TABLE_NAME, CellTowerSegmentsTable.ROUTE_ID, "=", routeId
                )
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    segments.add(CellTowerSegment.fromString(cursor.getString(CellTowerSegmentsTable.DATA_COL)))
                }
            }
            cursor?.close()
            return segments
        }

        fun discount(db: SQLiteDatabase, id: Long): Discount? {
            var ret = Discount()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(DiscountTable.TABLE_NAME, DiscountTable.ID, "=", id)
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    ret = Discount.fromString(cursor.getString(DiscountTable.DATA_COL))
                }
            }
            cursor?.close()
            return ret
        }

        fun distanceBasedFareTable(db: SQLiteDatabase, id: Long): DistanceBasedFareTable? {
            var ret = DistanceBasedFareTable()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(
                    DistanceBasedFaresTable.TABLE_NAME,
                    DistanceBasedFaresTable.ID,
                    "=",
                    id
                )
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    ret =
                        DistanceBasedFareTable.fromString(cursor.getString(DistanceBasedFaresTable.DATA_COL))
                }
            }
            cursor?.close()
            return ret
        }

        fun fixedBasedFareTable(db: SQLiteDatabase, id: Long): FixedBasedFareTable? {
            var ret = FixedBasedFareTable()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(
                    FixedBasedFaresTable.TABLE_NAME,
                    FixedBasedFaresTable.ID,
                    "=",
                    id
                )
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    ret =
                        FixedBasedFareTable.fromString(cursor.getString(FixedBasedFaresTable.DATA_COL))
                }
            }
            cursor?.close()
            return ret
        }

        fun route(db: SQLiteDatabase, id: Long): Route? {
            var ret = Route()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(RouteTable.TABLE_NAME, RouteTable.ID, "=", id)
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    ret = Route.fromString(cursor.getString(RouteTable.DATA_COL))
                }
            }
            cursor?.close()
            return ret
        }

        fun segments(db: SQLiteDatabase, routeId: Long): ArrayList<Segment>? {
            var segments = ArrayList<Segment>()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(
                    SegmentsTable.TABLE_NAME, SegmentsTable.ROUTE_ID, "=", routeId
                )
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    segments.add(Segment.fromString(cursor.getString(SegmentsTable.DATA_COL)))
                }
            }
            cursor?.close()
            return segments
        }

        fun stopBasedFareTable(db: SQLiteDatabase, id: Long): StopBasedFareTable? {
            var ret = StopBasedFareTable()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(
                    StopBasedFaresTable.TABLE_NAME,
                    StopBasedFaresTable.ID,
                    "=",
                    id
                )
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    ret =
                        StopBasedFareTable.fromString(cursor.getString(StopBasedFaresTable.DATA_COL))
                }
            }
            cursor?.close()
            return ret
        }

        fun stops(db: SQLiteDatabase, routeId: Long): ArrayList<Stop>? {
            var stops = ArrayList<Stop>()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(
                    StopTable.TABLE_NAME, StopTable.ROUTE_ID, "=", routeId
                )
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    stops.add(Stop.fromString(cursor.getString(StopTable.DATA_COL)))
                }
            }
            cursor?.close()
            return stops
        }

        fun timeBasedFeeTable(db: SQLiteDatabase, id: Long): TimeBasedFeeTable? {
            var ret = TimeBasedFeeTable()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(
                    TimeBasedFaresTable.TABLE_NAME,
                    TimeBasedFaresTable.ID,
                    "=",
                    id
                )
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    ret =
                        TimeBasedFeeTable.fromString(cursor.getString(TimeBasedFaresTable.DATA_COL))
                }
            }
            cursor?.close()
            return ret
        }

        fun user(db: SQLiteDatabase, uid: String): User? {
            val user = User()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(
                    UsersTable.TABLE_NAME,
                    UsersTable.UID,
                    "=",
                    uid.toUpperCase()
                )
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    user.id = cursor.getLong(UsersTable.ID_COL)
                    user.companyId = (cursor.getString(UsersTable.COMPANY_ID_COL))
                    user.shortName = (cursor.getString(UsersTable.SHORT_NAME_COL))
                    user.longName = (cursor.getString(UsersTable.LONG_NAME_COL))
                    user.effective =
                        EffectivePeriod.fromString(cursor.getString(UsersTable.USER_EFFECTIVE_COL))

                    val cards = ArrayList<IdCards>()
                    val idCard = IdCards()
                    idCard.uid = (cursor.getString(UsersTable.UID_COL))
                    idCard.role = (cursor.getString(UsersTable.ROLE_COL))
                    idCard.effective =
                        EffectivePeriod.fromString(cursor.getString(UsersTable.CARD_EFFECTIVE_COL))

                    cards.add(idCard)
                    user.idCards = cards
                    user.operatorId = cursor.getInt(UsersTable.OPERATOR_ID_COL)
                }
            }
            cursor?.close()
            return user
        }

        fun vehicle(db: SQLiteDatabase): Vehicle? {
            var vehicle = Vehicle()
            val cursor = db.rawQuery(SQLQueryHelper.selectAll(VehicleTable.TABLE_NAME), null)

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    vehicle = Vehicle.fromString(cursor.getString(VehicleTable.DATA_COL))
                }
            }
            cursor?.close()
            return vehicle
        }

        fun version(db: SQLiteDatabase, tableName: String): Int? {
            var version = 0
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(
                    VersionsTable.TABLE_NAME,
                    VersionsTable.TABLE_NAME_COL,
                    "=",
                    tableName
                )
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    version = cursor.getInt(VersionsTable.VERSION_COL)
                }
            }
            cursor?.close()
            return version
        }

        fun printTemplate(db: SQLiteDatabase, id: Long): PrintTemplate? {
            var ret = PrintTemplate()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(
                    PrintTemplatesTable.TABLE_NAME,
                    PrintTemplatesTable.ID,
                    "=",
                    id
                )
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    ret = PrintTemplate.fromString(cursor.getString(PrintTemplatesTable.DATA_COL))
                }
            }
            cursor.close()
            return ret
        }

        fun printTemplate(db: SQLiteDatabase, type: String): PrintTemplate? {
            var ret = PrintTemplate()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(
                    PrintTemplatesTable.TABLE_NAME,
                    PrintTemplatesTable.TYPE,
                    "=",
                    type
                )
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    ret = PrintTemplate.fromString(cursor.getString(PrintTemplatesTable.DATA_COL))
                }
            }
            cursor?.close()
            return ret
        }

        fun cashboxReport(db: SQLiteDatabase, lastUpload: Long, limit: Long): ArrayList<String>? {
            var reports = ArrayList<String>()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhereLimit(
                    CashboxReportsTable.TABLE_NAME, CashboxReportsTable.MTC, ">", lastUpload, limit
                )
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    reports.add(cursor.getString(CashboxReportsTable.REPORT_DATA_COL))
                }
            }
            cursor?.close()
            return reports
        }

        fun cashboxReport(db: SQLiteDatabase, lastUpload: Long): ArrayList<String>? {
            var reports = ArrayList<String>()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(
                    CashboxReportsTable.TABLE_NAME, CashboxReportsTable.MTC, ">", lastUpload
                )
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    reports.add(cursor.getString(CashboxReportsTable.REPORT_DATA_COL))
                }
            }
            cursor?.close()
            return reports
        }

        fun operator(db: SQLiteDatabase, id: Int): Operator? {
            var ret = Operator()
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(OperatorTable.TABLE_NAME, OperatorTable.ID, "=", id)
                , null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    ret = Operator.fromString(cursor.getString(OperatorTable.DATA_COL))
                }
            }
            cursor?.close()
            return ret
        }

        fun sqliteSequence(db: SQLiteDatabase, tableName: String): Int {
            var lastIndex = 0
            val cursor = db.rawQuery(
                "select seq from sqlite_sequence where name='$tableName'",
                null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    lastIndex = cursor.getInt(0)
                }
            }

            cursor?.close()
            return lastIndex;

        }

    }
}
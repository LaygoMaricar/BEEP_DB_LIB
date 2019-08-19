package com.afpayments.beejees.fe.database.sqlite.queries

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.afpayments.beejees.fe.database.dataObjects.*
import com.afpayments.beejees.fe.database.sqlite.tables.*
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

class DBRead {
    companion object {
        fun blacklist(db: SQLiteDatabase): String? {
            val cursor = db.rawQuery(SQLQueryHelper.selectAll(BlacklistTable.TABLE_NAME), null)

            if (cursor.count > 0) {
                var blacklist = ""
                while (cursor.moveToNext()) {
                    blacklist = cursor.getString(BlacklistTable.BLACKLIST_DATA_COL)
                }
                cursor.close()
                return blacklist
            }
            return null
        }

        fun cardTransactions(db: SQLiteDatabase, lastUpload: Long, limit: Long): ArrayList<String>? {
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhereLimit(
                    CardTransactionsTable.TABLE_NAME, CardTransactionsTable.MTC, ">", lastUpload, limit
                )
                , null
            )

            if (cursor.count > 0) {
                var transactions = ArrayList<String>()
                while (cursor.moveToNext()) {
                    transactions.add(cursor.getString(CardTransactionsTable.TRANSACTION_DATA_COL))
                }
                cursor.close()
                return transactions
            }
            return null
        }

        fun cardTransactions(db: SQLiteDatabase, lastUpload: Long): ArrayList<String>? {
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(
                    CardTransactionsTable.TABLE_NAME, CardTransactionsTable.MTC, ">", lastUpload
                )
                , null
            )

            if (cursor.count > 0) {
                var transactions = ArrayList<String>()
                while (cursor.moveToNext()) {
                    transactions.add(cursor.getString(CardTransactionsTable.TRANSACTION_DATA_COL))
                }
                cursor.close()
                return transactions
            }
            return null
        }

        fun transactions(db: SQLiteDatabase, lastUpload: Long, limit: Long): ArrayList<String>? {
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhereLimit(
                    TransactionsTable.TABLE_NAME, TransactionsTable.MTC, ">", lastUpload, limit
                )
                , null
            )

            if (cursor.count > 0) {
                var transactions = ArrayList<String>()
                while (cursor.moveToNext()) {
                    transactions.add(cursor.getString(TransactionsTable.TRANSACTION_DATA_COL))
                }
                cursor.close()
                return transactions
            }
            return null
        }

        fun transactions(db: SQLiteDatabase, lastUpload: Long): ArrayList<String>? {
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(
                    TransactionsTable.TABLE_NAME, TransactionsTable.MTC, ">", lastUpload
                )
                , null
            )

            if (cursor.count > 0) {
                var transactions = ArrayList<String>()
                while (cursor.moveToNext()) {
                    transactions.add(cursor.getString(TransactionsTable.TRANSACTION_DATA_COL))
                }
                cursor.close()
                return transactions
            }
            return null
        }

        fun reports(db: SQLiteDatabase, lastUpload: Long, limit: Long): ArrayList<String>? {
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhereLimit(
                    UserLogsTable.TABLE_NAME, UserLogsTable.MTC, ">", lastUpload, limit
                )
                , null
            )

            if (cursor.count > 0) {
                var reports = ArrayList<String>()
                while (cursor.moveToNext()) {
                    reports.add(cursor.getString(UserLogsTable.REPORT_DATA_COL))
                }
                cursor.close()
                return reports
            }
            return null
        }

        fun cellTowerSegments(db: SQLiteDatabase, routeId: Long): ArrayList<CellTowerSegment>? {
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(
                    CellTowerSegmentsTable.TABLE_NAME, CellTowerSegmentsTable.ROUTE_ID, "=", routeId
                )
                , null
            )

            if (cursor.count > 0) {
                var segments = ArrayList<CellTowerSegment>()
                while (cursor.moveToNext()) {
                    segments.add(CellTowerSegment.fromString(cursor.getString(CellTowerSegmentsTable.DATA_COL)))
                }
                cursor.close()
                return segments
            }
            return null
        }

        fun discount(db: SQLiteDatabase, id: Long): Discount? {
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(DiscountTable.TABLE_NAME, DiscountTable.ID, "=", id)
                , null
            )

            if (cursor.count > 0) {
                var ret = Discount()
                while (cursor.moveToNext()) {
                    ret = Discount.fromString(cursor.getString(DiscountTable.DATA_COL))
                }
                cursor.close()
                return ret
            }
            return null
        }

        fun distanceBasedFareTable(db: SQLiteDatabase, id: Long): DistanceBasedFareTable? {
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(DistanceBasedFaresTable.TABLE_NAME, DistanceBasedFaresTable.ID, "=", id)
                , null
            )

            if (cursor.count > 0) {
                var ret = DistanceBasedFareTable()
                while (cursor.moveToNext()) {
                    ret = DistanceBasedFareTable.fromString(cursor.getString(DistanceBasedFaresTable.DATA_COL))
                }
                cursor.close()
                return ret
            }
            return null
        }

        fun fixedBasedFareTable(db: SQLiteDatabase, id: Long): FixedBasedFareTable? {
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(FixedBasedFaresTable.TABLE_NAME, FixedBasedFaresTable.ID, "=", id)
                , null
            )

            if (cursor.count > 0) {
                var ret = FixedBasedFareTable()
                while (cursor.moveToNext()) {
                    ret = FixedBasedFareTable.fromString(cursor.getString(FixedBasedFaresTable.DATA_COL))
                }
                cursor.close()
                return ret
            }
            return null
        }

        fun route(db: SQLiteDatabase, id: Long): Route? {
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(RouteTable.TABLE_NAME, RouteTable.ID, "=", id)
                , null
            )

            if (cursor.count > 0) {
                var ret = Route()
                while (cursor.moveToNext()) {
                    ret = Route.fromString(cursor.getString(RouteTable.DATA_COL))
                }
                cursor.close()
                return ret
            }
            return null
        }

        fun segments(db: SQLiteDatabase, routeId: Long): ArrayList<Segment>? {
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(
                    SegmentsTable.TABLE_NAME, SegmentsTable.ROUTE_ID, "=", routeId
                )
                , null
            )

            if (cursor.count > 0) {
                var segments = ArrayList<Segment>()
                while (cursor.moveToNext()) {
                    segments.add(Segment.fromString(cursor.getString(SegmentsTable.DATA_COL)))
                }
                cursor.close()
                return segments
            }
            return null
        }

        fun stopBasedFareTable(db: SQLiteDatabase, id: Long): StopBasedFareTable? {
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(StopBasedFaresTable.TABLE_NAME, StopBasedFaresTable.ID, "=", id)
                , null
            )

            if (cursor.count > 0) {
                var ret = StopBasedFareTable()
                while (cursor.moveToNext()) {
                    ret = StopBasedFareTable.fromString(cursor.getString(StopBasedFaresTable.DATA_COL))
                }
                cursor.close()
                return ret
            }
            return null
        }

        fun stops(db: SQLiteDatabase, routeId: Long): ArrayList<Stop>? {
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(
                    StopTable.TABLE_NAME, StopTable.ROUTE_ID, "=", routeId
                )
                , null
            )

            if (cursor.count > 0) {
                var stops = ArrayList<Stop>()
                while (cursor.moveToNext()) {
                    stops.add(Stop.fromString(cursor.getString(StopTable.DATA_COL)))
                }
                cursor.close()
                return stops
            }
            return null
        }

        fun timeBasedFeeTable(db: SQLiteDatabase, id: Long): TimeBasedFeeTable? {
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(TimeBasedFaresTable.TABLE_NAME, TimeBasedFaresTable.ID, "=", id)
                , null
            )

            if (cursor.count > 0) {
                var ret = TimeBasedFeeTable()
                while (cursor.moveToNext()) {
                    ret = TimeBasedFeeTable.fromString(cursor.getString(TimeBasedFaresTable.DATA_COL))
                }
                cursor.close()
                return ret
            }
            return null
        }

        fun user(db: SQLiteDatabase, uid: String): User? {
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(UsersTable.TABLE_NAME, UsersTable.UID, "=", uid)
                , null
            )

            if (cursor.count > 0) {
                val user = User()
                while (cursor.moveToNext()) {
                    user.id = cursor.getLong(UsersTable.ID_COL)
                    user.companyID = (cursor.getString(UsersTable.COMPANY_ID_COL))
                    user.shortName = (cursor.getString(UsersTable.SHORT_NAME_COL))
                    user.longName = (cursor.getString(UsersTable.LONG_NAME_COL))
                    user.effective = EffectivePeriod.fromString(cursor.getString(UsersTable.USER_EFFECTIVE_COL))

                    val cards = ArrayList<IdCards>()
                    val idCard = IdCards()
                    idCard.uid = (cursor.getString(UsersTable.UID_COL))
                    idCard.role = (cursor.getString(UsersTable.ROLE_COL))
                    idCard.effective = EffectivePeriod.fromString(cursor.getString(UsersTable.CARD_EFFECTIVE_COL))

                    cards.add(idCard)
                    user.idCards = cards
                }
                cursor.close()
                return user
            }
            return null
        }

        fun vehicle(db: SQLiteDatabase): Vehicle? {
            val cursor = db.rawQuery(SQLQueryHelper.selectAll(VehicleTable.TABLE_NAME), null)

            if (cursor.count > 0) {
                var vehicle = Vehicle()
                while (cursor.moveToNext()) {
                    vehicle = Vehicle.fromString(cursor.getString(VehicleTable.DATA_COL))
                }
                cursor.close()
                return vehicle
            }
            return null
        }

        fun version(db: SQLiteDatabase, tableName: String): Int? {
            val cursor = db.rawQuery(
                SQLQueryHelper.selectWhere(VersionsTable.TABLE_NAME, VersionsTable.TABLE_NAME_COL, "=", tableName)
                , null
            )

            if (cursor.count > 0) {
                var version = 0
                while (cursor.moveToNext()) {
                    version = cursor.getInt(VersionsTable.VERSION_COL)
                }
                cursor.close()
                return version
            }
            return 0
        }

    }
}
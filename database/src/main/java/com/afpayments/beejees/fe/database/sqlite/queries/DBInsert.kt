package com.afpayments.beejees.fe.database.sqlite.queries

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.afpayments.beejees.fe.database.dataObjects.User
import com.afpayments.beejees.fe.database.sqlite.tables.*

class DBInsert {

    companion object{
        fun blacklist(db : SQLiteDatabase, blacklist : String) : Long{
            val value = ContentValues()

            value.put(BlacklistTable.BLACKLIST_DATA,blacklist)

            return db.insertWithOnConflict(BlacklistTable.TABLE_NAME,null, value,SQLiteDatabase.CONFLICT_REPLACE)
        }

        fun transaction(db : SQLiteDatabase, mtc : Long, transaction : String, transactionType : String) : Long{
            val value = ContentValues()

            value.put(TransactionsTable.MTC,mtc)
            value.put(TransactionsTable.TRANSACTION_DATA,transaction)
            value.put(TransactionsTable.TRANSACTION_TYPE,transactionType)

            return db.insertWithOnConflict(TransactionsTable.TABLE_NAME,null,value,SQLiteDatabase.CONFLICT_REPLACE)
        }

        fun cardTransaction(db : SQLiteDatabase,mtc : Long, transaction : String, dateInserted: String) : Long{
            val value = ContentValues()

            value.put(CardTransactionsTable.MTC,mtc)
            value.put(CardTransactionsTable.TRANSACTION_DATA,transaction)
            value.put(CardTransactionsTable.DATE_INSERTED,dateInserted)

            return db.insertWithOnConflict(CardTransactionsTable.TABLE_NAME,null,value,SQLiteDatabase.CONFLICT_REPLACE)
        }

        fun report(db : SQLiteDatabase, reportData : String, dateInserted : String) : Long{
            val value = ContentValues()

            value.put(UserLogsTable.REPORT_DATA,reportData)
            value.put(UserLogsTable.DATE_INSERTED,dateInserted)

            return db.insertWithOnConflict(UserLogsTable.TABLE_NAME,null,value,SQLiteDatabase.CONFLICT_REPLACE)
        }

        fun cashboxReport(db : SQLiteDatabase, reportData : String, dateInserted : String) : Long{
            val value = ContentValues()

            value.put(CashboxReportsTable.REPORT_DATA,reportData)
            value.put(CashboxReportsTable.DATE_INSERTED,dateInserted)

            return db.insertWithOnConflict(CashboxReportsTable.TABLE_NAME,null,value,SQLiteDatabase.CONFLICT_REPLACE)
        }

        fun user(db: SQLiteDatabase, id : Long, companyId : String, shortName : String, longName : String, uid : String, role : String, userEffective : String, cardEffective : String) : Long{
            val value = ContentValues()

            value.put(UsersTable.ID,id)
            value.put(UsersTable.COMPANY_ID,companyId)
            value.put(UsersTable.SHORT_NAME,shortName)
            value.put(UsersTable.LONG_NAME,longName)
            value.put(UsersTable.UID,uid.toUpperCase())
            value.put(UsersTable.ROLE,role)
            value.put(UsersTable.USER_EFFECTIVE,userEffective)
            value.put(UsersTable.CARD_EFFECTIVE,cardEffective)

            return db.insertWithOnConflict(UsersTable.TABLE_NAME,null,value,SQLiteDatabase.CONFLICT_REPLACE)
        }

        fun user(db : SQLiteDatabase, user : User){
            for(i in 0 until user.idCards!!.size) {
                user(
                    db,
                    user.id!!,
                    user.companyId!!,
                    user.shortName!!,
                    user.longName!!,
                    user.idCards!![i].uid!!,
                    user.idCards!![i].role!!,
                    user.effective!!.toString(),
                    user.idCards!![i].effective!!.toString()
                )
            }
        }

        fun vehicle(db : SQLiteDatabase, data : String) : Long{
            val value = ContentValues()

            value.put(VehicleTable.DATA,data)

            return db.insertWithOnConflict(VehicleTable.TABLE_NAME,null,value,SQLiteDatabase.CONFLICT_REPLACE)
        }

        fun version(db : SQLiteDatabase, id : Long, tableName : String, version : Int) : Long{
            val value = ContentValues()

            value.put(VersionsTable.ID,id)
            value.put(VersionsTable.TABLE_NAME_COL,tableName)
            value.put(VersionsTable.VERSION,version)

            return db.insertWithOnConflict(VersionsTable.TABLE_NAME,null,value,SQLiteDatabase.CONFLICT_REPLACE)

        }

        fun cellTowerSegment(db : SQLiteDatabase, id : Long, data : String) : Long{
            val value = ContentValues()

            value.put(CellTowerSegmentsTable.ID,id)
            value.put(CellTowerSegmentsTable.DATA,data)

            return db.insertWithOnConflict(CellTowerSegmentsTable.TABLE_NAME,null,value,SQLiteDatabase.CONFLICT_REPLACE)

        }

        fun discount(db : SQLiteDatabase, id : Long, data : String) : Long{
            val value = ContentValues()

            value.put(DiscountTable.ID,id)
            value.put(DiscountTable.DATA,data)

            return db.insertWithOnConflict(DiscountTable.TABLE_NAME,null,value,SQLiteDatabase.CONFLICT_REPLACE)

        }

        fun distanceBasedFareTable(db : SQLiteDatabase, id : Long, data : String ) : Long{
            val value = ContentValues()

            value.put(DistanceBasedFaresTable.ID,id)
            value.put(DistanceBasedFaresTable.DATA,data)

            return db.insertWithOnConflict(DistanceBasedFaresTable.TABLE_NAME,null,value,SQLiteDatabase.CONFLICT_REPLACE)

        }

        fun fixedBasedFareTable(db : SQLiteDatabase, id : Long, data : String ) : Long{
            val value = ContentValues()

            value.put(FixedBasedFaresTable.ID,id)
            value.put(FixedBasedFaresTable.DATA,data)

            return db.insertWithOnConflict(FixedBasedFaresTable.TABLE_NAME,null,value,SQLiteDatabase.CONFLICT_REPLACE)

        }

        fun parameter(db : SQLiteDatabase, id : Long, data : String, dateInserted: String) : Long{
            val value = ContentValues()

            value.put(ParameterTable.ID,id)
            value.put(ParameterTable.DATA,data)
            value.put(ParameterTable.DATE_INSERTED,dateInserted)

            return db.insertWithOnConflict(ParameterTable.TABLE_NAME,null,value,SQLiteDatabase.CONFLICT_REPLACE)

        }

        fun route(db : SQLiteDatabase, id : Long, data : String) : Long{
            val value = ContentValues()

            value.put(RouteTable.ID,id)
            value.put(RouteTable.DATA,data)

            return db.insertWithOnConflict(RouteTable.TABLE_NAME,null,value,SQLiteDatabase.CONFLICT_REPLACE)

        }

        fun segment(db : SQLiteDatabase, id : Long, routeId : Long, data : String) : Long{
            val value = ContentValues()

            value.put(SegmentsTable.ID,id)
            value.put(SegmentsTable.ROUTE_ID,routeId)
            value.put(SegmentsTable.DATA,data)

            return db.insertWithOnConflict(SegmentsTable.TABLE_NAME,null,value,SQLiteDatabase.CONFLICT_REPLACE)

        }

        fun stopBasedFareTable(db : SQLiteDatabase, id : Long, data : String) : Long{
            val value = ContentValues()

            value.put(StopBasedFaresTable.ID,id)
            value.put(StopBasedFaresTable.DATA,data)

            return db.insertWithOnConflict(StopBasedFaresTable.TABLE_NAME,null,value,SQLiteDatabase.CONFLICT_REPLACE)

        }

        fun stop(db : SQLiteDatabase, id : Long, routeId : Long,  data : String) : Long{
            val value = ContentValues()

            value.put(StopTable.ID,id)
            value.put(StopTable.ROUTE_ID,routeId)
            value.put(StopTable.DATA,data)

            return db.insertWithOnConflict(StopTable.TABLE_NAME,null,value,SQLiteDatabase.CONFLICT_REPLACE)

        }

        fun timeBasedFareTable(db : SQLiteDatabase, id : Long, data : String) : Long{
            val value = ContentValues()

            value.put(TimeBasedFaresTable.ID,id)
            value.put(TimeBasedFaresTable.DATA,data)

            return db.insertWithOnConflict(TimeBasedFaresTable.TABLE_NAME,null,value,SQLiteDatabase.CONFLICT_REPLACE)

        }

        fun printTemplate(db : SQLiteDatabase, id: Long, data : String) : Long{
            val value = ContentValues()

            value.put(PrintTemplatesTable.ID,id)
            value.put(PrintTemplatesTable.DATA,data)

            return db.insertWithOnConflict(PrintTemplatesTable.TABLE_NAME,null,value,SQLiteDatabase.CONFLICT_REPLACE)

        }
    }
}
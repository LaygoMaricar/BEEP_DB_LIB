package com.afpayments.beejees.fe.database.sqlite

import afpayments.beepStorage.BeepStorage
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Environment
import com.afpayments.beejees.fe.database.sqlite.queries.QueryCreate
import timber.log.Timber
import java.io.File

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DB_DIR + File.separator + DB_NAME, null, DB_VERSION) {

    companion object{
        const val DB_NAME = "beejeesFrontEnd.db"
        const val DB_VERSION = 2
        val DB_DIR = BeepStorage.BEEP_FOLDER
    }

    init {
        Timber.d("Creating database")
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        if (p0 != null) {
            p0.execSQL(QueryCreate.BLACKLIST_TABLE)
            p0.execSQL(QueryCreate.CARD_TRANSACTIONS_TABLE)
            p0.execSQL(QueryCreate.TRANSACTIONS_TABLE)
            p0.execSQL(QueryCreate.USER_LOGS_TABLE)
            p0.execSQL(QueryCreate.USERS_TABLE)
            p0.execSQL(QueryCreate.VEHICLE_TABLE)
            p0.execSQL(QueryCreate.VERSIONS_TABLE)
            p0.execSQL(QueryCreate.CELL_TOWER_SEGMENTS_TABLE)
            p0.execSQL(QueryCreate.DISCOUNT_TABLE)
            p0.execSQL(QueryCreate.DISTANCE_BASED_FARE_TABLE)
            p0.execSQL(QueryCreate.FIXED_BASED_FARE_TABLE)
            p0.execSQL(QueryCreate.PARAMETERS_TABLE)
            p0.execSQL(QueryCreate.ROUTES_TABLE)
            p0.execSQL(QueryCreate.SEGMENTS_TABLE)
            p0.execSQL(QueryCreate.STOP_BASED_FARE_TABLE)
            p0.execSQL(QueryCreate.STOPS_TABLE)
            p0.execSQL(QueryCreate.TIME_BASED_FARE_TABLE)
            p0.execSQL(QueryCreate.PRINT_TEMPLATE_TABLE)
            p0.execSQL(QueryCreate.CASHBOX_REPORTS_TABLE)
            p0.execSQL(QueryCreate.OPERATORS_TABLE)
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL(QueryCreate.OPERATORS_TABLE)
    }
}
package com.afpayments.beejees.fe.database.sqlite.queries

import android.database.sqlite.SQLiteDatabase

class DBDelete {
    companion object{
        fun deleteRecords(db : SQLiteDatabase, tableName : String){
            db.execSQL("DELETE FROM $tableName")
        }
    }
}
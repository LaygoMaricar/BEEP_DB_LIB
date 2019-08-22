package com.afpayments.beejees.fe.database.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase

open class DatabaseModel {
    companion object{
        lateinit var databaseHelper : DatabaseHelper
        internal var isdatabaseHelperinit = false
    }
    var context: Context

    constructor(context: Context){
        this.context = context
        initializeDatahelper()
    }

    fun initializeDatahelper(){
        databaseHelper = DatabaseHelper(context)
    }

    fun getDatabaseHelper() : DatabaseHelper{
        return databaseHelper
    }

    fun getDatabase(): SQLiteDatabase {

        if (!isdatabaseHelperinit) {
            databaseHelper.writableDatabase
            //databaseHelper.exportDb()
            isdatabaseHelperinit = true
        }
        return databaseHelper.writableDatabase
    }



}
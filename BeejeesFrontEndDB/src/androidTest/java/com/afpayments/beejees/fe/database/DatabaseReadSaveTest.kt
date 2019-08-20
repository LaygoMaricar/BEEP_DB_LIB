package com.afpayments.beejees.fe.database

import android.content.Context
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.internal.inject.InstrumentationContext
import com.afpayments.beejees.fe.database.sqlite.DatabaseModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

class DatabaseReadSaveTest {

    lateinit var context : Context
    lateinit var model : DatabaseModel

    @Before
    internal fun initializeDatabase() {
        context = androidx.test.platform.app.InstrumentationRegistry.getInstrumentation().context

        model = DatabaseModel(context)
    }

    @Test
    fun insertBlacklist(){

    }

    @Test
    fun insertCardTransaction(){

    }

    @Test
    fun insertCellTowerSegment(){

    }

    @Test
    fun insertDiscount(){

    }

    @Test
    fun insertDistanceBasedFareTable(){

    }

    @Test
    fun insertFixedBasedFareTable(){

    }

    @Test
    fun insertParameter(){

    }

    @Test
    fun insertRoute(){

    }

    @Test
    fun insertSegment(){

    }

    @Test
    fun insertStopBasedFareTable(){

    }

    @Test
    fun insertStop(){

    }

    @Test
    fun insertTimeBasedFareTable(){

    }

    @Test
    fun insertTransaction(){

    }

    @Test
    fun insertUserLog(){

    }

    @Test
    fun insertUser(){

    }

    @Test
    fun insertVehicle(){

    }

    @Test
    fun insertVersion(){

    }
}
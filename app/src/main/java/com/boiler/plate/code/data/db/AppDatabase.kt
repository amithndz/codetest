package com.boiler.plate.code.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.boiler.plate.code.data.db.DATABASE.DATABASE_MOVIE_VERSION
import com.boiler.plate.code.data.entities.EmployeeData

@Database(entities = arrayOf(EmployeeData::class), version = DATABASE_MOVIE_VERSION,exportSchema = false)
abstract class AppDatabase  : RoomDatabase() {
    abstract fun getMoviesDao(): EmployeeDao
}

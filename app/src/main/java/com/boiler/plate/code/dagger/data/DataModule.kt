package com.boiler.plate.code.dagger.data

import android.content.Context
import androidx.room.Room
import com.boiler.plate.code.dagger.DI
import com.boiler.plate.code.data.api.Api
import com.boiler.plate.code.data.db.AppDatabase
import com.boiler.plate.code.data.mappers.EmployeeEntityDataMapper
import com.boiler.plate.code.data.repository.EmployeeRepositoryImpl
import com.boiler.plate.code.domain.EmployeeRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "app_db").allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: Api, movieDataMapper: EmployeeEntityDataMapper, appDatabase: AppDatabase): EmployeeRepository {

        return EmployeeRepositoryImpl(api, appDatabase,movieDataMapper )
    }




}
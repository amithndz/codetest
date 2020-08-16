package com.boiler.plate.code.dagger.application

import com.boiler.plate.code.dagger.data.DataModule
import com.boiler.plate.code.dagger.network.NetworkModule
import com.boiler.plate.code.dagger.employee.EmployeeModule
import com.boiler.plate.code.dagger.employee.EmployeeSubComponent
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

const val SCHEDULER_MAIN_THREAD = "mainThread"
const val SCHEDULER_IO = "io"

@Singleton
@Component(modules = [
    (AppModule::class),
    (NetworkModule::class),
    (DataModule::class),
    (AndroidSupportInjectionModule::class)
])

interface MainComponent {
    fun plus(popularMoviesModule: EmployeeModule): EmployeeSubComponent



}

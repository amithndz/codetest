package com.boiler.plate.code

import android.app.Application
import com.boiler.plate.code.common.Endpoint.EMPLOYEE_URL
import com.boiler.plate.code.dagger.application.AppModule
import com.boiler.plate.code.dagger.application.DaggerMainComponent
import com.boiler.plate.code.dagger.application.MainComponent
import com.boiler.plate.code.dagger.data.DataModule
import com.boiler.plate.code.dagger.network.NetworkModule
import com.boiler.plate.code.dagger.employee.EmployeeModule
import com.boiler.plate.code.dagger.employee.EmployeeSubComponent

class EmployeeApplication : Application()//, HasActivityInjector
 {
    lateinit var mainComponent: MainComponent

     private var popularMoviesComponent: EmployeeSubComponent? = null


    override fun onCreate() {
        super.onCreate()
        initDependencies()

    }

    private fun initDependencies() {
        mainComponent = DaggerMainComponent.builder()
                .appModule(AppModule(applicationContext))
                .networkModule(NetworkModule(EMPLOYEE_URL))
                .dataModule(DataModule())
                .build()



    }

    fun createPopularComponenet(): EmployeeSubComponent {
        popularMoviesComponent = mainComponent.plus(EmployeeModule())
        return popularMoviesComponent!!
    }


     fun releasePopularComponent() {
         popularMoviesComponent = null
     }


 }
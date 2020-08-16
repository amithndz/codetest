package com.boiler.plate.code.dagger.employee

import com.boiler.plate.code.domain.EmployeeRepository
import com.boiler.plate.code.presentation.ui.Employee.fragments.EmployeeVMFactory
import dagger.Module
import dagger.Provides
@Module
class EmployeeModule {

    @EmployeeScope
    @Provides
    fun providePopularMoviesVMFactory(moviesRepository: EmployeeRepository)
            : EmployeeVMFactory {
        return EmployeeVMFactory(moviesRepository)
    }
}
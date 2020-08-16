package com.boiler.plate.code.dagger.employee

import com.boiler.plate.code.presentation.ui.Employee.fragments.EmployeeListFragment
import dagger.Subcomponent
@EmployeeScope
@Subcomponent(modules = [EmployeeModule::class])
interface EmployeeSubComponent {
    fun inject(employeeListFragment: EmployeeListFragment)
}

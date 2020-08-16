package com.boiler.plate.code.dagger.fragments

import androidx.fragment.app.Fragment
import com.boiler.plate.code.presentation.ui.Employee.fragments.EmployeeListFragment
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Subcomponent/*(modules = ...)*/
interface EmployeeListFragmentSubcomponent: AndroidInjector<EmployeeListFragment> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<EmployeeListFragment>()
}

@Module(subcomponents = arrayOf(EmployeeListFragmentSubcomponent::class))
abstract class EmployeeListFragmentModule {
    @Binds
    @IntoMap
    @FragmentKey(EmployeeListFragment::class)
    abstract fun bindEmployeeListFragmentInjectorFactory(builder: EmployeeListFragmentSubcomponent.Builder):
            AndroidInjector.Factory<out Fragment>
}

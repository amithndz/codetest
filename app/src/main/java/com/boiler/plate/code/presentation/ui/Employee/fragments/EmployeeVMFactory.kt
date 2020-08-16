package com.boiler.plate.code.presentation.ui.Employee.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.boiler.plate.code.domain.EmployeeRepository

class EmployeeVMFactory(private val moviesRepository: EmployeeRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EmployeeViewModel(moviesRepository) as T
    }

}
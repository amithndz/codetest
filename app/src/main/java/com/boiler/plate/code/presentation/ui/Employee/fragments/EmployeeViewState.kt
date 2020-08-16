package com.boiler.plate.code.presentation.ui.Employee.fragments

import com.boiler.plate.code.data.entities.EmployeeData


data class EmployeeViewState(
        var showLoading: Boolean = true,
        var employee: List<EmployeeData>? = null
)

package com.boiler.plate.code.domain

import com.boiler.plate.code.data.entities.EmployeeData
import io.reactivex.Observable


interface EmployeeRepository{
    fun getMovies(): Observable<List<EmployeeData>>

}
package com.boiler.plate.code.domain

import io.reactivex.Observable
import okhttp3.ResponseBody

interface EmployeeDataStore {
    fun getMovies(): Observable<ResponseBody>

}

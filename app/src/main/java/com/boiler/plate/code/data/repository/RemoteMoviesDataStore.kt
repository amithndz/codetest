package com.boiler.plate.code.data.repository

import com.boiler.plate.code.data.api.Api
import com.boiler.plate.code.domain.EmployeeDataStore
import io.reactivex.Observable
import okhttp3.ResponseBody


class RemoteMoviesDataStore (private val api: Api ):
        EmployeeDataStore {



    override fun getMovies(): Observable<ResponseBody> {
        return api.getEmployeeList()
    }
}
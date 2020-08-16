package com.boiler.plate.code.data.api

import io.reactivex.Observable
import okhttp3.ResponseBody
import org.json.JSONArray
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {



    @GET("5d565297300000680030a986") /// EMP LIST
    fun getEmployeeList(): Observable<ResponseBody>

}
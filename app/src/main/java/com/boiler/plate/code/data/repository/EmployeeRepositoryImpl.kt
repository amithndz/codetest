package com.boiler.plate.code.data.repository

import com.boiler.plate.code.data.api.Api
import com.boiler.plate.code.data.api.EmployeeResponse
import com.boiler.plate.code.data.db.AppDatabase
import com.boiler.plate.code.data.entities.EmployeeData
import com.boiler.plate.code.domain.Mapper
import com.boiler.plate.code.domain.EmployeeDataStore
import com.boiler.plate.code.domain.EmployeeRepository
import com.google.gson.Gson
import io.reactivex.Observable
import org.json.JSONArray

class EmployeeRepositoryImpl (api: Api, private val database: AppDatabase, private  val employeeDataMapper: Mapper<EmployeeResponse, EmployeeData>) : EmployeeRepository {

    private val remoteDataStore: EmployeeDataStore


    init {
        remoteDataStore = RemoteMoviesDataStore(api)
    }

    override fun getMovies(): Observable<List<EmployeeData>> {
        var list: List<EmployeeData> = listOf()


            list = database.getMoviesDao().getFavorites()



        if(list.isNotEmpty())
        {
            return  Observable.just(list)
        }
        else {
            return remoteDataStore.getMovies().map { results->
                val array = JSONArray(results.string())
                val gson = Gson()
                var dataList: List<EmployeeResponse> = listOf()
                for (i in 0 until array.length()) {

                    val movieData: EmployeeResponse = gson.fromJson(array.getJSONObject(i).toString(), EmployeeResponse::class.java)
                    dataList += movieData
                }
                dataList.map { employeeDataMapper.mapFrom(it) }
            }.doOnNext(
                    {
                       database.getMoviesDao().saveAllMovies(it)
                    }
            )







        }

    }



}
package com.boiler.plate.code.data.db

import androidx.room.*
import com.boiler.plate.code.data.entities.EmployeeData

@Dao
interface EmployeeDao {
    @Query("SELECT * FROM employee")
    fun getFavorites(): List<EmployeeData>

    @Query("SELECT * FROM employee WHERE id=:movieId")
    fun get(movieId: Int): EmployeeData?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovie(movie: EmployeeData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllMovies(movies: List<EmployeeData>)

    @Delete
    fun removeMovie(movie: EmployeeData)

    @Query("DELETE FROM employee")
    fun clear()
}

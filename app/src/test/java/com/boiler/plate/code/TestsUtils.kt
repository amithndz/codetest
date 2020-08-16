package com.boiler.plate.code

import com.boiler.plate.code.data.entities.EmployeeData

class TestsUtils {

    companion object {
        fun getMockedMovieData(id: Int, title: String = "MovieData"): EmployeeData {
            return EmployeeData(
                    id = id,
                    title = title,
                    backdropPath = "movieData_backdrop",
                    originalLanguage = "movieData_lan",
                    posterPath = "movieData_poster",
                    originalTitle = "Original title of MovieData",
                    releaseDate = "1970-1-1",
                    adult = true,
                    popularity = 10.0,
                    voteAverage = 7.0,
                    voteCount = 100
            )
        }

        fun generateMovieDataList(): List<EmployeeData> {

            return (0..4).map {
                EmployeeData(
                        id = it,
                        title = "Movie$it",
                        backdropPath = "",
                        originalLanguage = "",
                        posterPath = "",
                        originalTitle = "",
                        releaseDate = ""
                )
            }
        }

    }

}
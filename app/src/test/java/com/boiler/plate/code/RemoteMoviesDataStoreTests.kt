package com.boiler.plate.code

import com.boiler.plate.code.data.api.Api
import com.boiler.plate.code.data.entities.EmployeeData
import com.boiler.plate.code.data.repository.RemoteMoviesDataStore
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class RemoteMoviesDataStoreTests {
    private val movieDataMovieEntityMapper = MovieDataEntityMapper()
    private val detailsDataMovieEntityMapper = DetailsDataMovieEntityMapper()
    private lateinit var api: Api
    private lateinit var remoteMoviesDataStore: RemoteMoviesDataStore
    @Before
    fun before() {
        api = Mockito.mock(Api::class.java)
        remoteMoviesDataStore = RemoteMoviesDataStore(
                api
                , movieDataMovieEntityMapper
                , detailsDataMovieEntityMapper)

    }

    @Test
    fun whenRequestingPopularMovieListFromRemoteSourceReturnExpectedResult() {
        val movies = (0..5).map {
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
        val movieListResult = MovieListResult()
        movieListResult.movies = movies
        movieListResult.page = 1
        Mockito.`when`(api.getPopularMovies()).thenReturn(Observable.just(movieListResult))
        remoteMoviesDataStore.getMovies().test()
                .assertValue { list -> list.size == 6 && list[0].title == "Movie0" }
                .assertComplete()
    }

}
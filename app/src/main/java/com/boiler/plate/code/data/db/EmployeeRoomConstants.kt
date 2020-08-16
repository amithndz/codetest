package com.boiler.plate.code.data.db

object DATABASE {
    const val DATABASE_MOVIE_VERSION = 2
    const val TABLE_EMPLOYEE = "employee"

    const val SELECT_MOVIE = "SELECT * FROM $TABLE_EMPLOYEE ORDER BY popularity DESC, title ASC"

    const val PAGE_SIZE = 20
}

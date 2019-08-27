package com.ankit.thepopulas.data.source.Local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ankit.thepopulas.model.Result

@Dao
interface TMDBDao {

    @Query("SELECT * FROM Result")
    fun getAppShows(): List<Result>

    @Insert
    fun savePopularTVShows(result: List<Result>)

    @Insert
    fun savePopularMovies(result: List<Result>)

}
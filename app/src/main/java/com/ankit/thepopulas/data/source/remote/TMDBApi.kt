package com.ankit.thepopulas.data.source.remote

import com.ankit.thepopulas.model.PopPersons
import com.ankit.thepopulas.model.PopularTVObj

import retrofit2.Call
import retrofit2.http.Query
import retrofit2.http.GET

interface TMDBApi {

    @GET("tv/popular")
    fun getPopularShows(@Query("api_key") apiKey: String,
                        @Query("language") language: String,
                        @Query("page") page: Int): Call<PopularTVObj>

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String,
                        @Query("language") language: String,
                        @Query("page") page: Int): Call<PopularTVObj>

    @GET("person/popular")
    fun getPopularPeoples(@Query("api_key") apiKey: String,
                        @Query("language") language: String,
                        @Query("page") page: Int): Call<PopPersons>

}
package com.ankit.thepopulas.data.source.remote

import com.ankit.thepopulas.model.PopularTVObj

import retrofit2.Call
import retrofit2.http.Query
import retrofit2.http.GET

interface TMDBApi {

    @GET("movie/tv/popular")
    fun getPopularShows(@Query("api_key") apiKey: String,
                        @Query("language") language: String,
                        @Query("page") page: Int): Call<PopularTVObj>

}
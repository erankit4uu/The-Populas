package com.ankit.thepopulas.data.source.reprository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ankit.thepopulas.data.source.Local.TMDBDao
import com.ankit.thepopulas.data.source.remote.TMDBApi
import com.ankit.thepopulas.model.PopPersons
import com.ankit.thepopulas.model.PopularTVObj
import com.ankit.thepopulas.model.Result
import com.ankit.thepopulas.model.ResultX
import com.ankit.thepopulas.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor

class CommonReprository internal constructor(val tmdbDao: TMDBDao,
                                             val executor: Executor,
                                             val webService: TMDBApi){


    val data = MutableLiveData<PopularTVObj>()
    val popMovie = MutableLiveData<PopularTVObj>()
    val popPeople = MutableLiveData<PopPersons>()
    lateinit var tvList : List<Result>
    lateinit var movieList : List<Result>
    lateinit var resultXList : List<ResultX>
    fun getPopularTv(): LiveData<PopularTVObj> {
        executor.execute {
            tvList = tmdbDao.getAppShows()
            if (!tvList.isNullOrEmpty()) {
                val list = PopularTVObj(results = tvList)
                data.postValue(list)
            } else {
                webService.getPopularShows(Constants.APP_KEY, "UN", 1)
                    .enqueue(object : Callback<PopularTVObj> {
                        override fun onResponse(call: Call<PopularTVObj>, response: Response<PopularTVObj>) {
                            tvList = response.body()?.results!!
                            val tvObj = response.body()
                            executor.execute {
                                data.postValue(tvObj)
                                tmdbDao.savePopularTVShows(tvObj!!.results)
//                       Log.v("result", resultList.toString())
                            }
                        }

                        override fun onFailure(call: Call<PopularTVObj>, t: Throwable) {
                        }

                    })
            }
        }

        return data
    }
    fun getPopularMovies(): LiveData<PopularTVObj> {
        executor.execute {

                webService.getPopularMovies(Constants.APP_KEY, "UN", 1)
                    .enqueue(object : Callback<PopularTVObj> {
                        override fun onResponse(call: Call<PopularTVObj>, response: Response<PopularTVObj>) {
                            movieList = response.body()?.results!!
                            val tvObj = response.body()
                            executor.execute {
                                popMovie.postValue(tvObj)
//                                tmdbDao.savePopularMovies(tvObj!!.results)
//                            Log.v("result", resultList.toString())
                            }
                        }

                        override fun onFailure(call: Call<PopularTVObj>, t: Throwable) {
                        }

                    })
        }

        return popMovie
    }
    fun getPopularPeople(): LiveData<PopPersons> {
        executor.execute {
            webService.getPopularPeoples(Constants.APP_KEY, "UN", 1)
                .enqueue(object : Callback<PopPersons>{
                    override fun onResponse(call: Call<PopPersons>, response: Response<PopPersons>) {
                        resultXList = response.body()?.results!!
                        val tvObj = response.body()
                        executor.execute {
                            popPeople.postValue(tvObj)
//                            Log.v("result", resultXList.toString())
                        }
                    }

                    override fun onFailure(call: Call<PopPersons>, t: Throwable) {
                    }

                })
        }

        return popPeople
    }
}



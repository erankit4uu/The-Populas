package com.ankit.thepopulas.view.landingView

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ankit.thepopulas.architechture.di.App
import com.ankit.thepopulas.data.source.reprository.CommonReprository
import com.ankit.thepopulas.model.PopPersons
import com.ankit.thepopulas.model.PopularTVObj
import com.ankit.thepopulas.model.ResultX

class LandingViewModel : ViewModel(){

    var repo : CommonReprository = App.REPOSITORY

    var tvShowsList: LiveData<PopularTVObj> = repo.getPopularTv()
    var movieShowsList: LiveData<PopularTVObj> = repo.getPopularMovies()
    var peopleShowsList: LiveData<PopPersons> = repo.getPopularPeople()
}
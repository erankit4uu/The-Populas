package com.ankit.thepopulas.view.viewPopularTvShows.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ankit.thepopulas.architechture.di.App
import com.ankit.thepopulas.data.source.reprository.CommonReprository
import com.ankit.thepopulas.model.PopularTVObj

class PopularTvShowsViewModel : ViewModel(){

    var repo : CommonReprository = App.REPOSITORY
    var tvShowsList: LiveData<PopularTVObj> = repo.getPopularTv()

}
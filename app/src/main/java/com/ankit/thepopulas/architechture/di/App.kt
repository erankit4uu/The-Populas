package com.ankit.thepopulas.architechture.di

import android.app.Application
import com.ankit.thepopulas.architechture.AppComponent
import com.ankit.thepopulas.architechture.DaggerAppComponent
import com.ankit.thepopulas.architechture.di.modules.AppModule
import com.ankit.thepopulas.data.source.Local.AppDatabase
import com.ankit.thepopulas.data.source.Local.TMDBDao
import com.ankit.thepopulas.data.source.remote.RetrofitClient
import com.ankit.thepopulas.data.source.remote.TMDBApi
import com.ankit.thepopulas.data.source.reprository.CommonReprository
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasAndroidInjector
import dagger.android.DispatchingAndroidInjector
import java.util.concurrent.Executors
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>? = null

    override fun androidInjector(): AndroidInjector<Any> {
      return dispatchingAndroidInjector!!
    }


    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .builder()
            .application(this)
            .build()
            .inject(this)

        REPOSITORY = CommonReprository(AppDatabase.getInstance(this).tmdbDao(), Executors.newSingleThreadExecutor(),
            RetrofitClient.getClient().create(TMDBApi::class.java))

    }

    companion object{
       lateinit var REPOSITORY : CommonReprository
    }
}
package com.ankit.thepopulas.architechture.di

import android.app.Application
import com.ankit.thepopulas.architechture.AppComponent
import com.ankit.thepopulas.architechture.DaggerAppComponent
import com.ankit.thepopulas.architechture.di.modules.AppModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasAndroidInjector
import dagger.android.DispatchingAndroidInjector
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


    }

//    lateinit var appComponent: AppComponent

//    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
//        return DaggerAppComponent
//            .builder()
//            .appModule(AppModule::class.java)
//            .application(this)
//            .build()
//    }
}
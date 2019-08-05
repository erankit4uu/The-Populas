package com.ankit.thepopulas.architechture

import dagger.Component
import dagger.android.AndroidInjector

import javax.inject.Singleton
import android.app.Application
import com.ankit.thepopulas.architechture.di.App
import com.ankit.thepopulas.architechture.di.modules.AppModule
import dagger.BindsInstance


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

    fun inject(instance: App)

}
package com.example.androiduistudyprojects.di

import com.example.androiduistudyprojects.App
import com.example.androiduistudyprojects.dialogs.DialogsModule
import com.example.androiduistudyprojects.input.InputModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelBuilder::class,
        AppModule::class,
        InputModule::class,
        DialogsModule::class]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }

}
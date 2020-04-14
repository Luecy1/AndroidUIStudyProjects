package com.example.androiduistudyprojects.input

import androidx.lifecycle.ViewModel
import com.example.androiduistudyprojects.di.ViewModelBuilder
import com.example.androiduistudyprojects.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class InputModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelBuilder::class
        ]
    )
    internal abstract fun blankFragment(): InputFragment

    @Binds
    @IntoMap
    @ViewModelKey(InputViewModel::class)
    abstract fun bindViewModel(viewmodel: InputViewModel): ViewModel
}
package com.example.androiduistudyprojects.blank

import androidx.lifecycle.ViewModel
import com.example.androiduistudyprojects.di.ViewModelBuilder
import com.example.androiduistudyprojects.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class BlankModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelBuilder::class
        ]
    )
    internal abstract fun blankFragment(): BlankFragment

    @Binds
    @IntoMap
    @ViewModelKey(BlankViewModel::class)
    abstract fun bindViewModel(viewmodel: BlankViewModel): ViewModel
}
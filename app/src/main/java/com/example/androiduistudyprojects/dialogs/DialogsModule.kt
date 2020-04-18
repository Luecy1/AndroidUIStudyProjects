package com.example.androiduistudyprojects.dialogs

import androidx.lifecycle.ViewModel
import com.example.androiduistudyprojects.di.ViewModelBuilder
import com.example.androiduistudyprojects.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class DialogsModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelBuilder::class
        ]
    )
    internal abstract fun blankFragment(): DialogsFragment

    @Binds
    @IntoMap
    @ViewModelKey(DialogsViewModel::class)
    abstract fun bindViewModel(viewmodel: DialogsViewModel): ViewModel
}
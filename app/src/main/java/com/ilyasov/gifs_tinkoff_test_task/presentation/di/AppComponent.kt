package com.ilyasov.gifs_tinkoff_test_task.presentation.di

import com.ilyasov.gifs_tinkoff_test_task.presentation.fragments.base.BaseFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RemoteModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(baseFragment: BaseFragment)
}
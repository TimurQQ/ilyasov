package com.ilyasov.gifs_tinkoff_test_task.presentation.di

import com.ilyasov.gifs_tinkoff_test_task.presentation.fragments.BaseFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(baseFragment: BaseFragment)
}
package com.ilyasov.gifs_tinkoff_test_task.presentation.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ilyasov.gifs_tinkoff_test_task.ViewModelKey
import com.ilyasov.gifs_tinkoff_test_task.ViewModelProviderFactory
import com.ilyasov.gifs_tinkoff_test_task.presentation.viewmodels.GetGifViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(GetGifViewModel::class)
    abstract fun bindGetGifViewModel(viewModel: GetGifViewModel): ViewModel
}
package com.ilyasov.gifs_tinkoff_test_task.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilyasov.gifs_tinkoff_test_task.domain.interactor.usecase.GetRandomGifUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetGifViewModel @Inject constructor(
    private val getRandomGifUseCase: GetRandomGifUseCase
): ViewModel() {
    fun getRandomGif() = viewModelScope.launch(Dispatchers.Main) {

    }
}
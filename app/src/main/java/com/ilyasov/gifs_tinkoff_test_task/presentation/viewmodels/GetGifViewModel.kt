package com.ilyasov.gifs_tinkoff_test_task.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilyasov.gifs_tinkoff_test_task.domain.entity.GifEntity
import com.ilyasov.gifs_tinkoff_test_task.domain.interactor.usecase.GetRandomGifUseCase
import com.ilyasov.gifs_tinkoff_test_task.util.Constants.Companion.RESPONSE_FAILED
import com.ilyasov.gifs_tinkoff_test_task.util.Constants.Companion.START_LOADING
import com.ilyasov.gifs_tinkoff_test_task.util.Constants.Companion.STOP_LOADING
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetGifViewModel @Inject constructor(
    private val getRandomGifUseCase: GetRandomGifUseCase
) : ViewModel() {
    val loadingMutableLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val errorStateLiveData: MutableLiveData<String> = MutableLiveData()
    val currentGifImageLiveData: MutableLiveData<GifEntity> = MutableLiveData()

    fun getRandomGif() = viewModelScope.launch(Dispatchers.Main) {
        loadingMutableLiveData.postValue(START_LOADING)
        val response = getRandomGifUseCase.execute()
        loadingMutableLiveData.postValue(STOP_LOADING)
        val body = response.body()
        if (!response.isSuccessful || body == null) {
            errorStateLiveData.postValue(RESPONSE_FAILED)
            return@launch
        } else {
            currentGifImageLiveData.postValue(body)
        }
    }
}
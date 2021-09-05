package com.ilyasov.gifs_tinkoff_test_task.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilyasov.gifs_tinkoff_test_task.domain.entity.GifEntity
import com.ilyasov.gifs_tinkoff_test_task.domain.interactor.usecase.GetRandomGifUseCase
import com.ilyasov.gifs_tinkoff_test_task.domain.interactor.usecase.NetworkConnectionUseCase
import com.ilyasov.gifs_tinkoff_test_task.util.Constants.Companion.NO_NETWORK_CONNECTION
import com.ilyasov.gifs_tinkoff_test_task.util.Constants.Companion.RESPONSE_FAILED
import com.ilyasov.gifs_tinkoff_test_task.util.Constants.Companion.START_LOADING
import com.ilyasov.gifs_tinkoff_test_task.util.Constants.Companion.STOP_LOADING
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class GetGifViewModel @Inject constructor(
    private val getRandomGifUseCase: GetRandomGifUseCase,
    private val networkConnectionUseCase: NetworkConnectionUseCase
) : ViewModel() {
    val loadingMutableLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val errorStateLiveData: MutableLiveData<String> = MutableLiveData()
    val currentGifImageLiveData: MutableLiveData<GifEntity> = MutableLiveData()
    val backButtonStateLiveData: MutableLiveData<Boolean> = MutableLiveData()
    private var currentIndex = -1
    private val cashedList = ArrayList<GifEntity>()

    fun getRandomGif(onCompleteCallback: () -> Unit) = viewModelScope.launch(Dispatchers.Main) {
        if (!isConnected()) {
            errorStateLiveData.postValue(NO_NETWORK_CONNECTION)
            return@launch
        }
        loadingMutableLiveData.postValue(START_LOADING)
        val response = getRandomGifUseCase.execute()
        loadingMutableLiveData.postValue(STOP_LOADING)
        val body = response.body()
        if (!response.isSuccessful || body == null) {
            errorStateLiveData.postValue(RESPONSE_FAILED)
            return@launch
        } else {
            onCompleteCallback.invoke()
            currentGifImageLiveData.postValue(body)
            cashedList.add(body)
            currentIndex++
        }
    }

    fun getNextGif() {
        if (currentIndex == cashedList.size - 1) {
            getRandomGif { backButtonStateLiveData.postValue(true) }
        } else {
            currentGifImageLiveData.postValue(cashedList[++currentIndex])
        }
    }

    fun getPreviousGif() {
        if (currentIndex <= 0) return
        currentGifImageLiveData.postValue(cashedList[--currentIndex])
        if (currentIndex == 0) backButtonStateLiveData.postValue(false)
    }

    private fun isConnected(): Boolean = networkConnectionUseCase.isInternetAvailable()
}
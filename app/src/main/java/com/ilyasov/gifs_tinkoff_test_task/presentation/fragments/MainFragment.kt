package com.ilyasov.gifs_tinkoff_test_task.presentation.fragments

import android.os.Bundle
import android.view.View
import com.ilyasov.gifs_tinkoff_test_task.R
import com.ilyasov.gifs_tinkoff_test_task.presentation.fragments.base.BaseFragment
import com.ilyasov.gifs_tinkoff_test_task.presentation.viewmodels.GetGifViewModel
import com.ilyasov.gifs_tinkoff_test_task.util.isVisible
import com.ilyasov.gifs_tinkoff_test_task.util.loadGifFromUrl
import com.ilyasov.gifs_tinkoff_test_task.util.showToast
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment(R.layout.fragment_main) {
    private val viewModel: GetGifViewModel by lazy { createViewModel {} }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        btnNext.setOnClickListener { onClickNext() }
        btnBack.setOnClickListener { onClickBack() }
    }

    private fun setupObserver() {
        viewModel.currentGifImageLiveData.observe(viewLifecycleOwner) { gifEntity ->
            ivCurrentGif.loadGifFromUrl(gifEntity.gifURL)
            tvGifDescription.text = gifEntity.description
        }
        viewModel.errorStateLiveData.observe(viewLifecycleOwner) { error ->
            showToast("An error: $error")
        }
        viewModel.loadingMutableLiveData.observe(viewLifecycleOwner) { visibility ->
            progressBar.isVisible(visibility)
        }
        viewModel.backButtonStateLiveData.observe(viewLifecycleOwner) { visibility ->
            btnBack.isVisible(visibility)
        }
        viewModel.networkConnectionUseCase.observe(viewLifecycleOwner) { isConnected ->
            if (isConnected && tvGifDescription.text == "") viewModel.getRandomGif {}
            if (!isConnected) showToast("Connection lost")
        }
    }

    private fun onClickNext() {
        viewModel.getNextGif()
    }

    private fun onClickBack() {
        viewModel.getPreviousGif()
    }
}
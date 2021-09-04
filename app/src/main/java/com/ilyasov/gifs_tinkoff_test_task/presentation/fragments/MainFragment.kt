package com.ilyasov.gifs_tinkoff_test_task.presentation.fragments

import com.ilyasov.gifs_tinkoff_test_task.R
import com.ilyasov.gifs_tinkoff_test_task.presentation.fragments.base.BaseFragment
import com.ilyasov.gifs_tinkoff_test_task.presentation.viewmodels.GetGifViewModel

class MainFragment : BaseFragment(R.layout.fragment_main) {
    private val viewModel: GetGifViewModel by lazy { createViewModel {} }
}
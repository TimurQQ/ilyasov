package com.ilyasov.gifs_tinkoff_test_task.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ilyasov.gifs_tinkoff_test_task.App

open class BaseFragment(layoutId: Int) : Fragment(layoutId) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }
}
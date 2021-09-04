package com.ilyasov.gifs_tinkoff_test_task.util

import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.ilyasov.gifs_tinkoff_test_task.R
import kotlinx.android.synthetic.main.fragment_main.view.*

fun ImageView.loadFromUrl(url: String?) {
    Glide.with(this)
        .load(url)
        .error(R.drawable.placeholder)
        .into(ivCurrentGif)
}

fun View.isVisible(visibility: Boolean) =
    if (visibility) this.visibility = View.VISIBLE else this.visibility = View.GONE

fun Fragment.showToast(message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}
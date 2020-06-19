package com.thundercsun.lomonosovv.presentation

import android.widget.ImageView
import com.bumptech.glide.Glide

object ImageLoader {

    @JvmStatic
    fun load(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
                .load(url)
                .centerCrop()
                .into(imageView)
    }
}
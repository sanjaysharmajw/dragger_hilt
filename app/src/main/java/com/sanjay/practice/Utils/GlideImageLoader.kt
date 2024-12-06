package com.sanjay.practice.Utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.sanjay.practice.R

object GlideImageLoader {
    fun loadImage(
        context: Context,
        imageUrl: String?,
        imageView: ImageView,
        placeholderRes: Int = R.drawable.placeholder, // Set your placeholder drawable
        errorRes: Int = R.drawable.error_placeholder, // Set your error drawable
    ) {
        Glide.with(context)
            .load(imageUrl)
            .apply(
                RequestOptions()
                    .placeholder(placeholderRes)
                    .error(errorRes)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            )
            .into(imageView)
    }

    fun loadCircularImage(
        context: Context,
        imageUrl: String?,
        imageView: ImageView,
        placeholderRes: Int = R.drawable.placeholder,
        errorRes: Int = R.drawable.error_placeholder,
    ) {
        Glide.with(context)
            .load(imageUrl)
            .apply(
                RequestOptions.circleCropTransform()
                    .placeholder(placeholderRes)
                    .error(errorRes)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            )
            .into(imageView)
    }

    /**  How to use

    com.sanjay.practice.utils.com.sanjay.practice.utils.com.sanjay.practice.Utils.GlideImageLoader.loadImage(
    context = this,
    imageUrl = "https://example.com/image.jpg",
    imageView = imageView)

    * Circular Image
    com.sanjay.practice.utils.com.sanjay.practice.utils.com.sanjay.practice.Utils.GlideImageLoader.loadCircularImage(
    context = this,
    imageUrl = "https://example.com/profile.jpg",
    imageView = profileImageView
    )
     */


}

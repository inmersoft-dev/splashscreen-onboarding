package com.inmersoft.splashscreenonboarding.onboarding

import android.view.View
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.inmersoft.splashscreenonboarding.R

class ViewPageTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        val pageWidth = page.width
        val image = page.findViewById<ImageView>(R.id.image_parallax)
        // val text = page.findViewById<TextView>(R.id.titleText)
        image.translationX = -position * (pageWidth / 2)
        // text.translationX = position * (pageWidth / 2)
    }
}
package com.inmersoft.splashscreenonboarding.onboarding

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.inmersoft.splashscreenonboarding.R


class ViewPageTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        val pageWidth = page.width
        val image = page.findViewById<ImageView>(R.id.image_parallax)
        val SplashTitle = page.findViewById<TextView>(R.id.txtSplashTitle)
        val SplashDescriptiom = page.findViewById<TextView>(R.id.txtSplashDescription)
        image.translationX = -position * (pageWidth / 2)
        SplashTitle.translationX = position * (pageWidth / 2)
        SplashDescriptiom.translationX = position * (pageWidth / 2)
    }
}
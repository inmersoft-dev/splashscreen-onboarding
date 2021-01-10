package com.inmersoft.splashscreenonboarding.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inmersoft.splashscreenonboarding.R
import com.inmersoft.splashscreenonboarding.databinding.FragmentOnboardingScreenBinding


class OnboardingScreen : Fragment(R.layout.fragment_onboarding_screen) {

    private lateinit var binding: FragmentOnboardingScreenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentOnboardingScreenBinding.inflate(layoutInflater, container, false)

        val data = this.arguments
        val imgID = data?.getInt("imgID")
        val title = data?.getString("title")
        val subtitle = data?.getString("subtitle")

        binding.imageParallax.setImageResource(imgID!!)
        binding.txtSplashTitle.text = title!!
        binding.txtSplashDescription.text = subtitle!!

        return binding.root
    }

}
package com.inmersoft.splashscreenonboarding.onboarding.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inmersoft.splashscreenonboarding.R
import com.inmersoft.splashscreenonboarding.databinding.FragmentThirdOnboardingScreenBinding

class ThirdOnboardingScreen : Fragment(R.layout.fragment_third_onboarding_screen) {

    private lateinit var binding: FragmentThirdOnboardingScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdOnboardingScreenBinding.inflate(layoutInflater, container, false)


        return binding.root
    }



}
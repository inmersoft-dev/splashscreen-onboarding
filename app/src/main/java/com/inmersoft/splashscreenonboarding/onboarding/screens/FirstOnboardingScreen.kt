package com.inmersoft.splashscreenonboarding.onboarding.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inmersoft.splashscreenonboarding.R
import com.inmersoft.splashscreenonboarding.databinding.FragmentFirstOnboardingScreenBinding

class FirstOnboardingScreen : Fragment(R.layout.fragment_first_onboarding_screen) {

    private lateinit var binding: FragmentFirstOnboardingScreenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentFirstOnboardingScreenBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

}
package com.inmersoft.splashscreenonboarding.onboarding.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inmersoft.splashscreenonboarding.R
import com.inmersoft.splashscreenonboarding.databinding.FragmentSecondOnboardingScreenBinding

class SecondOnboardingScreen : Fragment(R.layout.fragment_second_onboarding_screen) {

    private lateinit var binding: FragmentSecondOnboardingScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondOnboardingScreenBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

}
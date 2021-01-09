package com.inmersoft.splashscreenonboarding.onboarding.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.inmersoft.splashscreenonboarding.R
import com.inmersoft.splashscreenonboarding.databinding.FragmentThirdOnboardingScreenBinding

class ThirdOnboardingScreen : Fragment(R.layout.fragment_third_onboarding_screen) {

    private lateinit var binding: FragmentThirdOnboardingScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdOnboardingScreenBinding.inflate(layoutInflater, container, false)

        val viewPageOnBoarding = activity?.findViewById<ViewPager2>(R.id.viewPageOnBoarding)

        binding.txtBtnNextPage.setOnClickListener {
            //onBoardingFinish()
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
        }
        return binding.root
    }

    private fun onBoardingFinish() {
        val sharedPref = requireActivity().getSharedPreferences("ON_BOARDING", Context.MODE_PRIVATE)
        val edit = sharedPref.edit()
        edit.putBoolean("ON_BOARDING_FINISHED", true)
        edit.apply()
    }

}
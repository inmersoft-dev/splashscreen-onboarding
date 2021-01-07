package com.inmersoft.splashscreenonboarding.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.inmersoft.splashscreenonboarding.R
import com.inmersoft.splashscreenonboarding.databinding.FragmentViewPagerBinding
import com.inmersoft.splashscreenonboarding.onboarding.screens.FirstOnboardingScreen
import com.inmersoft.splashscreenonboarding.onboarding.screens.SecondOnboardingScreen
import com.inmersoft.splashscreenonboarding.onboarding.screens.ThirdOnboardingScreen

class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {

    private lateinit var binding: FragmentViewPagerBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        binding = FragmentViewPagerBinding.inflate(layoutInflater, container, false)


        // val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstOnboardingScreen(), SecondOnboardingScreen(), ThirdOnboardingScreen()
        )

        val adapter =
            ViewPageAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)

        binding.viewPageOnBoarding.adapter = adapter

        return binding.root
    }
}
package com.inmersoft.splashscreenonboarding.onboarding

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.inmersoft.splashscreenonboarding.R
import com.inmersoft.splashscreenonboarding.databinding.FragmentViewPagerBinding
import com.inmersoft.splashscreenonboarding.onboarding.screens.FirstOnboardingScreen
import com.inmersoft.splashscreenonboarding.onboarding.screens.SecondOnboardingScreen
import com.inmersoft.splashscreenonboarding.onboarding.screens.ThirdOnboardingScreen

class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {

    private lateinit var binding: FragmentViewPagerBinding

    private var viewIndex = 0;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
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

        binding.viewPageOnBoarding.setPageTransformer(ViewPageTransformer())



        binding.floatingActionButton.setOnClickListener(View.OnClickListener {
            if (binding.viewPageOnBoarding.currentItem == fragmentList.size-1) {
                //Call  onBoardingFinish() HERE
                findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
            } else {
                binding.viewPageOnBoarding.currentItem++
            }
        })


        return binding.root

    }

    private fun onBoardingFinish() {
        val sharedPref = requireActivity().getSharedPreferences("ON_BOARDING", Context.MODE_PRIVATE)
        val edit = sharedPref.edit()
        edit.putBoolean("ON_BOARDING_FINISHED", true)
        edit.apply()
    }

}
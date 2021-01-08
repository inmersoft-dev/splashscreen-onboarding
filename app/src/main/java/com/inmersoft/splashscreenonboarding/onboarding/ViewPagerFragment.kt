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

        return binding.root

/*
        /** Setup View Pager **/
        parallaxCarousel.adapter = PagerAdapter(photos, supportFragmentManager)
        parallaxCarousel.setPageTransformer(false, PageTransformer())
        setupPageDivider()
        /** Setup Tab Dots **/
        tab_dots.setupWithViewPager(parallaxCarousel, true)

 */
    }
/*
    private fun setupPageDivider() {

        /** below 3 line of codes will make viewpager vertical white border **/
        val px = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2f, resources.displayMetrics))
        parallaxCarousel.pageMargin = px
        parallaxCarousel.setPageMarginDrawable(R.color.divider)

        /** below codes will make viewpager partial visible next/previous screen **/
        /*parallaxCarousel.clipToPadding = false
        parallaxCarousel.setPadding(48, 0, 48, 0)*/
    }*/


}
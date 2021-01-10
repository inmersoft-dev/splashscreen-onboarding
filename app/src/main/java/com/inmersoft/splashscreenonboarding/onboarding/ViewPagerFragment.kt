package com.inmersoft.splashscreenonboarding.onboarding

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Interpolator
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.inmersoft.splashscreenonboarding.R
import com.inmersoft.splashscreenonboarding.databinding.FragmentViewPagerBinding


class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {

    private lateinit var binding: FragmentViewPagerBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        // Inflate the layout for this fragment

        binding = FragmentViewPagerBinding.inflate(layoutInflater, container, false)

        // val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val firstPage = OnboardingScreen()
        val data: Bundle = Bundle();
        data.putInt("imgID", R.drawable.first_onboard_page);
        data.putString("title", "SplashTitle-1");
        data.putString("subtitle", "SplashSubTitle-1");
        firstPage.arguments = data

        val secondPage = OnboardingScreen()
        val data2: Bundle = Bundle();
        data2.putInt("imgID", R.drawable.secound_onboard_page);
        data2.putString("title", "SplashTitle-2");
        data2.putString("subtitle", "SplashSubTitle-2");
        secondPage.arguments = data2

        val thridPage = OnboardingScreen()
        val data3: Bundle = Bundle();
        data3.putInt("imgID", R.drawable.third_onboard_page);
        data3.putString("title", "SplashTitle-3");
        data3.putString("subtitle", "SplashSubTitle-3");
        thridPage.arguments = data3

        val fragmentList = arrayListOf<Fragment>(
            firstPage, secondPage, thridPage
        )

        val adapter =
            ViewPageAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)


        binding.viewPageOnBoarding.adapter = adapter

        binding.viewPageOnBoarding.setPageTransformer(ViewPageTransformer())

        binding.floatingActionButton.setOnClickListener(View.OnClickListener {
            if (binding.viewPageOnBoarding.currentItem == fragmentList.size - 1) {
                //Call  onBoardingFinish() HERE
                onBoardingFinish()
                findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
            } else {
                binding.viewPageOnBoarding.currentItem++
            }
        })
        return binding.root

    }


    private fun setCustomScrollerToViewPager(interpolator: Interpolator, duration: Int) {
        try {

        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }
    }

    private fun onBoardingFinish() {
        val sharedPref = requireActivity().getSharedPreferences("ON_BOARDING", Context.MODE_PRIVATE)
        val edit = sharedPref.edit()
        edit.putBoolean("ON_BOARDING_FINISHED", true)
        edit.apply()
    }

}
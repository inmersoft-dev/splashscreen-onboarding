package com.inmersoft.splashscreenonboarding.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.inmersoft.splashscreenonboarding.R
import com.inmersoft.splashscreenonboarding.databinding.FragmentViewPagerBinding
import kotlinx.coroutines.launch


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
                lifecycleScope.launch {
                    onBoardingFinished()
                }
                findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)

            } else {
                binding.viewPageOnBoarding.currentItem++
            }
        })
        return binding.root

    }

    suspend fun onBoardingFinished() {
        val onBoardingDataStore: DataStore<Preferences> = requireContext().createDataStore(
            name = "ON_BOARDING"
        )

        val OB_FINISHED = preferencesKey<Boolean>("ON_BOARDING_FINISHED")
        onBoardingDataStore.edit { ON_BOARDING ->
            ON_BOARDING[OB_FINISHED] = true
        }
    }


}
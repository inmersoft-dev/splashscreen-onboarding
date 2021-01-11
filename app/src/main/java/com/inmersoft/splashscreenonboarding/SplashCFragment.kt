package com.inmersoft.splashscreenonboarding

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SplashCFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        Handler(Looper.getMainLooper()).postDelayed({
            lifecycleScope.launch {
                if (isOnBoardingFinished() == true) {
                    findNavController().navigate(R.id.action_splashCFragment_to_homeFragment)
                } else {
                    findNavController().navigate(R.id.action_splashCFragment_to_viewPagerFragment)
                }
            }
        }, 3000)
        return inflater.inflate(R.layout.fragment_splash_c, container, false)
    }


    private suspend fun isOnBoardingFinished(): Boolean? {
        val onBoardingDataStore: DataStore<Preferences> = requireContext().createDataStore(
            name = "ON_BOARDING"
        )
        val OB_FINISHED = preferencesKey<Boolean>("ON_BOARDING_FINISHED")
        return onBoardingDataStore.data.first()[OB_FINISHED]
    }


}
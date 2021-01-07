package com.inmersoft.splashscreenonboarding.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPageAdapter(
    listPages: ArrayList<Fragment>,
    fManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fManager, lifecycle) {

    private val fragmentList: ArrayList<Fragment> = listPages

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

}
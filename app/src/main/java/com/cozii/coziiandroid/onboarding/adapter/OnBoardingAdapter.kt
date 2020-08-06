package com.cozii.coziiandroid.onboarding.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cozii.coziiandroid.onboarding.OnBoardViewPagerFragment
import com.cozii.coziiandroid.onboarding.OnBoardingTenantFragment

class OnBoardingAdapter(fragment: OnBoardViewPagerFragment, private val itemsCount: Int) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return itemsCount
    }

    override fun createFragment(position: Int): Fragment {
        return OnBoardingTenantFragment.getInstance(position)
    }
}
package com.cozii.coziiandroid.signupandsigninbase

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cozii.coziiandroid.signupandsigninbase.login.LoginFragment
import com.cozii.coziiandroid.signupandsigninbase.register.RegisterFragment

class SignUpAndSignInPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> {
                LoginFragment()
            }
            else -> {
                return RegisterFragment()
            }
        }
    }

    override fun getItemCount(): Int {
        return 2
    }


}
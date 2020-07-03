package com.cozii.coziiandroid.signupandsigninbase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cozii.coziiandroid.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_sign_up_and_sign_in_base.*

class SignUpAndSignInBaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_and_sign_in_base)

        //Titles of the Sign Up arrays
        val tabTitles : Array<String> = arrayOf("SignIn","SignUp")

        val signupPagerAdapter = SignUpAndSignInPagerAdapter(this)
        base_view_pager.adapter = signupPagerAdapter

        //Tab Layout mediator used for handling the Fragment State Adapter
        TabLayoutMediator(tab_sign_up_and_sign_in,base_view_pager, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            tab.text = tabTitles[position]
            base_view_pager.setCurrentItem(tab.position,true)
                }).attach()
    }
}

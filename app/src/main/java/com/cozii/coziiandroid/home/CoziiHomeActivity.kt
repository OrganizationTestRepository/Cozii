package com.cozii.coziiandroid.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.cozii.coziiandroid.R
import kotlinx.android.synthetic.main.activity_cozii_home.*

class CoziiHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cozii_home)
        setUpView()
    }

    fun setUpView(){
        val navFragment = findNavController(R.id.home_nav_fragment)

        home_bottom_navigation_view.setupWithNavController(navFragment)
    }
}

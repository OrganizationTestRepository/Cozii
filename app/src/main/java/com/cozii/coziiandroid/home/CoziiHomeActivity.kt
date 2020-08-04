package com.cozii.coziiandroid.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

    private fun setUpView(){
        val navFragment = findNavController(R.id.home_nav_fragment)
        home_bottom_navigation_view.setupWithNavController(navFragment)
    }

    fun updateToolbarTitle(title : String){
        toolbar_title.text = title
    }

    fun changeToolbarBackVisibity(value : Boolean){
        if (value){
            iv_home_back_button.visibility = View.VISIBLE
        }else {
            iv_home_back_button.visibility = View.GONE
        }
    }
}

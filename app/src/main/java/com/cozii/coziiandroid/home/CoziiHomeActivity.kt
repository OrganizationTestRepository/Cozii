package com.cozii.coziiandroid.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.databinding.ActivityCoziiHomeBinding
import com.cozii.coziiandroid.onboarding.viewmodel.OnBoardingSharedViewModel
import com.cozii.coziiandroid.util.stringPreference

class CoziiHomeActivity : AppCompatActivity() {

    private val homeViewModel : CoziiHomeMainViewModel by viewModels()

    private var typeOfUser = stringPreference(OnBoardingSharedViewModel.USER_TYPE,"cozii_android")

    private lateinit var binding : ActivityCoziiHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_cozii_home)

        binding.homeViewModel = homeViewModel
        binding.executePendingBindings()

        setUpView()
    }

    private fun setUpView() {
        val navFragment = findNavController(R.id.home_nav_fragment)
        binding.homeBottomNavigationView.setupWithNavController(navFragment)

        val user = typeOfUser.getValue(this,::typeOfUser)

        if (user == "Tenant"){
            binding.homeBottomNavigationView.inflateMenu(R.menu.tenant_bottom_navigation_menu)
        }else if (user == "Landlord"){
            binding.homeBottomNavigationView.inflateMenu(R.menu.landlord_bottom_navigation_menu)
        }else if (user == "Handyman"){
            binding.homeBottomNavigationView.inflateMenu(R.menu.handyman_bottom_navigation_menu)
        }
    }

    fun updateToolbarTitle(title: String) {
        binding.toolbarTitle.text = title
    }

    fun changeToolbarBackVisibity(value: Boolean) {
        if (value) {
            binding.ivHomeBackButton.visibility = View.VISIBLE
        } else {
            binding.ivHomeBackButton.visibility = View.GONE
        }
    }
}

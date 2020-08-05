package com.cozii.coziiandroid.onboarding

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.databinding.ActivityOnBoardViewPagerBinding
import com.cozii.coziiandroid.onboarding.adapter.OnBoardingAdapter

class OnBoardViewPagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val numberOfScreens = resources.getStringArray(R.array.on_boarding_titles).size
        val onBoardingAdapter = OnBoardingAdapter(this, numberOfScreens)
        binding.onBoardingViewPager.adapter = onBoardingAdapter
    }

    fun updateStatusBarColor(color : String){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.parseColor(color)
        }
    }
}

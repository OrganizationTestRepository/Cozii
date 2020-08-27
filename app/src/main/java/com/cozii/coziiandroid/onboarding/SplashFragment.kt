package com.cozii.coziiandroid.onboarding

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.cozii.coziiandroid.R

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as OnBoardingLandingActivity).updateStatusBarColor("#ffffff")

        val handler = Handler()
        handler.postDelayed({
            this.findNavController()
                .navigate(R.id.action_splashFragment_to_onBoardUserSelectionFragment)
        }, 2000)
    }
}

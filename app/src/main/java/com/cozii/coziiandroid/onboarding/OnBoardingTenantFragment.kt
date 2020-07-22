package com.cozii.coziiandroid.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController

import com.cozii.coziiandroid.R
import kotlinx.android.synthetic.main.fragment_onboarding_0.*
import kotlinx.android.synthetic.main.fragment_onboarding_2.*


class OnBoardingTenantFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //on_board_first_logo.setImageDrawable(ContextCompat.getDrawable(context!!,R.drawable.second_onboard_tenant_logo))
    }

}

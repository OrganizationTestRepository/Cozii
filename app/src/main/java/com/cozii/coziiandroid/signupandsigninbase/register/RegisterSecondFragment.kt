package com.cozii.coziiandroid.signupandsigninbase.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController

import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.signupandsigninbase.SignUpAndSignInBaseActivity
import kotlinx.android.synthetic.main.fragment_register_second.*


class RegisterSecondFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as SignUpAndSignInBaseActivity).updateStatusBarColor("#ffffff")

        tv_sign_in.setOnClickListener {
            it.findNavController().navigate(R.id.action_registerSecondFragment_to_loginFragment);
        }

        second_register_login_button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_registerSecondFragment_to_verifyEmailOtpFragment);
        }
    }

}

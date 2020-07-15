package com.cozii.coziiandroid.signupandsigninbase.resetpassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.signupandsigninbase.SignUpAndSignInBaseActivity

class ResetPasswordFirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reset_password_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as SignUpAndSignInBaseActivity).updateStatusBarColor("#3f2587")
    }
}

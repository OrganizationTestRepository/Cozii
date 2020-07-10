package com.cozii.coziiandroid.signupandsigninbase.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.signupandsigninbase.SignUpAndSignInBaseActivity
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as SignUpAndSignInBaseActivity).updateStatusBarColor("#ffffff")

        tv_sign_up.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment3_to_registerFirstFragment2);
        }

        tv_forget_password.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment3_to_resetPasswordFirstFragment);
        }
    }
}

package com.cozii.coziiandroid.signupandsigninbase.resetpassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.cozii.coziiandroid.R
import kotlinx.android.synthetic.main.fragment_reset_password_success.*

class ResetPasswordSuccessFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reset_password_success, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sign_in_button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_resetPasswordSuccessFragment_to_loginFragment);
        }
    }
}

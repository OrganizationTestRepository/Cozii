package com.cozii.coziiandroid.signupandsigninbase.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.cozii.coziiandroid.R
import kotlinx.android.synthetic.main.fragment_first_register.*
import kotlinx.android.synthetic.main.fragment_first_register.tv_sign_in


class RegisterFirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_sign_in.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_registerFirstFragment_to_loginFragment3);
        }

        first_register_login_button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_registerFirstFragment_to_registerSecondFragment);
        }
    }

}

package com.cozii.coziiandroid.signupandsigninbase.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController

import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.signupandsigninbase.SignUpAndSignInBaseActivity
import com.cozii.coziiandroid.signupandsigninbase.viewmodel.SignUpAndSignInSharedViewModel
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    private val loginViewModel: SignUpAndSignInSharedViewModel by activityViewModels()

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
            it.findNavController().navigate(R.id.action_loginFragment_to_registerFirstFragment);
        }

        tv_forget_password.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_loginFragment_to_resetPasswordFirstFragment);
        }
    }
}

package com.cozii.coziiandroid.signupandsigninbase.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController

import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.databinding.FragmentLoginBinding
import com.cozii.coziiandroid.home.CoziiHomeActivity
import com.cozii.coziiandroid.signupandsigninbase.SignUpAndSignInBaseActivity
import com.cozii.coziiandroid.signupandsigninbase.login.models.LoginFields
import com.cozii.coziiandroid.signupandsigninbase.viewmodel.SignUpAndSignInSharedViewModel
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by activityViewModels()

    private lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.loginviewmodel = loginViewModel

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as SignUpAndSignInBaseActivity).updateStatusBarColor("#ffffff")

        checkAndGoToHomeScreen()

        tv_sign_up.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_registerFirstFragment);
        }

        tv_forget_password.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_loginFragment_to_resetPasswordFirstFragment);
        }
    }

    private fun checkAndGoToHomeScreen() {
        loginViewModel.getLoginFields().observe(viewLifecycleOwner, Observer<LoginFields> {
            val intent = Intent(
                activity,
                CoziiHomeActivity::class.java
            )
            startActivity(intent)
            activity?.finish()
        })
    }
}

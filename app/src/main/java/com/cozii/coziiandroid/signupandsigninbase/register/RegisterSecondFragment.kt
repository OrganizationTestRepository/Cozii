package com.cozii.coziiandroid.signupandsigninbase.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.databinding.FragmentRegisterSecondBinding
import com.cozii.coziiandroid.signupandsigninbase.SignUpAndSignInBaseActivity
import com.cozii.coziiandroid.signupandsigninbase.register.models.RegisterSecondFields
import kotlinx.android.synthetic.main.fragment_register_second.*


class RegisterSecondFragment : Fragment() {

    private val registerViewModel: RegisterViewModel by activityViewModels()

    private lateinit var binding: FragmentRegisterSecondBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register_second, container, false)

        binding.registerSecondViewModel = registerViewModel

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as SignUpAndSignInBaseActivity).updateStatusBarColor("#ffffff")

        tv_sign_in.setOnClickListener {
            it.findNavController().navigate(R.id.action_registerSecondFragment_to_loginFragment);
        }

        goToOtpVerificationFragment(this)
    }

    private fun goToOtpVerificationFragment(registerSecondFragment: RegisterSecondFragment) {
        registerViewModel.getSecondRegisterFields().observe(viewLifecycleOwner, Observer<RegisterSecondFields> {
            registerSecondFragment.findNavController()
                .navigate(R.id.action_registerSecondFragment_to_verifyEmailOtpFragment)
        })
    }

}

package com.cozii.coziiandroid.signupandsigninbase.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController


import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.databinding.FragmentFirstRegisterBinding
import com.cozii.coziiandroid.signupandsigninbase.SignUpAndSignInBaseActivity
import com.cozii.coziiandroid.signupandsigninbase.register.models.RegisterFirstFields
import kotlinx.android.synthetic.main.fragment_first_register.*
import kotlinx.android.synthetic.main.fragment_first_register.tv_sign_in


class RegisterFirstFragment : Fragment() {

    private val registerViewModel: RegisterViewModel by activityViewModels()

    private lateinit var binding: FragmentFirstRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first_register, container, false)

        binding.registerViewModel = registerViewModel

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as SignUpAndSignInBaseActivity).updateStatusBarColor("#ffffff")

        tv_sign_in.setOnClickListener {
            it.findNavController().navigate(R.id.action_registerFirstFragment_to_loginFragment)
        }

        goToSecondRegisterFragment(this)
    }

    private fun goToSecondRegisterFragment(registerFirstFragment: RegisterFirstFragment) {
        registerViewModel.getFirstRegisterFields().observe(viewLifecycleOwner, Observer<RegisterFirstFields> {
            registerFirstFragment.findNavController()
                .navigate(R.id.action_registerFirstFragment_to_registerSecondFragment)
        })
    }

}

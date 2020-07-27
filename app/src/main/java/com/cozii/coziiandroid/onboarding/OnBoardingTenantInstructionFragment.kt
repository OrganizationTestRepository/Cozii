package com.cozii.coziiandroid.onboarding

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.cozii.coziiandroid.R

class OnBoardingTenantInstructionFragment : Fragment() {

    companion object {
        fun newInstance() = OnBoardingTenantInstructionFragment()
    }

    private lateinit var viewModel: OnBoardingTenantInstructionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.on_boarding_tenant_instruction_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =
            ViewModelProviders.of(this).get(OnBoardingTenantInstructionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}

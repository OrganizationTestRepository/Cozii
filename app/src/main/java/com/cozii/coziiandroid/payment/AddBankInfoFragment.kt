package com.cozii.coziiandroid.payment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels

import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.home.CoziiHomeActivity
import com.cozii.coziiandroid.payment.adapter.CountrySpinnerAdapter
import com.cozii.coziiandroid.payment.viewmodels.PaymentInformationViewModel
import kotlinx.android.synthetic.main.fragment_add_bank_info.*

class AddBankInfoFragment : Fragment() {

    private val paymentInformationViewModel: PaymentInformationViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_bank_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as CoziiHomeActivity).updateToolbarTitle(getString(R.string.bank_info_toolbar_title))

        (activity as CoziiHomeActivity).changeToolbarBackVisibity(true)

        sp_country.adapter = CountrySpinnerAdapter(paymentInformationViewModel.setPaymentCountries(requireContext()),requireContext())
    }
}

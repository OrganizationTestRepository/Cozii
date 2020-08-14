package com.cozii.coziiandroid.payment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.home.CoziiHomeActivity
import com.cozii.coziiandroid.payment.adapter.PaymentMethodsAdapter
import com.cozii.coziiandroid.payment.models.PaymentMethods
import com.cozii.coziiandroid.payment.viewmodels.PaymentSelectionViewModel
import kotlinx.android.synthetic.main.fragment_payment_selection.*

class PaymentSelectionFragment : Fragment(), PaymentOptionClickListener {

    private val paymentSelectionViewModel: PaymentSelectionViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as CoziiHomeActivity).updateToolbarTitle(getString(R.string.add_payment_toolbar_title))

        (activity as CoziiHomeActivity).changeToolbarBackVisibity(true)

        rv_payment_options.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = PaymentMethodsAdapter(
                paymentSelectionViewModel.setPaymentOptionsForUser(context),
                this@PaymentSelectionFragment
            )
        }
    }

    override fun onPaymentOptionClick(data: PaymentMethods) {

        if (data.paymentOption.equals("Bank Account", false)) {
            this.findNavController()
                .navigate(R.id.action_paymentSelectionFragment_to_addBankInfoFragment)
        } else if (data.paymentOption.equals("Credit or Debit Card", false)) {
            this.findNavController()
                .navigate(R.id.action_paymentSelectionFragment_to_addCardPaymentFragment)
        } else if (data.paymentOption.equals("Gift Card", false)) {
            this.findNavController()
                .navigate(R.id.action_paymentSelectionFragment_to_promoCodeFragment)
        }
    }
}

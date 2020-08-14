package com.cozii.coziiandroid.payment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.home.CoziiHomeActivity
import com.cozii.coziiandroid.payment.adapter.AddedPaymentsAdapter
import com.cozii.coziiandroid.payment.adapter.PaymentMethodsAdapter
import com.cozii.coziiandroid.payment.viewmodels.PaymentSelectionViewModel
import kotlinx.android.synthetic.main.fragment_payment.*
import kotlinx.android.synthetic.main.fragment_payment_selection.*

class PaymentFragment : Fragment() {

    private val paymentSelectionViewModel: PaymentSelectionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as CoziiHomeActivity).updateToolbarTitle(getString(R.string.payment_method_toolbar_title))

        (activity as CoziiHomeActivity).changeToolbarBackVisibity(true)

        rv_added_cards.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = AddedPaymentsAdapter(
                paymentSelectionViewModel.setPaymentOptionsForUser(context)
            )
        }

        tv_add_payment_method.setOnClickListener {
            it.findNavController().navigate(R.id.action_paymentFragment_to_paymentSelectionFragment)
        }
    }
}

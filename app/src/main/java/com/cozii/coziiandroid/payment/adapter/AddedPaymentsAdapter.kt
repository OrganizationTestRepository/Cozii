package com.cozii.coziiandroid.payment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cozii.coziiandroid.databinding.LayoutSingleAddedPaymentBinding
import com.cozii.coziiandroid.databinding.LayoutSinglePaymentBinding
import com.cozii.coziiandroid.payment.PaymentOptionClickListener
import com.cozii.coziiandroid.payment.models.PaymentMethods

class AddedPaymentsAdapter(private val paymentOptions: List<PaymentMethods>) :
    RecyclerView.Adapter<AddedPaymentsAdapter.PaymentOptionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentOptionViewHolder {
        return PaymentOptionViewHolder.from(
            parent
        )
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(
        holder: PaymentOptionViewHolder,
        position: Int
    ) {
        val paymentOption = paymentOptions[position]
    }

    class PaymentOptionViewHolder(private val binding: LayoutSingleAddedPaymentBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(paymentOption: PaymentMethods,paymentOptionClickListener: PaymentOptionClickListener) {
        }

        companion object {
            fun from(parent: ViewGroup): PaymentOptionViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LayoutSingleAddedPaymentBinding.inflate(layoutInflater, parent, false)
                return PaymentOptionViewHolder(
                    binding
                )
            }
        }

    }
}